package org.cwsya.hifiadmin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.mapper.UserMapper;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;
import org.cwsya.hifiadmin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author cws
 * 用户相关的增删改查
 */
@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    private final UserMapper userMapper;

    @Override
    public boolean addUser(UserEntity user) {
        userMapper.insert(user);
        return true;
    }

    @Override
    public boolean upUser(UserEntity user){
        userMapper.updateById(user);
        return true;
    }

    @Override
    public boolean stopUser(Integer id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setStatus(0);
        userEntity.setId(id);
        userMapper.updateById(userEntity);
        return true;
    }

    @Override
    public boolean startUser(Integer id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setStatus(1);
        userEntity.setId(id);
        userMapper.updateById(userEntity);
        return true;
    }

    @Override
    public Page<UserEntity> getUser(Integer current, Integer size,String name) {
        Page<UserEntity> page= new Page<>(current,size);
        if (StrUtil.isBlankIfStr(name)){
            userMapper.selectPage(page,null);
        }else {
            LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.like(UserEntity::getUserName,name);
            userMapper.selectPage(page, queryWrapper);
        }
        return page;
    }
}
