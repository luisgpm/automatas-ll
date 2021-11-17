/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica;

import java.util.logging.Logger;

/**
 *
 * @author Alan
 */
public class Gramatica {

    private static final Logger LOG = Logger.getLogger(Gramatica.class.getName());

    private static String entrada = "as";
    private static String pila[] = {"s0"};

    private static String producciones[][] = {
        {"a", "s3", "s2", "s1"},
        {"s1", "b"},
        {"-"},
        {"s2", "c"},
        {"-"},
        {"s3", "d"},
        {"-"}
    };

    private static Integer table[][] = {
        {1, 1, 1, 1, null},
        {3, 2, 3, 3, 3},
        {5, null, 4, 5, 5},
        {7, null, null, 6, null}
    };

    public static void main(String[] args) {

        int r = getPos(pila[pila.length - 1]);
        int c = getPos(entrada);
        String prod[] = producciones[table[r][c] - 1];

        pila = prod;

        while (!entrada.equals("$")) {
            imp(pila);
            r = getPos(pila[pila.length - 1]);
            c = getPos(entrada);
            prod = producciones[table[r][c] - 1];
            pila = op(prod, pila);
        }

    }

    private static int getPos(String s) {
        if (s.equals("s0") || s.equals("a")) {
            return 0;
        } else if (s.equals("s1") || s.equals("b")) {
            return 1;
        } else if (s.equals("s2") || s.equals("c")) {
            return 2;
        } else if (s.equals("s3") || s.equals("d")) {
            return 3;
        } else if (s.equals("$")) {
            return 4;
        }
        return -1;
    }

    private static void imp(String[] p) {
        System.out.print("$ ");
        for (String p1 : p) {
            System.out.print(p1 + " ");

        }
        System.out.println("");
    }

    private static String[] op(String[] r, String[] p) {
        if (p.length != 0) {
            if (p.length - 1 == 0) {
                entrada = "$";
                System.out.println("$");
            } else {
                if (r.length == 1 && r[0].equals("-")) {
                    String aux[] = new String[p.length - 1];
                    for (int i = 0; i < aux.length; i++) {
                        aux[i] = p[i];
                    }
                    return aux;
                }
            }
        }
        return null;
    }

}
