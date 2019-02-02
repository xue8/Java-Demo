package com.shiro.entity;

/**
 * @program: shiro
 * @description:
 * @author: Xue 8
 * @create: 2019-02-01 13:44
 **/
public class UserRole {
    int id;
    int uId;
    int rId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }
}
