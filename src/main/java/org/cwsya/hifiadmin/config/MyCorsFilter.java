package org.cwsya.hifiadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author cws
 * 跨域配置
 */
@Configuration
public class MyCorsFilter {
    private CorsConfiguration corsConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 设置允许的header属性
        corsConfiguration.addAllowedHeader("*");
        // 设置允许的请求方式
        corsConfiguration.addAllowedMethod("*");
        // 设置允许跨域请求的域名
        corsConfiguration.addAllowedOriginPattern("*");
        // 跨域允许时间
        corsConfiguration.setMaxAge(3600L);
        // 是否允许cookie
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfig());
        return new CorsFilter(source);
    }
}