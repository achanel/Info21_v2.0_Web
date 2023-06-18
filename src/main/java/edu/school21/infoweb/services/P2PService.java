package edu.school21.infoweb.services;

import edu.school21.infoweb.models.P2P;

import java.util.List;

public interface P2PService {
    List<P2P> getAllP2P();

    List<P2P> saveP2P(List<P2P> p2ps);

    void deleteP2P(List<P2P> p2ps);
}
