/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizacionCodigo;

import intermedio.Cuadrupla;
import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Prb {

    public static void main(String[] args) {
        ArrayList<Lexema> tablaLexemas = Lexema.getTablaLexema("post");
        tablaLexemas = Postfijo.convertirPostfijo(tablaLexemas);

        ArrayList<Cuadrupla> tablaCuadruplas = Cuadrupla.generaCuadrupla(tablaLexemas);

        for (Cuadrupla c : tablaCuadruplas) {
            System.out.println(c);
        }

        System.out.println("--------------------------");
        System.out.println("Optimizacion");
        System.out.println("--------------------------");

        Optimizacion.optimizaCuadrupla(tablaCuadruplas, 5);

        for (Cuadrupla c : tablaCuadruplas) {
            System.out.println(c);
        }

    }

}
