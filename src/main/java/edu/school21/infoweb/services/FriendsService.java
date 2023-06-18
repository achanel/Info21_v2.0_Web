package edu.school21.infoweb.services;

import edu.school21.infoweb.models.Friends;

import java.util.List;

public interface FriendsService {
    List<Friends> getAllFriends();

    List<Friends> saveFriends(List<Friends> friends);

    void deleteFriends(List<Friends> friends);
}
