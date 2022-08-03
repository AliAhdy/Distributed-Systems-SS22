package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import static com.example.a6.Main.conference;

@WebServlet("/show")
public class Show extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<title> Show all Participants</title>" +
                "<h2>Show all Participants</h2>"
        );

        Set<Participant> participants = conference.getParSet();
        for (Participant par : participants){
            out.println("Name: " + par.getName() + "<br>\n" +
                        "Country: " + par.getCountry() + "<br>\n" +
                        "Company: " + par.getCompany() + "<br>\n"
            );
        }
        out.println("<form action = \"search\" method=\"POST\">\n" +
                "<input type=\"submit\" value=\"Search for a participant\" /> \n </form>" +

                "<form action=\"addPar\" method=\"POST\">\n" +
                "<input type=\"submit\" value=\"Add a new participant\"/> \n </form>" +

                "<form action = \"show\" method=\"POST\"> \n" +
                "<input type=\"submit\" value=\"Show all Participants\"/> </form>" +

                "<form action=\"changeCom\" method=\"POST\"> \n" +
                "<input type=\"submit\" value=\"Change the Company\" /> </form>");
    }
}
