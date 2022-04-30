package org.cwsya.hifiadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.pojo.PO.AccessEntity;

/**
 * @author cws
 */
public interface AccessService {
    /**
     * 增加权限
     * @param access 权限
     * @return 是否成功
     */
    boolean addAccess(AccessEntity access);

    /**
     * 停用权限
     * @param id 权限id
     * @return 是否成功
     */
    boolean stopAccess(Integer id);
    /**
     * 启用用户
     * @param id 权限id
     * @return 是否成功
     */
    boolean startAccess(Integer id);

    /**
     * 查权限
     * @param current 页数
     * @param size 数量
     * @return 信息
     *
     */
    Page<AccessEntity> getAccess(Integer current, Integer size);
}
