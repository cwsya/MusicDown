package org.cwsya.tadmin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.cwsya.tadmin.exception.UserErrorException;
import org.cwsya.tadmin.pojo.PO.UserAllEntity;
import org.cwsya.tadmin.pojo.PO.UserEntity;

/**
 * @author cws
 */
public interface LoginService {

    /**
     * 登录方法
     * @param user 用户信息
     * @return 用户对象
     * @throws UserErrorException 错误
     * @throws JsonProcessingException 错误
     */
    UserAllEntity login(UserEntity user) throws UserErrorException, JsonProcessingException;

    /**
     * 验证是否登录
     * @return 是否登录
     */
    boolean isLogin();

    /**
     * 退出登录 清理用户在redis的数据
     * @param token 用户标识
     * @return 是否成功
     */
    boolean outLogin(String token);
}
