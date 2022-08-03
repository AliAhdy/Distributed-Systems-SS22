package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/options")
public class Options extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        //Prints text data to output stream
        PrintWriter out = response.getWriter();

        out.println("<title> Conference </title>" +
                "<h3> Option Panel </h3>" +
                "<p> Choose a option! </p>" +
                "<form action = \"search\" method=\"POST\">\n" +
                "<input type=\"submit\" value=\"Search for a participant\" /> \n </form>" +

                "<form action=\"addPar\" method=\"POST\">\n" +
                "<input type=\"submit\" value=\"Add a new participant\"/> \n </form>" +

                "<form action = \"show\" method=\"POST\"> \n" +
                "<input type=\"submit\" value=\"Show all Participants\"/> </form>" +

                "<form action=\"changeCom\" method=\"POST\"> \n" +
                "<input type=\"submit\" value=\"Change the Company\" /> </form>"
        );
    }
}

