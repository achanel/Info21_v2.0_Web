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
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TotalXp {
    @Autowired
    SqlExecutor sqlExecutor;

    public List<SqlResult> execute() throws BusinessException, SQLException {
        log.info("start execute function fnc_total_xp().");
        List<SqlResult> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_total_xp()");

        while (rs.next()) {
            result.add(new SqlResult(
                    rs.getString("Peer"),
                    rs.getInt("Xp"),
                    "1.0")
            );
        }
        return result;
    }
}
