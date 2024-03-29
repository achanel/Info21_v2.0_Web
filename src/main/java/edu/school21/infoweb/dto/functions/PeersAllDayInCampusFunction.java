package edu.school21.infoweb.dto.functions;


import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class PeersAllDayInCampusFunction {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(PeersAllDayInCampusFunction.class);
    @Autowired
    SqlExecutor sqlExecutor;

    public List<String> execute(LocalDate day) throws BusinessException, SQLException {
        log.info("start execute function fnc_all_day_in_campus().");
        List<String> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_all_day_in_campus('" + day.toString() + "')");

        while (rs.next()) {
            result.add(rs.getString("fnc_all_day_in_campus"));
        }
        return result;
    }
}
