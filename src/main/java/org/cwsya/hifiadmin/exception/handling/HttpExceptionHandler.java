package org.cwsya.hifiadmin.exception.handling;

import org.cwsya.hifiadmin.exception.ParameterException;
import org.cwsya.hifiadmin.pojo.Result;
import org.cwsya.hifiadmin.pojo.ResultCodeEnum;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cws
 */

@ControllerAdvice
@ResponseBody
public class HttpExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> httpRequestMethodNotSupportedException(){
        ResultCodeEnum codeEnum = ResultCodeEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),false);
    }
    @ExceptionHandler({ParameterException.class, HttpMessageNotReadableException.class})
    public Result<?> parameterException(){
        ResultCodeEnum codeEnum = ResultCodeEnum.REQUEST_EXCEPTION;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),false);
    }
}
