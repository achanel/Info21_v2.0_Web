package edu.school21.infoweb.dto.functions;


import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PeersAllDayInCampusFunction {
    @Autowired
    SqlExecutor sqlExecutor;

    public List<String> execute(LocalDate day) throws BusinessException, SQLException {
        List<String> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_not_left_peer('" + day.toString() + "')");

        while(rs.next()) {
            result.add(rs.getString("fnc_not_left_peer"));
        }
        return result;
    }
}
