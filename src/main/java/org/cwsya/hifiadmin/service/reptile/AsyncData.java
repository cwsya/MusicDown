package org.cwsya.hifiadmin.service.reptile;

import cn.hutool.core.util.StrUtil;
import org.aspectj.weaver.ast.Or;
import org.cwsya.hifiadmin.mapper.MDataMapper;
import org.cwsya.hifiadmin.pojo.PO.MDataEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author cws
 */
@Service
public class AsyncData {

    private final RedisTemplate<String,String> redisTemplate;

    private final MDataMapper mDataMapper;
    private final String redisDataName="music:data:";

    public AsyncData(RedisTemplate<String, String> redisTemplate, MDataMapper mDataMapper) {
        this.redisTemplate = redisTemplate;
        this.mDataMapper = mDataMapper;
    }

    @Async("msgThreadPool")
    public void reptileData(MDataEntity mDataEntity){
        if (mDataEntity.getUsable()!=1){
            String key = redisDataName + mDataEntity.getSource() + ":" + mDataEntity.getUrl();
            if (!StrUtil.isBlankIfStr(redisTemplate.opsForValue().get(key))){
                System.out.println("已提交---->"+mDataEntity.getUrl());
                return;
            }
            redisTemplate.opsForValue().set(key,"1");
            try {
                String data = ReptileFactory.create(mDataEntity.getSource()).getData(mDataEntity.getUrl());
                if (!StrUtil.isBlankIfStr(data)) {
                    mDataMapper.updateById(new MDataEntity(mDataEntity.getId(),null,null,null,1,data));
                    redisTemplate.delete(key);
                }
            }finally {
                redisTemplate.delete(key);
            }
        }
    }
}
