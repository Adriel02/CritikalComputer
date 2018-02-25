/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.cuenta;

import Model.Carrito;
import Model.usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adriel
 */
public class Registro extends Controller.controller{

    @Override
    public void process() {
        HttpSession session= request.getSession(true);
        usuario user= new usuario();
        Carrito carrito = new Carrito();
        user.setNombre(request.getParameter("usuario"));
        user.setContraseña(request.getParameter("pass"));
        session.setAttribute("Usuario", user);
        session.setAttribute("Carrito", carrito);
        try {
            redirect("/Tienda.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
