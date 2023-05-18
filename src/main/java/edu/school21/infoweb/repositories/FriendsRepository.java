package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends CrudRepository<Friends, Integer> {
}
