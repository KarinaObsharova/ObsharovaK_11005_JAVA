package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.models.User;
import ru.itis.repositories.AccountsRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private AccountsRepository accountsRepository;

        @Override
        public void init(ServletConfig servletConfig) {
            ServletContext servletContext = servletConfig.getServletContext();
            ApplicationContext context = (ApplicationContext) servletContext.getAttribute("springContext");
            this.accountsRepository = context.getBean(AccountsRepository.class);
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/registration.jsp").forward(request, response);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("psw");
        accountsRepository.save(new User(firstName,lastName,login,password));

    }
}
