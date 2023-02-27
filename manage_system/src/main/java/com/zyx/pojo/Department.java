package com.zyx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 张宇森
 * @version 1.0
 * 部门信息属性
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Department {

    private Integer id;
    private String departmentname;

}
