package org.cwsya.hifiadmin.pojo;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @author cws
 * 统一返回值
 * @param <T>
 */

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Value("返回码")
    private int resultCode;

    @Value("返回信息")
    private String message;

    @Value("返回数据")
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message, T data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public Result(int resultCode, String message) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
