package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.Friends;
import edu.school21.infoweb.repositories.FriendsRepository;
import edu.school21.infoweb.services.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {
    @Autowired
    private FriendsRepository friendsRepository;

    @Override
    @Transactional
    public List<Friends> getAllFriends() {
        System.out.println("friendsService: " + friendsRepository.findAll());
        return friendsRepository.findAll();
    }

    @Override
    @Transactional
    public List<Friends> saveFriends(List<Friends> friends) {
        return friends == null ?
                null : (List<Friends>) friendsRepository.saveAll(friends);
    }

    @Override
    public void deleteFriends(List<Friends> friends) {
        if (friends != null) {
            friendsRepository.deleteAll(friends);
        }
    }
}
