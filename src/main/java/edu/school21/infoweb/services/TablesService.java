package edu.school21.infoweb.services;

import edu.school21.infoweb.dto.TablesDTO;

public interface TablesService {
    TablesDTO getTable();
    TablesDTO saveTable(TablesDTO tablesDTO);

    void deleteTable(TablesDTO tablesDTO);
}
