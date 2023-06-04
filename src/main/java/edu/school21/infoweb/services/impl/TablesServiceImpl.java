package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TablesServiceImpl implements TablesService {
    @Autowired
    private PeersService peersService;
    @Autowired
    private TasksService tasksService;
    @Autowired
    private ChecksService checksService;
    @Autowired
    private FriendsService friendsService;

    @Override
    public TablesDTO getPeers() {
        return TablesDTO.builder().peersList(peersService.getAllPeers()).build();
    }
    @Override
    public TablesDTO savePeers(TablesDTO tablesDTO) {
        return TablesDTO.builder().peersList(peersService.savePeers(tablesDTO.getPeersList())).build();
    }
    @Override
    public void deletePeers(TablesDTO tablesDTO) {
        peersService.deletePeer(tablesDTO.getPeersList());
    }
    @Override
    public TablesDTO getTasks() {
        return TablesDTO.builder().tasksList(tasksService.getAllTasks()).build();
    }
    @Override
    public TablesDTO saveTasks(TablesDTO tablesDTO) {
        return TablesDTO.builder().tasksList(tasksService.saveTasks(tablesDTO.getTasksList())).build();
    }
    @Override
    public void deleteTasks(TablesDTO tablesDTO) {
        tasksService.deleteTasks(tablesDTO.getTasksList());
    }

    @Override
    public TablesDTO getChecks() {
        return TablesDTO.builder().checksList(checksService.getAllChecks()).build();
    }
    @Override
    public TablesDTO saveChecks(TablesDTO tablesDTO) {
        return TablesDTO.builder().checksList(checksService.saveChecks(tablesDTO.getChecksList())).build();
    }
    @Override
    public void deleteChecks(TablesDTO tablesDTO) {
        checksService.deleteChecks(tablesDTO.getChecksList());
    }
    @Override
    public TablesDTO getFriends() {
        return TablesDTO.builder().friendsList(friendsService.getAllFriends()).build();
    }
    @Override
    public TablesDTO saveFriends(TablesDTO tablesDTO) {
        return TablesDTO.builder().friendsList(friendsService.saveFriends(tablesDTO.getFriendsList())).build();
    }
    @Override
    public void deleteFriends(TablesDTO tablesDTO) {
        friendsService.deleteFriends(tablesDTO.getFriendsList());
    }
}
