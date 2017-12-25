package com.yang.tucao.service;

import com.yang.tucao.entity.Tucao;
import com.yang.tucao.entity.User;
import com.yang.tucao.mapper.TucaoMapper;
import com.yang.tucao.mapper.UserMapper;
import com.yang.tucao.menu.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TucaoService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TucaoMapper tucaoMapper;

    public User findUser(String wxid) {
        return userMapper.getOne(wxid);
    }

    public User startTucao(User user) {
        user.setState(State.START);
        userMapper.insert(user);
        return user;
    }

    public Long endTucao(String wxid, Long tcid) {
        tucaoMapper.setBest(wxid,tcid);
        return tcid;
    }

    public Tucao addTucao(Tucao tucao) {
        tucaoMapper.insert(tucao);
        return tucao;
    }

    public List<Tucao> listTucao(String wxid) {
        return tucaoMapper.findTucaoByToWxid(wxid);
    }
}
