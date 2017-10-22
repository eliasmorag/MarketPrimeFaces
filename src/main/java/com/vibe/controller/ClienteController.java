
package com.vibe.controller;

import com.vibe.ejb.ClienteFacadeLocal;
import com.vibe.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.PostPersist;

@Named
@ViewScoped

public class ClienteController implements Serializable {
   
    @EJB
     private ClienteFacadeLocal clienteEJB;
     private Cliente cliente;
     private List<Cliente> clientes;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    @PostPersist
    public void refresh(){
        clientes = clienteEJB.findAll();
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
        clientes = clienteEJB.findAll();
    }
    
   
    public void registrar(){
        try{
            clienteEJB.create(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro exitoso"));
            clientes = clienteEJB.findAll();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
}