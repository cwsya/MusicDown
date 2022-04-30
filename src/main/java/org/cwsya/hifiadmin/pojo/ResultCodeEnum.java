package org.cwsya.hifiadmin.pojo;

/**
 * @author cws
 */
public enum ResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS(100,"成功"),
    /**
     * 账号或密码错误
     */
    USER_ERROR(101,"账号或密码错误"),
    /**
     * 请求类型错误
     */
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(102,"不要乱动我的接口"),
    NOT_LOG_IN_EXCEPTION(103,"请先登录"),
    REQUEST_EXCEPTION(104,"参数异常"),
    NOT_JURISDICTION(105,"权限不足"),
    FUCK_YOU(666,"滚");

    private int resultCode;
    private String message;

    ResultCodeEnum(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}