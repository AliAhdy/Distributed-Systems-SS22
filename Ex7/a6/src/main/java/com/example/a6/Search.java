package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search")
public class Search extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<body>\n" +
                        "\n" +
                        "<h2>Search Participant</h2>\n" +
                        "<title>Search</title>\n" +
                        "<form action=\"searchResult\" method = \"POST\">\n" +
                        "<label for=\"name\">Name:</label><br>\n" +
                        "<input type=\"text\" name=\"name\"><br>\n" +
                        "<input type=\"submit\" value=\"Search\">\n" +
                        "</body>"
        );
    }
}
