package org.apache.skywalking.apm.webapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.skywalking.apm.webapp.entity.UserInfo;

/**
 * Created by qibaichao on 2018/11/26.
 */
@Mapper
public interface UserInfoDao {

    UserInfo selectByUserName(String userName);
}
