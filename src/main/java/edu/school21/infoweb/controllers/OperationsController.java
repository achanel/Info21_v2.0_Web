package edu.school21.infoweb.controllers;


import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.operations.AddP2PReviewParams;
import edu.school21.infoweb.models.operations.AddVerterReviewParams;
import edu.school21.infoweb.services.TablesService;
import edu.school21.infoweb.sqlServices.OperationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
@Controller
@RequestMapping("/v1/operations/")
public class OperationsController {
    @Autowired
    OperationsService operationsService;
    @Autowired
    private TablesService tablesService;

    @GetMapping
    String showOperationsPage() {
//        log.info("GET /operations");
        return "/operations/operations";
    }

    @GetMapping("/add-p2p-review")
    String showAddP2pCheckPage(Model model) {
//        log.info("GET /operations/add-p2p-review");
        model.addAttribute("tasks", tablesService.getTasks());
        model.addAttribute("addP2pCheck", new AddP2PReviewParams());
        return "/operations/add_p2p_review";
    }

    @PostMapping("/add-p2p-review")
    String executeAddP2pCheckProcedure(@ModelAttribute("addP2pCheck")AddP2PReviewParams params, Model model) throws BusinessException {
//        log.info("POST /operations/add-p2p-check");
        model.addAttribute("tasks", tablesService.getTasks());
//        if (bindingResult.hasErrors()) {
//            log.warn("bindingResult has errors: {}", bindingResult.getAllErrors());
//            return "/operations/add_p2p_check";
//        }
        operationsService.addP2PReviewProcedure(params);
        model.addAttribute("addP2pCheckSuccess", true);
        return "/operations/add_p2p_review";
    }

    @GetMapping("/add-verter-check")
    String showAddVerterCheckPage(Model model) {
//        log.info("GET /operations/add-verter-check");
        model.addAttribute("tasks", tablesService.getTasks());
        model.addAttribute("addVerterCheck", new AddVerterReviewParams());
        return "/operations/add_verter_check";
    }

    @PostMapping("/add-verter-check")
    String executeAddVerterCheck(@ModelAttribute("addVerterCheck") AddVerterReviewParams params, Model model) throws BusinessException {
//        log.info("POST /operations/add-verter-check");
        model.addAttribute("tasks", tablesService.getTasks());
//        if (bindingResult.hasErrors()) {
//            log.warn("bindingResult has errors: {}", bindingResult.getAllErrors());
//            return "/operations/add_verter_check";
//        }
        operationsService.addVerterReviewProcedure(params);
        model.addAttribute("addVerterCheckSuccess", true);
        return "/operations/add_verter_check";
    }

    @GetMapping("/transferred-points-human-read")
    String showTransferredPointsHumanRead() {
//        log.info("GET /operations/transferred-points-human-read");
        return "/operations/transferred_points_human_read";
    }

    @PostMapping("/transferred-points-human-read")
    String executeFunctionTransferredPointsHumanRead(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/transferred-points-human-read");
        model.addAttribute("entities", operationsService.executeTransferredPointsHumanRead());
        return "/operations/transferred_points_human_read";
    }

    @GetMapping("/successful-checks")
    String showSuccessfulChecks() {
//        log.info("GET /operations/successful-checks");
        return "/operations/successful_checks";
    }

    @PostMapping("/successful-checks")
    String executeFunctionSuccessfulChecks(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/successful-checks");
        model.addAttribute("entities", operationsService.executeSuccessfulChecksFunction());
        return "/operations/successful_checks";
    }

    @GetMapping("/all-day-in-campus")
    String showAllDayInCampus() {
//        log.info("GET /operations/all-day-in-campus");
        return "/operations/all_day_in_campus";
    }

    @PostMapping("/all-day-in-campus")
    String executeFunctionAllDayInCampus(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                         Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/all-day-in-campus");
        model.addAttribute("entities", operationsService.executePeersAllDayInCampusFunction(date));
        return "/operations/all_day_in_campus";
    }

    @GetMapping("/fnc_peer_points_changes")
    String showTransferredPointsChangeV1() {
//        log.info("GET /operations/transferred-points-change");
        return "/operations/fnc_peer_points_changes";
    }

    @PostMapping("/fnc_peer_points_changes")
    String executeFunctionTransferredPointsChangeV1(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/transferred-points-change");
        model.addAttribute("entities", operationsService.executePeersPointsChanges());
        return "/operations/fnc_peer_points_changes";
    }

    @GetMapping("/fnc_peer_points_changes_2")
    String showTransferredPointsChangeV2() {
//        log.info("GET /operations/transferred-points-change");
        return "/operations/fnc_peer_points_changes_2";
    }

    @PostMapping("/fnc_peer_points_changes_2")
    String executeFunctionTransferredPointsChangeV2(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/transferred-points-change");
        model.addAttribute("entities", operationsService.executePeersPointsChanges2());
        return "/operations/fnc_peer_points_changes_2";
    }

    @GetMapping("/checked-tasks")
    String showCheckedTasks() {
//        log.info("GET /operations/checked-tasks");
        return "/operations/checked_tasks";
    }

    @PostMapping("/checked-tasks")
    String executeFunctionCheckedTasks(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/checked-tasks");
        model.addAttribute("entities", operationsService.executeCheckedTaskFunction());
        return "/operations/checked_tasks";
    }

    @GetMapping("/task-block")
    String showTaskBlockFunctionPage() {
//        log.info("GET /operations/task-block");
        return "/operations/task_block";
    }

    @PostMapping("/task-block")
    String executeFunctionTaskBlock(@RequestParam String blockName, Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/task-block");
        model.addAttribute("entities", operationsService.executeTaskBlockFunction(blockName));
        return "/operations/task_block";
    }

    @GetMapping("/recommended-peer")
    String showRecommendedPeer() {
//        log.info("GET /operations/recommended-peer");
        return "/operations/recommended_peer";
    }

    @PostMapping("/recommended-peer")
    String executeFunctionRecommendedPeer(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/recommended-peer");
        model.addAttribute("entities", operationsService.executeRecommendedPeerFunction());
        return "/operations/recommended_peer";
    }

    @GetMapping("/blocks-comparing")
    String showBlocksComparing() {
//        log.info("GET /operations/blocks-comparing");
        return "/operations/blocks_comparing";
    }

    @PostMapping("/blocks-comparing")
    String executeFunctionRecommendedPeer(@RequestParam String firstBlock, @RequestParam String secondBlock,
                                          Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/blocks-comparing");
        model.addAttribute("entities", operationsService.executeTwoBlockCompareFunction(firstBlock, secondBlock));
        return "/operations/blocks_comparing";
    }

    @GetMapping("/birthday-check")
    String showBirthdayCheck() {
//        log.info("GET /operations/birthday-check");
        return "/operations/birthday_check";
    }

    @PostMapping("/birthday-check")
    String executeFunctionBirthdayCheck(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/birthday-check");
        model.addAttribute("entities", operationsService.executeBirthdayCheckFunction());
        return "/operations/birthday_check";
    }

    @GetMapping("/completed-task")
    String showCompletedTwoTaskWithoutThird(Model model) {
//        log.info("GET /operations/completed-two-tasks");
        model.addAttribute("tasks", tablesService.getTasks());
        return "/operations/completed_task";
    }

    @PostMapping("/completed-task")
    String executeFunctionCompletedTwoTaskWithoutThird(@RequestParam String firstTask,
                                                       @RequestParam String secondTask,
                                                       @RequestParam String thirdTask,
                                                       Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/birthday-check");
        model.addAttribute("entities",
                operationsService.executeCompletedTwoTaskWithoutThirdFunction(firstTask, secondTask, thirdTask));
        model.addAttribute("tasks", tablesService.getTasks());
        return "/operations/completed_task";
    }

    @GetMapping("/task-count")
    String showTaskCountPage() {
//        log.info("GET /operations/task-count");
        return "/operations/task_count";
    }

    @PostMapping("/task-count")
    String executeFunctionTaskCount(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/task-count");
        model.addAttribute("entities", operationsService.executeTaskCountFunction());
        return "/operations/task_count";
    }

    @GetMapping("/lucky-days")
    String showLuckyDaysPage() {
//        log.info("GET /operations/lucky-days");
        return "/operations/lucky_days";
    }

    @PostMapping("/lucky-days")
    String executeFunctionLuckyDays(@RequestParam Integer n, Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/lucky-days");
        model.addAttribute("entities", operationsService.executeLuckyDaysFunction(n));
        return "/operations/lucky_days";
    }

    @GetMapping("/top-peer")
    String showTopPeerPage() {
//        log.info("GET /operations/top-peer");
        return "/operations/top_peer";
    }

    @PostMapping("/top-peer")
    String executeFunctionTopPeer(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/top-peer");
        model.addAttribute("entity", operationsService.executeTopPeerFunction());
        return "/operations/top_peer";
    }

    @GetMapping("/campus-coming")
    String showCampusComingPage() {
//        log.info("GET /operations/campus-coming");
        return "/operations/campus_coming";
    }

    @PostMapping("/campus-coming")
    String executeFunctionCampusComing(@RequestParam LocalTime time,
                                      @RequestParam Integer n,
                                      Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/campus-coming");
        model.addAttribute("entities", operationsService.executeCampusComingFunction(time, n));
        return "/operations/campus_coming";
    }

    @GetMapping("/campus-leaving")
    String showCampusLeavingPage() {
//        log.info("GET /operations/campus-leaving");
        return "/operations/campus_leaving";
    }

    @PostMapping("/campus-leaving")
    String executeFunctionCampusLeaving(@RequestParam Integer n,
                                      @RequestParam Integer m,
                                      Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/campus-leaving");
        model.addAttribute("entities", operationsService.executeLeavingFromCampusFunction(n, m));
        return "/operations/campus_leaving";
    }

    @GetMapping("/early-coming")
    String showEarlyComingPage() {
//        log.info("GET /operations/early-coming");
        return "/operations/early_coming";
    }

    @PostMapping("/early-coming")
    String executeFunctionEarlyComing(Model model) throws BusinessException, SQLException {
//        log.info("POST /operations/early-coming");
        model.addAttribute("entities", operationsService.executeEarlyComingFunction());
        return "/operations/early_coming";
    }
}
