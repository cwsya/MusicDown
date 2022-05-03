package org.cwsya.hifiadmin.controller.musicController;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.hifiadmin.exception.ParameterException;
import org.cwsya.hifiadmin.pojo.PO.MDataEntity;
import org.cwsya.hifiadmin.pojo.Result;
import org.cwsya.hifiadmin.pojo.ResultCodeEnum;
import org.cwsya.hifiadmin.pojo.VO.MDataPageEntity;
import org.cwsya.hifiadmin.service.MusicService;
import org.cwsya.hifiadmin.service.reptile.ReptileFactory;
import org.cwsya.hifiadmin.util.BeanCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 音乐相关接口
 * @author cws
 */
@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }
    @SaCheckRole("admin")
    @PostMapping("/addMusic")
    public Result<?> addMusic(@RequestBody JSONObject jsonObject) throws ParameterException {
        String musicName =jsonObject.getStr("musicName");
        String url = jsonObject.getStr("url");
        String source = jsonObject.getStr("source");
        if (StrUtil.isBlankIfStr(musicName)||StrUtil.isBlankIfStr(url)||StrUtil.isBlankIfStr(source)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),musicService.addMusic(new MDataEntity(null,musicName,url,source,null,null)));
    }
    @SaCheckRole("admin")
    @PostMapping("/delMusic")
    public Result<?> delUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id = jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),musicService.delMusic(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/upMusicData")
    public Result<?> upUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id = jsonObject.getInt("id");
        String data = jsonObject.getStr("data");
        if (StrUtil.isBlankIfStr(id)||StrUtil.isBlankIfStr(data)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),musicService.upMusic(new MDataEntity(id,null,null,null,1,data)));
    }
    @PostMapping("/getMusic")
    public Result<?> getMusic(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        String name = jsonObject.getStr("name");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)){
            throw new ParameterException();
        }
        Page<MDataEntity> music = musicService.getMusic(current, size, name);
        List<MDataPageEntity> list = BeanCopyUtils.copyBeanList(music.getRecords(), MDataPageEntity.class);
        Map<String,Object> map=new HashMap<>(2);
        map.put("music",list);
        map.put("page",music.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
    @PostMapping("/getMusicData")
    public Result<?> getMusicData(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id = jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        MDataEntity music = musicService.getMusic(id);
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),new org.cwsya.hifiadmin.pojo.VO.MDataEntity(music.getId(),music.getName(), music.getData()));
    }

    @SaCheckRole("admin")
    @PostMapping("/upCookie")
    public Result<?> upCookie(@RequestBody JSONObject jsonObject) throws ParameterException {
        String cookie = jsonObject.getStr("cookie");
        String name = jsonObject.getStr("name");
        if (StrUtil.isBlankIfStr(cookie)||StrUtil.isBlankIfStr(name)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),ReptileFactory.create(name).setCookie(cookie));
    }


}
