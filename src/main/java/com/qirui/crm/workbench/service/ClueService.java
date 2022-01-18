package com.qirui.crm.workbench.service;

import com.qirui.crm.workbench.domain.Activity;
import com.qirui.crm.workbench.domain.Clue;

import java.util.List;

public interface ClueService {

    Clue getDetailById(String id);

    List<Activity> getActivityByClue(String clueId);

    //boolean unBond(String id);
}
