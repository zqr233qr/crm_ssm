package com.qirui.crm.workbench.service.impl;

import com.qirui.crm.settings.dao.UserDao;
import com.qirui.crm.settings.domain.User;
import com.qirui.crm.vo.pageListVO;
import com.qirui.crm.workbench.dao.ActivityDao;
import com.qirui.crm.workbench.domain.Activity;
import com.qirui.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private UserDao userDao;

    @Override
    public pageListVO<Activity> getActivityPageList(Activity activity) {
        List<Activity> activities = activityDao.pageList(activity);
        int total = activityDao.totalActivity();
        pageListVO<Activity> activityPageList = new pageListVO<>();
        activityPageList.setList(activities);
        activityPageList.setTotal(total);
        return activityPageList;
    }

    @Override
    public boolean addActivity(Activity activity) {
        int num = activityDao.addActivity(activity);
        if (num != 1){
            return false;
        }else
            return true;

    }

    @Override
    public boolean deleteActivity(String[] id) {
        int num = activityDao.deleteActivity(id);
        if (num <= 0){
            return false;
        }else
            return true;
    }

    @Override
    public Map<String,Object> getUserListAndActivity(String id) {
        HashMap<String, Object> map = new HashMap<>();

        List<User> uList = userDao.getAll();
        Activity a = activityDao.getUserListAndActivity(id);
        map.put("uList",uList);
        map.put("a",a);
        return map;
    }

    @Override
    public boolean updateActivity(Activity activity) {
        int num = activityDao.updateActivity(activity);
        if (num <= 0){
            return false;
        }else
            return true;
    }
}
