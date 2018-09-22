package com.raspberrymonitor.enity;

import java.util.Date;

public class Ram {

    private int value;
    private Date date;

    public Ram(int value, Date date) {
        this.value = value;
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
