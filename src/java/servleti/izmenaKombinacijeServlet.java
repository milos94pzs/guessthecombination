
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Baza;
import model.Igra;
import model.Korisnik;


@WebServlet(name = "izmenaKombinacijeServlet", urlPatterns = {"/izmenaKombinacijeServlet"})
public class izmenaKombinacijeServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesija = request.getSession();
        
        String k1 = request.getParameter("k1nova");
        String k2 = request.getParameter("k2nova");
        String k3 = request.getParameter("k3nova");
        String k4 = request.getParameter("k4nova");
        
        Igra.setKombinacija1(k1);
        Igra.setKombinacija2(k2);
        Igra.setKombinacija3(k3);
        Igra.setKombinacija4(k4);
        
        
        ArrayList<Korisnik>korisnici = Baza.korisnici;
        /*
        for(Korisnik k : korisnici){
            k.setPoeni(0);
            k.setPokusaji(1);
            k.setKombinacija("");
        }
        */
        
        response.sendRedirect("izmenaKombinacije.jsp");
        
    }

    

}
