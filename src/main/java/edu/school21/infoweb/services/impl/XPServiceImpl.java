package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.XP;
import edu.school21.infoweb.repositories.XPRepository;
import edu.school21.infoweb.services.XPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class XPServiceImpl implements XPService {
    @Autowired
    private XPRepository xpRepository;

    @Override
    @Transactional
    public List<XP> getAllXP() {
        System.out.println("xpService: " + xpRepository.findAll());
        return xpRepository.findAll();
    }

    @Override
    @Transactional
    public List<XP> saveXP(List<XP> xp) {
        return xp == null ?
                null : (List<XP>) xpRepository.saveAll(xp);
    }

    @Override
    public void deleteXP(List<XP> xp) {
        if (xp != null) {
            xpRepository.deleteAll(xp);
        }
    }
}
