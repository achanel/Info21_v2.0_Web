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
public class EarlyComingFunction {
    @Autowired
    SqlExecutor sqlExecutor;
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(EarlyComingFunction.class);
    public List<SqlResult> execute() throws BusinessException, SQLException {
        log.info("start execute function fnc_early_coming().");
        List<SqlResult> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_early_coming()");

        while(rs.next()) {
            result.add(new SqlResult(
                    rs.getString("Month"),
                    rs.getInt("EarlyEntries"),
                    1.0
            ));
        }
        return result;
    }
}
