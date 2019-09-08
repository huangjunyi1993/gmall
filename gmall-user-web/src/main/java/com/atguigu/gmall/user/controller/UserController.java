package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("getAllUser")
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMemberList = userService.getAllUser();

        return umsMemberList;
    }

    @RequestMapping("getUmsMemberReceiveAddressById")
    public List<UmsMemberReceiveAddress> getUmsMemberReceiveAddressById(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = userService.getUmsMemberReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddressList;
    }

    @RequestMapping("index")
    public String index(){
        return "hello user";
    }

}
