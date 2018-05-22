
package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Baza;


@WebServlet(name = "brisanjeKorisnikaServlet", urlPatterns = {"/brisanjeKorisnikaServlet"})
public class brisanjeKorisnikaServlet extends HttpServlet {

   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nazivUsername = request.getParameter("nazivUsername");
        Baza.brisiKorisnikaPoUseru(nazivUsername);
        response.sendRedirect("igra.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    

}
