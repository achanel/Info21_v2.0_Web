package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class LuckyDays {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(LuckyDays.class);
    @Autowired
    SqlExecutor sqlExecutor;

    public List<Date> execute(Integer n) throws BusinessException, SQLException {
        log.info("start execute function fnc_lucky_day().");
        List<Date> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_lucky_day(" + n + ")");

        while (rs.next()) {
            result.add(rs.getDate("CDate"));
        }
        return result;
    }
}
