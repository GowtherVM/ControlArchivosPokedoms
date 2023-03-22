/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokedoms;

/**
 *
 * @author Admin
 */
public class PokedomDb {

    private Pokedom array[] = new Pokedom[100];
    private int indice = 0;
    private String familias[] = new String[100];
    private String condicion = "False";
    private int indice2 = 0;
    private int i = 0;

    public Pokedom describe(String nom) {
        for (int i = 0; i < array.length; i++) {
            if (nom.equalsIgnoreCase(array[i].getNom())) {
                return array[i];

            }
        }
        return null;
    }

    public void insert(Pokedom nuevo) {
        if(indice < 100){
          array[indice] = nuevo;  
        }
        
        indice++;

    }

    public void familias(String familia) {

        i = 0;
        while (i < familias.length) {
            if (familias[i] != (null)) {
                if (familias[i].equals(familia)) {
                    condicion = "True";
                    i++;

                } else {
                    condicion = "False";
                    i = familias.length;
                }
            } else {
                i++;
            }

            if (condicion.equals("False")) {
                familias[indice2] = familia;
                indice2++;
            }

        }
       
       
}

}
