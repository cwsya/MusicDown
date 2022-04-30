package org.cwsya.hifiadmin.exception;

/**
 * @author cws
 * 参数异常错误
 */
public class ParameterException extends Exception{
    public ParameterException() {
    }

    public ParameterException(String message) {
        super(message);
    }
}
