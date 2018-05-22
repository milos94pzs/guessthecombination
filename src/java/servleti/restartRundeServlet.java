
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Baza;
import model.Korisnik;
import model.Igra;

@WebServlet(name = "restartRundeServlet", urlPatterns = {"/restartRundeServlet"})
public class restartRundeServlet extends HttpServlet {

    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession sesija = request.getSession();
        
        
        ArrayList<Korisnik>korisnici = Baza.korisnici;
        
        for(Korisnik k : korisnici){
            k.setPoeni(0);
            k.setPokusaji(1);
            k.setKombinacija("");
        }
        
        response.sendRedirect("igra.jsp");
        
        
        
        
        
    }
}
