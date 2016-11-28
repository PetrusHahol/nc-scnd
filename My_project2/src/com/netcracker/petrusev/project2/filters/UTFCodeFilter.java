package com.netcracker.petrusev.project2.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Asus on 24.11.2016.
 */
@WebFilter( urlPatterns = { "/*" })
public class UTFCodeFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("UTF-8");
        chain.doFilter(req, resp);
    }
    @Override
    public void destroy() {

    }
}
