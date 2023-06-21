package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.TransferredPoints;
import edu.school21.infoweb.repositories.TransferredPointsRepository;
import edu.school21.infoweb.services.TransferredPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferedPointsServiceImpl implements TransferredPointsService {
    @Autowired
    private TransferredPointsRepository transferredPointsRepository;

    @Override
    @Transactional
    public List<TransferredPoints> getAllTransferredPoints() {
        System.out.println("transferredPointsService: " + transferredPointsRepository.findAll());
        return transferredPointsRepository.findAll();
    }

    @Override
    @Transactional
    public List<TransferredPoints> saveTransferredPoints(List<TransferredPoints> transferredPoints) {
        return transferredPoints == null ?
                null : (List<TransferredPoints>) transferredPointsRepository.saveAll(transferredPoints);
    }

    @Override
    public void deleteTransferredPoints(List<TransferredPoints> transferredPoints) {
        if (transferredPoints != null) {
            transferredPointsRepository.deleteAll(transferredPoints);
        }
    }
}
