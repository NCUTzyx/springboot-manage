package com.zyx.controller;

import com.zyx.mapper.StorepojoMapper;
import com.zyx.pojo.Provider;
import com.zyx.pojo.Storepojo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 * 连锁商店管理
 */
@Controller
@SuppressWarnings("all")
public class StorepojoController {

    @Resource
    StorepojoMapper storepojoMapper;

    //出厂商列表页面 ==
    @RequestMapping("/store/poj")
    public String listPro(Model model){

        List<Storepojo> storepojos = storepojoMapper.selectList(null);
        System.out.println(storepojos);
        model.addAttribute("poj",storepojos);
        return "/poj/list";
    }

    //添加页面 ==
    @RequestMapping(value = "/store/toAdd",method = RequestMethod.GET)
    public String toAddPagePro(Model model){
        return "/poj/add";
    }

    //添加操作 ==
    @PostMapping(value = "/store/toAdd")
    public String addPro(Storepojo poj){

        //添加员工
        System.out.println("添加出厂商");
        System.out.println(poj);
        int insert = storepojoMapper.insert(poj);
        System.out.println(insert >0 ? "插入成功":"插入失败");
        return "redirect:/store/poj";
    }
    //修改页面
    @RequestMapping(value = "/store/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdatePagePro(@PathVariable("id")Integer id , Model model){

        //查出出厂商信息
        Storepojo storepojo = storepojoMapper.selectById(id);
        model.addAttribute("poj",storepojo);
        System.out.println(storepojo);
        return "/poj/update";
    }
    //修改操作
    @PostMapping(value = "/store/toUpdate")
    public String updatePro(Storepojo poj){
        //修改员工
        System.out.println("修改员工");
        int update = storepojoMapper.updateById(poj);
        System.out.println(update >0 ? "修改成功":"修改失败");
        return "redirect:/store/poj";
    }

    //删除操作 ==
    @GetMapping(value = "/store/toDelete/{id}")
    public String DeletePro(@PathVariable("id")int id){
        //删除员工
        storepojoMapper.deleteById(id);
        return "redirect:/store/poj";
    }


}
