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
          private String desctipcion;
          
          @Column(name="precio")
          private Integer precio;
          
          @Column(name="cantidad")
          private Integer cantidad;
          
}
