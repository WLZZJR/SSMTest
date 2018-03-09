package com.wlz.dao;

import com.wlz.BaseTest;
import com.wlz.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() throws Exception {
        long bookId = 1001;
        long studentId = 12345678910L;
        int insert = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("insert=" + insert);
    }


    @Test
    public void testQueryByKeyWithBook() throws Exception {
        long bookId = 1001;
        long studentId = 12345678910L;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBookId());
    }
}
