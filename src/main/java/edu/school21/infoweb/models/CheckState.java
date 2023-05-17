package edu.school21.infoweb.models;

public enum CheckState {
    START("start"),
    SUCCESS("success"),
    FAILURE("failure");

    private String state;

    CheckState(String state) {
        this.state = state;
    }
}

