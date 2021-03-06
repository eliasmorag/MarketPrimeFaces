/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vibe.controller;

import com.vibe.ejb.ClienteFacadeLocal;
import com.vibe.ejb.ProductoFacadeLocal;
import com.vibe.ejb.ProveedorFacadeLocal;
import com.vibe.ejb.VentaFacadeLocal;
import com.vibe.model.Cliente;
import com.vibe.model.Producto;
import com.vibe.model.Venta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author mati
 */

@Named
@ViewScoped
public class VentaController implements Serializable {
    @EJB
    private VentaFacadeLocal ventaEJB;
    @EJB
    private ClienteFacadeLocal clienteEJB;
    @EJB
    private ProductoFacadeLocal productoEJB;
    private Venta venta;
    private List<Venta> ventas;
    private Cliente cliente;
    private Producto producto;
    private List<Producto> productos;
    private List<Cliente> clientes;
    private Integer total=100;
    private Integer cliente_id;
    private Integer producto_id;
    private Integer cantidad;
    private Integer cantidad_vendida;
    private Integer cantidad_stock;
    private List<Venta> ventasfiltered;
    
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Venta> getVentasfiltered() {
        return ventasfiltered;
    }

    public void setVentasfiltered(List<Venta> ventasfiltered) {
        this.ventasfiltered = ventasfiltered;
    }
    
    

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    @PostConstruct
    public void init(){
        venta = new Venta();
        cliente = new Cliente();
        producto= new Producto();
        productos = this.productoEJB.findAll();
        clientes = this.clienteEJB.findAll();
        ventas = this.ventaEJB.findAll();
    }
    
    public void registrar(){
        try{
            
            producto=productoEJB.find(this.producto_id);
            cliente=clienteEJB.find(this.cliente_id);
            venta.setProducto(producto);
            venta.setCliente(cliente);
            venta.setTotal(total);
            venta.setCantidad(cantidad);
            /////////////////////////////////////////////////
            cantidad_vendida=venta.getCantidad();
            cantidad_stock=producto.getCantidad();
            if (cantidad_stock >= cantidad_vendida){
                cantidad_stock=cantidad_stock-cantidad_vendida;
                producto.setCantidad(cantidad_stock);
                productoEJB.edit(producto);
                ventaEJB.create(this.venta);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Venta exitosa"));
                ventas = this.ventaEJB.findAll();

            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "No existe stock suficiente"));
            }         
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error abortar mision! llamar al chapulin"));
        }
    }
}
