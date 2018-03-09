package com.wlz.dao;

import com.wlz.entity.Appointment;
import org.apache.ibatis.annotations.Param;


public interface AppointmentDao {

    /**
     * Insert an appointment book record.
     * @param bookId
     * @param studentId
     * @return
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);


    /**
     * query appointment book record by booId and studentId
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
