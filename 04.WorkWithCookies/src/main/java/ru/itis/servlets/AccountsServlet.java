package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.config.ApplicationConfig;
import ru.itis.models.User;
import ru.itis.repositories.AccountsRepository;
import ru.itis.repositories.AccountsRepositoryJdbcImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/accounts")
public class AccountsServlet extends HttpServlet {

    private AccountsRepository accountsRepository;

    @Override
    public void init(ServletConfig servletConfig) {
        ServletContext servletContext = servletConfig.getServletContext();
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute("springContext");
        this.accountsRepository = context.getBean(AccountsRepository.class);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = accountsRepository.findAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/jsp/accounts.jsp").forward(request, response);
    }
}
