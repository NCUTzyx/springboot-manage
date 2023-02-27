package com.zyx.controller;

import com.zyx.mapper.ProviderMapper;
import com.zyx.pojo.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 * 出厂商管理
 */

@Controller
public class ProviderController {

    @Resource
    ProviderMapper providerMapper;

    //出厂商列表页面 ==
    @RequestMapping("/provider/pro")
    public String listPro(Model model){

        List<Provider> providers = providerMapper.selectList(null);
        System.out.println(providers);
        model.addAttribute("pro",providers);
        return "/pro/list";
    }

    //添加页面 ==
    @RequestMapping(value = "/provider/toAdd",method = RequestMethod.GET)
    public String toAddPagePro(Model model){
        return "/pro/add";
    }

    //添加操作 ==
    @PostMapping(value = "/provider/toAdd")
    public String addPro(Provider pro){

        //添加员工
        System.out.println("添加出厂商");
        System.out.println(pro);
        int insert = providerMapper.insert(pro);
        System.out.println(insert >0 ? "插入成功":"插入失败");
        return "redirect:/provider/pro";
    }
    //修改页面
    @RequestMapping(value = "/provider/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdatePagePro(@PathVariable("id")Integer id , Model model){

        //查出出厂商信息
        Provider provider = this.providerMapper.selectById(id);
        model.addAttribute("pro",provider);
        System.out.println(provider);
        return "/pro/update";
    }
    //修改操作
    @PostMapping(value = "/provider/toUpdate")
    public String updatePro(Provider pro){
        //修改员工
        System.out.println("修改员工");
        int update = providerMapper.updateById(pro);
        System.out.println(update >0 ? "修改成功":"修改失败");
        return "redirect:/provider/pro";
    }

    //删除操作 ==
    @GetMapping(value = "/provider/toDelete/{id}")
    public String DeletePro(@PathVariable("id")int id){
        //删除员工
        providerMapper.deleteById(id);
        return "redirect:/provider/pro";
    }
}
