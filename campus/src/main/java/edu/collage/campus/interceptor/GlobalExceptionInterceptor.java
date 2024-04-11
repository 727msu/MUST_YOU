//package edu.collage.campus.interceptor;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//public class GlobalExceptionInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 在请求处理之前执行
//
//        return true; // 继续执行后续的拦截器和处理器
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // 请求处理之后执行，但是在视图被渲染之前
//
//        // 在这里进行全局异常处理
//        try {
//            // 这里执行你的业务逻辑
//        } catch (Exception e) {
//            // 发生异常时，返回自定义的错误消息和状态码
//            response.setStatus(HttpStatus.OK.value());
//            response.getWriter().write("An error occurred: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        // 在请求处理完成后执行，包括视图渲染完毕（如果有）
//    }
//}
