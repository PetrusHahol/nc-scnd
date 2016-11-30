package com.netcracker.petrusev.project2.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
@WebFilter( urlPatterns = { "/*" })
public class UTFCodeFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("cp1251");
        chain.doFilter(req, resp);
    }
    @Override
    public void destroy() {

    }
}
