package org.cwsya.hifiadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
