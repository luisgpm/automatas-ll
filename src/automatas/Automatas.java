/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.HashMap;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Automatas {

    // Agregar el automata de llamada a metodos abc.abc.abc
    public static String[][] tabla = {
        /* {M,   m,   N,    -,      CE,  /,   *,     .,    ",    OA,     OL, OR,     PR,   ',  EAc, TOKEN} */
        {"S1", "S1", "S8", "S11", "E0", "S3", "E0", "E0", "S13", "E0", "E0", "E0", "E0", "S15", "0", "E0"},
        {"S1", "S1", "S1", "S2", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "41"}, // VARIABLES
        {"E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "44"}, // CLASES
        {"E0", "E0", "E0", "E0", "E0", "S4", "S5", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "42"}, // COMENTARIOS
        {"S4", "S4", "S4", "E0", "S4", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "42"}, // COMENTARIOS
        {"S5", "S5", "S5", "E0", "S5", "E0", "S6", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "S7", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "42"}, // COMENTARIOS
        {"E0", "E0", "S8", "E0", "E0", "E0", "E0", "S9", "E0", "E0", "E0", "E0", "E0", "E0", "1", "43"}, // NUMEROS
        {"E0", "E0", "S10", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E0", "E0", "S10", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "48"}, // NUMEROS REALES
        {"S12", "S12", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"S12", "S120", "S12", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "45"}, // OBJETOS
        {"S13", "S13", "S13", "E0", "S13", "E0", "E0", "E0", "S14", "S13", "S13", "S13", "S13", "E0", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "46"}, // CADENAS
        {"S16", "S16", "S16", "E0", "S16", "E0", "E0", "E0", "E0", "S16", "S16", "E0", "E0", "E0", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "S17", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "1", "47"} // CARACTERES
    };

    public static String[][] table = new String[][]{
        {"S1", "S1", "S8", "S11", "E0", "S3", "E0", "E0", "S13", "E0", "E0", "E0", "E0", "S15", "0", "E0"},
        {"S1", "S1", "S1", "S2", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "E1", "1", "41"}, // Variables
        {"E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "E2", "1", "44"}, // Clases
        {"E3 ", "E3", "E3", "E3", "E3", "S4", "S5", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "1", "42"}, // Comentarios
        {"S4", "S4", "S4", "E3", "S4", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "1", "42"}, // Comentarios
        {"S5", "S5", "S5", "E0", "S5", "E0", "S6", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "S7", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "E3", "1", "42"}, // Comentarios
        {"E4", "E4", "S8", "E4", "E4", "E4", "E4", "S9", "E4", "E4", "E4", "E4", "E4", "E4", "1", "43"}, // Numeros
        {"E5", "E5", "S10", "E0", "E0", "E0", "E0", "E5", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"E5", "E5", "S10", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "E5", "1", "48"}, // Numeros reales
        {"S12", "S12", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "0", "E0"},
        {"S12", "S12", "S12", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "E6", "1", "45"}, // Objetos
        {"S13", "S13", "S13", "E0", "S13", "E0", "E0", "E0", "S14", "S13", "S13", "S13", "S13", "E0", "0", "E7"},
        {"E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "E7", "1", "46"}, // Cadenas
        {"S16", "S16", "S16", "E0", "S16", "E0", "E0", "E0", "E0", "S16", "S16", "E0", "E0", "E0", "0", "E0"},
        {"E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "E0", "S17", "0", "E0"},
        {"E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "E8", "1", "47"} // Caracteres
    };

    // E0 Caracter no valido
    // E1 Error se esperaba una variable
    // E2 Error se esperaba un nombre de clase
    // E3 Error se esperaba un nombre de comentario
    // E4 Error se esperaba un numero
    // E5 Error se esperaba un numero real
    // E6 Error se esperaba un objeto
    // E7 Error se esperaba una cadena
    // E8 Error se esperaba un caracter
    public static HashMap<String, Integer> alfabetoMap = map("M,m,N,-,CE,/,*,.,\",OA,OL,OR,PR,\'");
    public static HashMap<String, Integer> estadoMap = map("S0,S1,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20");

    public static final String MAYUS = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z, ";
    public static final String MINUS = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z, ";
    public static final String NUMBER = "0,1,2,3,4,5,6,7,8,9";

    private static final String[][] TIPOS_DATO = {
        {"1", "String"},
        {"1", "int"},
        {"1", "double"},
        {"1", "boolean"},
        {"1", "char"}
    };

    private static final String[][] PALABRAS_RES = {
        {"2", "function"},
        {"3", "absctract"},
        {"4", "boolean"},
        {"5", "if"},
        {"6", "else"},
        {"7", "for"},
        {"8", "case"},
        {"9", "catch"},
        {"10", "const"},
        {"11", "default"},
        {"12", "delete"},
        {"13", "export"},
        {"14", "false"},
        {"15", "final"},
        {"16", "this"},
        {"17", "switch"},
        {"18", "while"},
        {"19", "null"},
        {"20", "return"},
        {"21", "package"},
        {"22", "super"},
        {"23", "this"},
        {"24", "true"},
        {"25", "void"},
        {"26", "new"},
        {"console", "console"},
        {"log", "log"},
        {".", "."},
        {"27", "document"},
        {"501", "read"},
        {"502", "write"}
    };

    private static final String[][] CARACTERES_ESP = {
        {"28", "("},
        {"29", ")"},
        {"30", ","},
        {"31", ":"},
        {"32", "["},
        {"33", "]"},
        {"33", "{"},
        {"33", "}"},
        {"33", ";"},
        {"33", "$"}
    };

    private static final String[][] CLASES_PREDE = {
        {"34", "ResultSet"},
        {"34", "Connection"},
        {"34", "Statement"}
    };

    private static final String[][] FUN_DEF = {
        {"35", "execute"},
        {"35", "on"},
        {"35", "getParameter"},
        {"35", "setParameter"}
    };

    private static final String[][] OPE_ARIT = {
        {"36", "+"},
        {"36", "-"},
        {"36", "*"},
        {"36", "/"},
        {"36", "%"},
        {"36", "^"}
    };

    private static final String[][] OPE_LOG = {
        {"37", "&"},
        {"37", "|"},
        {"38", "~"},
        {"38", "!"}
    };

    private static final String[][] OPE_REL = {
        {"39", "<"},
        {"39", ">"},
        {"39", "<="},
        {"39", ">="},
        {"39", "!="},
        {"39", "=="}
    };

    private static final String[][] OPE_ASIG = {
        {"40", "="},
        {"40", "+="},
        {"40", "-="},
        {"40", "*="},
        {"40", "/="},};

    public static final String[][][] TOKEN_FIJOS = {TIPOS_DATO, PALABRAS_RES, CARACTERES_ESP, CLASES_PREDE, FUN_DEF, OPE_ARIT, OPE_LOG,
        OPE_REL, OPE_ASIG};

    public static void validaPalabra(Lexema cad) {
        boolean error = false;
        String estado = "S0";
        int renglon = 0;
        int columna = 0;
        try {
            if (!isTokenFijo(cad)) {
                for (int i = 0; i < cad.getLexema().length(); i++) {
                    renglon = estadoMap.get(estado);
                    columna = getSecondPos("" + cad.getLexema().charAt(i));
                    estado = table[renglon][columna];
                    if (estado.contains("E")) {
                        error = true;
                        break;
                    }
                }
                if (estado.contains("E") || table[estadoMap.get(estado)][15].contains("E")) {
                    error = true;
                }
                if (!error) {
//                    System.out.println(cad + " Token: " + table[estadoMap.get(estado)][15] + " Renglón: " + renglon + " Columna: " + columna);
                    cad.setToken(table[estadoMap.get(estado)][15]);
                } else {
                    isError(estado, renglon, columna);
                }
            }
        } catch (Exception e) {
            System.err.println("Caracter no valido");
        }
    }

    public static boolean isError(String estado, int renglon, int columna) {
        if (estado.contains("E")) {
            switch (estado) {
                case "E0":
                    System.err.print("Error carácter no valido");
                    break;
                case "E1":
                    System.err.print("Error se esperaba una variable");
                    break;
                case "E2":
                    System.err.print("Error se esperaba un nombre de clase");
                    break;
                case "E3":
                    System.err.print("Error se esperaba un nombre de comentario ");
                    break;
                case "E4":
                    System.err.print("Error se esperaba un número entero");
                    break;
                case "E5":
                    System.err.print("Error se esperaba un número real");
                    break;
                case "E6":
                    System.err.print("Error se esperaba un objeto");
                    break;
                case "E7":
                    System.err.print("Error se esperaba una cadena");
                    break;
                case "E8":
                    System.err.print("Error se esperaba un carácter");
                    break;
                default:
                    System.err.print("Error desconocido");
            }
            System.err.println(" Renglón: " + renglon + " Columna: " + columna);
            return true;
        }
        return false;
    }

    public static void valida(Lexema l) {
        if (!isTokenFijo(l)) {
            String estado = "S0";
            boolean error = false;
            Integer renglon = 0;
            Integer columna = 0;
            for (int i = 0; i < l.getLexema().length(); i++) {
                renglon = estadoMap.get(estado);
                columna = getSecondPos("" + l.getLexema().charAt(i));
                if (renglon == null || columna == null) {
                    l.setError("E0");
                    error = true;
                    break;
                } else if (estado.contains("E")) {
                    error = true;
                    l.setError(estado);
                    break;
                } else {
                    estado = tabla[renglon][columna];
                }
            }
            if (!error && !estado.contains("E")) {
                renglon = estadoMap.get(estado);
                String a = tabla[renglon][15];
                if (!a.contains("E")) {
                    l.setToken(a);
                } else {
                    l.setError(a);
                }

            }
            //               else {
//                l.setError(estado);
//            }

        }
    }

    public static boolean isTokenFijo(Lexema cad) {
        for (String[][] token_fijo : TOKEN_FIJOS) {
            for (String[] token : token_fijo) {
                if (token[1].equals(cad.getLexema())) {
                    cad.setToken(token[0]);
                    return true;
                }
            }
        }
        return false;
    }

    public static Integer getSecondPos(String c) {
        if (MAYUS.contains(c)) {
            return 0;
        } else if (MINUS.contains(c)) {
            return 1;
        } else if (NUMBER.contains(c)) {
            return 2;
        } else if (contains(c, CARACTERES_ESP)) {
            return 4;
        } else if (contains(c, OPE_ARIT)) {
            return 9;
        } else if (contains(c, OPE_LOG)) {
            return 10;
        } else if (contains(c, OPE_REL)) {
            return 11;
        } else if (contains(c, PALABRAS_RES)) {
            return 12;
        } else {
            return alfabetoMap.get(c);
        }
    }

    private static boolean contains(String c, String[][] arr) {
        for (String[] ar : arr) {
            if (ar[1].equals(c)) {
                return true;
            }
        }
        return false;
    }

    public static HashMap<String, Integer> map(String alfabeto) {
        String[] alfabetoAux = alfabeto.split(",");
        HashMap<String, Integer> tabAux = new HashMap<>();
        int x = 0;
        for (String alfabetoAux1 : alfabetoAux) {
            tabAux.put(alfabetoAux1.trim(), x);
            x++;
        }
        return tabAux;
    }

}
