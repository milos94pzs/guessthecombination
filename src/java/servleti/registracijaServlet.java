
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Baza;


@WebServlet(name = "registracijaServlet", urlPatterns = {"/registracijaServlet"})
public class registracijaServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        boolean provera = false; 
        
        if(password1.equals(password2)){
            boolean flag = Baza.kreiranjeKorisnika(username,password2,ime,prezime);
        if(flag){
            provera = true;
        }
        }
        
        if(provera){
            response.sendRedirect("index.html");
        }else{
            response.sendRedirect("error.html");
        }
        
        
        
    }

    

}
