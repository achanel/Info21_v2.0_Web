package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.Peers;
import edu.school21.infoweb.repositories.PeersRepository;
import edu.school21.infoweb.services.PeersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeersServiceImpl implements PeersService {
    @Autowired
    private PeersRepository peersRepository;

    @Override
    @Transactional
    public List<Peers> getAllPeers() {
        return peersRepository.findAll();
    }

    @Override
    @Transactional
    public List<Peers> savePeers(List<Peers> peers) {
        return peersRepository.saveAllAndFlush(peers);
    }

    @Override
    public void deletePeer(String id) {
        peersRepository.deleteById(id);
    }


}
