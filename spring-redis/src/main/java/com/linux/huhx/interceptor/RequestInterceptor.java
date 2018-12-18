package com.linux.huhx.interceptor;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    HttpServletRequest req = new ContentCachingRequestWrapper(request);
    Map<String, String[]> parameterMap = req.getParameterMap();

    log.info("request = : " + parameterMap.toString());
    log.info("request parameter length = : " + parameterMap.size());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper(response);
    byte[] bytes = resp.getContentAsByteArray();
    log.info("response = : " + new String(bytes, resp.getCharacterEncoding()));
  }
}
