package com.yang.tucao.mapper;

import com.yang.tucao.entity.User;
import com.yang.tucao.menu.State;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "userMapper")
public interface UserMapper {

    @Select("SELECT * FROM user WHERE wxid = #{wxid}")
    @Results({
            @Result(property = "state",  column = "state", javaType = State.class),
            @Result(property = "titleCreateDate",  column = "title_create_date", javaType = Date.class)
    })
    User getOne(String wxid);

    @Insert({"UPDATE  user title = #{title} , title_create_date = #{titleCreateDate},state = 'PROCESS' where wxid = #{wxid} "})
    void process(User user);

    @Insert({"INSERT INTO user(wxid,name,account,state) VALUES(#{wxid}, #{name},0,'START')"})
    void init(User user);
}
