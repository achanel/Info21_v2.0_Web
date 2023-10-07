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


@Component
@RequiredArgsConstructor
public class ChecksPercent {
    @Autowired
    SqlExecutor sqlExecutor;
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(ChecksPercent.class);
    public SqlResult execute() throws BusinessException, SQLException {
        log.info("start execute function fnc_checks_percent().");
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_checks_percent()");
        rs.next();
        return new SqlResult(
                rs.getDouble("successfulchecks"),
                rs.getDouble("unsuccessfulchecks"),
                1.0);
    }
}