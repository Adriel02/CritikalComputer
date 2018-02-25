/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AccionesCarrito;

/**
 *
 * @author Adriel
 */
import Model.Carrito;
import Model.Producto;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class AddProduct extends Controller.controller{

    @Override
    public void process() {
       Producto producto = new Producto();
       producto.setNombre(request.getParameter("nombre"));
       producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
       producto.setDescripcion(request.getParameter("descripcion"));
       
        Carrito carrito = (Carrito) request.getSession().getAttribute("Carrito");  //devuelve un obj y tiene que ponerlo tipo carrito.
        
        HashMap<Producto,Integer> carro=carrito.getCarrito();
        Producto encontrado= null;
        for (Producto p : carro.keySet()) {
            if(p.getNombre().equals(producto.getNombre()))
                encontrado=p;
        }
        if(encontrado==null)
            carro.put(producto, 1);
        else
            carro.put(encontrado, carro.get(encontrado)+1);
        
        carrito.setCarrito(carro);
        request.getSession().setAttribute("Carrito", carrito);
        try {
            redirect("/Tienda.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
