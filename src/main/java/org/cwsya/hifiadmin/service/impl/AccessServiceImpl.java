package org.cwsya.hifiadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.mapper.AccessMapper;
import org.cwsya.hifiadmin.pojo.PO.AccessEntity;
import org.cwsya.hifiadmin.service.AccessService;
import org.springframework.stereotype.Service;

/**
 * 权限相关操作
 * @author cws
 */
@Service
public class AccessServiceImpl implements AccessService {
    private final AccessMapper accessMapper;

    public AccessServiceImpl(AccessMapper accessMapper) {
        this.accessMapper = accessMapper;
    }

    @Override
    public boolean addAccess(AccessEntity access) {
        accessMapper.insert(access);
        return true;
    }

    @Override
    public boolean stopAccess(Integer id) {
        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setId(id);
        accessEntity.setStatus(0);
        accessMapper.updateById(accessEntity);
        return true;
    }

    @Override
    public boolean startAccess(Integer id) {
        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setId(id);
        accessEntity.setStatus(1);
        accessMapper.updateById(accessEntity);
        return true;
    }

    @Override
    public Page<AccessEntity> getAccess(Integer current, Integer size) {
        Page<AccessEntity> page=new Page<>(current,size);
        accessMapper.selectPage(page,null);
        return page;
    }
}
