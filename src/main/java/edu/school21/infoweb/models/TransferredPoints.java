package edu.school21.infoweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TransferredPoints {
    private Integer id;
    private String checkingPeer;
    private String checkedPeer;
    private Integer pointsAmount;
}

