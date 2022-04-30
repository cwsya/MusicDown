package org.cwsya.hifiadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.pojo.PO.RoleEntity;

/**
 * 角色相关操作
 * @author cws
 */
public interface RoleService {

    /**
     * 增加角色
     * @param roleEntity 角色
     * @return 是否成功
     */
    boolean addRole(RoleEntity roleEntity);

    /**
     * 停用角色
     * @param id 角色id
     * @return 是否成功
     */
    boolean stopRole(Integer id);
    /**
     * 启用角色
     * @param id 角色id
     * @return 是否成功
     */
    boolean startRole(Integer id);

    /**
     * 查角色
     * @param current 页数
     * @param size 数量
     * @return 信息
     *
     */
    Page<RoleEntity> getRole(Integer current, Integer size);
}
