package com.hxy.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 韩磊
 * @version V1.0
 * @date 2018-11-07 16:06
 **/
@Slf4j
@Component
public class MyFilter extends ZuulFilter {
    /**
     *  filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *  pre：路由之前
     *  routing：路由之时
     *  post： 路由之后
     *  error：发送错误调用
     *
     * @author 韩磊
     * @date 2018/11/7 16:16
     * @param
     * @return java.lang.String
     */
    @Override
    public String filterType() {
        //pre：路由之前
        return "pre";
    }

    /**
     *  filterOrder：过滤的顺序
     *
     * @author 韩磊
     * @date 2018/11/7 16:16
     * @param
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *  shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     *
     * @author 韩磊
     * @date 2018/11/7 16:17
     * @param
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *  run：过滤器的具体逻辑。
     *  可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     *
     * @author 韩磊
     * @date 2018/11/7 16:17
     * @param
     * @return java.lang.Object
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
