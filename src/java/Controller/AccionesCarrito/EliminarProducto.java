/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesCarrito;

import Model.Carrito;
import Model.Producto;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Adriel
 */
public class EliminarProducto extends Controller.controller {

    @Override
    public void process() {
        String nombreProducto = request.getParameter("Producto");
        System.out.println(nombreProducto);
        Carrito carrito = (Carrito) request.getSession().getAttribute("Carrito");  //devuelve un obj y tiene que ponerlo tipo carrito.

        HashMap<Producto, Integer> carro = carrito.getCarrito();
        Producto encontrado = null;
        for (Producto p : carro.keySet()) {
            if (p.getNombre().equals(nombreProducto)) {
                encontrado = p;
            }
        }
        carro.put(encontrado, carro.get(encontrado) - 1);
        if(carro.get(encontrado)==0)
            carro.remove(encontrado);
            
        carrito.setCarrito(carro);
        request.getSession().setAttribute("Carrito", carrito);
        try {
            redirect("/Carrito.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
