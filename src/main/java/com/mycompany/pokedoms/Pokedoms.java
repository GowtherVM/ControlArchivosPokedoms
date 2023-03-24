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

    static CreateAndEditFiles pokedom;

    public static void main(String[] args) throws IOException {

        String contenido;
        PokedomDb db = new PokedomDb();
        Pokedom nuevo = new Pokedom("0", "0", 0, 0);

        generarRuta(args[0]);
        db.cargarPokedoms(args[0], db);

        switch (args[1].toLowerCase()) {

            case "add":
                if (db.comprobarPokedom(args[2].toUpperCase()) == null) {

                    if (args.length >= 4 && args.length <= 6) {
                        if (args.length == 6) {

                            nuevo = createPokedom(args[2].toUpperCase(), args[3].toLowerCase(), args[4], args[5]);
                            db.insert(nuevo);
                            db.familias(args[3].toLowerCase());
                        } else if (args.length == 5) {
                            nuevo = createPokedom(args[2].toUpperCase(), args[3].toLowerCase(), args[4], "0");
                            db.insert(nuevo);
                            db.familias(args[3].toLowerCase());
                        } else if (args.length == 4) {
                            nuevo = createPokedom(args[2].toUpperCase(), args[3].toLowerCase(), "0", "0");
                            db.insert(nuevo);
                            db.familias(args[3].toLowerCase());
                        } else {
                            System.out.println("Numero de parametros incorrectos");
                        }
                        contenido = (nuevo.getNom() + " " + nuevo.getFam() + " " + String.valueOf(nuevo.getAtk()) + " " + String.valueOf(nuevo.getDef()));
                        pokedom = new CreateAndEditFiles();
                        pokedom.añadirPokedom(args[0], contenido);
                    }
                } else {
                    System.out.println("El Pokedom ya existe.");
                }
                break;

            case "describe":
                if (db.comprobarPokedom(args[2].toUpperCase()) != null) {
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
                } else {
                    System.out.println("El Pokedom no existe");
                }
                break;

            case "list":
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

    public static void generarRuta(String ruta) throws IOException {
        int codigo;
        pokedom = new CreateAndEditFiles();
        codigo = pokedom.comprobarRuta(ruta);
        errorFichero(codigo);
    }


}

// List Famlia
// Battle

