package edu.school21.infoweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Friends {
    private Integer id;
    private String peer1;
    private String peer2;
}
