/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pokedoms;

import Files.CreateAndEditFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class Pokedoms {

    public static void main(String[] args) throws IOException {

        CreateAndEditFiles nuevopokedom;


        switch (args[0].toLowerCase()) {

            case "add":
                if (args.length == 7) {
                    if (Integer.parseInt(args[2]) == 1 || Integer.parseInt(args[2]) == 0) {
                        nuevopokedom = new CreateAndEditFiles(args[1], Integer.parseInt(args[2]), args[3], args[4], args[5], args[6]);
                        nuevopokedom.comprobarRuta();
                        nuevopokedom.añadirPokedom();
                    } else {
                        System.out.println("El tercer valor solo puede ser 0 o 1. ");
                    }

                } else {
                    System.out.println("Numero incorrecto de parmetros");
                }

                break;

            case "quit":
                break;
        }

    }
}

// Add
// List Famlia
// Describe Pokedom
// Battle

