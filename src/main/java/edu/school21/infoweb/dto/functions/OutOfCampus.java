package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.csv.CSVExecutor;
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


@Component
@RequiredArgsConstructor
public class OutOfCampus {
    @Autowired
    SqlExecutor sqlExecutor;
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(OutOfCampus.class);
    public List<String> execute(Integer n) throws BusinessException, SQLException {
        log.info("start execute function fnc_time_out_of_campus().");
        List<String> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_time_out_of_campus('" + n + "')");

        while(rs.next()) {
            result.add(rs.getString("Peers"));
        }
        return result;
    }
}
