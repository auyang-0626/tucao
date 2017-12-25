package com.yang.tucao.entity;

import java.util.Date;

public class Tucao {

    private Long id;
    private String fromWxid; //谁写的吐槽
    private String toWxid; //写给谁的吐槽

    private String content;
    private boolean isBest;//最佳吐槽

    private Date createAt;
}
