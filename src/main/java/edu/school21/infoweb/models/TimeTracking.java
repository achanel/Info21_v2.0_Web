package edu.school21.infoweb.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "TimeTracking")
@Table
public class TimeTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @OneToMany(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "id")
//    private List<Peers> peer = new LinkedList<>();
    private Date date;
    private Time time;
    private short state;
}
