package org.cwsya.hifiadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.exception.ParameterException;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;

/**
 * @author cws
 * 用户相关操作
 */
public interface UserService {
    /**
     * 添加用户
     * @param user 用户信息
     * @return 是否成功
     *
     */
    boolean addUser(UserEntity user);


    /**
     * 更新用户
     * @param user 用户
     * @return 是否成功
     * @throws ParameterException 参数异常
     */
    boolean upUser(UserEntity user) throws ParameterException;

    /**
     * 停用用户
     * @param id 用户id
     * @return 是否成功
     */
    boolean stopUser(Integer id);
    /**
     * 启用用户
     * @param id 用户id
     * @return 是否成功
     */
    boolean startUser(Integer id);

    /**
     * 查用户
     * @param current 页数
     * @param size 数量
     * @param name 查询信息(可以为空)
     * @return 信息
     *
     */
    Page<UserEntity> getUser(Integer current,Integer size,String name);



}
