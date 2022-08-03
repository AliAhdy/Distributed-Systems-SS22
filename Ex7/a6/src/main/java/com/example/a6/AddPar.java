package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addPar")
public class AddPar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body>\n" +
                "\n" +
                "<h2> Add a new Participant! </h2>\n" +
                "<title> Add a new Participant! </title>\n" +
                "<form action = \"added\" method = \"POST\" >\n" + //Redirect to servlet added

                "<label for=\"name\">Name:</label><br>\n" +
                "<input type=\"text\" name=\"name\"> <br>\n" +

                "<label for=\"country\">Country:</label><br>\n" +
                "<input type=\"text\" name=\"country\"> <br>\n" +

                "<label for=\"company\">Company:</label><br>\n" +
                "<input type=\"text\" name=\"company\"> <br>\n" +

                "<input type=\"submit\" value=\"Add the Participant\">\n" +
                "</form>\n" +
                "</body>"
        );
    }
}
