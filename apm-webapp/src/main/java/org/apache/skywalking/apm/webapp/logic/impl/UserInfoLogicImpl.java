package org.apache.skywalking.apm.webapp.logic.impl;

import org.apache.skywalking.apm.webapp.dao.UserInfoDao;
import org.apache.skywalking.apm.webapp.entity.UserInfo;
import org.apache.skywalking.apm.webapp.logic.UserInfoLogic;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by qibaichao on 2018/11/26.
 */
@Component
public class UserInfoLogicImpl implements UserInfoLogic {

    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public UserInfo selectByUserName(String userName) {
        return userInfoDao.selectByUserName(userName);
    }
}
