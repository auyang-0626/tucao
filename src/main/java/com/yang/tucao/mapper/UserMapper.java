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

    @Insert({"INSERT INTO user VALUES(#{wxid}, #{name},0,#{title},#{titleCreateDate},#{state})"})
    void insert(User user);
}
