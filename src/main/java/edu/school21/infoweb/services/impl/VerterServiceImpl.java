package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.Verter;
import edu.school21.infoweb.repositories.VerterRepository;
import edu.school21.infoweb.services.VerterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VerterServiceImpl implements VerterService {
    @Autowired
    private VerterRepository verterRepository;

    @Override
    @Transactional
    public List<Verter> getAllVerter() {
        System.out.println("verterService: " + verterRepository.findAll());
        return verterRepository.findAll();
    }

    @Override
    @Transactional
    public List<Verter> saveVerter(List<Verter> verters) {
        return (List<Verter>) verterRepository.saveAll(verters);
    }

    @Override
    public void deleteVerter(List<Verter> verters) {
        verterRepository.deleteAll(verters);
    }
}
