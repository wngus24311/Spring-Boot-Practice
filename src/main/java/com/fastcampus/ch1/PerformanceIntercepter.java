package com.fastcampus.ch1;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PerformanceIntercepter implements HandlerInterceptor {
//    long startTime;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 전처리 작업
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        // handler - 요청하고 연결된 컨트롤러의 메서드
        HandlerMethod method = (HandlerMethod) handler;
        System.out.println("method.getMethod() = " + method.getMethod());
        System.out.println("method.getBean() = " + method.getBean());

        // return true; 다음 인터셉터나 컨트롤러를 호출 false면 호출안함.
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long startTime = (long)request.getAttribute("startTime");
        // 2. 후처리 작업
        long endTime = System.currentTimeMillis();
        System.out.print("[" + request.getRequestURI() + "]");
        System.out.println("time => " + (endTime - startTime));
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
