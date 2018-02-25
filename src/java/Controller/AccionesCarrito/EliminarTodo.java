/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesCarrito;

import Model.Carrito;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Adriel
 */
public class EliminarTodo extends Controller.controller {

    @Override
    public void process() {
        request.getSession().setAttribute("Carrito",new Carrito());
        try {
            redirect("/Carrito.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(EliminarTodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EliminarTodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
