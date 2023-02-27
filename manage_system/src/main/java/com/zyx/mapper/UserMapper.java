package com.zyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyx.pojo.Zyx_user;
import org.springframework.stereotype.Repository;

/**
 * @author 张宇森
 * @version 1.0
 */
//登陆业务
@Repository
public interface UserMapper extends BaseMapper<Zyx_user> {
}
