package com.wyh.zuul.filter;

import com.netflix.zuul.IZuulFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 类名称: PreZuulFilter
 * 类描述: 网关过滤器
 * 创建信息: 王银鹤/ 2020/12/1 10:31/ 1.0
 * 修改信息：王银鹤/ 2020/12/1 10:31/ 1.0
 */



@Component
@Slf4j
public class PreZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("Remote host:{},method:{},uri:{}", host, method, uri);
        return null;
    }
}
