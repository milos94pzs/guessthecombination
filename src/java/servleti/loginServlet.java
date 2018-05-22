
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
import model.Korisnik;


@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession sesija = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean flag = Baza.proveraKorisnika(username, password);
        
        if(flag){
            ArrayList<Korisnik>korisnici = Baza.korisnici;
            ArrayList<Korisnik>adminIKomisija = Baza.adminIKomisija;
            Korisnik ulogovani = Baza.vratiKorisnikaPoUseru(username);
            
            sesija.setAttribute("adminIKomisija", adminIKomisija);
            sesija.setAttribute("korisnici", korisnici);
            sesija.setAttribute("ulogovani", ulogovani);
            response.sendRedirect("igra.jsp");
        }
        else{
            response.sendRedirect("index.html");
        }
        
    }

    

}
