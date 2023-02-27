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
 * 出产商信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("all")
@Component
public class Provider {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String procode;
    private String proname;
    private String prodesc;
    private String procontact;
    private String prophone;
    private String proaddress;
}
