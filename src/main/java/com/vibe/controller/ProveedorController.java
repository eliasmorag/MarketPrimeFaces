/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vibe.controller;

import com.vibe.ejb.ProveedorFacadeLocal;
import com.vibe.model.Proveedor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author eliasmorag
 */
@Named
@ViewScoped
public class ProveedorController implements Serializable {
    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    private Proveedor proveedor;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    @PostConstruct
    public void init(){
        proveedor = new Proveedor();
    }
    
    public void registrar(){
        try{
            proveedorEJB.create(proveedor);
        }catch(Exception e){
            //mensaje prime grwol
        }
    }
}
