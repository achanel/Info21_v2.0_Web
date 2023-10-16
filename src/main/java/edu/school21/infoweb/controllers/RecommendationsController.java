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
@RequestMapping("/recommendations")
public class RecommendationsController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String recommendationsRead() {
        log.info("Read recommendations table");
        return "/recommendations/read";
    }

    @GetMapping("/create")
    String createRecommendations() {
        log.info("Create recommendations table");
        return "/recommendations/create";
    }

    @GetMapping("/update")
    String showUpdateRecommendations() {
        log.info("Update recommendations table");
        return "/recommendations/update";
    }

    @GetMapping("/delete")
    String showDeleteRecommendations() {
        log.info("Delete recommendations table");
        return "/recommendations/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export recommendations table to csv");
        csvExecutor.writeRecommendationsCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import recommendations table from csv");
        csvExecutor.readCSV("Recommendations");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
