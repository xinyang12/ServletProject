package com.xinyang.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by car on 2016/12/7.
 */
public class CountFilter implements Filter {
    private int count;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ++count;
        HttpServletRequest request = (HttpServletRequest) req;
        ServletContext context = request.getSession().getServletContext();
        context.setAttribute("count", count);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String param = config.getInitParameter("count");
        count = Integer.valueOf(param);
    }

}
