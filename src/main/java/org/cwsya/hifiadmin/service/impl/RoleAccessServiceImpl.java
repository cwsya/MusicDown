package org.cwsya.hifiadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.mapper.RoleAccessMapper;
import org.cwsya.hifiadmin.pojo.PO.RoleAccessEntity;
import org.cwsya.hifiadmin.service.RoleAccessService;
import org.springframework.stereotype.Service;

/**
 * 角色权限对应信息
 * @author cws
 */
@Service
public class RoleAccessServiceImpl implements RoleAccessService {

    private final RoleAccessMapper roleAccessMapper;

    public RoleAccessServiceImpl(RoleAccessMapper roleAccessMapper) {
        this.roleAccessMapper = roleAccessMapper;
    }

    @Override
    public boolean addRoleAccess(RoleAccessEntity roleAccessEntity) {
        roleAccessMapper.insert(roleAccessEntity);
        return true;
    }

    @Override
    public boolean delRoleAccess(Integer id) {
        roleAccessMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<RoleAccessEntity> getRoleAccess(Integer current, Integer size,Integer roleid) {
        Page<RoleAccessEntity> page=new Page<>(current,size);
        LambdaQueryWrapper<RoleAccessEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleAccessEntity::getRid,roleid);
        roleAccessMapper.selectPage(page, queryWrapper);
        return page;
    }
    @Override
    public Page<RoleAccessEntity> getAccessRole(Integer current, Integer size,Integer accessid) {
        Page<RoleAccessEntity> page=new Page<>(current,size);
        LambdaQueryWrapper<RoleAccessEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleAccessEntity::getAid,accessid);
        roleAccessMapper.selectPage(page, queryWrapper);
        return page;
    }
}
