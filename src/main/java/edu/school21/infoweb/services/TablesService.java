package edu.school21.infoweb.services;

import edu.school21.infoweb.dto.TablesDTO;

public interface TablesService {
    TablesDTO getPeers();
    TablesDTO savePeers(TablesDTO tablesDTO);

    void deletePeers(TablesDTO tablesDTO);
    TablesDTO getTasks();

    TablesDTO saveTasks(TablesDTO tablesDTO);
    void deleteTasks(TablesDTO tablesDTO);
    TablesDTO getChecks();

    TablesDTO saveChecks(TablesDTO tablesDTO);
    void deleteChecks(TablesDTO tablesDTO);
    TablesDTO getFriends();

    TablesDTO saveFriends(TablesDTO tablesDTO);
    void deleteFriends(TablesDTO tablesDTO);
}
