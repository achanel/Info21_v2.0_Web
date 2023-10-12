package edu.school21.infoweb.csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import edu.school21.infoweb.controllers.SQLController;
import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.models.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class CSVExecutor {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(SQLController.class);
    public void writePeersCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/peers.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("name", "birthday");
            for (Peers peer : tablesDTO.getPeersList()) {
                csvPrinter.printRecord(
                        peer.getName(),
                        convertToLocalDateViaInstant(peer.getBirthday()));
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

    public List<Peers> readPeersCSV() {
        try {
            MappingIterator<Peers> orderLines = new CsvMapper().readerFor(Peers.class)
                    .with(CsvSchema.emptySchema().withHeader())
                    .readValues(new File("src/main/resources/peers.csv"));
            return orderLines.readAll();
        } catch (IOException e) {
            log.error("Error While reading CSV ", e);
        }
        return null;
    }

    public void writeChecksCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/checks.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("checks_id", "peer", "task", "date");
            for (Checks checks : tablesDTO.getChecksList()) {
                csvPrinter.printRecord(
                        checks.getChecks_id(),
                        checks.getPeer().getName(),
                        checks.getTask().getTitle(),
                        convertToLocalDateViaInstant(checks.getDate()));
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

    public List<Checks> readChecksCSV() {
        try {
            MappingIterator<Checks> orderLines = new CsvMapper().readerFor(Checks.class)
                    .with(CsvSchema.emptySchema().withHeader())
                    .readValues(new File("src/main/resources/checks.csv"));
            return orderLines.readAll();
        } catch (IOException e) {
            log.error("Error While reading CSV ", e);
        }
        return null;
    }

    public void writeTasksCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/tasks.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("title", "parentTask", "maxXP");
            for (Tasks tasks : tablesDTO.getTasksList()) {
                csvPrinter.printRecord(
                        tasks.getTitle(),
                        tasks.getParentTask(),
                        tasks.getMaxXP());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

    public List<Tasks> readTasksCSV() {
        try {
            MappingIterator<Tasks> orderLines = new CsvMapper().readerFor(Tasks.class)
                    .with(CsvSchema.emptySchema().withHeader())
                    .readValues(new File("src/main/resources/friends.csv"));
            return orderLines.readAll();
        } catch (IOException e) {
            log.error("Error While reading CSV ", e);
        }
        return null;
    }

    public void writeFriendsCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/friends.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("friend_id", "peer1", "peer2");
            for (Friends friends : tablesDTO.getFriendsList()) {
                csvPrinter.printRecord(
                        friends.getFriend_id(),
                        friends.getPeer1().getName(),
                        friends.getPeer2().getName());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

//    public List<Friends> readFriendsCSV() {
//        try {
//            MappingIterator<Friends> orderLines = new CsvMapper().readerFor(Friends.class)
//                    .with(CsvSchema.emptySchema().withHeader())
//                    .readValues(new File("src/main/resources/friends.csv"));
//            return orderLines.readAll();
//        } catch (IOException e) {
//            log.error("Error While reading CSV ", e);
//        }
//        return null;
//    }

    public void writeP2PCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/p2p.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("p2p_id", "check", "checkingpeer", "state", "time");
            for (P2P p2p : tablesDTO.getP2PList()) {
                csvPrinter.printRecord(
                        p2p.getP2p_id(),
                        p2p.getCheck().getChecks_id(),
                        p2p.getCheckingpeer().getName(),
                        p2p.getState(),
                        p2p.getTime());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

//    public List<P2P> readP2PCSV() {
//        try {
//            MappingIterator<P2P> orderLines = new CsvMapper().readerFor(P2P.class)
//                    .with(CsvSchema.emptySchema().withHeader())
//                    .readValues(new File("src/main/resources/p2p.csv"));
//            return orderLines.readAll();
//        } catch (IOException e) {
//            log.error("Error While reading CSV ", e);
//        }
//        return null;
//    }

    public void writeRecommendationsCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/recommendations.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("recommendations_id", "peer", "recommendedpeer");
            for (Recommendations recommendations : tablesDTO.getRecommendationsList()) {
                csvPrinter.printRecord(
                        recommendations.getRecommendations_id(),
                        recommendations.getPeer().getName(),
                        recommendations.getRecommendedpeer().getName());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

//    public List<Recommendations> readRecommendationsCSV() {
//        try {
//            MappingIterator<Recommendations> orderLines = new CsvMapper().readerFor(Recommendations.class)
//                    .with(CsvSchema.emptySchema().withHeader())
//                    .readValues(new File("src/main/resources/recommendations.csv"));
//            return orderLines.readAll();
//        } catch (IOException e) {
//            log.error("Error While reading CSV ", e);
//        }
//        return null;
//    }

    public void writeTimeTrackingCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/timeTracking.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("id", "peer", "date", "time", "state");
            for (TimeTracking timeTracking : tablesDTO.getTimeTrackingList()) {
                csvPrinter.printRecord(
                        timeTracking.getId(),
                        timeTracking.getPeer().getName(),
                        convertToLocalDateViaInstant(timeTracking.getDate()),
                        timeTracking.getTime(),
                        timeTracking.getState());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

//    public List<TimeTracking> readTimeTrackingCSV() {
//        try {
//            MappingIterator<TimeTracking> orderLines = new CsvMapper().readerFor(TimeTracking.class)
//                    .with(CsvSchema.emptySchema().withHeader())
//                    .readValues(new File("src/main/resources/timeTracking.csv"));
//            return orderLines.readAll();
//        } catch (IOException e) {
//            log.error("Error While reading CSV ", e);
//        }
//        return null;
//    }

    public void writeTransferredPointsCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/transferredPoints.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("transferredPoints_id", "checkingpeer", "checkedpeer", "pointsamount");
            for (TransferredPoints transferredPoints : tablesDTO.getTransferredPointsList()) {
                csvPrinter.printRecord(
                        transferredPoints.getTransferredPoints_id(),
                        transferredPoints.getCheckingpeer().getName(),
                        transferredPoints.getCheckedpeer().getName(),
                        transferredPoints.getPointsamount());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

//    public List<TransferredPoints> readTransferredPointsCSV() {
//        try {
//            MappingIterator<TransferredPoints> orderLines = new CsvMapper().readerFor(TransferredPoints.class)
//                    .with(CsvSchema.emptySchema().withHeader())
//                    .readValues(new File("src/main/resources/transferredPoints.csv"));
//            return orderLines.readAll();
//        } catch (IOException e) {
//            log.error("Error While reading CSV ", e);
//        }
//        return null;
//    }

    public void writeVerterCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/verter.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("verter_id", "check", "state", "time");
            for (Verter verter : tablesDTO.getVerterList()) {
                csvPrinter.printRecord(
                        verter.getVerter_id(),
                        verter.getCheck().getChecks_id(),
                        verter.getState(),
                        verter.getTime());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

//    public List<Verter> readVerterCSV() {
//        try {
//            MappingIterator<Verter> orderLines = new CsvMapper().readerFor(Verter.class)
//                    .with(CsvSchema.emptySchema().withHeader())
//                    .readValues(new File("src/main/resources/verter.csv"));
//            return orderLines.readAll();
//        } catch (IOException e) {
//            log.error("Error While reading CSV ", e);
//        }
//        return null;
//    }

    public void writeXPCSV(TablesDTO tablesDTO) {
        try (CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter("src/main/resources/xp.csv"), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("xp_id", "check", "xpamount");
            for (XP xp : tablesDTO.getXpList()) {
                csvPrinter.printRecord(
                        xp.getXp_id(),
                        xp.getCheck().getChecks_id(),
                        xp.getXpamount());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }

//    public List<Verter> readVerterCSV() {
//        try {
//            MappingIterator<Verter> orderLines = new CsvMapper().readerFor(Verter.class)
//                    .with(CsvSchema.emptySchema().withHeader())
//                    .readValues(new File("src/main/resources/verter.csv"));
//            return orderLines.readAll();
//        } catch (IOException e) {
//            log.error("Error While reading CSV ", e);
//        }
//        return null;
//    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
    }
}

