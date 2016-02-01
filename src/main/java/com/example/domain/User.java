package com.example.domain;

/**
 * Created by SunYi on 2016/2/1/0001.
 * 用户类包含用户名和密码
 */
public class User extends baseobject{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
