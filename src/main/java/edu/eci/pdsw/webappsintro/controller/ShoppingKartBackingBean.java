/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.webappsintro.controller;

import edu.eci.pdsw.stubs.servicesfacadestub.Producto;
import edu.eci.pdsw.stubs.servicesfacadestub.ServicesFacade;
import java.util.LinkedList;
import javax.faces.event.ActionEvent;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author hcadavid
 */
@ManagedBean(name="carritoDeCompras")
@SessionScoped
public class ShoppingKartBackingBean {
    private int cant,total;
    private List<Total> cantidad;
    private Producto selectedProducto;

    public ShoppingKartBackingBean() {
        cantidad = new LinkedList<Total>();
        total=0;
        cant=0;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public List<Producto> getProductos(){
        return ServicesFacade.getInstance().getProductos();
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public List<Total> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<Total> cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }
    
    public void comprar(){
        //System.out.println("Entro "+cant+" "+selectedProducto.getNombre()+" "+selectedProducto.getId()+" "+selectedProducto.getPrecioEnPesos());
        cantidad.add(new Total(selectedProducto.getPrecioEnPesos(), cant, (selectedProducto.getPrecioEnPesos()*cant), selectedProducto.getId(), selectedProducto.getNombre()));
        //System.out.println("Entro "+cant+" "+selectedProducto.getNombre());
    }
    public void neto(){
        for (Total cantidad1 : cantidad) {
            total+=(cantidad1.getCantidad()*cantidad1.getPrecio());
        }
        cantidad.clear();
    }
    
}
