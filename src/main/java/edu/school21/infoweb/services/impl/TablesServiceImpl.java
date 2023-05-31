package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.services.PeersService;
import edu.school21.infoweb.services.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TablesServiceImpl implements TablesService {
    @Autowired
    private PeersService peersService;

    @Override
    public TablesDTO getTables() {
        System.out.println("tableService: " + new TablesDTO.TablesDTOBuilder().peersList(peersService.getAllPeers()).build().getPeersList());
        return new TablesDTO.TablesDTOBuilder().peersList(peersService.getAllPeers()).build();
    }

    @Override
    public TablesDTO saveTables(TablesDTO tablesDTO) {
        return new TablesDTO.TablesDTOBuilder().peersList(peersService.savePeers(tablesDTO.getPeersList())).build();
    }
}
