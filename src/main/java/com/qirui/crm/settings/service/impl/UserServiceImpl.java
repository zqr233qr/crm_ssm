package com.qirui.crm.settings.service.impl;

import com.qirui.crm.exception.LoginException;
import com.qirui.crm.settings.dao.UserDao;
import com.qirui.crm.settings.domain.User;
import com.qirui.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public com.qirui.crm.settings.domain.User login(String loginAct, String loginPwd, String ip) throws LoginException{

        com.qirui.crm.settings.domain.User user = userDao.selectByAct(loginAct);

        if (user == null){
            throw new LoginException("账号错误！");
        }else {

            if (!user.getLoginPwd().equals(loginPwd)){
                throw new LoginException("密码错误！");
            }

            if (!user.getAllowIps().contains(ip)){
                throw new LoginException("您不被允许访问！");
            }

            if (user.getLockState() == "0"){
                throw new LoginException("该账号已被锁定！");
            }

            return user;

        }

    }

    @Override
    public List<User> getList() {
        return userDao.getAll();
    }
}
