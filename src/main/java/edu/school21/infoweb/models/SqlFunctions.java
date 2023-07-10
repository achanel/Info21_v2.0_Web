package edu.school21.infoweb.models;

import org.springframework.stereotype.Component;

@Component
public class SqlFunctions {
    private String sqlStatement;
    private String requiredParams;
    private String params;

    public String getFunction(String request) {
        switch (request) {
            case "fnc_transferred_points":
                sqlStatement = "fnc_transferred_points()";
                break;
            case "fnc_peer_success_project":
                sqlStatement = "fnc_peer_success_project()";
                break;
            case "fnc_not_left_peer":
                requiredParams = "day";
                sqlStatement = "fnc_peer_success_project(" + params + ")";
        }
        return sqlStatement;
    }

    public String getRequiredParams() {
        return requiredParams;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
