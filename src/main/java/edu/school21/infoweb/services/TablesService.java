package edu.school21.infoweb.services;

import edu.school21.infoweb.dto.TablesDTO;

public interface TablesService {
    TablesDTO getTables();

    TablesDTO saveTables(TablesDTO tablesDTO);
}
