package com.zyx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyx.mapper.UserMapper;
import com.zyx.pojo.Storepojo;
import com.zyx.pojo.Zyx_user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author 张宇森
 * @version 1.0
 * 登录/注销
 */
@SuppressWarnings("all")
@Controller
public class LoginController {

    @Resource
    UserMapper userMapper;

    //登录
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){

            QueryWrapper<Zyx_user> wrapper = new QueryWrapper<>();
            wrapper.eq("usercode",username);
            Zyx_user user = userMapper.selectOne(wrapper);
            System.out.println("用户:"+user);
            if(user==null){
                model.addAttribute("message","账户或密码错误!");
            }else{

                if(password.equals(user.getUserpassword())){
                    session.setAttribute("loginUser",username);
                    return "redirect:/main.html";
                }else{
                    model.addAttribute("message","账户或密码错误!");
                }
            }
        return "index";
    }
    //注销
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){

        session.invalidate();
        return "redirect:/index.html";
    }

    /**
     * 登录信息管理
     */

    //出厂商列表页面 ==
    @RequestMapping("/login/use")
    public String listPro(Model model){

        List<Zyx_user> zyx_users = userMapper.selectList(null);
        System.out.println(zyx_users);
        model.addAttribute("use",zyx_users);
        return "/use/list";
    }

    //添加页面 ==
    @RequestMapping(value = "/login/toAdd",method = RequestMethod.GET)
    public String toAddPagePro(Model model){
        return "/use/add";
    }

    //添加操作 ==
    @PostMapping(value = "/login/toAdd")
    public String addPro(Zyx_user use){

        //添加员工
        System.out.println("添加登录信息");
        System.out.println(use);
        int insert = userMapper.insert(use);
        System.out.println(insert >0 ? "插入成功":"插入失败");
        return "redirect:/login/use";
    }
    //修改页面
    @RequestMapping(value = "/login/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdatePagePro(@PathVariable("id")Integer id , Model model){

        //查出登录信息
        Zyx_user zyx_user = userMapper.selectById(id);
        model.addAttribute("use",zyx_user);
        System.out.println(zyx_user);
        return "/use/update";
    }
    //修改操作
    @PostMapping(value = "/login/toUpdate")
    public String updatePro(Zyx_user use){
        //修改员工
        System.out.println("修改登录信息");
        int update = userMapper.updateById(use);
        System.out.println(update >0 ? "修改成功":"修改失败");
        return "redirect:/login/use";
    }

    //删除操作 ==
    @GetMapping(value = "/login/toDelete/{id}")
    public String DeletePro(@PathVariable("id")int id){
        //删除员工
        userMapper.deleteById(id);
        return "redirect:/login/use";
    }

}
