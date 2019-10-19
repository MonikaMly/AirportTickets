import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*")
//public class SecurityFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig)  {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String login = (String) req.getSession().getAttribute("login");
//        String requestUri = req.getRequestURI();
//
//        if (login != null || requestUri.endsWith("/login.html") || requestUri.endsWith("login") || requestUri.endsWith("register.html")
//                || requestUri.endsWith("register")){
//            filterChain.doFilter(req, resp);
//        } else {
//            resp.sendRedirect(resp.encodeRedirectURL("login.html"));
//        }
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
