/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pokedoms;

import Files.CreateAndEditFiles;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Pokedoms {

    public static void main(String[] args) throws IOException {

        CreateAndEditFiles pokedom;
        String contenido;
        int codigo;
        PokedomDb db = new PokedomDb();

        cargarPokedoms(args[0], db);

        switch (args[1].toLowerCase()) {

            case "add":

                if (args.length == 6) {
                    Pokedom nuevo = createPokedom(args[2].toUpperCase(), args[3].toLowerCase(), args[4], args[5]);
                    db.insert(nuevo);
                    db.familias(args[3].toLowerCase());
                    contenido = (nuevo.getNom() + " " + nuevo.getFam() + " " + String.valueOf(nuevo.getAtk()) + " " + String.valueOf(nuevo.getDef()));
                    pokedom = new CreateAndEditFiles(args[0], contenido);
                    codigo = pokedom.comprobarRuta();
                    errorFichero(codigo);
                    pokedom.añadirPokedom();

                } else if (args.length == 5) {
                    Pokedom nuevo = createPokedom(args[2].toUpperCase(), args[3].toLowerCase(), args[4], "0");
                    db.insert(nuevo);
                    db.familias(args[3].toLowerCase());
                    contenido = (nuevo.getNom() + " " + nuevo.getFam() + " " + String.valueOf(nuevo.getAtk()) + " " + String.valueOf(nuevo.getDef()));
                    pokedom = new CreateAndEditFiles(args[0], contenido);
                    codigo = pokedom.comprobarRuta();
                    errorFichero(codigo);
                    pokedom.añadirPokedom();

                } else if (args.length == 4) {
                    Pokedom nuevo = createPokedom(args[2].toUpperCase(), args[3].toLowerCase(), "0", "0");
                    db.insert(nuevo);
                    db.familias(args[3].toLowerCase());
                    contenido = (nuevo.getNom() + " " + nuevo.getFam() + " " + String.valueOf(nuevo.getAtk()) + " " + String.valueOf(nuevo.getDef()));
                    pokedom = new CreateAndEditFiles(args[0], contenido);
                    codigo = pokedom.comprobarRuta();
                    errorFichero(codigo);
                    pokedom.añadirPokedom();
                } else {
                    System.out.println("Numero de parametros incorrectos");
                }

                break;

            case "describe":
                String busqueda = args[2];
                BufferedReader fichero = new BufferedReader(new FileReader(args[0]));
                String linea;

                while ((linea = fichero.readLine()) != null) {
                    if (linea.contains(busqueda.toUpperCase())) {
                        String[] partes = linea.split(" ");
                        if (partes.length == 4) {
                            System.out.println(partes[0].toUpperCase());
                            System.out.println("Family: " + partes[1]);
                            System.out.println("Attack power: " + partes[2]);
                            System.out.println("Defense power: " + partes[3]);
                        }

                    }
                }
                break;

            case "quit":
                break;
        }

    }

    public static void errorFichero(int codigo) {
        if (codigo == 10) {
            System.out.println("El fichero es correcto.");
        } else if (codigo == 11) {
            System.out.println("Se ha creado un archivo con ese nombre.");
        }
    }

    public static Pokedom createPokedom(String nom, String familia, String atk, String def) {
        Pokedom nuevo = new Pokedom(nom, familia, Double.parseDouble(atk), Double.parseDouble(def));

        return nuevo;
    }

    public static void cargarPokedoms(String archivo, PokedomDb db) throws FileNotFoundException, IOException {
        BufferedReader fichero = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = fichero.readLine()) != null) {

            String[] partes = linea.split(" ");
            Pokedom carga = new Pokedom(partes[1], partes[2], Double.parseDouble(partes[3]), Double.parseDouble(partes[4]));
            db.insert(carga);
            db.familias(partes[2]);
        }
    }
}

// Add
// List Famlia
// Describe Pokedom
// Battle

