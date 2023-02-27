package com.zyx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 张宇森
 * @version 1.0
 * 订单信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@SuppressWarnings("all")
public class Orderbill {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String billcode;
    private String productid;
    private String productname;
    private Double productprice;
    private Integer productnum;
    private Double totalprice;

}
