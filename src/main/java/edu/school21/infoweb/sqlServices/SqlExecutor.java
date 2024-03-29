package edu.school21.infoweb.sqlServices;

import edu.school21.infoweb.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SqlExecutor {
    public List<List<String>> csv = new ArrayList<>();

    public StringBuilder execute(String statement) throws BusinessException {
        Connection connection;
        StringBuilder sqlResponse = new StringBuilder();
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

            CallableStatement cs = connection.prepareCall(statement);
            Statement st = connection.createStatement();
            ResultSet rs = Objects.requireNonNull(cs).executeQuery();
            ResultSetMetaData rsmd = Objects.requireNonNull(rs).getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            int flag = 0;

            List<String> tmp = new ArrayList<>();
            while (rs.next()) {
                if (flag == 0) {
                    for (int j = 1; j <= columnsNumber; j++) {
                        if (j == columnsNumber) {
                            tmp.add(rsmd.getColumnName(j));
                            sqlResponse.append(rsmd.getColumnName(j)).append("\n");
                            List<String> innerList = new ArrayList<>(tmp);
                            csv.add(innerList);
                            tmp.clear();
                            break;
                        }
                        tmp.add(rsmd.getColumnName(j));
                        sqlResponse.append(rsmd.getColumnName(j)).append(",");
                    }
                    flag++;
                }
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i == columnsNumber) {
                        tmp.add(rs.getString(i));
                        sqlResponse.append(rs.getString(i)).append("\n");
                        List<String> innerList = new ArrayList<>(tmp);
                        csv.add(innerList);
                        tmp.clear();
                        break;
                    }
                    tmp.add(rs.getString(i));
                    sqlResponse.append(rs.getString(i)).append(",");
                }
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            if (e.getMessage().startsWith("Запрос не вернул результатов")) {
                return sqlResponse;
            } else {
                throw new BusinessException(e.getMessage());
            }
        }
        return sqlResponse;
    }

    public ResultSet executeToResultSet(String statement) throws BusinessException {
        Connection connection;
        ResultSet rs;
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

            CallableStatement cs = connection.prepareCall(statement);
            rs = Objects.requireNonNull(cs).executeQuery();
        } catch (SQLException e) {
            if (e.getMessage().startsWith("Запрос не вернул результатов")) {
                return null;
            } else {
                throw new BusinessException(e.getMessage());
            }
        }
        return rs;
    }

    public List<List<String>> getCsv() {
        return this.csv;
    }
}
