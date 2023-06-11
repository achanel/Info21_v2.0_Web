package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends CrudRepository<Friends, Long> {
    List<Friends> findAll();
}