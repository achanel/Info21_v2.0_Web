package edu.school21.infoweb.dto.sqlOperations.procedures;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddVerterReview {

    @Autowired
    SqlExecutor sqlExecutor;

    public void execute(String checkedPeer, String taskTitle, String state, String checkTime, Integer flag) throws BusinessException {
//        log.info("start execute procedure add_p2p_review. Parameters: {{}, {}, {}, {}, {}}", checkingPeer, checkedPeer, taskTitle, state, checkTime);
        sqlExecutor.execute("call add_verter_review('" +
                        checkedPeer + "', '" +
                        taskTitle + "', '" +
                        state + "', '" +
                        checkTime + ":00');",
                flag);
//            log.info("procedure add_p2p_review was executed");
    }
}
