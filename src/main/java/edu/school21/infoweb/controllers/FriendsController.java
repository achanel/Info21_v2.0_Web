package edu.school21.infoweb.controllers;

import edu.school21.infoweb.utils.CSVExecutor;
import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.services.TablesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendsController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String friendsRead() {
        log.info("Read friends table");
        return "/friends/read";
    }

    @GetMapping("/create")
    String createFriends() {
        log.info("Create friends table");
        return "/friends/create";
    }

    @GetMapping("/update")
    String showUpdatFriends() {
        log.info("Update friends table");
        return "/friends/update";
    }

    @GetMapping("/delete")
    String showDeleteFriends() {
        log.info("Delete friends table");
        return "/friends/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export friends table to csv");
        csvExecutor.writeFriendsCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import friends table from csv");
        csvExecutor.readCSV("Friends");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
