package edu.school21.infoweb.models;

import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
public class SqlResult {
    private String peer;
    private String peer_two;
    private String task;
    private Integer xp;
    private String startedblock1;
    private String startedblock2;
    private String startedbothblocks;
    private String didntstartanyblock;
    private String pointschange;
    private Date cDate;
    private Double successfulChecks;
    private Double unsuccessfulChecks;
    private Integer prevCount;
    private Long completed;
    private String month;
    private Integer earlyEntries;
    private String friendsCount;
    private Time time;
    private Object v;

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

    public SqlResult(Date cDate, String task) {
        this.cDate = cDate;
        this.task = task;
    }

    public SqlResult(String peer, Date cDate) {
        this.peer = peer;
        this.cDate = cDate;
    }

    public SqlResult(String peer, String recommendedPeer, double v) {
        this.peer = peer;
        this.peer_two = recommendedPeer;
        this.v = v;
    }

    public SqlResult(Double successfulChecks, Double unsuccessfulChecks) {
        this.successfulChecks = successfulChecks;
        this.unsuccessfulChecks = unsuccessfulChecks;
    }

    public SqlResult(String task, Integer prevCount) {
        this.task = task;
        this.prevCount = prevCount;
    }

    public SqlResult(Integer xp, String peer) {
        this.xp = xp;
        this.peer = peer;
    }

    public SqlResult(String month, Integer earlyEntries, double v) {
        this.month = month;
        this.earlyEntries = earlyEntries;
        this.v = v;
    }

    public SqlResult(String peer, String task, Integer xp, String v) {
        this.peer = peer;
        this.task = task;
        this.xp = xp;
        this.v = v;
    }

    public SqlResult(String peer, Long completed, String v) {
        this.peer = peer;
        this.completed = completed;
        this.v = v;
    }

    public SqlResult(String peer, String friendsCount, String v) {
        this.peer = peer;
        this.friendsCount = friendsCount;
        this.v = v;
    }

    public SqlResult(String peer, Integer xp, String v) {
        this.peer = peer;
        this.xp = xp;
        this.v = v;
    }

    public SqlResult(Time times) {
        this.time = times;
    }

    public SqlResult(Double successfulChecks, Double unsuccessfulChecks, Double v) {
        this.successfulChecks = successfulChecks;
        this.unsuccessfulChecks = unsuccessfulChecks;
        this.v = v;
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

    public Date getcDate() {
        return cDate;
    }

    public String getPeer_two() {
        return peer_two;
    }

    public Double getSuccessfulChecks() {
        return successfulChecks;
    }

    public Double getUnsuccessfulChecks() {
        return unsuccessfulChecks;
    }

    public Integer getPrevCount() {
        return prevCount;
    }

    public Long getCompleted() {
        return completed;
    }

    public String getMonth() {
        return month;
    }

    public Integer getEarlyEntries() {
        return earlyEntries;
    }

    public String getFriendsCount() {
        return friendsCount;
    }

    public Time getTime() {
        return time;
    }

    public Date getDay() {
        return cDate;
    }
}
