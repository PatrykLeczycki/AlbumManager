package pl.coderslab.filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;
import pl.coderslab.model.LoggedUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/albums/*")
public class AuthenticationFilter extends GenericFilterBean implements Filter {

    private LoggedUser loggedUser;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if(null == loggedUser.getLogin()){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            loggedUser = webApplicationContext.getBean(LoggedUser.class);
            response.sendRedirect("/user/login");
        } else chain.doFilter(request, response);


        /*if (loggedUser == null) {
            System.out.println(loggedUser);
            response.sendRedirect("/user/login");
        } else chain.doFilter(request, response);*/
    }
}
/*

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {
    private MyServices service;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(service==null){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            service = webApplicationContext.getBean(MyServices.class);
        }
        your code ...
    }

}

 */