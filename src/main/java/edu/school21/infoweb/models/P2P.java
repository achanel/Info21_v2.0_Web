package edu.school21.infoweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;

@AllArgsConstructor
@Data
public class P2P {
    private Integer id;
    private Integer check;
    private String checkingPeer;

    private CheckState checkState;

    private Time time;
}
