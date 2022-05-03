package org.cwsya.hifiadmin.service.reptile;

import cn.hutool.core.util.StrUtil;
import org.cwsya.hifiadmin.mapper.MDataMapper;
import org.cwsya.hifiadmin.pojo.PO.MDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncData {


    private final MDataMapper mDataMapper;

    public AsyncData(MDataMapper mDataMapper) {
        this.mDataMapper = mDataMapper;
    }

    @Async("msgThreadPool")
    public void reptileData(MDataEntity mDataEntity){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (mDataEntity.getUsable()!=1){
            String data = ReptileFactory.create(mDataEntity.getSource()).getData(mDataEntity.getUrl());
            if (!StrUtil.isBlankIfStr(data)) {
                mDataMapper.updateById(new MDataEntity(mDataEntity.getId(),null,null,null,1,data));
            }
        }
    }
}
