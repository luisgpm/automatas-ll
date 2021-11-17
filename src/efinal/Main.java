/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efinal;

import efinal.intermedio.CodigoIntermedio;
import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Main {

    private static ArrayList<Lexema> listaLexemas;

    public static void main(String[] args) {

        listaLexemas = Stream.getListLexemas("fuentes/codinter.txt");
        CodigoIntermedio.getCodigoIntermedio(listaLexemas);

    }
}
