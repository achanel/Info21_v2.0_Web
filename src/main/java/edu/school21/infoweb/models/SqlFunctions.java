package edu.school21.infoweb.models;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SqlFunctions {
    private String sqlStatement;
    private String requiredParams;
    private String params;

    public String getFunction(String request) {
        switch (request) {


            case "export":
                requiredParams = "tablename varchar, path text, separator char";
                sqlStatement = "export(" + params + ")";
                break;
            case "import":
                requiredParams = "tablename varchar, path text, separator char";
                sqlStatement = "import(" + params + ")";
                break;


            case "add_p2p_review":
                requiredParams = "checked_peer varchar checkingPeer varchar, task_name text, " +
                        "p2p_status check_state, check_time time";
                sqlStatement = sqlStatement = "add_p2p_review(" + params + ")";
                break;
            case "add_verter_review":
                requiredParams = "checkedPeer varchar, task_name text, verter_status check_state, " +
                        "check_time time";
                sqlStatement = sqlStatement = "add_verter_review(" + params + ")";
                break;


            case "pcd_success_projects_percent":
                sqlStatement = "pcd_success_projects_percent(null, null)";
                break;

            case "pcd_peer_points_changes":
                sqlStatement = "begin;" +
                        "call pcd_peer_points_changes('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
            case "pcd_peer_points_changes_2":
                sqlStatement = "begin ;" +
                        "call pcd_peer_points_changes_2('ref');" +
                        "fetch all in \"ref\";" +
                        "end ;";
                break;
            case "pcd_most_reviewed_task":
                sqlStatement = "begin;" +
                        "call pcd_most_reviewed_task('ref');" +
                        "fetch all in\"ref\";" +
                        "end;";
                break;
            case "pcd_last_check_duration":
                sqlStatement = "begin;" +
                        "call pcd_last_check_duration('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
//            case "pcd_completed_block":
//                requiredParams = "block varchar";
//                sqlStatement = "begin ;" +
//                        "call pcd_completed_block('" + request + "%', 'ref');" +
//                        "fetch all in\"ref\";" +
//                        "end;";
//                break;
            case "pcd_recommendation_list":
                sqlStatement = "begin;" +
                        "call pcd_recommendation_list('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
//            case "pcd_peers_block_started_percent":
//                requiredParams = "block_name_1 varchar, block_name_2 varchar";
//                sqlStatement = "begin;" +
//                        "call pcd_peers_block_started_percent('cursor_name', '" +
//                        requiredParams.charAt(0) + "%', '" + requiredParams.charAt(sqlStatement.length()) +
//                        "%');" + "fetch all in \"cursor_name\";" +
//                        "end;";
//                break;
//            case "pcd_most_friends_peer":
//                requiredParams = "limits int";
//                sqlStatement = "begin ;" +
//                        "call pcd_most_friends_peer(" + requiredParams + ", 'ref');" +
//                        "fetch all in \"ref\";" +
//                        "end;";
//                break;
            case "pcd_success_reviews_on_birthday":
                sqlStatement = "begin;" +
                        "call pcd_success_reviews_on_birthday('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
            case "pcd_total_xp":
                sqlStatement = "begin;" +
                        "call pcd_total_xp('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
//            case "pcd_completed_task":
//                requiredParams = "first_task text, second_task text, third_task text";
//                params = Arrays.toString(new String[]{requiredParams.trim()});
//                sqlStatement = "begin;" +
//                        "call pcd_completed_task('cursor_name', '" + params[0] +
//                        "', '" + params[1] + "', '" + params[2] + "');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
//                break;
            case "pcd_pre_task":
                sqlStatement = "begin;" +
                        "call pcd_pre_task('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
//            case "pcd_lucky_day":
//                requiredParams = "n int";
//                sqlStatement = "begin;" +
//                        "call pcd_lucky_day(" + requiredParams + ", 'ref');" +
//                        "fetch all in \"ref\";" +
//                        "end;";
//                break;
            case "pcd_peer_max_done":
                sqlStatement = "begin;" +
                        "call pcd_peer_max_done('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
            case "pcd_peer_max_xp":
                sqlStatement = "begin;" +
                        "call pcd_peer_max_xp('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
            case "pcd_max_time_in_campus":
                sqlStatement = "begin;" +
                        "call pcd_max_time_in_campus('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
//            case "pcd_coming_early":
//                requiredParams = "\"check_time\" time, n int";
//                params = Arrays.toString(new String[]{requiredParams.trim()});
//                sqlStatement = "begin;" +
//                        "call pcd_coming_early('" + params[0] +
//                        "', " + params[1] + ",'cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
//                break;
//            case "pcd_out_of_campus":
//                requiredParams = "n int, m int";
//                sqlStatement = "begin;" +
//                        "call pcd_out_of_campus('cursor_name', 10000, 0);" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
//                break;
            case "pcd_last_visited_peer":
                sqlStatement = "begin;" +
                        "call pcd_last_visited_peer('cursor_name');" +
                        "fetch all in \"cursor_name\";" +
                        "end;";
                break;
//            case "pcd_time_out_of_campus":
//                requiredParams = "N int";
//                sqlStatement = "begin;" +
//                        "call pcd_time_out_of_campus('cursor_name', '90');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
//                break;
//            case "fnc_count_of_visits":
//                requiredParams = "ppeer text, ttime time";
//                sqlStatement = "begin;" +
//                        "call pcd_early_visits_for_months('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
//                break;
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
