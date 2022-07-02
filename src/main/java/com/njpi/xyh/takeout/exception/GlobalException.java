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


/**
 * @author: xyh
 * @create: 2022/6/26 20:11
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalException {

    /**
     * ResponseEntity 返回状态
     * 如果不套ResponseEntity 返回值的话
     * @param
     * @return
     */
//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<Result> login(AuthenticationException e){
//        return ResponseEntity.ok(e.getResult());
//    }


    /**
     * 捕捉登录认证异常
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public Result login(AuthenticationException e){
        log.debug("login");
        return e.getResult();
    }

    /**
     * 校验登录数据
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result validate(MethodArgumentNotValidException e){
        // 只需要获取 第一个校验失败的错误返回
        String defaultMessage = e.getAllErrors().get(0).getDefaultMessage();
        log.debug("数据校验异常====> {}",defaultMessage);
        return Result.error(defaultMessage);
    }


}
