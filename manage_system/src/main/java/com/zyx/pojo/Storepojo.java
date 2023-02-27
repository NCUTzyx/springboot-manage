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
 */
@SuppressWarnings("all")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Storepojo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String storecode;
    private String storename;
    private String storeduty;
    private String storephone;
    private String storeaddress;
    private String storefax;
}
