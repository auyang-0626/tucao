package com.yang.tucao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String wxid;
    private String name;
    private Double account;

    //发起的吐槽大会的title，虽然以下字段放在user表中不符合设计的原则，但是能够减少大量的关联查询，以后也不打算扩展该程序，所以性能优先
    private String title;
    private Date titleCreateDate; //表示title的创建时间，不关心用户的创建时间，因为是微信用户

}
