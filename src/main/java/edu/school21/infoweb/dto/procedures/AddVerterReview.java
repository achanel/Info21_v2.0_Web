package edu.school21.infoweb.dto.procedures;

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

    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(AddVerterReview.class);
    @Autowired
    SqlExecutor sqlExecutor;

    public void execute(String checkedPeer, String taskTitle, String state, String checkTime) throws BusinessException {
        log.info("start execute procedure add_verter_review");
        sqlExecutor.execute("call add_verter_review('" +
                checkedPeer + "', '" +
                taskTitle + "', '" +
                state + "', '" +
                checkTime + ":00');");
        log.info("procedure add_verter_review was executed");
    }
}
