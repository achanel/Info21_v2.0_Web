package edu.school21.infoweb.services;

import edu.school21.infoweb.models.Peers;

import java.util.List;

public interface PeersService {
    List<Peers> getAllPeers();

    List<Peers> savePeers(List<Peers> peers);

    void deletePeer(String id);
}
