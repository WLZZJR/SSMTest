package com.wlz.entity;



import java.util.Date;
import com.wlz.entity.Book;


public class Appointment {

    private long bookId;
    private long studentId;
    private Date appointTime;

    private Book book;

    public void Appointment(){}

    public void Appointment(long bookId,long studentId,Date appointTime){

        this.bookId=bookId;
        this.studentId=studentId;
        this.appointTime=appointTime;
    }

    public void Appointment(long bookId,long studentId,Date appointTime,Book book){

        this.bookId=bookId;
        this.studentId=studentId;
        this.appointTime=appointTime;
        this.book=book;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "bookId=" + bookId +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                '}';
    }
}
