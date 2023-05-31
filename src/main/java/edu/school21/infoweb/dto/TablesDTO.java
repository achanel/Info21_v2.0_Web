package edu.school21.infoweb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.school21.infoweb.models.*;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TablesDTO {
    @JsonProperty("peersList")
    List<Peers> peersList;

    @JsonProperty("checksList")
    List<Checks> checksList;

    @JsonProperty("friendsList")
    List<Friends> friendsList;

    @JsonProperty("p2PList")
    List<P2P> p2PList;

    @JsonProperty("recommendationsList")
    List<Recommendations> recommendationsList;

    @JsonProperty("tasksList")
    List<Tasks> tasksList;

    @JsonProperty("timeTrackingList")
    List<TimeTracking> timeTrackingList;

    @JsonProperty("transferredPointsList")
    List<TransferredPoints> transferredPointsList;

    @JsonProperty("verterList")
    List<Verter> verterList;

    @JsonProperty("xpList")
    List<XP> xpList;

    public TablesDTO(List<Peers> peersList, List<Checks> checksList, List<Friends> friendsList, List<P2P> p2PList, List<Recommendations> recommendationsList, List<Tasks> tasksList, List<TimeTracking> timeTrackingList, List<TransferredPoints> transferredPointsList, List<Verter> verterList, List<XP> xpList) {
        this.peersList = peersList;
        this.checksList = checksList;
        this.friendsList = friendsList;
        this.p2PList = p2PList;
        this.recommendationsList = recommendationsList;
        this.tasksList = tasksList;
        this.timeTrackingList = timeTrackingList;
        this.transferredPointsList = transferredPointsList;
        this.verterList = verterList;
        this.xpList = xpList;
    }

    public TablesDTO() {
    }

    public static TablesDTOBuilder builder() {
        return new TablesDTOBuilder();
    }

    public List<Peers> getPeersList() {
        return this.peersList;
    }

    public List<Checks> getChecksList() {
        return this.checksList;
    }

    public List<Friends> getFriendsList() {
        return this.friendsList;
    }

    public List<P2P> getP2PList() {
        return this.p2PList;
    }

    public List<Recommendations> getRecommendationsList() {
        return this.recommendationsList;
    }

    public List<Tasks> getTasksList() {
        return this.tasksList;
    }

    public List<TimeTracking> getTimeTrackingList() {
        return this.timeTrackingList;
    }

    public List<TransferredPoints> getTransferredPointsList() {
        return this.transferredPointsList;
    }

    public List<Verter> getVerterList() {
        return this.verterList;
    }

    public List<XP> getXpList() {
        return this.xpList;
    }

    public void setPeersList(List<Peers> peersList) {
        this.peersList = peersList;
    }

    public void setChecksList(List<Checks> checksList) {
        this.checksList = checksList;
    }

    public void setFriendsList(List<Friends> friendsList) {
        this.friendsList = friendsList;
    }

    public void setP2PList(List<P2P> p2PList) {
        this.p2PList = p2PList;
    }

    public void setRecommendationsList(List<Recommendations> recommendationsList) {
        this.recommendationsList = recommendationsList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public void setTimeTrackingList(List<TimeTracking> timeTrackingList) {
        this.timeTrackingList = timeTrackingList;
    }

    public void setTransferredPointsList(List<TransferredPoints> transferredPointsList) {
        this.transferredPointsList = transferredPointsList;
    }

    public void setVerterList(List<Verter> verterList) {
        this.verterList = verterList;
    }

    public void setXpList(List<XP> xpList) {
        this.xpList = xpList;
    }

    public static class TablesDTOBuilder {
        private List<Peers> peersList;
        private List<Checks> checksList;
        private List<Friends> friendsList;
        private List<P2P> p2PList;
        private List<Recommendations> recommendationsList;
        private List<Tasks> tasksList;
        private List<TimeTracking> timeTrackingList;
        private List<TransferredPoints> transferredPointsList;
        private List<Verter> verterList;
        private List<XP> xpList;

        public TablesDTOBuilder() {
        }

        public TablesDTOBuilder peersList(List<Peers> peersList) {
            this.peersList = peersList;
            return this;
        }

        public TablesDTOBuilder checksList(List<Checks> checksList) {
            this.checksList = checksList;
            return this;
        }

        public TablesDTOBuilder friendsList(List<Friends> friendsList) {
            this.friendsList = friendsList;
            return this;
        }

        public TablesDTOBuilder p2PList(List<P2P> p2PList) {
            this.p2PList = p2PList;
            return this;
        }

        public TablesDTOBuilder recommendationsList(List<Recommendations> recommendationsList) {
            this.recommendationsList = recommendationsList;
            return this;
        }

        public TablesDTOBuilder tasksList(List<Tasks> tasksList) {
            this.tasksList = tasksList;
            return this;
        }

        public TablesDTOBuilder timeTrackingList(List<TimeTracking> timeTrackingList) {
            this.timeTrackingList = timeTrackingList;
            return this;
        }

        public TablesDTOBuilder transferredPointsList(List<TransferredPoints> transferredPointsList) {
            this.transferredPointsList = transferredPointsList;
            return this;
        }

        public TablesDTOBuilder verterList(List<Verter> verterList) {
            this.verterList = verterList;
            return this;
        }

        public TablesDTOBuilder xpList(List<XP> xpList) {
            this.xpList = xpList;
            return this;
        }

        public TablesDTO build() {
            return new TablesDTO();
        }

        public String toString() {
            return "TablesDTO.TablesDTOBuilder(peersList=" + this.peersList + ", checksList=" + this.checksList + ", friendsList=" + this.friendsList + ", p2PList=" + this.p2PList + ", recommendationsList=" + this.recommendationsList + ", tasksList=" + this.tasksList + ", timeTrackingList=" + this.timeTrackingList + ", transferredPointsList=" + this.transferredPointsList + ", verterList=" + this.verterList + ", xpList=" + this.xpList + ")";
        }
    }
}
