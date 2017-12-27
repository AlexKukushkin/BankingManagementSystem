package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Client Filter");

        String role = (String) ((HttpServletRequest)request)
                .getSession().getAttribute("role");

        if("client".equals(role)){
            chain.doFilter(request, response);
        }else{
            ((HttpServletResponse)response).sendRedirect("/web");
        }
    }

    @Override
    public void destroy() {

    }
}
