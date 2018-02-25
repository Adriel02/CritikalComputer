<%-- 
    Document   : Carrito
    Created on : 22-feb-2018, 17:34:17
    Author     : Adriel
--%>

<%@page import="Model.Carrito"%>
<%@page import="Model.Producto"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Critikal Computer</title>
        <link rel="stylesheet" href="Recursos/cssTabla.css">
        <link rel="stylesheet" href="Recursos/FondoCss.css">
        <link rel="stylesheet" href="Recursos/newcss.css">
    </head>
    <body>
        <a href="/Tienda.jsp" href="#" class="myButton" id="izquierda">Tienda</a>
        <table>
            <tr>
                <th></th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>PrecioTotal</th>
                <th>Quitar Producto</th>
            </tr>
            <%
                Carrito carro = (Carrito) session.getAttribute("Carrito");
                for (Producto p : carro.getCarrito().keySet()) {%>
            <tr>
                <td id="stilo2" style="width: 20%;text-align: center;"><%= p.getNombre()%></td>
                <td><%=carro.getCarrito().get(p)%></td>
                <td><%= p.getPrecio()%>€</td>
                <td><%= p.getPrecio() * carro.getCarrito().get(p)%>€</td>
                <td><a href="/frontServlet?command=AccionesCarrito.EliminarProducto&Producto=<%=p.getNombre()%>" id="stilo1">Eliminar</a></td>
            </tr>
            <%}%>
        </table>
        <%if (carro.getCarrito().isEmpty() == false) {%>
        <a  href = "/frontServlet?command=AccionesCarrito.EliminarTodo" href = "#" class="myButton" id = "izquierda" > Vaciar Carrito</a >
        <%}%>
    </body>
</html>
