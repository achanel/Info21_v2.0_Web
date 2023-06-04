package edu.school21.infoweb.services;

import edu.school21.infoweb.models.TimeTracking;

import java.util.List;

public interface TimeTrackingService {
    List<TimeTracking> getAllTimeTracking();

    List<TimeTracking> saveTimeTracking(List<TimeTracking> peers);

    void deleteTimeTracking(List<TimeTracking> peers);
}
