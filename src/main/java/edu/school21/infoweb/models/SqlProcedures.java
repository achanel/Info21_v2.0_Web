package edu.school21.infoweb.models;

public enum SqlProcedures {
    ADD_P2P_REVIEW("call add_p2p_review(?, ?, ?, ?, ?)"),
    ADD_VERTER_REVIEW("call add_verter_review(?, ?, ?, ?)"),
    FNC_TRG_UPDATE_TRANSFERREDPOINTS("execute procedure fnc_trg_update_transferredpoints()"),
    FNC_TRG_XP("execute procedure call fnc_trg_XP()"),
    FNC_TRANSFERRED_POINTS("select * from fnc_transferred_points()"),
    FNC_PEER_SUCCESS_PROJECT("select * from fnc_peer_success_project()"),
    FNC_NOT_LEFT_PEER("select * from fnc_not_left_peer(?);")
    ;


    SqlProcedures(String procedure) {
    }
}
