package org.cwsya.hifiadmin.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cws
 * web配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Sa-Token 权限拦截器
        registry.addInterceptor(new SaRouteInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/isLogin",
                                "/login",
                                "/music/getMusic",
                                "/music/getMusicData");
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }
}
