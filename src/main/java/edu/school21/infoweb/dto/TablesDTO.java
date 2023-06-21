package edu.school21.infoweb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.school21.infoweb.models.*;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TablesDTO {
    @JsonProperty("peersList")
    List<Peers> peersList;
    @JsonProperty("tasksList")
    List<Tasks> tasksList;

    @JsonProperty("checksList")
    List<Checks> checksList;

    @JsonProperty("friendsList")
    List<Friends> friendsList;

    @JsonProperty("p2PList")
    List<P2P> p2PList;

    @JsonProperty("recommendationsList")
    List<Recommendations> recommendationsList;

    @JsonProperty("timeTrackingList")
    List<TimeTracking> timeTrackingList;

    @JsonProperty("transferredPointsList")
    List<TransferredPoints> transferredPointsList;

    @JsonProperty("verterList")
    List<Verter> verterList;

    @JsonProperty("xpList")
    List<XP> xpList;

    public TablesDTO(List<Peers> peersList, List<Tasks> tasksList, List<Checks> checksList,
                     List<Friends> friendsList, List<P2P> p2PList, List<Recommendations> recommendationsList,
                     List<TimeTracking> timeTrackingList, List<TransferredPoints> transferredPointsList,
                     List<Verter> verterList, List<XP> xpList) {
        this.peersList = peersList;
        this.tasksList = tasksList;
        this.checksList = checksList;
        this.friendsList = friendsList;
        this.p2PList = p2PList;
        this.recommendationsList = recommendationsList;
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
    public List<Tasks> getTasksList() {
        return this.tasksList;
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

    @JsonProperty("peersList")
    public void setPeersList(List<Peers> peersList) {
        this.peersList = peersList;
    }
    @JsonProperty("tasksList")
    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }
    @JsonProperty("checksList")
    public void setChecksList(List<Checks> checksList) {
        this.checksList = checksList;
    }
    @JsonProperty("friendsList")
    public void setFriendsList(List<Friends> friendsList) {
        this.friendsList = friendsList;
    }
    @JsonProperty("p2PList")
    public void setP2PList(List<P2P> p2PList) {
        this.p2PList = p2PList;
    }
    @JsonProperty("recommendationsList")
    public void setRecommendationsList(List<Recommendations> recommendationsList) {
        this.recommendationsList = recommendationsList;
    }
    @JsonProperty("timeTrackingList")
    public void setTimeTrackingList(List<TimeTracking> timeTrackingList) {
        this.timeTrackingList = timeTrackingList;
    }
    @JsonProperty("transferredPointsList")
    public void setTransferredPointsList(List<TransferredPoints> transferredPointsList) {
        this.transferredPointsList = transferredPointsList;
    }
    @JsonProperty("verterList")
    public void setVerterList(List<Verter> verterList) {
        this.verterList = verterList;
    }
    @JsonProperty("xpList")
    public void setXpList(List<XP> xpList) {
        this.xpList = xpList;
    }
    public static class TablesDTOBuilder {
        private List<Peers> peersList;
        private List<Tasks> tasksList;
        private List<Checks> checksList;
        private List<Friends> friendsList;
        private List<P2P> p2PList;
        private List<Recommendations> recommendationsList;
        private List<TimeTracking> timeTrackingList;
        private List<TransferredPoints> transferredPointsList;
        private List<Verter> verterList;
        private List<XP> xpList;

        TablesDTOBuilder() {
        }

        public TablesDTOBuilder peersList(List<Peers> peersList) {
            this.peersList = peersList;
            return this;
        }

        public TablesDTOBuilder tasksList(List<Tasks> tasksList) {
            this.tasksList = tasksList;
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
            return new TablesDTO(
                    peersList,
                    tasksList,
                    checksList,
                    friendsList,
                    p2PList,
                    recommendationsList,
                    timeTrackingList,
                    transferredPointsList,
                    verterList,
                    xpList);
        }

        @Override
        public String toString() {
            return "TablesDTOBuilder{" +
                    "peersList=" + peersList +
                    ", tasksList=" + tasksList +
                    ", checksList=" + checksList +
                    ", friendsList=" + friendsList +
                    ", p2PList=" + p2PList +
                    ", recommendationsList=" + recommendationsList +
                    ", timeTrackingList=" + timeTrackingList +
                    ", transferredPointsList=" + transferredPointsList +
                    ", verterList=" + verterList +
                    ", xpList=" + xpList +
                    '}';
        }
    }
}
