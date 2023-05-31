package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Peers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeersRepository extends CrudRepository<Peers, Long> {
    List<Peers> findAll();

    void deleteById(String id);
}
