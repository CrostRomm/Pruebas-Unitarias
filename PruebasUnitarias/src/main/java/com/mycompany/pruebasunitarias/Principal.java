/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasunitarias;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Hp-14
 */
public class Principal {
    
    private static Map<Integer,Persona> mapaAbuelo = new HashMap<Integer,Persona>();
    
    public void cargarDatos() {
    mapaAbuelo = new HashMap();
    //Abuelos
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
    mapaAbuelo.get(1).getMapaPersona().get(6).getMapaPersona().put(13, new Persona(13,"Tatiana"));
    mapaAbuelo.get(1).getMapaPersona().get(6).getMapaPersona().put(14, new Persona(14,"Fernanda"));
    mapaAbuelo.get(2).getMapaPersona().get(7).getMapaPersona().put(15, new Persona(15,"Viviana"));
    mapaAbuelo.get(2).getMapaPersona().get(8).getMapaPersona().put(16, new Persona(16,"Diana"));
    }
    
    public void imprimeArbol(){
        System.out.println("       ARBOL GENIALOGICO");
        System.out.println("       ");
        System.out.println("------------------------");
        System.out.println("");
        System.out.println("Digite un documento: ");
        Scanner scan = new Scanner(System.in);
        int cedula = scan.nextInt();
        for(Integer keyAbuelo:mapaAbuelo.keySet()){
        Persona abueloAux = mapaAbuelo.get(keyAbuelo);
            for(Integer keyPadre:abueloAux.getMapaPersona().keySet()){
                Persona padreAux = abueloAux.getMapaPersona().get(keyPadre);
                for(Integer keyHijo:padreAux.getMapaPersona().keySet()){
                    Persona hijoAux = padreAux.getMapaPersona().get(keyHijo);
                    if(abueloAux.getDocumento() == cedula){
                    System.out.println("ABUELO: " +abueloAux.getNombre());
                    System.out.println("   PADRE: ");
                    System.out.println("   "+padreAux.getDocumento()+" - "+padreAux.getNombre());
                    System.out.println("      NIETO: ");
                    System.out.println("      "+hijoAux.getDocumento()+" - "+hijoAux.getNombre());
                    break;
                    }
                    else if (abueloAux.getMapaPersona().containsKey(cedula)){
                        System.out.println("   PADRE: ");
                        System.out.println("   "+padreAux.getDocumento()+" - "+padreAux.getNombre());
                        System.out.println("      NIETO: ");
                        System.out.println("      "+padreAux.getMapaPersona().get(keyHijo).getDocumento()+" - "+padreAux.getMapaPersona().get(keyHijo).getNombre());
                        if(abueloAux.getMapaPersona().containsKey(keyHijo))
                            System.out.println("ABUELO: " +abueloAux.getNombre());
                        break;
                    }
                    else if(padreAux.getMapaPersona().containsKey(cedula)){
                        System.out.println("      NIETO: ");
                        System.out.println("      "+hijoAux.getDocumento()+" - "+hijoAux.getNombre());
                        System.out.println("   PADRE: ");
                        System.out.println("   "+padreAux.getDocumento()+" - "+padreAux.getNombre());
                        System.out.println("ABUELO: " +abueloAux.getNombre());
                        break;
                    }
                    String familia = abueloAux.getNombre()+padreAux.getNombre()+hijoAux.getNombre();
                }
            }
        }
    }
    public String TestFamilia(Map<Integer,Persona> mapaAbuelo,int cedula){
        String familia = "";
        for(Integer keyAbuelo:mapaAbuelo.keySet()){
        Persona abueloAux = mapaAbuelo.get(keyAbuelo);
            for(Integer keyPadre:abueloAux.getMapaPersona().keySet()){
                Persona padreAux = abueloAux.getMapaPersona().get(keyPadre);
                for(Integer keyHijo:padreAux.getMapaPersona().keySet()){
                    Persona hijoAux = padreAux.getMapaPersona().get(keyHijo);
                    if(abueloAux.getDocumento() == cedula){
                    System.out.println("ABUELO: " +abueloAux.getNombre());
                    System.out.println("   PADRE: ");
                    System.out.println("   "+padreAux.getDocumento()+" - "+padreAux.getNombre());
                    System.out.println("      NIETO: ");
                    System.out.println("      "+hijoAux.getDocumento()+" - "+hijoAux.getNombre());
                    familia = abueloAux.getNombre()+padreAux.getNombre()+hijoAux.getNombre();
                    break;
                    }
                    else if (abueloAux.getMapaPersona().containsKey(cedula)){
                        System.out.println("   PADRE: ");
                        System.out.println("   "+padreAux.getDocumento()+" - "+padreAux.getNombre());
                        System.out.println("      NIETO: ");
                        System.out.println("      "+hijoAux.getNombre());
                            System.out.println("ABUELO: " +abueloAux.getNombre());
                        familia = abueloAux.getNombre()+padreAux.getNombre()+hijoAux.getNombre();
                        break;
                    }
                    else if(padreAux.getMapaPersona().containsKey(cedula)){
                        System.out.println("      NIETO: ");
                        System.out.println("      "+hijoAux.getDocumento()+" - "+hijoAux.getNombre());
                        System.out.println("   PADRE: ");
                        System.out.println("   "+padreAux.getDocumento()+" - "+padreAux.getNombre());
                        System.out.println("ABUELO: " +abueloAux.getNombre());
                        familia = abueloAux.getNombre()+padreAux.getNombre()+hijoAux.getNombre();
                        break;
                    }
                }
            }
        }
        return familia;
    }
    public static void main (String [ ] args) {
        Principal principal = new Principal();
        principal.cargarDatos();
        principal.imprimeArbol();
    }
}

