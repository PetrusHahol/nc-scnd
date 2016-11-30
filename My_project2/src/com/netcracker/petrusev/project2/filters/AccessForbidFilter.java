package com.netcracker.petrusev.project2.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class AccessForbidFilter implements Filter {
    private String indexPath;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        indexPath = filterConfig.getInitParameter("INDEX_PATH");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println(request.getContextPath());
        response.sendRedirect("file://$MODULE_DIR$/web/index.jsp");//refactor
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
