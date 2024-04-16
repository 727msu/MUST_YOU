package edu.collage.campus.config;

import edu.collage.campus.util.RestResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResult ExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("request URL = {}, 发生业务异常！原因是：{}", req.getContextPath(), e);
        return RestResult.exception("服务器内部错误");
    }
}
