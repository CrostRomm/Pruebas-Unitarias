/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasunitarias;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hp-14
 */
public class Persona {
    private int documento;
    private String nombre;
    private Map<Integer, Persona> mapaPersona = new HashMap<Integer,Persona>();

    public Persona(int documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<Integer, Persona> getMapaPersona() {
        return mapaPersona;
    }

    public void setMapaPersona(Map<Integer, Persona> mapaPersona) {
        this.mapaPersona = mapaPersona;
    }
    
    
    
    
}
