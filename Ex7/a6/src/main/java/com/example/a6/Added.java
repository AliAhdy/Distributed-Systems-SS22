package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.a6.Main.conference;


@WebServlet("/added")
public class Added extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ParName = request.getParameter("name");
        String ParCountry = request.getParameter("country");
        String ParCompany = request.getParameter("company");

        conference.addPar(ParName, ParCountry, ParCompany);

        PrintWriter out = response.getWriter();
        out.println("<body>\n" +
                "\n" +
                "<h2>Add new Participant to the conference</h2>\n" +
                "<title>Participant added</title>\n" +
                "<form action=\"added\" method=\"POST\">\n" +
                "<p>Participant has been added to the conference</p>\n" +

                "<p>Name: " + ParName + "</label><br>\n" +

                "<p>Country: " + ParCountry + "</label><br>\n" +

                "<p>Company: " + ParCompany + "</label><br>\n" +

                "</form>\n" +

                        "<form action = \"search\" method=\"POST\">\n" +
                        "<input type=\"submit\" value=\"Search for a participant\" /> \n </form>" +

                        "<form action=\"addPar\" method=\"POST\">\n" +
                        "<input type=\"submit\" value=\"Add a new participant\"/> \n </form>" +

                        "<form action = \"show\" method=\"POST\"> \n" +
                        "<input type=\"submit\" value=\"Show all Participants\"/> </form>" +

                        "<form action=\"changeCom\" method=\"POST\"> \n" +
                        "<input type=\"submit\" value=\"Change the Company\" /> </form>" +

                "</body>"
        );
    }
}

