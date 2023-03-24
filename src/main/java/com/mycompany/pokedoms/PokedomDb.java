/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokedoms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PokedomDb {

    private ArrayList<Pokedom> pokedomlist = new ArrayList();
    private ArrayList<String> familiaslist = new ArrayList();


    public void insert(Pokedom nuevo) {
        pokedomlist.add(nuevo);
    }
    
    public Pokedom comprobarPokedom(String nuevopokedom){
        
        for(Pokedom elpokedom: pokedomlist){
            if(elpokedom.getNom().equalsIgnoreCase(nuevopokedom)){
                return elpokedom;
            }
        }
        
        
        return null;
        
    }

    public void familias(String familianueva) {
        boolean comprobar = false;
        for (String familia : familiaslist) {
            if (familia.equalsIgnoreCase(familianueva)) {
                comprobar = true;
            }
        }
        if (comprobar = false) {
            familiaslist.add(familianueva);
        }

    }
    
        public static void cargarPokedoms(String archivo, PokedomDb db) throws FileNotFoundException, IOException {
        BufferedReader fichero = new BufferedReader(new FileReader(archivo));
        String linea;
        Pokedom carga = new Pokedom("0", "0", 0, 0);
        while ((linea = fichero.readLine()) != null) {

            String[] partes = linea.split(" ");
            if (partes.length > 1) {
                if (partes.length == 4) {
                    carga = new Pokedom(partes[0], partes[1], Double.parseDouble(partes[2]), Double.parseDouble(partes[3]));
                } else if (partes.length == 3) {
                    carga = new Pokedom(partes[0], partes[1], Double.parseDouble(partes[2]), 0);
                } else if (partes.length == 2) {
                    carga = new Pokedom(partes[0], partes[1], 0, 0);
                }
                db.insert(carga);
                db.familias(partes[1]);
            }

        }
    }

}
