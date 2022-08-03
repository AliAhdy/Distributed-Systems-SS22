package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changeCom")
public class Change extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<title>Change</title>\n" +
                        "<form action=\"changed\" method=\"POST\">\n" +
                        "<label for=\"name\">Name:</label><br>\n" +
                        "<input type=\"text\" name=\"name\"><br>\n" +

                        "  <label for=\"newCompany\">New Company:</label><br>\n" +
                        "  <input type=\"text\" name=\"newCompany\" ><br>\n" +

                        "  <input type=\"submit\" value=\"Change\">\n" +
                        "</body>"
        );
    }
}
