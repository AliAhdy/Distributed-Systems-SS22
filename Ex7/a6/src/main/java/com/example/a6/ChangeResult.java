package com.example.a6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.a6.Main.conference;


@WebServlet("/changed")
public class ChangeResult extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String newCompany = request.getParameter("newCompany");

        Participant participant = conference.searchP(name);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (participant != null){
            String oldComp = participant.getCompany();
            participant.setCompany(newCompany);

            out.println(
                    "<title>Change</title>\n" +
                            "<h3> Company change successful </h3>" +
                            "<p> Company of " + name +
                            " was changed from " + oldComp +
                            " to " + newCompany + "</p>\n\n" +

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
        else {
            out.println(
                    "<title>Change</title>\n" +
                            "<h3> Error! </h3>" +
                            "<p> No Such Participant in the Company </p>" +

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
}

