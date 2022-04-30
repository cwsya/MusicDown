package org.cwsya.hifiadmin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.cwsya.hifiadmin.exception.UserErrorException;
import org.cwsya.hifiadmin.pojo.PO.UserAllEntity;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;

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
