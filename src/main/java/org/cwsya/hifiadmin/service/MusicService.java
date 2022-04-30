package org.cwsya.hifiadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.pojo.PO.MDataEntity;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;

/**
 * 音乐相关操作
 * @author cws
 */
public interface MusicService {
    /**
     * 添加音乐
     * @param mDataEntity 音乐数据
     * @return 是否成功
     */
    boolean addMusic(MDataEntity mDataEntity);


    /**
     * 删除音乐
     * @param id 音乐id
     * @return 是否成功
     */
    boolean delMusic(Integer id);


    /**
     * 更新音乐数据
     * @param mDataEntity 音乐数据
     * @return 是否成功
     */
    boolean upMusic(MDataEntity mDataEntity);

    /**
     * 分页查询
     * @param current 页数
     * @param size 单页个数
     * @param name 查询信息(可以为空)
     * @return 信息
     */
    Page<MDataEntity> getMusic(Integer current, Integer size, String name);

    /**
     * 获取单个歌曲信息
     * @param id 歌曲id
     * @return 歌曲信息
     */
    MDataEntity getMusic(Integer id);

}
