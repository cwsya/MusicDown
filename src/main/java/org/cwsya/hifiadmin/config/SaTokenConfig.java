package org.cwsya.hifiadmin.config;

import cn.dev33.satoken.stp.StpInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.cwsya.hifiadmin.pojo.PO.UserAllEntity;
import org.cwsya.hifiadmin.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cws
 * 权限角色配置
 */
@Component
public class SaTokenConfig implements StpInterface {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        UserAllEntity userAllEntity;
        try {
            userAllEntity = ObjectMapperUtil.getIntstance().readValue(redisTemplate.opsForValue().get("token:login:user:" + loginId.toString()), UserAllEntity.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return userAllEntity.getAccess();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        UserAllEntity userAllEntity;
        try {
            userAllEntity = ObjectMapperUtil.getIntstance().readValue(redisTemplate.opsForValue().get("token:login:user:" + loginId.toString()), UserAllEntity.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return userAllEntity.getRole();
    }
}
