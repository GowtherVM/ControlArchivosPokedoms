/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokedoms;

/**
 *
 * @author Admin
 */
public class Pokedom {

    private String nom;
    private String fam;
    private double Atk;
    private double Def;

    public Pokedom(String nom, String fam, double Atk, double Def) {
        this.nom = nom;
        this.fam = fam;
        this.Atk = Atk;
        this.Def = Def;
    }

    public String getNom() {
        return this.nom;
    }
            

    public String getFam() {
        return this.fam;
    }

    public double getAtk() {
        return this.Atk;
    }

    public double getDef() {
        return this.Def;
    }

}
