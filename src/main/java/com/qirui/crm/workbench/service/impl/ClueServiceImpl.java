package com.qirui.crm.workbench.service.impl;

import com.qirui.crm.workbench.dao.ActivityDao;
import com.qirui.crm.workbench.dao.ClueDao;
import com.qirui.crm.workbench.domain.Activity;
import com.qirui.crm.workbench.domain.Clue;
import com.qirui.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {

    @Autowired
    private ClueDao clueDao;
    @Autowired
    private ActivityDao activityDao;


    @Override
    public Clue getDetailById(String id) {
        return clueDao.getDetailById(id);
    }

    @Override
    public List<Activity> getActivityByClue(String clueId) {
        return clueDao.getActivityByClue(clueId);
    }


}
