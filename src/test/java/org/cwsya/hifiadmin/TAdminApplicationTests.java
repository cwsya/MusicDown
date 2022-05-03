package org.cwsya.hifiadmin;


import org.cwsya.hifiadmin.mapper.UserAllMapper;
import org.cwsya.hifiadmin.mapper.UserMapper;
import org.cwsya.hifiadmin.pojo.PO.UserEntity;
import org.cwsya.hifiadmin.service.AccessService;
import org.cwsya.hifiadmin.service.reptile.ReptileFactory;
import org.cwsya.hifiadmin.service.reptile.ReptileService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TAdminApplicationTests {

    @Autowired
    UserAllMapper userAllMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads(){
//        System.out.println(userMapper.selectList(null));
//        System.out.println(userAllMapper.selectUserAll(new UserEntity(null,"admin","admin",null)));
//        String s = ObjectMapperUtil.getIntstance().writeValueAsString(userAllMapper.selectUserAll(new UserEntity(null, "admin", "admin", null)));
//        System.out.println(s);
//        UserAllEntity allMapper = ObjectMapperUtil.getIntstance().readValue(s, UserAllEntity.class);
//        System.out.println(allMapper);
//        Page<UserEntity> userEntityPage = new Page<>();
//        userEntityPage.setSize(1).setSize(2);
//        userMapper.selectPage(userEntityPage,null);
//        System.out.println(userEntityPage.getRecords());
//        userMapper.insert(new UserEntity(null,"cws","cws",null,null,null));
        userMapper.insert(new UserEntity(null,"1","1",null,null,null));
    }

    @Autowired
    private AccessService accessService;
    @Test
    public void ceshi(){
//        accessService.addAccess(new AccessEntity(null,"aaa",null,null,null));
        accessService.stopAccess(6);
        accessService.startAccess(6);
        accessService.getAccess(6,1);
    }

    @Test
    public void tttt(){
        ReptileService hifini = ReptileFactory.create("hifini");
        String data = hifini.getData("5926");
        System.out.println(data);
    }
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void logTest(){
        //日志级别 由低到高
        logger.trace("trace 级别日志");
        logger.debug("debug 级别日志");
        logger.info("info 级别日志");
        logger.warn("warn 级别日志");
        logger.error("error 级别日志");
    }


}
