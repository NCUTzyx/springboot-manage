package com.zyx.controller;
import com.zyx.mapper.OrderbillMapper;
import com.zyx.pojo.Orderbill;
import com.zyx.pojo.Provider;
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
public class OrderbillController {

    @Resource
    OrderbillMapper orderbillMapper;

    //订单列表页面 ==
    @RequestMapping("/order/bill")
    public String listPro(Model model){

        List<Orderbill> orderbills = orderbillMapper.selectList(null);
        System.out.println(orderbills);
        model.addAttribute("bill",orderbills);
        return "/bill/list";
    }

    //添加页面 ==
    @RequestMapping(value = "/order/toAdd",method = RequestMethod.GET)
    public String toAddPagePro(Model model){
        return "/bill/add";
    }

    //添加操作 ==
    @PostMapping(value = "/order/toAdd")
    public String addPro(Orderbill bill){

        //添加订单
        System.out.println("添加订单");
        System.out.println(bill);
        int insert = orderbillMapper.insert(bill);
        System.out.println(insert >0 ? "插入成功":"插入失败");
        return "redirect:/order/bill";
    }
    //修改页面
    @RequestMapping(value = "/order/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdatePagePro(@PathVariable("id")Integer id , Model model){

        //查出订单信息
        Orderbill orderbill = orderbillMapper.selectById(id);
        model.addAttribute("bill",orderbill);
        System.out.println(orderbill);
        return "/bill/update";
    }
    //修改操作
    @PostMapping(value = "/order/toUpdate")
    public String updatePro(Orderbill bill){
        //修改订单信息
        System.out.println("修改员工");
        int update = orderbillMapper.updateById(bill);
        System.out.println(update >0 ? "修改成功":"修改失败");
        return "redirect:/order/bill";
    }

    //删除操作 ==
    @GetMapping(value = "/order/toDelete/{id}")
    public String DeletePro(@PathVariable("id")int id){
        //删除员工
        orderbillMapper.deleteById(id);
        return "redirect:/order/bill";
    }

}
