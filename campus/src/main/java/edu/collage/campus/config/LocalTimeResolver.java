package edu.collage.campus.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalTime;
import java.util.Objects;

public class LocalTimeResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(LocalTime.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String timeString = webRequest.getParameter(Objects.requireNonNull(parameter.getParameterName()));
        // 在这里根据实际情况进行 LocalTime 的解析，这里假设时间格式为 "HH:mm:ss"
        assert timeString != null;
        return LocalTime.parse(timeString);
    }
}
