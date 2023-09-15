package edu.school21.infoweb.models;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SqlResult {
    private String peer;
    private String task;
    private Integer xp;
    private String startedblock1;
    private String startedblock2;
    private String startedbothblocks;
    private String didntstartanyblock;
    private String pointschange;

    public SqlResult(String peer, String task, Integer xp) {
        this.peer = peer;
        this.task = task;
        this.xp = xp;
    }

    public SqlResult(String startedblock1, String startedblock2, String startedbothblocks, String didntstartanyblock) {
        this.startedblock1 = startedblock1;
        this.startedblock2 = startedblock2;
        this.startedbothblocks = startedbothblocks;
        this.didntstartanyblock = didntstartanyblock;
    }

    public SqlResult(String peer, String pointschange) {
        this.peer = peer;
        this.pointschange = pointschange;
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

    public String getStartedblock1() {
        return startedblock1;
    }

    public String getStartedblock2() {
        return startedblock2;
    }

    public String getStartedbothblocks() {
        return startedbothblocks;
    }

    public String getDidntstartanyblock() {
        return didntstartanyblock;
    }

    public String getPointschange() {
        return pointschange;
    }
}
