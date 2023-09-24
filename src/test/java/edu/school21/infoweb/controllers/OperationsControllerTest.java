package edu.school21.infoweb.controllers;

import edu.school21.infoweb.services.TablesService;
import edu.school21.infoweb.sqlServices.OperationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = OperationsController.class)
class OperationsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    OperationsService operationsService;
    @MockBean
    TablesService tablesService;

//    AddP2PReviewParams params = new AddP2PReviewParams("achanel", "mmonarch", "DO6_CICD", "Start", "08:08");
    @Test
    void showOperationsPage() throws Exception {
        mockMvc.perform(get("/v1/operations/"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void showAddP2pCheckPage() throws Exception {
        mockMvc.perform(get("/v1/operations/add-p2p-review"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

//    @Test
//    void executeAddP2pCheckProcedure() throws Exception {
//        mockMvc.perform(post("/v1/operations/add-p2p-review", params))
//                .andDo(print())
//                .andExpectAll(
//                        status().isOk(),
//                        content().contentType("text/html;charset=UTF-8")
//                );
//    }

    @Test
    void showAddVerterCheckPage() throws Exception {
        mockMvc.perform(get("/v1/operations/add-verter-review"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeAddVerterCheck() {
    }

    @Test
    void showTransferredPointsHumanRead() throws Exception {
        mockMvc.perform(get("/v1/operations/transferred-points-human-read"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionTransferredPointsHumanRead() throws Exception {
        mockMvc.perform(post("/v1/operations/transferred-points-human-read"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void showSuccessfulChecks() throws Exception {
        mockMvc.perform(get("/v1/operations/successful-checks"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionSuccessfulChecks() {
    }

    @Test
    void showAllDayInCampus() throws Exception {
        mockMvc.perform(get("/v1/operations/all-day-in-campus"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionAllDayInCampus() {
    }

    @Test
    void showTransferredPointsChangeV1() throws Exception {
        mockMvc.perform(get("/v1/operations/fnc_peer_points_changes"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionTransferredPointsChangeV1() {
    }

    @Test
    void showTransferredPointsChangeV2() throws Exception {
        mockMvc.perform(get("/v1/operations/fnc_peer_points_changes_2"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionTransferredPointsChangeV2() {
    }

    @Test
    void showMostReviewedTask() throws Exception {
        mockMvc.perform(get("/v1/operations/most-reviewed-task"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionMostReviewedTask() {
    }

    @Test
    void showTaskBlockFunctionPage() throws Exception {
        mockMvc.perform(get("/v1/operations/task-block"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionTaskBlock() {
    }

    @Test
    void showRecommendedPeer() throws Exception {
        mockMvc.perform(get("/v1/operations/recommended-peer"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionRecommendedPeer() {
    }

    @Test
    void showBlocksComparing() throws Exception {
        mockMvc.perform(get("/v1/operations/blocks-comparing"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void testExecuteFunctionRecommendedPeer() {
    }

    @Test
    void showBirthdayCheck() throws Exception {
        mockMvc.perform(get("/v1/operations/birthday-check"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionBirthdayCheck() {
    }

    @Test
    void showCompletedTwoTaskWithoutThird() throws Exception {
        mockMvc.perform(get("/v1/operations/completed-task"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionCompletedTwoTaskWithoutThird() {
    }

    @Test
    void showTaskCountPage() throws Exception {
        mockMvc.perform(get("/v1/operations/task-count"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionTaskCount() {
    }

    @Test
    void showLuckyDaysPage() throws Exception {
        mockMvc.perform(get("/v1/operations/lucky-days"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionLuckyDays() {
    }

    @Test
    void showTopPeerPage() throws Exception {
        mockMvc.perform(get("/v1/operations/top-peer"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionTopPeer() {
    }

    @Test
    void showCampusComingPage() throws Exception {
        mockMvc.perform(get("/v1/operations/campus-coming"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionCampusComing() {
    }

    @Test
    void showCampusLeavingPage() throws Exception {
        mockMvc.perform(get("/v1/operations/campus-leaving"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionCampusLeaving() {
    }

    @Test
    void showEarlyComingPage() throws Exception {
        mockMvc.perform(get("/v1/operations/early-coming"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionEarlyComing() {
    }

    @Test
    void showOutOfCampus() throws Exception {
        mockMvc.perform(get("/v1/operations/out-of-campus"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionOutOfCampus() {
    }

    @Test
    void showLastPeer() throws Exception {
        mockMvc.perform(get("/v1/operations/last-peer"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionLastPeer() {
    }

    @Test
    void showMaxTimeInCampus() throws Exception {
        mockMvc.perform(get("/v1/operations/max-time-in-campus"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionMaxTimeInCampus() {
    }

    @Test
    void showMaxTasks() throws Exception {
        mockMvc.perform(get("/v1/operations/max-tasks"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionMaxTasks() {
    }

    @Test
    void showMaxFriends() throws Exception {
        mockMvc.perform(get("/v1/operations/max-friends"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionMaxFriends() {
    }

    @Test
    void showTotalXP() throws Exception {
        mockMvc.perform(get("/v1/operations/total-xp"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeTotalXP() {
    }

    @Test
    void showLastCheck() throws Exception {
        mockMvc.perform(get("/v1/operations/last-check-duration"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionLastCheck() {
    }

    @Test
    void showChecksPercent() throws Exception {
        mockMvc.perform(get("/v1/operations/checks-percent"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

    @Test
    void executeFunctionChecksPercent() {
    }
}