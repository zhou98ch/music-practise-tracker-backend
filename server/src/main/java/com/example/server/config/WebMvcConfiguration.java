package com.example.server.config;

import com.example.server.interceptor.JwtTokenInterceptor;
import json.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * register certain web-related components
 */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtTokenInterceptor jwtTokenInterceptor;

    @Value("${app.security.jwt.enabled:true}")
    private boolean jwtEnabled;

    /**
     * register custom interceptors
     *
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("adding my interceptor...");
        if (jwtEnabled) {
            registry.addInterceptor(jwtTokenInterceptor)
                    .addPathPatterns("/api/user/**")
                    .excludePathPatterns("/api/user/create")
                    .excludePathPatterns("/api/user/login");
        }
    // TODO which controller should also add interceptor?
    }

    /**
     * extemd spring MVC‘s message converter (e.g. date time)
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("extending MessageC onverters....");
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new JacksonObjectMapper());
        converters.add(0,converter);
    }
}
