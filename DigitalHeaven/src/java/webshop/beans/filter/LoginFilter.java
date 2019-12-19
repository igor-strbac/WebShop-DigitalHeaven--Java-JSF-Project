package webshop.beans.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webshop.beans.LoginManagedBean;

/**
 *
 * @author Igor Strbac <mail@igorstrbac.com>
 */
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LoginManagedBean loginBean = (LoginManagedBean) ((HttpServletRequest) request).getSession().getAttribute("loginMB");
        String loginURL = ((HttpServletRequest) request).getContextPath() + "/faces/login.xhtml";
        String pageRequested = ((HttpServletRequest) request).getRequestURL().toString();

        if (loginBean == null || (loginBean.getLoggedInUser() == null)) {
            ((HttpServletResponse) response).sendRedirect(loginURL);
        }

        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
