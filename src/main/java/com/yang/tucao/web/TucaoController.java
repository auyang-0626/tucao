package com.yang.tucao.web;

import com.yang.tucao.entity.Tucao;
import com.yang.tucao.entity.User;
import com.yang.tucao.mapper.UserMapper;
import com.yang.tucao.service.TucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class TucaoController {

    @Autowired
    private TucaoService tucaoService;



    @RequestMapping(value = "/user/{wxid}",method = RequestMethod.GET)
    public User findUser(@PathVariable(name = "wxid") String wxid){
        return tucaoService.findUser(wxid);
    }

    @RequestMapping(value = "/tucao/start",method = RequestMethod.POST)
    public User startTucao(@RequestBody User user){
        return tucaoService.startTucao(user);
    }


    @RequestMapping(value = "/tucao/end/{wxid}/{tcid}",method = RequestMethod.GET)
    public Long endTucao(@PathVariable(name = "wxid") String wxid,@PathVariable(name = "tcid") Long tcid){
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
