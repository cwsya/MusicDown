package org.cwsya.hifiadmin.exception;

/**
 * @author cws
 * 用户相关错误
 */
public class UserErrorException extends Exception{
    public UserErrorException() {
    }

    public UserErrorException(String message) {
        super(message);
    }
}
