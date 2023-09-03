package edu.school21.infoweb.models.operations;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
public class AddP2PReviewParams {
    @NotBlank(message = "Can not be empty")
    private String checkingPeer;

    @NotBlank(message = "Can not be empty")
    private String checkedPeer;

    @NotBlank(message = "Can not be empty")
    private String taskTitle;

    @NotBlank(message = "Can not be empty")
    private String state;

    @NotNull(message = "Can not be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime checkTime;

    public @NotBlank(message = "Can not be empty") String getCheckingPeer() {
        return this.checkingPeer;
    }

    public @NotBlank(message = "Can not be empty") String getCheckedPeer() {
        return this.checkedPeer;
    }

    public @NotBlank(message = "Can not be empty") String getTaskTitle() {
        return this.taskTitle;
    }

    public @NotBlank(message = "Can not be empty") String getState() {
        return this.state;
    }

    public @NotNull(message = "Can not be empty") LocalTime getCheckTime() {
        return this.checkTime;
    }

    public void setCheckingPeer(@NotBlank(message = "Can not be empty") String checkingPeer) {
        this.checkingPeer = checkingPeer;
    }

    public void setCheckedPeer(@NotBlank(message = "Can not be empty") String checkedPeer) {
        this.checkedPeer = checkedPeer;
    }

    public void setTaskTitle(@NotBlank(message = "Can not be empty") String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setState(@NotBlank(message = "Can not be empty") String state) {
        this.state = state;
    }

    public void setCheckTime(@NotNull(message = "Can not be empty") LocalTime checkTime) {
        this.checkTime = checkTime;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $checkingPeer = this.getCheckingPeer();
        result = result * PRIME + ($checkingPeer == null ? 43 : $checkingPeer.hashCode());
        final Object $checkedPeer = this.getCheckedPeer();
        result = result * PRIME + ($checkedPeer == null ? 43 : $checkedPeer.hashCode());
        final Object $taskTitle = this.getTaskTitle();
        result = result * PRIME + ($taskTitle == null ? 43 : $taskTitle.hashCode());
        final Object $state = this.getState();
        result = result * PRIME + ($state == null ? 43 : $state.hashCode());
        final Object $checkTime = this.getCheckTime();
        result = result * PRIME + ($checkTime == null ? 43 : $checkTime.hashCode());
        return result;
    }

    public String toString() {
        return "AddP2PReviewParams(checkingPeer=" + this.getCheckingPeer() + ", checkedPeer=" + this.getCheckedPeer() + ", taskTitle=" + this.getTaskTitle() + ", state=" + this.getState() + ", checkTime=" + this.getCheckTime() + ")";
    }
}
