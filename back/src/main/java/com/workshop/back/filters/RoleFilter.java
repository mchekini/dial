package com.workshop.back.filters;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

@Component
@Slf4j
public class RoleFilter implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String userRole = "VIEWER";
        Method method = ((HandlerMethod) handler).getMethod();
        final RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);

        HashSet roles = new HashSet<>(Arrays.asList(rolesAllowed.value()));

        if (roles.contains(userRole)) return true;
        response.setStatus(403);
        return false;
    }
}
