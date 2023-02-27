package com.zyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张宇森
 * @version 1.0
 *  联系我们
 */
@Controller
public class ContactController {

    //跳转联系我们的页面
    @RequestMapping("/cont/act")
    public String contactWe(){
        return "/cont/contact";
    }

    //处理发邮件
    @RequestMapping("/cont/toSend")
    public String contactSend(){
        System.out.println("发送成功");
        return "/cont/act";
    }

}
