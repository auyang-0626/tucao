package com.yang.tucao.mapper;

import com.yang.tucao.entity.Tucao;
import com.yang.tucao.entity.User;
import com.yang.tucao.menu.State;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component(value = "tucaoMapper")
public interface TucaoMapper {
    @Select("select * from tucao where to_wxid = #{wxid}")
    @Results({
            @Result(property = "fromWxid",  column = "from_wxid", javaType = String.class),
            @Result(property = "toWxid",  column = "to_wxid", javaType = String.class),
            @Result(property = "isBest",  column = "is_best", javaType = Boolean.class),
            @Result(property = "createAt",  column = "create_at", javaType = Date.class)
    })
    List<Tucao> findTucaoByToWxid(String wxid);

    @Select("UPDATE tucao SET is_best = true  WHERE to_wxid = #{wxid} and id = #{tcid}")
    void setBest(@Param("wxid") String wxid,@Param("tcid") Long tcid);

    @Insert({"insert into tucao(from_wxid,to_wxid,content,is_best,create_at) values(#{fromWxid},#{toWxid},#{content},false,#{createAt});"})
    void insert(Tucao tucao);
}
