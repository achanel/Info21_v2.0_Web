package edu.school21.infoweb.models;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SqlResult {
    private String peer;
    private String task;
    private Integer xp;

    public SqlResult(String peer, String task, Integer xp) {
        this.peer = peer;
        this.task = task;
        this.xp = xp;
    }

    public String getPeer() {
        return this.peer;
    }

    public String getTask() {
        return this.task;
    }

    public Integer getXp() {
        return this.xp;
    }
}
