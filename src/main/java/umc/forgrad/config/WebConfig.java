package umc.forgrad.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import umc.forgrad.interceptor.LoggingInterceptor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final HttpSessionInterceptor httpSessionInterceptor;
    private final LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpSessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");

        registry.addInterceptor(loggingInterceptor);
    }

}
