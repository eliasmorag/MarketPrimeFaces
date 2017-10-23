package com.vibe.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


    @Entity
    @Table(name = "compra")
    public class Compra implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int codigo;
    
        @OneToOne
        @JoinColumn(name="proveedor", nullable=false)
        private Proveedor proveedor;
        
        @ManyToOne
        @JoinColumn(name="producto", nullable=false)
        private  Producto producto;
    
        @Column(name="cantidad")
        private Integer cantidad;

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
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

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }
        
        
    }
