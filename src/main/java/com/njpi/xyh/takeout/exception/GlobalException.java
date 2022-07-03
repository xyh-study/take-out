package com.njpi.xyh.takeout.exception;

import com.njpi.xyh.takeout.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;


/**
 * @author: xyh
 * @create: 2022/6/26 20:11
 */
@ControllerAdvice
@Slf4j
public class GlobalException {


    @Resource
    private HttpServletResponse response;



    /**
     * 捕捉登录认证异常
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Result login(AuthenticationException e){
        log.debug("异常信息 ---- > {}",e.getResult().getMsg());
        return e.getResult();
    }

    /**
     * 校验登录数据
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result validate(MethodArgumentNotValidException e){
        // 只需要获取 第一个校验失败的错误返回
        String defaultMessage = e.getAllErrors().get(0).getDefaultMessage();
        log.debug("数据校验异常====> {}",defaultMessage);
        return Result.error(defaultMessage);
    }




    /**
     * 数据插入异常
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public Result insert(SQLIntegrityConstraintViolationException e){
            if(e.getMessage().contains("Duplicate")){
                String[] split = e.getMessage().split(" ");
                return Result.error(split[2] +" 已经存在");
            }
        return Result.error("未知错误");
    }

}
