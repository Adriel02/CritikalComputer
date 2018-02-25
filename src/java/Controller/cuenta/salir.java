/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cuenta;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adriel
 */
public class salir extends Controller.controller{

    @Override
    public void process() {
        HttpSession session = request.getSession();
        if(session.getAttribute("Usuario")!=null){
            session.invalidate();
        }
        try {
            redirect("/index.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(salir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(salir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
