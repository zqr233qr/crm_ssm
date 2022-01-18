package com.qirui.crm.workbench.dao;

import com.qirui.crm.workbench.domain.Activity;

import java.util.List;

public interface ActivityDao {

    List<Activity> pageList(Activity activity);

    int totalActivity();

    int addActivity(Activity activity);

    int deleteActivity(String[] id);

    Activity getUserListAndActivity(String id);

    int updateActivity(Activity activity);
}
