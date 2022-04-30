package org.cwsya.hifiadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author cws
 */
@SpringBootApplication
@MapperScan("org.cwsya.hifiadmin.mapper")
@EnableAspectJAutoProxy
public class TAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TAdminApplication.class, args);
    }

}
