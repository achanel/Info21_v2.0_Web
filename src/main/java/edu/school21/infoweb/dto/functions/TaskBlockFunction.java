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
public class TaskBlockFunction {
    @Autowired
    SqlExecutor sqlExecutor;

    public List<SqlResult> execute(String blockName) throws BusinessException, SQLException {
        List<SqlResult> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_task_block('" + blockName + "')");

        while(rs.next()) {
            result.add(new SqlResult(
                    rs.getString("Peer"),
                    rs.getDate("CDate")
            ));
        }
        return result;
    }
}
