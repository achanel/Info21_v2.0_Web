package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Peers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeersRepository extends JpaRepository<Peers, Long> {
    List<Peers> findAll();

    List<Peers> saveAllAndFlush(List<Peers> peers);

    void deleteById(String id);
}
