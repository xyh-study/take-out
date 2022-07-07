package com.njpi.xyh.takeout.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njpi.xyh.takeout.entity.User;
import com.njpi.xyh.takeout.result.Result;

/**
 * 用户信息(User)表服务接口
 *
 * @author xyh
 * @since 2022-07-02 18:55:01
 */
public interface UserService extends IService<User> {

    Result login(User user);
}

