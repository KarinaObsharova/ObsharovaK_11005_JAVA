package ru.itis.servlets;

import ru.itis.CountingWords;
import ru.itis.MyFileReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/file")
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("path");
        CountingWords countingWords = new CountingWords(new MyFileReader(fileName));
        String responseHtml = "<h1> Количетво слов в тексте: " + countingWords.count() + "</h1>";
        response.setContentType("text/html");

        response.getWriter().println(responseHtml);

    }
}
