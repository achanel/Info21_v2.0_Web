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
public class EarlyComingFunction {
//
//    private static final String sqlQuery = "SELECT * FROM ex17()";
//
//    public List<EarlyComingResult> execute() {
//        log.info("start execute function ex17().");
//        try {
//            return jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(EarlyComingResult.class));
//        } catch (Exception e) {
//            log.warn("FAIL execute function ex17. Message: {}", e.getMessage());
//            throw e;
//        }
//    }
}