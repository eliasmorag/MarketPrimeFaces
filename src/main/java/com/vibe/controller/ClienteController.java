
package com.vibe.controller;

import com.vibe.ejb.ClienteFacadeLocal;
import com.vibe.model.Cliente;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped

public class ClienteController implements Serializable {
   
    @EJB
     private ClienteFacadeLocal clienteEJB;
     private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

     
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    
   
    public void registrar(){
        try{
            clienteEJB.create(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro exitoso"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
}