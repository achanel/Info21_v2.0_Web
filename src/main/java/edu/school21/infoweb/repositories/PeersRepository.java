package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Peers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeersRepository extends CrudRepository<Peers, String> {
    List<Peers> findAll();

    Peers save(Peers peers);

    void deleteById(String id);
}
