package edu.school21.infoweb.dto.functions;


import edu.school21.infoweb.exception.BusinessException;
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
public class CompletedTask {

    @Autowired
    SqlExecutor sqlExecutor;

    public List<String> execute(String firstTask, String secondTask, String thirdTask) throws BusinessException, SQLException {
        List<String> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_completed_task('" +
                        firstTask + "', '" +
                        secondTask + "', '" +
                        thirdTask + "');");

        while (rs.next()) {
            result.add(rs.getString("CheckedPeer"));
        }
        return result;
    }
}
