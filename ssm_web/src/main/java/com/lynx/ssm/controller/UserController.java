package com.lynx.ssm.controller;

import com.lynx.ssm.domain.Role;
import com.lynx.ssm.domain.UserInfo;
import com.lynx.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //查找所有用户
    @RequestMapping("findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> list = userService.findAll();
        modelAndView.addObject("userList",list);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    //增加用户
    @RequestMapping("/save.do")
    public String  saveUser(UserInfo userInfo)throws Exception{
        userService.saveUser(userInfo);
        return "redirect:findAll.do";
    }

    //根据id查询用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findByid(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    //给用户添加角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userid) throws Exception {
        ModelAndView modelAndView  = new ModelAndView();
        UserInfo userInfo = userService.findByid(userid);
        List<Role> otherRoles = userService.findOtherRoles(userid);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",otherRoles);
        modelAndView.setViewName("user-role-add");
        return  modelAndView;
    }

    @RequestMapping("/addRoleToUser.do")
    public  String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return  "redirect:findAll.do";
    }

}
