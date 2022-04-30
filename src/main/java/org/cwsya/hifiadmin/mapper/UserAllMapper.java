package org.cwsya.hifiadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.cwsya.hifiadmin.pojo.PO.UserAllEntity;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;

/**
 * @author cws
 */
@Mapper
public interface UserAllMapper extends BaseMapper<UserAllEntity> {
    /**
     * 5表联查 用户角色权限信息
     * @param userEntity 用户信息
     * @return 用户角色权限相关信息
     */
    UserAllEntity selectUserAll(UserEntity userEntity);
}
