package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//Servlet: arbeitet mit dem Daten vom HTTP request
//HttpServletRequest: nimmt die daten die wir vom Server bekommen entgegen
//HttpServletResponse: Auf den request wird eine Antwort gesendet
@WebServlet("/Main")
public class Main extends HttpServlet {

    public static Conference conference = new Conference("conference1");


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();//getWriter:antwort an den webbrowser

        /*out.println(
                "<h3>Start the Process</h3>" +
                        "<form action=\"options\" method=\"POST\">\n" +
                        "<input type=\"submit\" value=\"Start the Process\"/> \n </form>");
                response.setContentType("text/html");*/
        //Prints text data to output stream

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
