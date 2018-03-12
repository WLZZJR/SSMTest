package com.wlz.service.impl;

import com.wlz.dao.AppointmentDao;
import com.wlz.dao.BookDao;
import com.wlz.dto.AppointExecution;
import com.wlz.entity.Appointment;
import com.wlz.entity.Book;
import com.wlz.enums.AppointStateEnum;
import com.wlz.exception.AppointException;
import com.wlz.exception.NoNumberException;
import com.wlz.exception.RepeatAppointException;
import com.wlz.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;


    @Override
    public Book getById(long bookId) {

        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0,1000);
    }

    @Override
    @Transactional
    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public AppointExecution appoint(long bookId, long studentId) {

        try{

            //减库存
            int update=bookDao.reduceNumber(bookId);
            if(update<=0){
                throw new NoNumberException("no number");
            }else{
                int insert=appointmentDao.insertAppointment(bookId,studentId);
                if(insert<=0){
                    throw new RepeatAppointException("repeat appoint");
                }else {
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        }catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            //return new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);//错误写法
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }
}
