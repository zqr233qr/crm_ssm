package com.qirui.crm.settings.controller;

import com.qirui.crm.exception.LoginException;
import com.qirui.crm.settings.domain.User;
import com.qirui.crm.settings.service.UserService;
import com.qirui.crm.utils.MD5Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/settings/user")
@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(String loginAct, String loginPwd, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String ip = request.getRemoteAddr();
        String loginpwd = MD5Util.getMD5(loginPwd);
        User user;
        try {
            user = userService.login(loginAct, loginpwd,ip);
            request.getSession().setAttribute("user",user);
            jsonObject.put("success",true);
        } catch (LoginException e) {
            String msg = e.getMessage();
            jsonObject.put("success",false);
            jsonObject.put("msg",msg);
        }finally {
            return jsonObject.toString();
        }
    }
}
