package edu.school21.infoweb.services;

import edu.school21.infoweb.models.Checks;

import java.util.List;

public interface ChecksService {
    List<Checks> getAllChecks();

    List<Checks> saveChecks(List<Checks> peers);

    void deleteChecks(List<Checks> peers);
}
