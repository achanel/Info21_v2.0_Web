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
public class LeavingFromCampus {
    @Autowired
    SqlExecutor sqlExecutor;

    public List<String> execute(Integer n, Integer m) throws BusinessException, SQLException {

        log.info("start execute function ex10().");
        List<String> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_out_of_campus('" +
                        n + "', '" +
                        m + "')");

        while(rs.next()) {
            result.add(rs.getString("Peer"));
        }
        return result;
    }
}
