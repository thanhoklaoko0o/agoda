package com.gcs.springex.config;

import com.gcs.springex.base.annotations.ApiAuthen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class JwtTokenFilter implements OncePerRequestFilter {

  @Autowired
  private RequestMappingHandlerMapping mapping;

  HandlerMethod getHandle(HttpServletRequest request) throws Exception {
    HandlerExecutionChain handlerExeChain = mapping.getHandler(request);
    if (Objects.nonNull(handlerExeChain)) {
      return (HandlerMethod) handlerExeChain.getHandler();
    }
    return null;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
      HandlerMethod handlerMethod = getHandle(request);
      if(handlerMethod == null){
        //TODO throw request not found
      }
      Boolean apiAuthen = handlerMethod.hasMethodAnnotation(ApiAuthen.class);
      //Nếu cái mapping nào mà ko config ApiAuthen annotion => public api
      if (apiAuthen == false || handlerMethod.getMethodAnnotation(ApiAuthen.class).isPublic()) {
        filterChain.doFilter(request, response);
        return;
      }

      String token = request.getHeader("token");
      //TODO parse token
      // => role
      String role = "";// guest
      String[] roles = handlerMethod.getMethodAnnotation(ApiAuthen.class).roles();
      for (String x : roles){
        if(x.equals(role)){
          filterChain.doFilter(request, response);
          return;
        }
      }

      response.getWriter().write("403");
      //
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
