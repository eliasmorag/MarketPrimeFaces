/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vibe.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author mati
 */

    @Entity
    @Table(name = "producto")
    
public class Producto implements Serializable {
        
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)


          private int id;

          @Column(name="nombre")
          private String nombre;

          @Column(name="descripcion")
          private String descripcion;
          
          @Column(name="precio")
          private Integer precio;
          
          @Column(name="cantidad")
          private Integer cantidad;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String desctipcion) {
            this.descripcion = desctipcion;
        }

        public Integer getPrecio() {
            return precio;
        }

        public void setPrecio(Integer precio) {
            this.precio = precio;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

          
}
