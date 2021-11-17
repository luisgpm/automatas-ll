/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import automatas.Automatas;
import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Pruebas {

    public static String[] prbs;

    public static void main(String[] args) {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("fuentes/pro2.txt");
        ArrayList<Lexema> palabras = separarPalabras.SeparaPalabras.separa(lineas);
        for (Lexema palabra : palabras) {
            System.out.println(palabra);
        }
    }

    public static String[] getPalabras() {
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer("fuentes/pro2.txt");
        ArrayList<Lexema> palabras = separarPalabras.SeparaPalabras.separa(lineas);
        cambia(palabras);

        prbs = new String[palabras.size() + 2];

        for (int i = 0; i < palabras.size(); i++) {
            prbs[i] = palabras.get(i).getLexema().trim();
        }

        prbs[prbs.length - 2] = "}";
        prbs[prbs.length - 1] = "$";

        return prbs;
    }

    public static void cambia(ArrayList<Lexema> p) {
        Lexema aux;
        for (int i = 0; i < p.size(); i++) {
            aux = p.get(i);
            try {
                if (aux.getLexema().equals("+") && p.get(i + 1).getLexema().equals("+")) {
                    aux.setLexema("44");
                    p.remove(i + 1);
                }
                if (aux.getToken().equals("43") || aux.getToken().equals("48")) {
                    aux.setLexema("num");
                } else if (aux.getLexema().equals("console")) {
                    aux.setLexema("console");
                } else if (aux.getLexema().equals("log")) {
                    aux.setLexema("log");
                } else if (aux.getLexema().equals("read")) {
                    aux.setLexema("read");
                } else if (aux.getToken().equals("46")) {
                    aux.setLexema("cadena");
                } else if (aux.getToken().equals("41")) {
                    aux.setLexema("id");
                } else if (aux.getToken().equals("39")) {
                    aux.setLexema("OR");
                }
            } catch (Exception e) {

            }
        }
    }

}
