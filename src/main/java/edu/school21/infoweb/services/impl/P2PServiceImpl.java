package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.P2P;
import edu.school21.infoweb.repositories.P2PRepository;
import edu.school21.infoweb.services.P2PService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class P2PServiceImpl implements P2PService {
    @Autowired
    private P2PRepository p2PRepository;

    @Override
    @Transactional
    public List<P2P> getAllP2P() {
        return p2PRepository.findAll();
    }

    @Override
    @Transactional
    public List<P2P> saveP2P(List<P2P> p2p) {
        return p2p == null ?
                null : (List<P2P>) p2PRepository.saveAll(p2p);
    }

    @Override
    public void deleteP2P(List<P2P> p2p) {
        if (p2p != null) {
            p2PRepository.deleteAll(p2p);
        }
    }
}
