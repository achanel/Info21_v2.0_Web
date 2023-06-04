package edu.school21.infoweb.services;

import edu.school21.infoweb.models.TransferredPoints;

import java.util.List;

public interface TransferredPointsService {
    List<TransferredPoints> getAllTransferredPoints();

    List<TransferredPoints> saveTransferredPoints(List<TransferredPoints> peers);

    void deleteTransferredPoints(List<TransferredPoints> peers);
}
