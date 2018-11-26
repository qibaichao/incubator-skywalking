package org.apache.skywalking.apm.webapp.security;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest extends Assert {
    @Before
    public void baseBefore() {
        System.out.println("-----------开始测试用例----------");
    }

    @After
    public void baseAfter() {
        System.out.println("-----------结束测试用例----------");
    }
}
