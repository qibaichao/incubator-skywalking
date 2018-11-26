package org.apache.skywalking.apm.webapp.security.logic;

import org.apache.skywalking.apm.webapp.entity.UserInfo;
import org.apache.skywalking.apm.webapp.logic.UserInfoLogic;
import org.apache.skywalking.apm.webapp.security.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2018/11/26.
 */

public class UserInfoLogicTest  extends BaseTest {

    @Autowired
    private UserInfoLogic userInfoLogic;

    @Test
    public void selectByUserName() {
        String userName = "qibaichao";
        UserInfo userInfo = userInfoLogic.selectByUserName(userName);
        System.out.println("userName" + userInfo.getUserName());
    }
}
