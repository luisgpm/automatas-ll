/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class PrbSimbolo {
    
    public static void main(String[] args) {

        /**
         * Programa fuente en lexemas
         */
        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("fuentes/declaraciones.txt");

        /**
         * Tablas de variables globales y locales en notacion postfija
         */
        TablaSimbolo tablaGlobal = Simbolo.getTablasDeSimbolos(tablaLexema);
        
        tablaGlobal.imprime(0);
        
    }
    
}
