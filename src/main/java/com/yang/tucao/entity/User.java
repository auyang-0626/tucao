package com.yang.tucao.entity;

import com.yang.tucao.menu.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class User {

    private String wxid;
    private String name;
    private Double account;

    //发起的吐槽大会的title，虽然以下字段放在user表中不符合设计的原则，但是能够减少大量的关联查询，以后也不打算扩展该程序，所以性能优先
    private String title;
    private Date titleCreateDate; //表示title的创建时间，不关心用户的创建时间，因为是微信用户
    private State state;


    public User() {
    }

    public User(String wxid, String name, Double account, String title, Date titleCreateDate, State state) {
        this.wxid = wxid;
        this.name = name;
        this.account = account;
        this.title = title;
        this.titleCreateDate = titleCreateDate;
        this.state = state;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTitleCreateDate() {
        return titleCreateDate;
    }

    public void setTitleCreateDate(Date titleCreateDate) {
        this.titleCreateDate = titleCreateDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
