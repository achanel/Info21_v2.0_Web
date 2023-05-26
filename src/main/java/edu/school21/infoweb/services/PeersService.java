package edu.school21.infoweb.services;

import edu.school21.infoweb.models.Peers;

import java.util.List;

public interface PeersService {
    List<Peers> getAllPeers();

    Peers savePeer(Peers peers);

    void deletePeer(String id);
}
