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

import java.sql.SQLException;
import java.time.LocalDate;
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
//    private final TransferedPointsHumanReadMapper transferedPointsHumanReadMapper;
//    private final TransferredPointsChangeFunctionV2 transferredPointsChangeFunctionV2;
//    private final CheckedTaskFunction checkedTaskFunction;
//    private final TaskBlockFunction taskBlockFunction;
//    private final RecommendedPeerFunction recommendedPeerFunction;
    private final TwoBlockCompareFunction twoBlockCompareFunction;
//    private final BirthdayCheckFunction birthdayCheckFunction;
//    private final CompletedTwoTaskWithoutThirdFunction completedTwoTaskWithoutThirdFunction;
//    private final TaskCountFunction taskCountFunction;
//    private final LuckyDaysFunction luckyDaysFunction;
//    private final TopPeerFunction topPeerFunction;
//    private final CampusComingFunction campusComingFunction;
//    private final LeavingFromCampusFunction leavingFromCampusFunction;
//    private final EarlyComingFunction earlyComingFunction;


    public OperationsService(AddP2PReview addP2PReview, AddVerterReview addVerterReview,
                             TransferredPointsHumanReadFunction transferredPointsHumanReadFunction,
                             SuccessfulChecksFunction successfulChecksFunction, PeersAllDayInCampusFunction peersAllDayInCampusFunction,
                             FncPeerPointsChanges fncPeerPointsChanges, TwoBlockCompareFunction twoBlockCompareFunction) {
        this.addP2PReview = addP2PReview;
        this.addVerterReview = addVerterReview;
        this.transferredPointsHumanReadFunction = transferredPointsHumanReadFunction;
        this.successfulChecksFunction = successfulChecksFunction;
        this.peersAllDayInCampusFunction = peersAllDayInCampusFunction;
        this.fncPeerPointsChanges = fncPeerPointsChanges;
        this.twoBlockCompareFunction = twoBlockCompareFunction;
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
//
//    public List<TransferredPointChangeResult> executeTransferredPointsChangeFunctionV2() {
//        return transferredPointsChangeFunctionV2.execute();
//    }
//
//    public List<CheckedTaskResult> executeCheckedTaskFunction() {
//        return checkedTaskFunction.execute();
//    }
//
//    public List<TaskBlockResult> executeTaskBlockFunction(String blockName) {
//        return taskBlockFunction.execute(blockName);
//    }
//
//    public List<RecommendedPeerResult> executeRecommendedPeerFunction() {
//        return recommendedPeerFunction.execute();
//    }

    public List<SqlResult> executeTwoBlockCompareFunction(String firstBlock, String secondBlock) throws BusinessException, SQLException {
        return twoBlockCompareFunction.execute(firstBlock, secondBlock);
    }

//    public List<BirthdayCheckResult> executeBirthdayCheckFunction() {
//        return birthdayCheckFunction.execute();
//    }
//
//    public List<String> executeCompletedTwoTaskWithoutThirdFunction(String firstTask, String secondTask, String thirdTask) {
//        return completedTwoTaskWithoutThirdFunction.execute(firstTask, secondTask, thirdTask);
//    }
//    public List<TaskCountResult> executeTaskCountFunction() {
//        return taskCountFunction.execute();
//    }
//    public List<LocalDate> executeLuckyDaysFunction(Integer n) {
//        return luckyDaysFunction.execute(n);
//    }
//
//    public TopPeerResult executeTopPeerFunction() {
//        return topPeerFunction.execute();
//    }
//
//    public List<String> executeCampusComingFunction(LocalTime time, Integer n) {
//        return campusComingFunction.execute(time, n);
//    }
//
//    public List<String> executeLeavingFromCampusFunction(Integer n, Integer m) {
//        return leavingFromCampusFunction.execute(n, m);
//    }
//    public List<EarlyComingResult> executeEarlyComingFunction() {
//        return earlyComingFunction.execute();
//    }

}
