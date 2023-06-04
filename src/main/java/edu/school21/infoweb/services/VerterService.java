package edu.school21.infoweb.services;

import edu.school21.infoweb.models.Verter;

import java.util.List;

public interface VerterService {
    List<Verter> getAllVerter();

    List<Verter> saveVerter(List<Verter> peers);

    void deleteVerter(List<Verter> peers);
}
