package edu.school21.infoweb.models.operations;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
public class AddVerterReviewParams {
    @NotBlank(message = "Can not be empty")
    private String checkedPeer;

    @NotBlank(message = "Can not be empty")
    private String taskTitle;

    @NotBlank(message = "Can not be empty")
    private String state;

    @NotNull(message = "Can not be empty")
    private String checkTime;


    public @NotBlank(message = "Can not be empty") String getCheckedPeer() {
        return this.checkedPeer;
    }

    public void setCheckedPeer(String checkedPeer) {
        this.checkedPeer = checkedPeer;
    }

    public @NotBlank(message = "Can not be empty") String getTaskTitle() {
        return this.taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public @NotBlank(message = "Can not be empty") String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public @NotNull(message = "Can not be empty") String getCheckTime() {
        return this.checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String toString() {
        return "AddP2PReviewParams(checkedPeer=" + this.getCheckedPeer() + ", taskTitle=" + this.getTaskTitle() + ", state=" + this.getState() + ", checkTime=" + this.getCheckTime() + ")";
    }
}
