package com.qirui.crm.settings.dao;

import com.qirui.crm.settings.domain.User;

import java.util.List;

public interface UserDao {

    User selectByAct(String loginAct);

    List<User> getAll();
}