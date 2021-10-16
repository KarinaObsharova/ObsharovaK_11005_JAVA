package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.services.SignInService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
     private SignInService signInService;

    @Override
    public void init(ServletConfig servletConfig) {
        ServletContext servletContext = servletConfig.getServletContext();
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute("springContext");
        this.signInService = context.getBean(SignInService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/signIn.jsp").forward(request, response);
        String login = request.getParameter("login");
        String password = request.getParameter("psw");
        if(signInService.singIn(login,password)){
            /*request.getRequestDispatcher("/jsp/accounts.jsp").forward(request,response);*/
            response.sendRedirect("/jsp/accounts.jsp");
        }

    }
}
