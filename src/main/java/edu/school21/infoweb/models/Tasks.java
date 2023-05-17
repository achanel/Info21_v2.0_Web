package edu.school21.infoweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Tasks")
@Table
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tittle;
    private String parentTask;
    private Integer maxXP;

}
