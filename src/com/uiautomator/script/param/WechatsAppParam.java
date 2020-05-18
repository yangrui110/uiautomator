package com.uiautomator.script.param;

import java.util.ArrayList;
import java.util.List;

public class WechatsAppParam {

    //登录的手机号
    private String phone;

    //国籍
    private String country = "1";

    //获取验证码的地址
    private String url;

    //发送人的数量
    private int person = 0;

    //发送的消息
    private List<String> msgs = new ArrayList();


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public List<String> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<String> msgs) {
        this.msgs = msgs;
    }
}
