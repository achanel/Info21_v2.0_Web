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
    @Autowired
    private P2PService p2PService;
    @Autowired
    private RecommendationsService recommendationsService;
    @Autowired
    private TimeTrackingService timeTrackingService;
    @Autowired
    private TransferredPointsService transferredPointsService;
    @Autowired
    private VerterService verterService;
    @Autowired
    private XPService xpService;

    @Override
    public TablesDTO getTable() {
        return TablesDTO.builder()
                .peersList(peersService.getAllPeers())
                .tasksList(tasksService.getAllTasks())
                .checksList(checksService.getAllChecks())
                .friendsList(friendsService.getAllFriends())
                .p2PList(p2PService.getAllP2P())
                .recommendationsList(recommendationsService.getAllRecommendations())
                .timeTrackingList(timeTrackingService.getAllTimeTracking())
                .transferredPointsList(transferredPointsService.getAllTransferredPoints())
                .verterList(verterService.getAllVerter())
                .xpList(xpService.getAllXP())
                .build();
    }
    @Override
    public TablesDTO saveTable(TablesDTO tablesDTO) {
        return TablesDTO.builder()
                .peersList(peersService.savePeers(tablesDTO.getPeersList()))
                .tasksList(tasksService.saveTasks(tablesDTO.getTasksList()))
                .checksList(checksService.saveChecks(tablesDTO.getChecksList()))
                .friendsList(friendsService.saveFriends(tablesDTO.getFriendsList()))
                .p2PList(p2PService.saveP2P(tablesDTO.getP2PList()))
                .recommendationsList(recommendationsService
                        .saveRecommendations(tablesDTO.getRecommendationsList()))
                .timeTrackingList(timeTrackingService.saveTimeTracking(tablesDTO.getTimeTrackingList()))
                .transferredPointsList(transferredPointsService
                        .saveTransferredPoints(tablesDTO.getTransferredPointsList()))
                .verterList(verterService.saveVerter(tablesDTO.getVerterList()))
                .xpList(xpService.saveXP(tablesDTO.getXpList()))
                .build();
    }
    @Override
    public void deleteTable(TablesDTO tablesDTO) {
        peersService.deletePeer(tablesDTO.getPeersList());
        tasksService.deleteTasks(tablesDTO.getTasksList());
        checksService.deleteChecks(tablesDTO.getChecksList());
        friendsService.deleteFriends(tablesDTO.getFriendsList());
        p2PService.deleteP2P(tablesDTO.getP2PList());
        recommendationsService.deleteRecommendations(tablesDTO.getRecommendationsList());
        timeTrackingService.deleteTimeTracking(tablesDTO.getTimeTrackingList());
        transferredPointsService.deleteTransferredPoints(tablesDTO.getTransferredPointsList());
        verterService.deleteVerter(tablesDTO.getVerterList());
        xpService.deleteXP(tablesDTO.getXpList());
    }

    @Override
    public TablesDTO getP2PTable() {
        return TablesDTO.builder()
                .p2PList(p2PService.getAllP2P())
                .build();
    }
}
