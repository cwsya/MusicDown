package org.cwsya.hifiadmin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.mapper.MDataMapper;
import org.cwsya.hifiadmin.pojo.PO.MDataEntity;
import org.cwsya.hifiadmin.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;

/**
 * @author cws
 */
@Service
public class MusicServiceImpl implements MusicService {

    private final MDataMapper mDataMapper;

    public MusicServiceImpl(MDataMapper mDataMapper) {
        this.mDataMapper = mDataMapper;
    }

    @Override
    public boolean addMusic(MDataEntity mDataEntity) {
        mDataMapper.insert(mDataEntity);
        return true;
    }

    @Override
    public boolean delMusic(Integer id) {
        mDataMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean upMusic(MDataEntity mDataEntity) {
        mDataMapper.updateById(mDataEntity);
        return true;
    }

    @Override
    public Page<MDataEntity> getMusic(Integer current, Integer size, String name) {
        Page<MDataEntity> mDataEntityPage = new Page<>(current, size);
        if (StrUtil.isBlankIfStr(name)){
            mDataMapper.selectPage(mDataEntityPage,null);
        }else {
            LambdaQueryWrapper<MDataEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.like(MDataEntity::getName,name);
            mDataMapper.selectPage(mDataEntityPage,lambdaQueryWrapper);
        }
        return mDataEntityPage;
    }

    @Override
    public MDataEntity getMusic(Integer id) {
        return mDataMapper.selectById(id);
    }
}
