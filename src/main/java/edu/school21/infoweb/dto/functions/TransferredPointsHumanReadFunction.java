package edu.school21.infoweb.dto.functions;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.Peers;
import edu.school21.infoweb.models.TransferredPoints;
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
public class TransferredPointsHumanReadFunction {

    @Autowired
    SqlExecutor sqlExecutor;

    public List<TransferredPoints> execute() throws BusinessException, SQLException {
        List<TransferredPoints> result = new ArrayList<>();
        ResultSet rs = sqlExecutor.executeToResultSet(
                "select * from fnc_transferred_points()");

        while(rs.next()) {
            result.add(new TransferredPoints(
                    0,
                    new Peers(rs.getObject("peer1").toString(), null),
                    new Peers(rs.getObject("peer2").toString(), null),
                    rs.getInt("pointsamount")
            ));
        }
        return result;
    }
}