package com.zhangzhen.eduservice.controller;

import com.zhangzhen.commontils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eduservice/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping(value = "/login")
    public R login() {
        return R.success().data("token","admin");
    }

    @GetMapping(value = "/info")
    public R userInfo() {
        return R.success().data("roles",new String[]{"admin"}).data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
