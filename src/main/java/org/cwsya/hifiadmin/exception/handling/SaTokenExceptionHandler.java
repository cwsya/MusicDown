package org.cwsya.hifiadmin.exception.handling;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import org.cwsya.hifiadmin.pojo.Result;
import org.cwsya.hifiadmin.pojo.ResultCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cws
 */
@RestControllerAdvice
@ResponseBody
public class SaTokenExceptionHandler {
    @ExceptionHandler(NotLoginException.class)
    public Result<?> notLoginException(){
        ResultCodeEnum codeEnum = ResultCodeEnum.NOT_LOG_IN_EXCEPTION;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),false);
    }
    @ExceptionHandler({NotRoleException.class, NotPermissionException.class})
    public Result<?> notRoleException(){
        ResultCodeEnum codeEnum = ResultCodeEnum.NOT_JURISDICTION;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),false);
    }
    @ExceptionHandler(DisableLoginException.class)
    public Result<?> disableLoginException(){
        ResultCodeEnum codeEnum = ResultCodeEnum.FUCK_YOU;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),false);
    }
}
