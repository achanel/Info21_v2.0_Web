package edu.school21.infoweb.sqlServices;

import edu.school21.infoweb.dto.functions.*;
import edu.school21.infoweb.dto.procedures.AddP2PReview;
import edu.school21.infoweb.dto.procedures.AddVerterReview;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.SqlResult;
import edu.school21.infoweb.models.TransferredPoints;
import edu.school21.infoweb.models.operations.AddP2PReviewParams;
import edu.school21.infoweb.models.operations.AddVerterReviewParams;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Component
@Data
public class OperationsService {
    private final AddP2PReview addP2PReview;
    private final AddVerterReview addVerterReview;
    private final TransferredPointsHumanReadFunction transferredPointsHumanReadFunction;
    private final SuccessfulChecksFunction successfulChecksFunction;
    private final PeersAllDayInCampusFunction peersAllDayInCampusFunction;
    private final FncPeerPointsChanges fncPeerPointsChanges;
    private final FncPeerPointsChanges2 fncPeerPointsChanges2;
    private final CheckedTaskFunction checkedTaskFunction;
    private final TaskBlockFunction taskBlockFunction;
    private final RecommendedPeerFunction recommendedPeerFunction;
    private final TwoBlockCompareFunction twoBlockCompareFunction;
    private final BirthdayCheckFunction birthdayCheckFunction;
    private final CompletedTask completedTask;
    private final TaskCount taskCount;
    private final LuckyDays luckyDays;
    private final TopPeer topPeer;
    private final CampusComingFunction campusComingFunction;
    private final LeavingFromCampus leavingFromCampus;
    private final EarlyComingFunction earlyComingFunction;


    public OperationsService(AddP2PReview addP2PReview, AddVerterReview addVerterReview,
                             TransferredPointsHumanReadFunction transferredPointsHumanReadFunction,
                             SuccessfulChecksFunction successfulChecksFunction, PeersAllDayInCampusFunction peersAllDayInCampusFunction,
                             FncPeerPointsChanges fncPeerPointsChanges, FncPeerPointsChanges2 fncPeerPointsChanges2,
                             CheckedTaskFunction checkedTaskFunction, TaskBlockFunction taskBlockFunction,
                             RecommendedPeerFunction recommendedPeerFunction, TwoBlockCompareFunction twoBlockCompareFunction,
                             BirthdayCheckFunction birthdayCheckFunction, CompletedTask completedTask,
                             TaskCount taskCount, LuckyDays luckyDays, TopPeer topPeer, CampusComingFunction campusComingFunction,
                             LeavingFromCampus leavingFromCampus, EarlyComingFunction earlyComingFunction) {
        this.addP2PReview = addP2PReview;
        this.addVerterReview = addVerterReview;
        this.transferredPointsHumanReadFunction = transferredPointsHumanReadFunction;
        this.successfulChecksFunction = successfulChecksFunction;
        this.peersAllDayInCampusFunction = peersAllDayInCampusFunction;
        this.fncPeerPointsChanges = fncPeerPointsChanges;
        this.fncPeerPointsChanges2 = fncPeerPointsChanges2;
        this.checkedTaskFunction = checkedTaskFunction;
        this.taskBlockFunction = taskBlockFunction;
        this.recommendedPeerFunction = recommendedPeerFunction;
        this.twoBlockCompareFunction = twoBlockCompareFunction;
        this.birthdayCheckFunction = birthdayCheckFunction;
        this.completedTask = completedTask;
        this.taskCount = taskCount;
        this.luckyDays = luckyDays;
        this.topPeer = topPeer;
        this.campusComingFunction = campusComingFunction;
        this.leavingFromCampus = leavingFromCampus;
        this.earlyComingFunction = earlyComingFunction;
    }

    public void addP2PReviewProcedure(AddP2PReviewParams dto) throws BusinessException {
        addP2PReview.execute(dto.getCheckingPeer(), dto.getCheckedPeer(), dto.getTaskTitle(), dto.getState(), dto.getCheckTime());
    }

    public void addVerterReviewProcedure(AddVerterReviewParams dto) throws BusinessException {
        addVerterReview.execute(dto.getCheckedPeer(), dto.getTaskTitle(), dto.getState(), dto.getCheckTime());
    }

    public List<TransferredPoints> executeTransferredPointsHumanRead() throws BusinessException, SQLException {
        return transferredPointsHumanReadFunction.execute();
    }

    public List<SqlResult> executeSuccessfulChecksFunction() throws BusinessException, SQLException {
        return successfulChecksFunction.execute();
    }

    public List<String> executePeersAllDayInCampusFunction(LocalDate day) throws BusinessException, SQLException {
        return peersAllDayInCampusFunction.execute(day);
    }

    public List<SqlResult> executePeersPointsChanges() throws BusinessException, SQLException {
        return fncPeerPointsChanges.execute();
    }

    public List<SqlResult> executePeersPointsChanges2() throws BusinessException, SQLException {
        return fncPeerPointsChanges2.execute();
    }

    public List<SqlResult> executeCheckedTaskFunction() throws BusinessException, SQLException {
        return checkedTaskFunction.execute();
    }

    public List<SqlResult> executeTaskBlockFunction(String blockName) throws BusinessException, SQLException {
        return taskBlockFunction.execute(blockName);
    }

    public List<SqlResult> executeRecommendedPeerFunction() throws BusinessException, SQLException {
        return recommendedPeerFunction.execute();
    }

    public List<SqlResult> executeTwoBlockCompareFunction(String firstBlock, String secondBlock) throws BusinessException, SQLException {
        return twoBlockCompareFunction.execute(firstBlock, secondBlock);
    }

    public List<SqlResult> executeBirthdayCheckFunction() throws BusinessException, SQLException {
        return birthdayCheckFunction.execute();
    }

    public List<String> executeCompletedTwoTaskWithoutThirdFunction(String firstTask, String secondTask, String thirdTask) throws BusinessException, SQLException {
        return completedTask.execute(firstTask, secondTask, thirdTask);
    }

    public List<SqlResult> executeTaskCountFunction() throws BusinessException, SQLException {
        return taskCount.execute();
    }

    public List<Date> executeLuckyDaysFunction(Integer n) throws BusinessException, SQLException {
        return luckyDays.execute(n);
    }

    public SqlResult executeTopPeerFunction() throws BusinessException, SQLException {
        return topPeer.execute();
    }

    public List<String> executeCampusComingFunction(LocalTime time, Integer n) throws BusinessException, SQLException {
        return campusComingFunction.execute(time, n);
    }

    public List<String> executeLeavingFromCampusFunction(Integer n, Integer m) throws BusinessException, SQLException {
        return leavingFromCampus.execute(n, m);
    }

    public List<SqlResult> executeEarlyComingFunction() throws BusinessException, SQLException {
        return earlyComingFunction.execute();
    }
}
