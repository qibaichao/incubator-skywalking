package org.apache.skywalking.apm.webapp.security.logic;

import org.apache.skywalking.apm.webapp.entity.UserInfo;
import org.apache.skywalking.apm.webapp.logic.UserInfoLogic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by qibaichao on 2018/11/26.
 */
//@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@MybatisTest
@EnableAutoConfiguration
public class UserInfoLogicTest {

    @Autowired
    private UserInfoLogic userInfoLogic;

    @Test
    public void selectByUserName() {
        String userName = "qibaichao";
        UserInfo userInfo= userInfoLogic.selectByUserName(userName);
        System.out.println(userInfo.getUpdateTime());
    }
}
