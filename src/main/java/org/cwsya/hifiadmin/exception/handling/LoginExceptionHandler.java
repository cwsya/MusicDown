package org.cwsya.hifiadmin.exception.handling;

import org.cwsya.hifiadmin.exception.UserErrorException;
import org.cwsya.hifiadmin.pojo.Result;
import org.cwsya.hifiadmin.pojo.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cws
 * 登录相关异常处理
 */
@ControllerAdvice
@ResponseBody
public class LoginExceptionHandler {

    @ExceptionHandler(UserErrorException.class)
    public Result<?> userErrorException(){
        ResultCodeEnum codeEnum = ResultCodeEnum.USER_ERROR;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),false);
    }
}
