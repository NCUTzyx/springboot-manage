package com.zyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyx.pojo.Employee;
import org.springframework.stereotype.Repository;

/**
 * @author 张宇森
 * @version 1.0
 */
//员工业务
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}
