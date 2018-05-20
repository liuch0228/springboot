package com.lch.springboot03.controller;

import com.lch.springboot03.domain.User;
import com.lch.springboot03.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public String index(){
        return "redirect:/list"; //重定向到 /list
    }

    @RequestMapping("/list")
    public String lsit(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
        return "user/list"; // 跳转到springboot03\src\main\resources\templates\user下的list.html
    }

    @RequestMapping("/toAdd")
    public String toadd(User user){
        return "user/userAdd";//跳转到userAdd.html
    }

    @RequestMapping("/add")
    public String add(User user){
        userService.save(user);
        return "redirect:/list";//添加完成，请求重定向到/list
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/userEdit"; //跳转到userEdit.html页面
    }
    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/list";//获取列表数据并显示
    }

    @RequestMapping("/delete")
    public String edit(Long id){
        userService.delete(id);
        return "redirect:/list";
    }
}
