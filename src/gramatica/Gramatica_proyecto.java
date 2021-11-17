/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica;

import java.util.HashMap;
import programa.Pruebas;

/**
 *
 * @author alanm
 */
public class Gramatica_proyecto {

    private static HashMap<String, Integer> pos = new HashMap<>();

    private static String[][] producciones
            = {
                {
                    "<programa>", "}", "<sentencias>", "{"
                },
                {
                    "<sentencias>", "<sentencias>", "<sent_2>"
                },
                {
                    "<sentencias>", "-"
                },
                {
                    "<sent_2>", "<s_if>"
                },
                {
                    "<sent_2>", "<s_for>"
                },
                {
                    "<sent_2>", "<s_while>"
                },
                {
                    "<sent_2>", "<s_declaracion>"
                },
                {
                    "<sent_2>", "<s_asig>"
                },
                {
                    "<sent_2>", "<s_dowhile>"
                },
                {
                    "<sent_2>", "<s_function>"
                },
                {
                    "<sent_2>", "<s_call>"
                },
                {
                    "<sent_2>", "<s_leer>"
                },
                {
                    "<sent_2>", "<s_write>"
                },
                {
                    "<s_leer>", ";", ")", "id", "(", "read"
                },
                {
                    "<s_write>", ";", ")", "<s_w2>", "(", "log", ".", "console"
                },
                {
                    "<s_w2>", "<s_concat>"
                },
                {
                    "<s_declaracion>", ";", "<s_dec2>", "=", "id", "t_dato"
                },
                {
                    "<s_dec2>", "<exp>"
                },
                {
                    "<s_dec2>", "null"
                },
                {
                    "<s_dec2>", "<s_concat_cadenas>"
                },
                {
                    "<s_asig>", ";", "<s_asig2>", "=", "id"
                },
                {
                    "<s_asig2>", "null"
                },
                {
                    "<s_asig2>", "<s_concat>"
                },
                {
                    "<exp>", "<exp_2>", "<exp_1>"
                },
                {
                    "<exp_1>", ")", "<exp>", "("
                },
                {
                    "<exp_1>", "num" //aaakakkakak
                },
                {
                    "<exp_1>", "id"
                },
                {
                    "<exp_2>", "<exp>", "<exp_3>"
                },
                {
                    "<exp_2>", "-"
                },
                {
                    "<exp_3>", "+"
                },
                {
                    "<exp_3>", "36"
                },
                {
                    "<s_concat>", "<s_concat2>", "cadena"
                },
                {
                    "<s_concat>", "<s_concat2>", "<exp>"
                },
                {
                    "<s_concat2>", "<s_concat2>", "<s_concat3>", "+"
                },
                {
                    "<s_concat2>", "-"
                },
                {
                    "<s_concat3>", "cadena"
                },
                {
                    "<s_concat3>", "<exp>"
                },
                {
                    "<s_concat_cadenas>", "<s_concat_cadenas_2>", "cadena"
                },
                {
                    "<s_concat_cadenas_2>", "<s_concat_cadenas_2>", "cadenas", "+"
                },
                {
                    "<s_concat_cadenas_2>", "-"
                },
                {
                    "<condicion>", "<condicion_2>", "<exp>", "OR", "<exp>"
                },
                {
                    "<condicion>", "<condicion_2>", ")", "<exp>", "OR", "<exp>", "(", "!"
                },
                {
                    "<condicion_2>", "<condicion>", "OL"
                },
                {
                    "<condicion_2>", "-"
                },
                {
                    "<s_if>", ";", "<s_else>", "<s_elif>", "}", "<sentencias>", "{", ")", "<condicion>", "(", "if"
                },
                {
                    "<s_elif>", "<s_elif>", "}", "<sentencias>", "{", ")", "<condicion>", "(", "if", "else"
                },
                {
                    "<s_elif>", "-"
                },
                {
                    "<s_else>", "}", "<sentencias>", "{", "else"
                },
                {
                    "<s_for>", ";", "}", "<sentencias>", "{", ")", "<s_inc>", ";", "<condicion>", ";", "num", "=", "id", "(", "for"
                },
                {
                    "<s_inc>", "<s_inc_2>", "id"
                },
                {
                    "<s_inc_2>", "44"
                },
                {
                    "<s_inc_2>", "45"
                },
                {
                    "<s_while>", ";", "}", "<sentencias>", "{", ")", "<condicion>", "(", "while"
                },
                {
                    "<s_dowhile>", ";", ")", "<condicion>", "(", "while", "}", "<sentencias>", "{", "do"
                },
                {
                    "<s_call>", ";", ")", "<s_call_params>", "(", "idFuncion"
                },
                {
                    "<s_call_params>", "<s_call_params_1>"
                },
                {
                    "<s_call_params>", "-"
                },
                {
                    "<s_call_params_1>", "<s_call_multi_params>", "<s_concat>"
                },
                {
                    "<s_call_multi_params>", "<s_call_params_1>"
                },
                {
                    "<s_call_multi_params>", "-"
                },
                {
                    "<s_function>", ";", "}", "<sentencias>", "{", ")", "<s_params>", "(", "id", "function"
                },
                {
                    "<s_params>", "s_params_1"
                },
                {
                    "<s_params>", "-"
                },
                {
                    "<s_params_1>", "<s_params_2>", "id", "t_dato"
                },
                {
                    "<s_params_2>", "<s_params_1>", ","
                },
                {
                    "<s_params_2>", "-"
                }

            };

    private static int[][] tabla
            = {
                {
                    0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    2, 0, 0, 2, 0, 0, 2, 2, 0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 0, 0, 0, 2, 2, 2, 0, 3, 0, 0
                },
                {
                    8, 0, 0, 7, 0, 0, 12, 13, 0, 0, 0, 0, 6, 0, 5, 0, 0, 4, 0, 0, 0, 9, 11, 10, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    16, 16, 0, 0, 0, 0, 0, 0, 0, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    18, 18, 0, 0, 0, 0, 0, 0, 19, 18, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    23, 23, 0, 0, 0, 0, 0, 0, 22, 23, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    24, 24, 0, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    27, 25, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    27, 0, 29, 0, 28, 0, 0, 0, 0, 26, 0, 29, 0, 0, 0, 28, 28, 0, 0, 0, 0, 0, 0, 0, 29, 0, 29, 29
                },
                {
                    0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    33, 33, 0, 0, 0, 0, 0, 0, 0, 33, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 35, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 35, 0
                },
                {
                    37, 37, 0, 0, 0, 0, 0, 0, 0, 37, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0
                },
                {
                    41, 41, 0, 0, 0, 0, 0, 0, 0, 41, 0, 0, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 44, 0, 0, 0, 0, 0, 0, 0, 0, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 52, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 54, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 55, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 57, 0, 56, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    58, 58, 0, 0, 0, 0, 0, 0, 0, 58, 58, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 61, 0, 0, 0, 0
                },
                {
                    0, 0, 63, 62, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                {
                    0, 0, 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65, 0, 0
                },};

    private static String[] pila
            = {
                "$", "<programa>"
            };
    //private static String[] entrada = {"{", "console", ".", "log", "(", "num", ")", ";", "}", "$"};
//    private static String[] entrada = {"{", "while", "(", "num", "OR", "num", ")", "{", "console", ".", "log", "(", "num", ")", ";", "}", ";", "}", "$"};
//    private static String[] entrada = {"{", "while", "(", "num", "OR", "num", ")", "{", "if", "(", "num", "OR", "num", ")", "{", "console", ".", "log", "(", "num", ")", ";", "}",";", "}", ";", "}", "$"};
    // private static String[] entrada = {"{", "for", "(", "id", "=", "num", ";", "num", "OR", "num", ";", "id", "44", ")", "{", "console", ".", "log", "(", "num", ")", ";", "}", ";", "}", "$"};

    //private static String[] entrada = {"{", "while", "(", "num", "OR", "num", ")", "{", "for", "(", "id", "=", "num", ";", "num", "OR", "num", ";", "id", "44", ")", "{", "console", ".", "log", "(", "num", ")", ";", "}", ";", "}", ";", "}", "$"};
    private static String[] entrada = Pruebas.getPalabras();

    public static void main(String[] args) {
        genPos();

        imprime();
        while (!entrada[0].equals("$") && pila.length != 1) {
            if (pila[pila.length - 1].contains("<")) {
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
        return pos.get(s);
    }

    private static void genPos() {
        // Filas
        pos.put("<programa>", 0);
        pos.put("<sentencias>", 1);
        pos.put("<sent_2>", 2);
        pos.put("<s_leer>", 3);
        pos.put("<s_write>", 4);
        pos.put("<s_w2>", 5);
        pos.put("<s_declaracion>", 6);
        pos.put("<s_dec2>", 7);
        pos.put("<s_asig>", 8);
        pos.put("<s_asig2>", 9);
        pos.put("<exp>", 10);
        pos.put("<exp_1>", 11);
        pos.put("<exp_2>", 12);
        pos.put("<exp_3>", 13);
        pos.put("<s_concat>", 14);
        pos.put("<s_concat2>", 15);
        pos.put("<s_concat3>", 16);
        pos.put("<s_concat_cadenas>", 17);
        pos.put("<s_concat_cadenas2>", 18);
        pos.put("<condicion>", 19);
        pos.put("<condicion_2>", 20);
        pos.put("<s_if>", 21);
        pos.put("<s_elif>", 22);
        pos.put("<s_else>", 23);
        pos.put("<s_for>", 24);
        pos.put("<s_inc>", 25);
        pos.put("<s_inc_2>", 26);
        pos.put("<s_while>", 27);
        pos.put("<s_dowhile>", 28);
        pos.put("<s_call>", 29);
        pos.put("<s_call_params>", 30);
        pos.put("<s_call_params_1>", 31);
        // pos.put("s_call_multi_params", 29);
        pos.put("<s_function>", 32);
        pos.put("<s_params>", 33);
        pos.put("<s_params_1>", 34);
        pos.put("<s_params2>", 35);

        //Columnas
        pos.put("id", 0);
        pos.put("(", 1);
        pos.put(")", 2);
        pos.put("t_dato", 3);
        pos.put("+", 4);
        pos.put("{", 5);
        pos.put("read", 6);
        pos.put("console", 7);
        pos.put("null", 8);
        pos.put("num", 9);
        pos.put("cadena", 10);
        pos.put("OL", 11);
        pos.put("while", 12);
        pos.put("!", 13);
        pos.put("for", 14);
        pos.put("43", 15);
        pos.put("36", 16);
        pos.put("if", 17);
        pos.put("else", 18);
        pos.put("44", 19);
        pos.put("45", 20);
        pos.put("do", 21);
        pos.put("idFuncion", 22);
        pos.put("funcion", 23);
        pos.put(",", 24);
        pos.put("}", 25);
        pos.put(";", 26);
        pos.put("OR", 27);
    }
}
