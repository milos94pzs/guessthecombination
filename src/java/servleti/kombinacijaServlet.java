
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Baza;
import static model.Baza.korisnici;
import model.Igra;
import model.Korisnik;


@WebServlet(name = "kombinacijaServlet", urlPatterns = {"/kombinacijaServlet"})
public class kombinacijaServlet extends HttpServlet {

    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesija = request.getSession();
        
        String kombinacija1 = request.getParameter("kombinacija1");
        String kombinacija2 = request.getParameter("kombinacija2");
        String kombinacija3 = request.getParameter("kombinacija3");
        String kombinacija4 = request.getParameter("kombinacija4");
        
        String ispisKombinacije = kombinacija1 + " " + kombinacija2 + " " + 
                kombinacija3 + " " + kombinacija4;
        
        int poeni = Igra.proveraKombinacije(kombinacija1, kombinacija2, kombinacija3, kombinacija4);
        
        
            Korisnik ulogovani = (Korisnik) sesija.getAttribute("ulogovani");
            ulogovani.setPoeni(poeni);
            ulogovani.setPokusaji(0);
            ulogovani.setKombinacija(ispisKombinacije);
            
            
            
            Collections.sort(korisnici,new Comparator<Korisnik>(){
            
            public int compare(Korisnik k1, Korisnik k2){
                
                return Integer.valueOf(k2.getPoeni()).compareTo(k1.getPoeni());
            }
        });
            
            
        
        
        response.sendRedirect("igra.jsp");
        
    }

    

}
