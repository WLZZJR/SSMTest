package com.wlz.service.impl;

import com.wlz.BaseTest;
import com.wlz.dto.AppointExecution;
import com.wlz.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends BaseTest {


    @Autowired
    private BookService bookService;


    @Test
    public void testAppoint() throws Exception{
        long bookId = 1001;
        long studentId = 123456789L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
}

}
