package edu.school21.infoweb.dto.functions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskBlockFunction {
//
//    private static final String sqlQuery = "SELECT * FROM ex07(?)";
//
//    public List<TaskBlockResult> execute(String blockName) {
//        log.info("start execute function ex07(). BlockName: {}", blockName);
//        try {
//            return jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(TaskBlockResult.class), blockName);
//        } catch (Exception e) {
//            log.warn("FAIL execute function ex07. Message: {}", e.getMessage());
//            throw e;
//        }
//    }
}
