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
public class TwoBlockCompareFunction {
    @Autowired
    SqlExecutor sqlExecutor;

    public List<SqlResult> execute(String firstBlock, String secondBlock) throws BusinessException, SQLException {
        List<SqlResult> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_blocks_comparing('"
                        + firstBlock + "', '" + secondBlock + "');");

        while (rs.next()) {
            result.add(new SqlResult(
                    String.valueOf(rs.getInt("first_block")),
                    String.valueOf(rs.getInt("second_block")),
                    String.valueOf(rs.getInt("both_blocks")),
                    String.valueOf(rs.getInt("didnt_start"))
            ));
        }
        return result;
    }
}
