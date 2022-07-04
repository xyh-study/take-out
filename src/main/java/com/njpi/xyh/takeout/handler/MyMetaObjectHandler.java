package com.njpi.xyh.takeout.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.njpi.xyh.takeout.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * mybatis-plus 公共字段自动填充
 *
 * @author: xyh
 * @create: 2022/7/4 8:53
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Resource
    private HttpSession session;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "createUser", Long.class, getLoginEmployee());
        this.strictInsertFill(metaObject, "updateUser", Long.class, getLoginEmployee());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐)
        this.strictInsertFill(metaObject, "updateUser", Long.class, getLoginEmployee());

    }

    /**
     * 获取登录用户id
     * @return
     */
    private Long getLoginEmployee() {
        Employee employee = (Employee) session.getAttribute("employee");
        return employee.getId();

    }
}
