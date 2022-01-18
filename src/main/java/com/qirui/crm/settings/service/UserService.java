package com.qirui.crm.settings.service;

import com.qirui.crm.exception.LoginException;
import com.qirui.crm.settings.domain.User;

import java.util.List;

public interface UserService {

    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getList();

}
