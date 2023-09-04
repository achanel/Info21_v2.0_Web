package edu.school21.infoweb.services;

import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.models.Tasks;

import java.util.List;

public interface TablesService {
    TablesDTO getTable();
    TablesDTO saveTable(TablesDTO tablesDTO);

    void deleteTable(TablesDTO tablesDTO);
    TablesDTO getP2PTable();
    List<Tasks> getTasks();
}
