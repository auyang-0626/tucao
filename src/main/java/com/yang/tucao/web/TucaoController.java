package com.yang.tucao.web;

import com.yang.tucao.entity.Tucao;
import com.yang.tucao.entity.User;
import com.yang.tucao.helper.HttpHelper;
import com.yang.tucao.mapper.UserMapper;
import com.yang.tucao.service.TucaoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class TucaoController {

    private static final Log LOGGER = LogFactory.getLog(TucaoController.class);

    @Autowired
    private TucaoService tucaoService;



    @RequestMapping(value = "/user/{wxid}",method = RequestMethod.GET)
    public User findUser(@PathVariable(name = "wxid") String wxid){
        return tucaoService.findUser(wxid);
    }

    @RequestMapping(value = "/tucao/start",method = RequestMethod.POST)
    public User startTucao(@RequestBody User user){
        LOGGER.info(String.format("startTucao %s, %s ",user.getWxid(),user.getName()));
        return tucaoService.startTucao(user);
    }

    @RequestMapping(value = "/tucao/process",method = RequestMethod.POST)
    public User processTucao(@RequestBody User user){
        LOGGER.info(String.format("processTucao %s, %s ",user.getWxid(),user.getName()));
        return tucaoService.processTucao(user);
    }

    @RequestMapping(value = "/tucao/end/{wxid}/{tcid}",method = RequestMethod.GET)
    public Long endTucao(@PathVariable(name = "wxid") String wxid,@PathVariable(name = "tcid") Long tcid){
        LOGGER.info(String.format("endTucao %s, %s ",wxid,tcid));
        return tucaoService.endTucao(wxid,tcid);
    }


    @RequestMapping(value = "/tucao/add",method = RequestMethod.POST)
    public Tucao addTucao(@RequestBody Tucao tucao){
        return tucaoService.addTucao(tucao);
    }

    @RequestMapping(value = "/tucao/list/{wxid}",method = RequestMethod.GET)
    public List<Tucao> listTucao(@PathVariable(name = "wxid") String wxid){
        return tucaoService.listTucao(wxid);
    }
}
