package edu.school21.infoweb.sqlServices;

import edu.school21.infoweb.dto.sqlOperations.procedures.AddP2PReview;
import edu.school21.infoweb.dto.sqlOperations.procedures.AddVerterReview;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.operations.AddP2PReviewParams;
import edu.school21.infoweb.models.operations.AddVerterReviewParams;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Data
public class OperationsService {
    private final AddP2PReview addP2PReview;
    private final AddVerterReview addVerterReview;
//    private final TransferredPointsHumanReadFunction transferredPointsHumanReadFunction;
//    private final TransferedPointsHumanReadMapper transferedPointsHumanReadMapper;
//    private final SuccessfulChecksFunction successfulChecksFunction;
//    private final PeersAllDayInCampusFunction peersAllDayInCampusFunction;
//    private final TransferredPointsChangeFunctionV1 transferredPointsChangeFunctionV1;
//    private final TransferredPointsChangeFunctionV2 transferredPointsChangeFunctionV2;
//    private final CheckedTaskFunction checkedTaskFunction;
//    private final TaskBlockFunction taskBlockFunction;
//    private final RecommendedPeerFunction recommendedPeerFunction;
//    private final TwoBlockCompareFunction twoBlockCompareFunction;
//    private final BirthdayCheckFunction birthdayCheckFunction;
//    private final CompletedTwoTaskWithoutThirdFunction completedTwoTaskWithoutThirdFunction;
//    private final TaskCountFunction taskCountFunction;
//    private final LuckyDaysFunction luckyDaysFunction;
//    private final TopPeerFunction topPeerFunction;
//    private final CampusComingFunction campusComingFunction;
//    private final LeavingFromCampusFunction leavingFromCampusFunction;
//    private final EarlyComingFunction earlyComingFunction;


    public OperationsService(AddP2PReview addP2PReview, AddVerterReview addVerterReview) {
        this.addP2PReview = addP2PReview;
        this.addVerterReview = addVerterReview;
    }

    public void addP2PReviewProcedure(AddP2PReviewParams dto) throws BusinessException {
        addP2PReview.execute(dto.getCheckingPeer(), dto.getCheckedPeer(), dto.getTaskTitle(), dto.getState(), dto.getCheckTime(), 1);
    }

    public void addVerterReviewProcedure(AddVerterReviewParams dto) throws BusinessException {
        addVerterReview.execute(dto.getCheckedPeer(), dto.getTaskTitle(), dto.getState(), dto.getCheckTime(), 1);
    }

//    public List<TransferredPointDto> executeTransferredPointsHumanRead() {
//        List<Map<String, Object>> execute = transferredPointsHumanReadFunction.execute();
//        return transferedPointsHumanReadMapper.map(execute);
//    }
//
//    public List<SuccessfulCheckResult> executeSuccessfulChecksFunction() {
//        return successfulChecksFunction.execute();
//    }
//
//    public List<String> executePeersAllDayInCampusFunction(LocalDate day) {
//        return peersAllDayInCampusFunction.execute(day);
//    }
//
//    public List<TransferredPointChangeResult> executeTransferredPointsChangeFunctionV1() {
//        return transferredPointsChangeFunctionV1.execute();
//    }
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
//
//    public List<TwoBlockCompareResult> executeTwoBlockCompareFunction(String firstBlock, String secondBlock) {
//        return twoBlockCompareFunction.execute(firstBlock, secondBlock);
//    }
//
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
