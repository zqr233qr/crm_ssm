package com.qirui.crm.workbench.controller;

import com.qirui.crm.settings.domain.User;
import com.qirui.crm.settings.service.UserService;
import com.qirui.crm.utils.DateTimeUtil;
import com.qirui.crm.utils.UUIDUtil;
import com.qirui.crm.vo.pageListVO;
import com.qirui.crm.workbench.domain.Activity;
import com.qirui.crm.workbench.service.ActivityService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/workbench/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/pageList")
    public Object pageList(Activity activity){
        JSONObject jsonObject = new JSONObject();
        pageListVO<Activity> activityPageList = activityService.getActivityPageList(activity);
        List<Activity> pageList = activityPageList.getList();
        int total = activityPageList.getTotal();
        jsonObject.put("pageList",pageList);
        jsonObject.put("total",total);
        return jsonObject.toString();
    }


    @ResponseBody
    @RequestMapping("/getUserList")
    public Object getUserList(){
        JSONObject jsonObject = new JSONObject();
        List<User> userList = userService.getList();
        jsonObject.put("userList",userList);
        return jsonObject.toString();
    }
    
    @ResponseBody
    @RequestMapping("/save")
    public Object save(Activity activity, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        activity.setCreateBy(user.getName());
        activity.setCreateTime(DateTimeUtil.getSysTime());
        activity.setId(UUIDUtil.getUUID());
        JSONObject jsonObject = new JSONObject();
        boolean flag = activityService.addActivity(activity);
        jsonObject.put("success",flag);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(String[] id){
        JSONObject jsonObject = new JSONObject();
        boolean flag = activityService.deleteActivity(id);
        jsonObject.put("success",flag);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping("/getUserListAndActivity")
    public Map<String,Object> getUserListAndActivity(String id){
        Map<String, Object> map = activityService.getUserListAndActivity(id);
        return map;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(Activity activity){
        boolean success = activityService.updateActivity(activity);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",success);
        return jsonObject.toString();
    }

}
