package org.apache.skywalking.apm.webapp.entity;

import java.util.Date;

/**
 * Created by qibaichao on 2018/11/26.
 */
public class UserInfo {

    private Integer id;
    private Date createTime;
    private Date updateTime;
    private String userName;
    private String password;
    private Integer is_available;
    private Integer version;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIs_available() {
        return is_available;
    }

    public void setIs_available(Integer is_available) {
        this.is_available = is_available;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
