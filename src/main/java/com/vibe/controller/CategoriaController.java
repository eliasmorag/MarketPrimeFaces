package com.vibe.controller;

import com.vibe.ejb.CategoriaFacadeLocal;
import com.vibe.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CategoriaController implements Serializable {
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    @PostConstruct
    public void init(){
        categoria = new Categoria();
        
    }
    
    public void registrar(){
        try{
            categoriaEJB.create(categoria);
        }catch(Exception e){
            //mensaje prime grwol
        }
    }
}
