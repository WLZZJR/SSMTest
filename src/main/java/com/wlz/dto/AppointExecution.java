package com.wlz.dto;

import com.wlz.entity.Appointment;
import com.wlz.enums.AppointStateEnum;

public class AppointExecution {

    private long bookId;

    private int state;

    // 状态标识
    private String stateInfo;

    private Appointment appointment;

    public AppointExecution() {
    }


    /**
     * Make an appointment to failure
     * @param bookId
     * @param stateEnum
     */
    public AppointExecution(long bookId, AppointStateEnum stateEnum){

        this.bookId=bookId;
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();

    }


    /**
     * make a appointment to successful
     * @param bookId
     * @param stateEnum
     * @param appointment
     */
    public AppointExecution(long bookId,AppointStateEnum stateEnum,Appointment appointment){

        this.bookId=bookId;
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.appointment=appointment;
    }


    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
