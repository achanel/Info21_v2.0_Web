package edu.school21.infoweb.dto.sqlOperations.procedures;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddP2PReview {
    @Autowired
    SqlExecutor sqlExecutor;
//-- call add_p2p_review('mmonarch', 'rhoke', 'DO2_Linux Network', 'Start'::check_state, '11:12:13');
    public void execute(String checkingPeer, String checkedPeer, String taskTitle, String state, String checkTime) throws BusinessException {
//        log.info("start execute procedure add_p2p_review. Parameters: {{}, {}, {}, {}, {}}", checkingPeer, checkedPeer, taskTitle, state, checkTime);
        sqlExecutor.execute("call add_p2p_review('" +
                checkingPeer + "', '" +
                checkedPeer + "', '" +
                taskTitle + "', '" +
                state + "'::check_state, '" +
                checkTime + ":00');");
//            log.info("procedure add_p2p_review was executed");
    }
}
