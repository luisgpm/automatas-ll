/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica;

/**
 *
 * @author alanm
 */
public class Gramatica2 {

    private static String[][] producciones = {
        {"s0", "a", "s3", "s2", "s1"},
        {"s1", "s1", "b"},
        {"s1", "-"},
        {"s2", "s2", "c"},
        {"s2", "-"},
        {"s3", "s3", "d"},
        {"s3", "-"}
    };

    private static int[][] tabla = {
        {1, 1, 1, 1, 0},
        {3, 2, 3, 3, 3},
        {5, 0, 4, 5, 5},
        {7, 0, 0, 6, 0}
    };

    private static String[] pila = {"$", "s0"};
    private static String[] entrada = {"a", "$"};

    public static void main(String[] args) {
        imprime();
        while (!entrada[0].equals("$") && pila.length != 1) {
            if (pila[pila.length - 1].contains("s")) {
                pila = modPila(pila, 1, tabla[getPos(pila[pila.length - 1])][getPos(entrada[0])] - 1);
            } else if (pila[pila.length - 1].equals(entrada[0])) {
                pila = modPila(pila, 0, 0);
                entrada = modEntrada(entrada);
            } else if (pila[pila.length - 1].equals("-")) {
                pila = modPila(pila, 0, 0);
            }
            imprime();
        }

    }

    private static void imprime() {
        for (String p : pila) {
            System.out.print(p + " ");
        }
        System.out.print("--------- ");
        for (String e : entrada) {
            System.out.print(e + " ");
        }
        System.out.println("");
    }

    private static String[] modPila(String pila[], int sr, int prod) {
        String[] aux;

        aux = new String[pila.length - 1];
        for (int i = 0; i < pila.length - 1; i++) {
            aux[i] = pila[i];
        }
        if (sr == 1) {
            String[] aux2 = new String[aux.length + producciones[prod].length - 1];
            int i = 0;
            for (i = 0; i < aux.length; i++) {
                aux2[i] = aux[i];
            }
            for (int j = 1; j < producciones[prod].length; j++) {
                aux2[i] = producciones[prod][j];
                i++;
            }
            return aux2;
        }
        return aux;

    }

    private static String[] modEntrada(String[] entrada) {
        String[] aux = new String[entrada.length - 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = entrada[i + 1];
        }
        return aux;
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

}
