package nl.hu.IPASS;

import nl.hu.IPASS.model.Factuur;
import nl.hu.IPASS.model.Gebruiker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/show")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = new PrintWriter(resp.getWriter());
        Factuur factuur = Factuur.deFactuur;
    }
}
