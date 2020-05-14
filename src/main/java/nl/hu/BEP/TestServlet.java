package nl.hu.BEP;

import nl.hu.IPASS.model.Factuur;

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
        String nummer = req.getParameter("nummer");
        String logs = req.getParameter("logs");

        PrintWriter pw = new PrintWriter(resp.getWriter());
        if(nummer!=null){
            Factuur factuur = Factuur.deFactuur;

            if ("true".equals(logs)){
                pw.println(factuur.getFactuurNummer());

            }else{
                pw.println("Nummer: " + factuur.getFactuurDatum());

            }
        }else{
            pw.println(Factuur.deFactuur);
        }
    }
}
