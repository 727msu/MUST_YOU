package edu.collage.campus.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class LocalDateResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(LocalDate.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String timeString = webRequest.getParameter(Objects.requireNonNull(parameter.getParameterName()));
        // 在这里根据实际情况进行 LocalDate 的解析，这里假设日期格式为 "1920:1:1"
        assert timeString != null;
        return LocalDate.parse(timeString);
    }
}
