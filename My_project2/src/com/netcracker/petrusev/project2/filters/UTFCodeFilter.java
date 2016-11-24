package com.netcracker.petrusev.project2.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Asus on 24.11.2016.
 */

public class UTFCodeFilter implements Filter {
    private String initParamEncoding;

    @Override
    public void init(FilterConfig config) throws ServletException {
        initParamEncoding = config.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String requestEncoding = req.getCharacterEncoding();
        if (initParamEncoding != null && !initParamEncoding.equalsIgnoreCase(requestEncoding)) {
            req.setCharacterEncoding(initParamEncoding);
            resp.setCharacterEncoding(initParamEncoding);
        }
        resp.setContentType("UTF-8");
        chain.doFilter(req, resp);
    }
    @Override
    public void destroy() {

    }
}
