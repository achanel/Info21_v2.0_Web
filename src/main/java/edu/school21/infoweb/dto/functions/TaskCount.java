package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.SqlResult;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class TaskCount {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(TaskCount.class);
    @Autowired
    SqlExecutor sqlExecutor;

    public List<SqlResult> execute() throws BusinessException, SQLException {
        log.info("start execute function fnc_pre_task().");
        List<SqlResult> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_pre_task();");

        while (rs.next()) {
            result.add(new SqlResult(
                    rs.getString("Task"),
                    rs.getInt("PrevCount")
            ));
        }
        return result;
    }
}
