package org.cwsya.hifiadmin.controller.userController;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.exception.ParameterException;
import org.cwsya.hifiadmin.pojo.PO.UserRoleEntity;
import org.cwsya.hifiadmin.pojo.Result;
import org.cwsya.hifiadmin.pojo.ResultCodeEnum;
import org.cwsya.hifiadmin.pojo.VO.RoleUserEntity;
import org.cwsya.hifiadmin.service.UserRoleService;
import org.cwsya.hifiadmin.util.BeanCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Struct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户角色对应接口
 * @author cws
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @SaCheckRole("admin")
    @PostMapping("/addUserRole")
    public Result<?> addUserRole(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer uid = jsonObject.getInt("uid");
        Integer rid = jsonObject.getInt("rid");
        if (StrUtil.isBlankIfStr(uid)||StrUtil.isBlankIfStr(rid)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userRoleService.addUserRole(new UserRoleEntity(null,uid,rid,null)));
    }
    @SaCheckRole("admin")
    @PostMapping("/delUserRole")
    public Result<?> delUserRole(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id = jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userRoleService.delUserRole(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/getUserRole")
    public Result<?> getUserRole(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        Integer userid=jsonObject.getInt("userid");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)||StrUtil.isBlankIfStr(userid)){
            throw new ParameterException();
        }
        Page<UserRoleEntity> role = userRoleService.getUserRole(current,size,userid);
        List<org.cwsya.hifiadmin.pojo.VO.UserRoleEntity> list = BeanCopyUtils.copyBeanList(role.getRecords(), org.cwsya.hifiadmin.pojo.VO.UserRoleEntity.class);

        Map<String,Object> map=new HashMap<>(size);
        map.put("userRole",list);
        map.put("page",role.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
    @SaCheckRole("admin")
    @PostMapping("/getRoleUser")
    public Result<?> getRoleUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        Integer roleid=jsonObject.getInt("roleid");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)||StrUtil.isBlankIfStr(roleid)){
            throw new ParameterException();
        }
        Page<UserRoleEntity> role = userRoleService.getRoleUser(current,size,roleid);
        List<RoleUserEntity> list = BeanCopyUtils.copyBeanList(role.getRecords(), RoleUserEntity.class);

        Map<String,Object> map=new HashMap<>(size);
        map.put("userRole",list);
        map.put("page",role.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }


}
