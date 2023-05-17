package edu.school21.infoweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Recommendations {
    private Integer id;
    private String peer;
    private String recomendatedPeer;
}
