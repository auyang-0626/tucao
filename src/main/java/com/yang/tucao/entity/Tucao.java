package com.yang.tucao.entity;

import java.util.Date;

public class Tucao {

    private Long id;
    private String fromWxid; //谁写的吐槽6
    private String toWxid; //写给谁的吐槽

    private String content;
    private boolean isBest;//最佳吐槽

    private Date createAt;

    public Tucao() {
    }

    public Tucao(Long id, String fromWxid, String toWxid, String content, boolean isBest, Date createAt) {
        this.id = id;
        this.fromWxid = fromWxid;
        this.toWxid = toWxid;
        this.content = content;
        this.isBest = isBest;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromWxid() {
        return fromWxid;
    }

    public void setFromWxid(String fromWxid) {
        this.fromWxid = fromWxid;
    }

    public String getToWxid() {
        return toWxid;
    }

    public void setToWxid(String toWxid) {
        this.toWxid = toWxid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isBest() {
        return isBest;
    }

    public void setBest(boolean best) {
        isBest = best;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
