package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.SqlResult;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class MaxFriends {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(MaxFriends.class);
    @Autowired
    SqlExecutor sqlExecutor;

    public List<SqlResult> execute(Integer limits) throws BusinessException, SQLException {
        log.info("start execute function fnc_max_friends_peer().");
        List<SqlResult> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_max_friends_peer('" + limits + "');");

        while (rs.next()) {
            result.add(new SqlResult(
                    String.valueOf(rs.getString("Nick_name")),
                    String.valueOf(rs.getInt("FriendsCount")),
                    "1.0"
            ));
        }
        return result;
    }
}
