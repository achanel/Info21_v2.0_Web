package edu.school21.infoweb.sqlServices;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SqlFunctions {
    private String statement;
    private List<Object> params;

    @Deprecated
    public String getStatement(String request) {
        switch (request) {

            case "pcd_success_projects_percent":
                statement = "call pcd_success_projects_percent(null, null)";
                break;

            case "pcd_peer_points_changes":
//                statement = "begin;" +
//                        "call pcd_peer_points_changes(?);" +
//                        "fetch all in ?;" +
//                        "end;";
                statement = "call pcd_peer_points_changes(?);" +
                params.add("cursor");
                break;
            case "pcd_peer_points_changes_2":
                statement = "call pcd_peer_points_changes_2(?);";
//                statement = "begin ;" +
//                        "call pcd_peer_points_changes_2('ref');" +
//                        "fetch all in \"ref\";" +
//                        "end ;";
                break;
            case "pcd_most_reviewed_task":
//                sqlStatement = "begin;" +
//                        "call pcd_most_reviewed_task('ref');" +
//                        "fetch all in\"ref\";" +
//                        "end;";
                break;
            case "pcd_last_check_duration":
//                sqlStatement = "begin;" +
//                        "call pcd_last_check_duration('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_recommendation_list":
//                sqlStatement = "begin;" +
//                        "call pcd_recommendation_list('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_success_reviews_on_birthday":
//                sqlStatement = "begin;" +
//                        "call pcd_success_reviews_on_birthday('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_total_xp":
//                sqlStatement = "begin;" +
//                        "call pcd_total_xp('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_pre_task":
//                sqlStatement = "begin;" +
//                        "call pcd_pre_task('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_peer_max_done":
//                sqlStatement = "begin;" +
//                        "call pcd_peer_max_done('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_peer_max_xp":
//                sqlStatement = "begin;" +
//                        "call pcd_peer_max_xp('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_max_time_in_campus":
//                sqlStatement = "begin;" +
//                        "call pcd_max_time_in_campus('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_last_visited_peer":
//                sqlStatement = "begin;" +
//                        "call pcd_last_visited_peer('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;

            case "export":
                request = "tablename varchar, path text, separator char";
//                sqlStatement = "export(" + params + ")";
                break;
            case "import":
                request = "tablename varchar, path text, separator char";
//                sqlStatement = "import(" + params + ")";
                break;


            case "add_p2p_review":
                request = "checked_peer varchar checkingPeer varchar, task_name text, " +
                        "p2p_status check_state, check_time time";
//                sqlStatement = sqlStatement = "add_p2p_review(" + params + ")";
                break;
            case "add_verter_review":
                request = "checkedPeer varchar, task_name text, verter_status check_state, " +
                        "check_time time";
//                sqlStatement = sqlStatement = "add_verter_review(" + params + ")";
                break;


            case "pcd_completed_block":
                request = "block varchar";
//                sqlStatement = "begin ;" +
//                        "call pcd_completed_block('" + request + "%', 'ref');" +
//                        "fetch all in\"ref\";" +
//                        "end;";
                break;

            case "pcd_peers_block_started_percent":
                request = "block_name_1 varchar, block_name_2 varchar";
//                sqlStatement = "begin;" +
//                        "call pcd_peers_block_started_percent('cursor_name', '" +
//                        requiredParams.charAt(0) + "%', '" + requiredParams.charAt(sqlStatement.length()) +
//                        "%');" + "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_most_friends_peer":
                request = "limits int";
//                sqlStatement = "begin ;" +
//                        "call pcd_most_friends_peer(" + requiredParams + ", 'ref');" +
//                        "fetch all in \"ref\";" +
//                        "end;";
                break;

            case "pcd_completed_task":
                request = "first_task text, second_task text, third_task text";
//                params = Arrays.toString(new String[]{requiredParams.trim()});
//                sqlStatement = "begin;" +
//                        "call pcd_completed_task('cursor_name', '" + params[0] +
//                        "', '" + params[1] + "', '" + params[2] + "');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;

            case "pcd_lucky_day":
                request = "n int";
//                sqlStatement = "begin;" +
//                        "call pcd_lucky_day(" + requiredParams + ", 'ref');" +
//                        "fetch all in \"ref\";" +
//                        "end;";
                break;

            case "pcd_coming_early":
                request = "\"check_time\" time, n int";
//                params = Arrays.toString(new String[]{requiredParams.trim()});
//                sqlStatement = "begin;" +
//                        "call pcd_coming_early('" + params[0] +
//                        "', " + params[1] + ",'cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "pcd_out_of_campus":
                request = "n int, m int";
//                sqlStatement = "begin;" +
//                        "call pcd_out_of_campus('cursor_name', 10000, 0);" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;

            case "pcd_time_out_of_campus":
                request = "N int";
//                sqlStatement = "begin;" +
//                        "call pcd_time_out_of_campus('cursor_name', '90');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            case "fnc_count_of_visits":
                request = "ppeer text, ttime time";
//                sqlStatement = "begin;" +
//                        "call pcd_early_visits_for_months('cursor_name');" +
//                        "fetch all in \"cursor_name\";" +
//                        "end;";
                break;
            default:
                statement = request;
        }
        return statement;
    }

    public List<Object> getParams() {
        return params;
    }
}
