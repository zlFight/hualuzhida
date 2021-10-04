package zhida.business.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zhida.business.config.filter.*;
@Slf4j
@Configuration
public class AdminConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //先注册，再配置拦截路径
        //注册TestInterceptor拦截器
        registry.addInterceptor(new CrossInterceptor()).addPathPatterns("/**");
        log.info("CrossInterceptor拦截器注册成功！");

        registry.addInterceptor(new OptionsInterceptor()).addPathPatterns("/**");
        log.info("Options请求拦截器注册成功！");

        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/temp/login","/userManage/insert","/error","/userManage/checkNameExist");
        log.info("鉴权拦截器注册成功！");
    }
}
