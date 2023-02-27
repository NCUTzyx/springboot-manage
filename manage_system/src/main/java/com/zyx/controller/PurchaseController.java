package com.zyx.controller;

import com.zyx.mapper.PurchaseMapper;
import com.zyx.pojo.Orderbill;
import com.zyx.pojo.Purchase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 */
@Controller
@SuppressWarnings("all")
public class PurchaseController {

    @Resource
    private PurchaseMapper purchaseMapper;

    //采购列表页面 ==
    @RequestMapping("/purch/ase")
    public String listPro(Model model){

        List<Purchase> purchasebills = purchaseMapper.selectList(null);
        System.out.println(purchasebills);
        model.addAttribute("ase",purchasebills);
        return "/ase/list";
    }

    //添加页面 ==
    @RequestMapping(value = "/purch/toAdd",method = RequestMethod.GET)
    public String toAddPagePro(Model model){
        return "/ase/add";
    }

    //添加操作 ==
    @PostMapping(value = "/purch/toAdd")
    public String addPro(Purchase ase){

        //添加采购
        System.out.println("添加订单");
        System.out.println(ase);
        int insert = purchaseMapper.insert(ase);
        System.out.println(insert >0 ? "插入成功":"插入失败");
        return "redirect:/purch/ase";
    }
    //修改页面
    @RequestMapping(value = "/purch/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdatePagePro(@PathVariable("id")Integer id , Model model){

        //查出采购信息
        Purchase purchase = purchaseMapper.selectById(id);
        model.addAttribute("ase",purchase);
        System.out.println(purchase);
        return "/ase/update";
    }
    //修改操作
    @PostMapping(value = "/purch/toUpdate")
    public String updatePro(Purchase purchase){
        //修改采购信息
        System.out.println("修改员工");
        int update = purchaseMapper.updateById(purchase);
        System.out.println(update >0 ? "修改成功":"修改失败");
        return "redirect:/purch/ase";
    }

    //删除操作 ==
    @GetMapping(value = "/purch/toDelete/{id}")
    public String DeletePro(@PathVariable("id")int id){
        //删除采购信息
        purchaseMapper.deleteById(id);
        return "redirect:/purch/ase";
    }


}
