package com.radio.videogamescriticism.config;

import com.radio.videogamescriticism.controller.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/gra", "/setting");
                 /*.excludePathPatterns("/css/**","/js/**","/images/**")
                .excludePathPatterns("/1","/2","/3","/4","/5","/6","/7")
                .excludePathPatterns("/usercheck","/regcheck")
                .excludePathPatterns("/getCom")
                .excludePathPatterns("/","/getAllGame")
                .excludePathPatterns("/login");*/
    }
}
