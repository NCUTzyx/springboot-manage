package com.zyx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 张宇森
 * @version 1.0
 * 员工表信息属性
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Employee {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String employeename;
    private String email;
    private Integer sex;  //0.女 1.男
    private String department;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

}
