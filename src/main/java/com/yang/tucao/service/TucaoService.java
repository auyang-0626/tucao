package com.yang.tucao.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.yang.tucao.entity.Tucao;
import com.yang.tucao.entity.User;
import com.yang.tucao.helper.HttpHelper;
import com.yang.tucao.mapper.TucaoMapper;
import com.yang.tucao.mapper.UserMapper;
import com.yang.tucao.menu.State;
import okhttp3.HttpUrl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TucaoService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TucaoMapper tucaoMapper;

    private static final Log LOGGER = LogFactory.getLog(TucaoService.class);

    public User findUser(String wxid) {
        return userMapper.getOne(wxid);
    }

    public User startTucao(User user) {
        User checkUser = userMapper.getOne(user.getWxid());
        if (checkUser == null) {
            String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                    "wxa7ff3f12ca625de3","688eccf88ec5743b74575e6c22503ff2",user.getWxid());
            try {
                JSONObject res = JSON.parseObject(HttpHelper.httpGet(HttpUrl.parse(url), Maps.newHashMap()));
                user.setState(State.START);
                user.setWxid(res.getString("openid"));
                userMapper.init(user);
                return user;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return checkUser;
    }

    public Long endTucao(String wxid, Long tcid) {
        User user = userMapper.getOne(wxid);
        if (null != user && (System.currentTimeMillis() - user.getTitleCreateDate().getTime() >1000*3600 ) ) {
            tucaoMapper.setBest(wxid,tcid);
        }
        return tcid;
    }

    public Tucao addTucao(Tucao tucao) {
        tucaoMapper.insert(tucao);
        return tucao;
    }

    public List<Tucao> listTucao(String wxid) {
        return tucaoMapper.findTucaoByToWxid(wxid);
    }

    public User processTucao(User user) {
        userMapper.process(user);
        return user;
    }
}
