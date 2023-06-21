package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.TimeTracking;
import edu.school21.infoweb.repositories.TimeTrackingRepository;
import edu.school21.infoweb.services.TimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimeTrackingServiceImpl implements TimeTrackingService {
    @Autowired
    private TimeTrackingRepository timeTrackingRepository;

    @Override
    @Transactional
    public List<TimeTracking> getAllTimeTracking() {
        System.out.println("timeTrackingService: " + timeTrackingRepository.findAll());
        return timeTrackingRepository.findAll();
    }

    @Override
    @Transactional
    public List<TimeTracking> saveTimeTracking(List<TimeTracking> timeTrackings) {
        return timeTrackings == null ?
                null : (List<TimeTracking>) timeTrackingRepository.saveAll(timeTrackings);
    }

    @Override
    public void deleteTimeTracking(List<TimeTracking> timeTrackings) {
        if (timeTrackings != null) {
            timeTrackingRepository.deleteAll(timeTrackings);
        }
    }
}
