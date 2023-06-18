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
    public TablesDTO getTable() {
        return TablesDTO.builder()
                .peersList(peersService.getAllPeers())
                .tasksList(tasksService.getAllTasks())
//                .checksList(checksService.getAllChecks())
                .build();
    }
    @Override
    public TablesDTO saveTable(TablesDTO tablesDTO) {
        return TablesDTO.builder()
                .peersList(peersService.savePeers(tablesDTO.getPeersList()))
                .tasksList(tasksService.saveTasks(tablesDTO.getTasksList()))
//                .checksList(checksService.saveChecks(tablesDTO.getChecksList()))
                .build();
    }
    @Override
    public void deleteTable(TablesDTO tablesDTO) {
        peersService.deletePeer(tablesDTO.getPeersList());
        tasksService.deleteTasks(tablesDTO.getTasksList());
//        checksService.deleteChecks(tablesDTO.getChecksList());
    }
}
