package com.njpi.xyh.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njpi.xyh.takeout.dao.UserDao;
import com.njpi.xyh.takeout.entity.User;
import com.njpi.xyh.takeout.result.Result;
import com.njpi.xyh.takeout.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户信息(User)表服务实现类
 *
 * @author xyh
 * @since 2022-07-02 18:55:02
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private HttpSession session;

    @Override
    public Result login(User user) {
        // 1. 校验数据
        // 2.根据手机号查询用户
        User phone = baseMapper.selectOne(new QueryWrapper<User>().eq("phone", user.getPhone()));
        // 3.查询成功保存到session中
        if(phone == null){
        return  Result.error("登陆失败");
        }
        session.setAttribute("user",phone);
        // 4, 返回结果
        return Result.success(phone);
    }
}

