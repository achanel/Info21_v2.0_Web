package edu.school21.infoweb.services;

import edu.school21.infoweb.models.XP;

import java.util.List;

public interface XPService {
    List<XP> getAllXP();

    List<XP> saveXP(List<XP> peers);

    void deleteXP(List<XP> peers);
}
