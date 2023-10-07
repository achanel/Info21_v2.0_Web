package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.csv.CSVExecutor;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.SqlResult;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class SuccessfulChecksFunction {
    @Autowired
    SqlExecutor sqlExecutor;
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(SuccessfulChecksFunction.class);
    public List<SqlResult> execute() throws BusinessException, SQLException {
        log.info("start execute function fnc_successful_checks().");
        List<SqlResult> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_successful_checks()");

        while(rs.next()) {
            result.add(new SqlResult(
                    rs.getString("peer"),
                    rs.getString("task"),
                    rs.getInt("xp"),
                    "1.0"
            ));
        }
        return result;
    }
}