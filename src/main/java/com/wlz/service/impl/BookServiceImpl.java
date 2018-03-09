package com.wlz.service.impl;

import com.wlz.dto.AppointExecution;
import com.wlz.entity.Book;
import com.wlz.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Book getById(long bookId) {
        return null;
    }

    @Override
    public List<Book> getList() {
        return null;
    }

    @Override
    public AppointExecution appoint(long bookId, long studentId) {
        return null;
    }
}
