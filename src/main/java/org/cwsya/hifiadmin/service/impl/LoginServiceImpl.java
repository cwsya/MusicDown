package org.cwsya.hifiadmin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.cwsya.hifiadmin.exception.UserErrorException;
import org.cwsya.hifiadmin.mapper.UserAllMapper;
import org.cwsya.hifiadmin.pojo.PO.UserAllEntity;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;
import org.cwsya.hifiadmin.service.LoginService;
import org.cwsya.hifiadmin.util.ObjectMapperUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author cws
 * 登录相关
 */
@Service
public class LoginServiceImpl implements LoginService {
    public LoginServiceImpl(UserAllMapper userAllMapper, RedisTemplate<String, String> redisTemplate) {
        this.userAllMapper = userAllMapper;
        this.redisTemplate = redisTemplate;
    }

    private final UserAllMapper userAllMapper;

    private final RedisTemplate<String,String> redisTemplate;
    @Override
    public UserAllEntity login(UserEntity user) throws UserErrorException, JsonProcessingException {
        UserAllEntity userAllEntity = userAllMapper.selectUserAll(user);
        if (userAllEntity==null) {
            throw new UserErrorException();
        }
        StpUtil.login(userAllEntity.getId());
        redisTemplate.opsForValue().set("token:login:user:"+userAllEntity.getId(), ObjectMapperUtil.getIntstance().writeValueAsString(userAllEntity));
        return userAllEntity;
    }

    @Override
    public boolean isLogin() {
        return StpUtil.isLogin();
    }

    @Override
    public boolean outLogin(String token) {
        Object id = StpUtil.getLoginIdByToken(token);
        StpUtil.logoutByTokenValue(token);
        if (!StrUtil.isBlankIfStr(id)) {
            redisTemplate.delete("token:login:user:"+id);
        }
        return true;
    }
}
