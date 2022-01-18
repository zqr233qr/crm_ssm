package com.qirui.crm.workbench.dao;

import com.qirui.crm.workbench.domain.Activity;
import com.qirui.crm.workbench.domain.Clue;

import java.util.List;

public interface ClueDao {

    Clue getDetailById(String id);

    List<Activity> getActivityByClue(String clueId);

}
