/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vibe.controller;

import com.vibe.ejb.ProveedorFacadeLocal;
import com.vibe.ejb.ProductoFacadeLocal;
import com.vibe.ejb.CompraFacadeLocal;
import com.vibe.model.Proveedor;
import com.vibe.model.Proveedor;
import com.vibe.model.Producto;
import com.vibe.model.Compra;
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
 * @author santiago
 */
@Named
@ViewScoped
public class CompraController implements Serializable {
    @EJB
    private CompraFacadeLocal compraEJB;
    @EJB
    private ProveedorFacadeLocal proveedorEJB;
    @EJB
    private ProductoFacadeLocal productoEJB;
    
    private Compra compra;
    private Proveedor proveedor;
    private Producto producto;
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private Integer proveedor_id;
    private Integer producto_id;
    private Integer cantidad;
    private Integer cantidad_comprada;
    private Integer cantidad_stock;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public Integer getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Integer proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad_comprada() {
        return cantidad_comprada;
    }

    public void setCantidad_comprada(Integer cantidad_comprada) {
        this.cantidad_comprada = cantidad_comprada;
    }

    public Integer getCantidad_stock() {
        return cantidad_stock;
    }

    public void setCantidad_stock(Integer cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }
    
    @PostConstruct
    public void init(){
        compra = new Compra();
        proveedor = new Proveedor();
        producto= new Producto();
        productos = this.productoEJB.findAll();
        proveedores = this.proveedorEJB.findAll();
    }
    
    public void registrar(){
        try{
            
            producto=productoEJB.find(this.producto_id);
            proveedor=proveedorEJB.find(this.proveedor_id);
            compra.setProducto(producto);
            compra.setProveedor(proveedor);
            compra.setCantidad(cantidad);
            compraEJB.create(this.compra);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Compra exitosa"));
            /////////////////////////////////////////////////    
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error abortar mision! llamar al chapulin"));
        }
    }
}
