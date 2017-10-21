
package com.vibe.controller;

import com.vibe.ejb.ProductoFacadeLocal;
import com.vibe.model.Producto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped

public class ProductoController implements Serializable {
   
    @EJB
     private ProductoFacadeLocal productoEJB;
     private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @PostConstruct
    public void init(){
        producto = new Producto();
    }
    
   
    public void registrar(){
        try{
            productoEJB.create(producto);
        }catch(Exception e){
            //jeje
        }
    }
}