package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.Checks;
import edu.school21.infoweb.repositories.ChecksRepository;
import edu.school21.infoweb.services.ChecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChecksServiceImpl implements ChecksService {
    @Autowired
    private ChecksRepository checksRepository;

    @Override
    @Transactional
    public List<Checks> getAllChecks() {
        System.out.println("checksService: " + checksRepository.findAll());
        return checksRepository.findAll();
    }

    @Override
    @Transactional
    public List<Checks> saveChecks(List<Checks> checks) {
        return checks == null ? null : (List<Checks>) checksRepository.saveAll(checks);
    }

    @Override
    public void deleteChecks(List<Checks> checks) {
        if (checks != null) {
            checksRepository.deleteAll(checks);
        }
    }
}
