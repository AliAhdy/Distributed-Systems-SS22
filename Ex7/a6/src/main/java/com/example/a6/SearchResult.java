package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.a6.Main.conference;

@WebServlet("/searchResult")
public class SearchResult extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        Participant participant = conference.searchP(name);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(
                "<body>\n" +
                        "\n" +
                        "<h2>Search Result</h2>\n" +
                        "<title>Search</title>\n" +
                        "<label for=\"name\">Name: " + participant.getName() + "</label><br>\n" +
                        "<label for=\"country\">Country: " + participant.getCountry() + "</label><br>\n" +
                        "<label for=\"company\">Company: " + participant.getCompany() + "</label><br>\n" +

                        "<form action = \"start\" method=\"POST\">\n" +
                        "<input type=\"submit\" value=\"Back to Main page\" /> \n </form>" +

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
