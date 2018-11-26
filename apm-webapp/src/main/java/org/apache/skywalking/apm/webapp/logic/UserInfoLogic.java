package org.apache.skywalking.apm.webapp.logic;

import org.apache.skywalking.apm.webapp.entity.UserInfo;

/**
 * Created by qibaichao on 2018/11/26.
 */
public interface UserInfoLogic {

    UserInfo selectByUserName(String userName);
}
