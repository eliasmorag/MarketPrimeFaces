package com.vibe.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


    @Entity
    @Table(name = "venta")
    public class Venta implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int codigo;
    
        @OneToOne
        @JoinColumn(name="cliente", nullable=false)
        private Cliente cliente;
        
        @OneToOne
        @JoinColumn(name="producto", nullable=false)
        private  Producto producto;
    
        @Column(name="total")
        private Integer total;

        public Venta() {
        }
        
        public Venta(Cliente cliente, Producto producto, Integer total) {
            this.cliente = cliente;
            this.producto = producto;
            this.total = total;
        }
        
        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
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

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }
        
        
        
    }
