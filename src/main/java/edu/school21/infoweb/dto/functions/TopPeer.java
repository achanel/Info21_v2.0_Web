package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.SqlResult;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
@RequiredArgsConstructor
public class TopPeer {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(TopPeer.class);
    @Autowired
    SqlExecutor sqlExecutor;

    public SqlResult execute() throws BusinessException, SQLException {
        log.info("start execute function fnc_top_peer().");
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_top_peer()");
        rs.next();
        return new SqlResult(
                rs.getInt("Xp"),
                rs.getString("Peer"));
    }
}