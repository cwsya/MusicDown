package org.cwsya.hifiadmin.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.pojo.PO.RoleAccessEntity;

/**
 * 角色权限操作
 * @author cws
 */
public interface RoleAccessService {
    /**
     * 添加角色权限对应数据
     * @param roleAccessEntity 对应数据
     * @return 是否成功
     */
    boolean addRoleAccess(RoleAccessEntity roleAccessEntity);

    /**
     * 删除对应关系
     * @param id 对应的id
     * @return 是否成功
     */
    boolean delRoleAccess(Integer id);

    /**
     * 查对应表
     * @param current 页数
     * @param size 数量
     * @param roleid 角色id
     * @return 信息
     */
    Page<RoleAccessEntity> getRoleAccess(Integer current, Integer size,Integer roleid);

    /**
     * 查对应角色
     * @param current 页数
     * @param size 数量
     * @param accessid 权限id
     * @return 信息
     */
    Page<RoleAccessEntity> getAccessRole(Integer current, Integer size, Integer accessid);
}
