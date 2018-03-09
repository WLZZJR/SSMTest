package com.wlz.dao;

import com.wlz.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {


    /**
     * query book by bookId
     * @param bookId
     * @return
     */
    Book queryById(long bookId);


    /**
     * query all books
     * @param offset starting position of query
     * @param limit  query the number
     * @return
     */
    List<Book> queryAll (@Param("offset") int offset, @Param("limit") int limit);


    /**
     * reduce the number of book
     * @param number
     * @return
     */
    int reduceNumber(long number);
}
