package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.SqlResult;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Component
@RequiredArgsConstructor
public class LastCheck {
    @Autowired
    SqlExecutor sqlExecutor;

    public SqlResult execute() throws BusinessException, SQLException {
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_last_check_duration()");
        rs.next();
        return new SqlResult(
                rs.getTime("Times"));
    }
}