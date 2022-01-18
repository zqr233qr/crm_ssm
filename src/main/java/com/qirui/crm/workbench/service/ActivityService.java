package com.qirui.crm.workbench.service;

import com.qirui.crm.vo.pageListVO;
import com.qirui.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    pageListVO<Activity> getActivityPageList(Activity activity);

    boolean addActivity(Activity activity);

    boolean deleteActivity(String[] id);

    Map<String,Object> getUserListAndActivity(String id);

    boolean updateActivity(Activity activity);

}
