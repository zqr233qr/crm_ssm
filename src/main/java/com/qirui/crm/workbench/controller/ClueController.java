package com.qirui.crm.workbench.controller;

import com.qirui.crm.workbench.domain.Activity;
import com.qirui.crm.workbench.domain.Clue;
import com.qirui.crm.workbench.service.ClueService;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/workbench/clue")
public class ClueController {

    @Autowired
    private ClueService clueService;

    @RequestMapping("/detail")
    public ModelAndView detail(String id){
        ModelAndView modelAndView = new ModelAndView();
        Clue c = clueService.getDetailById(id);
        modelAndView.addObject("c",c);
        modelAndView.setViewName("detail");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/getActivityByClue")
    public List<Activity> getActivityByClue(String clueId){
        List<Activity> activityByClue = clueService.getActivityByClue(clueId);
        return activityByClue;

    }

    /*@ResponseBody
    @RequestMapping("/unBond")
    public boolean unBond(String id){
        boolean flag = clueService.unBond(id);
        return flag;
    }*/
}
