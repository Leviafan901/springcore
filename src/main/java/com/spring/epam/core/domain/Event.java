package com.spring.epam.core.domain;

import org.apache.commons.lang3.RandomUtils;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    private int id;
    private String message;
    private Date date;
    private DateFormat dateFormatter;

    public Event(Date date, DateFormat dateFormatter) {
        this.dateFormatter = dateFormatter;
        this.date = date;
        this.id = RandomUtils.nextInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + dateFormatter.format(this.date) +
                '}';
    }
}
