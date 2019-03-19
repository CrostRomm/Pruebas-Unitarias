/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasunitarias;

import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp-14
 */
public class PrincipalTest {
    
    static Principal p;
    private static Map<Integer,Persona> mapaAbuelo = new HashMap<Integer,Persona>();
    
    @BeforeClass
    public static void setUpCargador() {
        p = new Principal();
           llenaDatos();
    }
    public static void llenaDatos(){
    mapaAbuelo.put(1, new Persona(1,"Juan"));
    mapaAbuelo.put(2, new Persona(2,"Jose"));
    //Padres
    mapaAbuelo.get(1).getMapaPersona().put(3,new Persona(3,"Andres"));
    mapaAbuelo.get(1).getMapaPersona().put(4,new Persona(4,"Maria"));
    mapaAbuelo.get(1).getMapaPersona().put(5,new Persona(5,"Carlos"));
    mapaAbuelo.get(2).getMapaPersona().put(6,new Persona(6,"Alberto"));
    mapaAbuelo.get(2).getMapaPersona().put(7,new Persona(7,"Jimmy"));
    mapaAbuelo.get(2).getMapaPersona().put(8,new Persona(8,"Jhon"));
    //Hijos
    mapaAbuelo.get(1).getMapaPersona().get(3).getMapaPersona().put(9, new Persona(9,"Juana"));
    mapaAbuelo.get(1).getMapaPersona().get(3).getMapaPersona().put(10, new Persona(10,"Paola"));
    mapaAbuelo.get(1).getMapaPersona().get(4).getMapaPersona().put(11, new Persona(11,"Sofia"));
    mapaAbuelo.get(1).getMapaPersona().get(5).getMapaPersona().put(12, new Persona(12,"Jaime"));
    mapaAbuelo.get(2).getMapaPersona().get(6).getMapaPersona().put(13, new Persona(13,"Tatiana"));
    mapaAbuelo.get(2).getMapaPersona().get(6).getMapaPersona().put(14, new Persona(14,"Fernanda"));
    mapaAbuelo.get(2).getMapaPersona().get(7).getMapaPersona().put(15, new Persona(15,"Viviana"));
    mapaAbuelo.get(2).getMapaPersona().get(8).getMapaPersona().put(16, new Persona(16,"Diana"));
    }
    @Test
    public void Hijo1(){
        String alguien = p.TestFamilia(mapaAbuelo, 9);
        assertEquals("JuanAndresJuana", alguien);
    }
    @Test
    public void Hijo2(){
        String alguien = p.TestFamilia(mapaAbuelo, 12);
        assertEquals("JuanCarlosJaime", alguien);
    }
    @Test
    public void Papa(){
        String alguien = p.TestFamilia(mapaAbuelo, 5);
        assertEquals("MarioBross", alguien);
    }
    @Test
    public void Abuelo(){
        String alguien = p.TestFamilia(mapaAbuelo, 2);
        assertEquals("JoseJhonDiana", alguien);
    }
}
