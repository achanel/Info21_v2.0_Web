package edu.school21.infoweb.controllers;

import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.SqlFunctions;
import edu.school21.infoweb.services.TablesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/v1/data/")
public class DataController {
    @Autowired
    private TablesService tablesService;

    @Autowired
    SqlFunctions sqlFunctions;

    private final StringBuilder sqlResponse = new StringBuilder();

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("sqlResponse", sqlResponse);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam(required = false, name = "request") String request, Map<String, Object> model) throws BusinessException {
        Connection connection;
        sqlResponse.setLength(0);
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

            Statement statement = connection.createStatement();
            ResultSet rs;

            if (StringUtils.isNumeric(request)) {
                CallableStatement cs = connection.prepareCall(sqlFunctions.getFunction(request));
                rs = Objects.requireNonNull(cs).executeQuery();
            } else {
                rs = statement.executeQuery(request);
            }
            ResultSetMetaData rsmd = Objects.requireNonNull(rs).getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            int flag = 0;

            while (rs.next()) {
                if (flag == 0) {
                    for (int j = 1; j <= columnsNumber; j++) {
                        if (j == columnsNumber) {
                            sqlResponse.append(rsmd.getColumnName(j)).append("\n\n");
                            break;
                        }
                        sqlResponse.append(rsmd.getColumnName(j)).append("  ");
                    }
                    flag++;
                }
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i == columnsNumber) {
                        sqlResponse.append(rs.getString(i)).append("\n\n");
                        break;
                    }
                    sqlResponse.append(rs.getString(i)).append("  ");
                }
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }

        model.put("sqlResponse", sqlResponse);

        return "main";
    }

    @GetMapping("/get_table")
    public ResponseEntity<TablesDTO> getTable() {
        return new ResponseEntity<>(tablesService.getTable(), HttpStatus.OK);
    }

    @PostMapping("/save_table")
    public ResponseEntity<TablesDTO> saveNewTable(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.saveTable(tablesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_table")
    public ResponseEntity<TablesDTO> deleteTable(@RequestBody TablesDTO tablesDTO) {
        tablesService.deleteTable(tablesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update_table")
    public ResponseEntity<TablesDTO> updateTable(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.saveTable(tablesDTO), HttpStatus.OK);
    }
}
