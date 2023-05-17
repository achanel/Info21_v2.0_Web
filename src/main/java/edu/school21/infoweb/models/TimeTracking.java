package edu.school21.infoweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@Data
public class TimeTracking {
    private Integer id;
    private String peer;
    private Date date;
    private Time time;
    private short state;
}
