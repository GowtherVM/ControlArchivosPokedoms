/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokedoms;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PokedomDb {

    private ArrayList<Pokedom> pokedomlist = new ArrayList();
    private ArrayList<String> familiaslist = new ArrayList();

    public Pokedom describe(String nom) {
        return null;
    }

    public void insert(Pokedom nuevo) {
        pokedomlist.add(nuevo);
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

}
