/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efinal.intermedio;

import intermedio.Cuadrupla;
import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author Alan
 */
public class CodigoIntermedio {

    private static ArrayList<Cuadrupla> variablesEncabezado = new ArrayList<>();
    private static ArrayList<ArrayList<Cuadrupla>> listaCuadruplas = new ArrayList<>();
    private static Stack<Etiqueta> etiquetas = new Stack<>();

    private static Etiqueta anterior;
    private static ArrayList<Lexema> condicion;
    private static int posAux = 0;

    private static ArrayList<Cuadrupla> cuadruplaAux;

    public static void getCodigoIntermedio(ArrayList<Lexema> listaLex) {
        Lexema aux;
        for (int i = 0; i < listaLex.size(); i++) {
            aux = listaLex.get(i);
            switch (aux.getLexema()) {
                case "if":
                    etiquetas.push(new Etiqueta(anterior, Etiqueta.SENT_IF));
                    condicion = separaCondicionYPostfijo(i, listaLex);
                    cuadruplaAux = Cuadrupla.generaCuadrupla(condicion);
                    Cuadrupla.printCuadruplas(cuadruplaAux);
                    i = posAux;
                    break;
                case "else if":
                    break;
                case "else":
                    break;
                case "while":
                    break;
                case "read":
                    break;
                case "write":
                    break;
                case "int":
                    break;
                case "String":
                    break;
                case "double":
                    break;
                case "{":
                    
                    break;
                case "}":
//                    anterior = etiquetas.pop();
                    break;
                default:
                    if (aux.getToken().equals("41")) {

                    }
                    break;
            }
        }
    }

    public static ArrayList<Lexema> separaCondicionYPostfijo(int i, ArrayList<Lexema> listaLex) {
        i += 2;
        ArrayList<Lexema> condicionAux = new ArrayList<>();
        while (!listaLex.get(i).getLexema().equals(")")) {
            condicionAux.add(listaLex.get(i));
            i++;
        }

        posAux = i;
        return Postfijo.convertirPostfijo(condicionAux);
    }

}
