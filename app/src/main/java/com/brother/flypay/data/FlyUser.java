package com.brother.flypay.data;

import cn.bmob.v3.BmobUser;

/**
 * 说明：用户类
 * note：
 * Created by FuPei
 * on 2015/11/24 at 13:48
 */
public class FlyUser extends BmobUser {
    private String nickName;
    private Integer age;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
