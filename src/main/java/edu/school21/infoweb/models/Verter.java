package edu.school21.infoweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;

@AllArgsConstructor
@Data
public class Verter {
    private Integer id;
    private String check;

    private CheckState checkState;
    private Time time;
}
