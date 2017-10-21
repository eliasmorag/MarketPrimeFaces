/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vibe.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="nota")
public class Nota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int codigo;
    
    @OneToOne
    @JoinColumn(name="codigo_persona", nullable=false)
    private Persona persona;
    
    @OneToOne
    @JoinColumn(name="codigo_categoria", nullable=false)
    private Categoria categoria;
    
    @Column(name="encabezado")
    private String encabezado;
    
    @Column(name="cuerpo")
    private String cuerpo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="comentarioAdmin")
    private String comentarioAdmin;
    
    @Column(name="valorizacion")
    private short valorizacion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarioAdmin() {
        return comentarioAdmin;
    }

    public void setComentarioAdmin(String comentarioAdmin) {
        this.comentarioAdmin = comentarioAdmin;
    }

    public short getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(short valorizacion) {
        this.valorizacion = valorizacion;
    }
    
    
    
    
}
