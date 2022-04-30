package org.cwsya.hifiadmin.controller.userController;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.exception.ParameterException;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;
import org.cwsya.hifiadmin.pojo.Result;
import org.cwsya.hifiadmin.pojo.ResultCodeEnum;
import org.cwsya.hifiadmin.service.UserService;
import org.cwsya.hifiadmin.util.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cws
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 注册用户
     * @param jsonObject 前端传来得数据 userName--用户名, passWord--密码
     * @return 统一返回值
     * @throws ParameterException 参数异常
     */
    @SaCheckRole("admin")
    @PostMapping("/addUser")
    public Result<?> addUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        String userName =jsonObject.getStr("userName");
        String passWord = jsonObject.getStr("passWord");
        if (StrUtil.isBlankIfStr(userName)||StrUtil.isBlankIfStr(passWord)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(), userService.addUser(new UserEntity(null,userName,passWord,null,null,null)));
    }

    /**
     * 修改账号密码
     * @param jsonObject 统一数据接受 id--用户id, passWord--要更改的密码
     * @return 统一返回值
     * @throws ParameterException 参数异常
     */
    @SaCheckRole("admin")
    @PostMapping("/upUserPassword")
    public Result<?> upUserPassword(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id = jsonObject.getInt("id");
        String passWord = jsonObject.getStr("passWord");

        if (StrUtil.isBlankIfStr(id)||StrUtil.isBlankIfStr(passWord)){
            throw new ParameterException();
        }
        UserEntity user = new UserEntity(id, null, passWord, null, null, null);
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userService.upUser(user));
    }

    /**
     * 停用用户将用户状态改为0
     * @param jsonObject 统一接受值 id--用户id
     * @return 统一返回值
     * @throws ParameterException 参数异常
     */
    @SaCheckRole("admin")
    @PostMapping("/stopUser")
    public Result<?> stopUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        int id = jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userService.stopUser(id));
    }

    /**
     * 启用用户
     * @param jsonObject 统一数据接受 id--用户id
     * @return 统一返回值
     * @throws ParameterException 参数异常
     */
    @SaCheckRole("admin")
    @PostMapping("/startUser")
    public Result<?> startUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        int id = jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userService.stopUser(id));
    }

    /**
     * 获取用户数据(分页)
     * @param jsonObject 统一数据接受 current--页数 size--单页数量 name--要查询的关键词(可为空)
     * @return 统一返回值
     * @throws ParameterException 参数异常
     */
    @SaCheckRole("admin")
    @PostMapping("/getUser")
    public Result<?> getUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        int current = jsonObject.getInt("current");
        int size = jsonObject.getInt("size");
        String name = jsonObject.getStr("name");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)){
            throw new ParameterException();
        }
        if (StrUtil.isBlankIfStr(name)){
            name=null;
        }
        Page<UserEntity> user = userService.getUser(current, size, name);
        List<org.cwsya.hifiadmin.pojo.VO.UserEntity> list = BeanCopyUtils.copyBeanList(user.getRecords(), org.cwsya.hifiadmin.pojo.VO.UserEntity.class);

        Map<String,Object> map=new HashMap<>(2);
        map.put("user",list);
        map.put("page",user.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
}
