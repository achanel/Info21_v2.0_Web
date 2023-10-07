package infoweb.controllers;

import edu.school21.infoweb.controllers.OperationsController;
import edu.school21.infoweb.models.operations.AddP2PReviewParams;
import edu.school21.infoweb.models.operations.AddVerterReviewParams;
import edu.school21.infoweb.services.TablesService;
import edu.school21.infoweb.sqlServices.OperationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OperationsController.class)
class OperationsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    OperationsService operationsService;
    @MockBean
    TablesService tablesService;

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

    @Test
    void executeAddP2pCheckProcedure() throws Exception {
        mockMvc.perform(post("/v1/operations/add-p2p-review", new AddP2PReviewParams()))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }

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
    void executeAddVerterCheck() throws Exception {
        mockMvc.perform(post("/v1/operations/add-verter-review", new AddVerterReviewParams()))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionSuccessfulChecks() throws Exception {
        mockMvc.perform(post("/v1/operations/successful-checks"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionAllDayInCampus() throws Exception {
        mockMvc.perform(post("/v1/operations/all-day-in-campus")
                        .param("date", String.valueOf(LocalDate.now())))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionTransferredPointsChangeV1() throws Exception {
        mockMvc.perform(post("/v1/operations/fnc_peer_points_changes"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionTransferredPointsChangeV2() throws Exception {
        mockMvc.perform(post("/v1/operations/fnc_peer_points_changes_2"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionMostReviewedTask() throws Exception {
        mockMvc.perform(post("/v1/operations/most-reviewed-task"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionTaskBlock() throws Exception {
        mockMvc.perform(post("/v1/operations/task-block")
                        .param("blockName","C"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionRecommendedPeer() throws Exception {
        mockMvc.perform(post("/v1/operations/recommended-peer"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void testExecuteFunctionRecommendedPeer() throws Exception {
        mockMvc.perform(post("/v1/operations/blocks-comparing")
                        .param("firstBlock","C")
                        .param("secondBlock", "CPP"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionBirthdayCheck() throws Exception {
        mockMvc.perform(post("/v1/operations/birthday-check"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionCompletedTwoTaskWithoutThird() throws Exception {
        mockMvc.perform(post("/v1/operations/completed-task")
                        .param("firstTask","C2_SimpleBashUtils")
                        .param("secondTask", "DO1_Linux")
                        .param("thirdTask", "CPP1_s21_matrix+"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionTaskCount() throws Exception {
        mockMvc.perform(post("/v1/operations/task-count"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionLuckyDays() throws Exception {
        mockMvc.perform(post("/v1/operations/lucky-days")
                        .param("n","1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionTopPeer() throws Exception {
        mockMvc.perform(post("/v1/operations/top-peer"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionCampusComing() throws Exception {
        mockMvc.perform(post("/v1/operations/campus-coming")
                        .param("time", String.valueOf(LocalTime.now()))
                        .param("n","1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionCampusLeaving() throws Exception {
        mockMvc.perform(post("/v1/operations/campus-leaving")
                        .param("n","1000")
                        .param("m","1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionEarlyComing() throws Exception {
        mockMvc.perform(post("/v1/operations/early-coming"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionOutOfCampus() throws Exception {
        mockMvc.perform(post("/v1/operations/out-of-campus")
                        .param("n","1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionLastPeer() throws Exception {
        mockMvc.perform(post("/v1/operations/last-peer"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionMaxTimeInCampus() throws Exception {
        mockMvc.perform(post("/v1/operations/max-time-in-campus"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionMaxTasks() throws Exception {
        mockMvc.perform(post("/v1/operations/max-tasks"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionMaxFriends() throws Exception {
        mockMvc.perform(post("/v1/operations/max-friends")
                        .param("n", "1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeTotalXP() throws Exception {
        mockMvc.perform(post("/v1/operations/total-xp"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionLastCheck() throws Exception {
        mockMvc.perform(post("/v1/operations/last-check-duration"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
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
    void executeFunctionChecksPercent() throws Exception {
        mockMvc.perform(post("/v1/operations/checks-percent"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().contentType("text/html;charset=UTF-8")
                );
    }
}