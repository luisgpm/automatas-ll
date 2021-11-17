/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author alanm
 */
public class Postfijo {

    private static final HashMap<String, Integer> JERARQUIA = new HashMap<>();

    private static final Object[][] MAP_JER = {
        {"|", 1},
        {"&", 2},
        {"!", 3},
        {"=", 4},
        {"==", 4},
        {">", 4},
        {"<", 4},
        {">=", 4},
        {"<=", 4},
        {"!=", 4},
        {"+", 5},
        {"-", 5},
        {"*", 6},
        {"/", 6},
        {"^", 7},
        {"(", 9},
        {")", 9}
    };

    /**
     * Metodo que convierte una expresion infija a postfija
     *
     * @param expresion Arraylist que contiene los lexemas con su numero de
     * token, renglon y columna
     * @return retorna el ArrayList ordenado para evaluarlo
     */
    public static ArrayList<Lexema> convertirPostfijo(ArrayList<Lexema> expresion) {

        if (expresion.get(0).getToken().equals("46") || expresion.get(0).getToken().equals("24")
                || expresion.get(0).getToken().equals("14")) {
            return expresion;
        }

        /**
         * Asignar a un HashMap la jerarquia de cada operador
         */
        mapJerarquia();

        /**
         * Pila donde se amacenaran temporalmente los operadores y lista donde
         * se almacenara la salida
         */
        Stack<Lexema> operadores = new Stack<>();
        ArrayList<Lexema> salida = new ArrayList<>();

        /**
         * Temporal token, lexema
         */
        String lexema;
        String token;

        /**
         * Recorrer la tabla para convertir a notación postfija la expresión
         */
        for (Lexema simbolo : expresion) {

            lexema = simbolo.getLexema();
            token = simbolo.getToken();

            /**
             * Si el token es un numero o una variable lo inserta en la lista de
             * salida
             */
            if (token.equals("43") || token.equals("48") || token.equals("41")) {

                salida.add(simbolo);

                /**
                 * Si el token es un parentesis de apertura "(" lo inserta en la
                 * pila de operadores
                 */
            } else if (token.equals("28")) {

                operadores.push(simbolo);

                /**
                 * Si el token es un operador, comprobar los operadores que hay
                 * en la pila e irlos sacando
                 */
            } else if (token.equals("36") || token.equals("39") || token.equals("37") || token.equals("38")) {

                while (!operadores.isEmpty() && !operadores.peek().getLexema().equals("(")
                        && esDeMayorPre(lexema, operadores.peek().getLexema())) {
                    salida.add(operadores.pop());
                }

                operadores.add(simbolo);

                /**
                 * Si el token es un parentesis de cierre ")" sacar hasta que el
                 * primer elemento de la pila sea un parentesis de apertura o
                 * hasta que la pila este vacia
                 */
            } else if (token.equals("29")) {

                while (!operadores.isEmpty() && !operadores.peek().getLexema().equals("(")) {
                    salida.add(operadores.pop());
                }

                if (!operadores.isEmpty()) {
                    if (operadores.peek().getLexema().equals("(")) {
                        operadores.pop();
                    }
                }

            }

        }

        /**
         * Mientras la pila de operadores no este vacia sacar los operadores y
         * meterlos a la lista de salida
         */
        while (!operadores.isEmpty()) {
            salida.add(operadores.pop());
        }

        return salida;

    }

    /**
     * Compara si el operador2 es de mayor precedencia que el operador1.
     *
     * @param operador1 operador 1
     * @param operador2 operador 2
     * @return true si el operador2 es de mayor o igual precedencia, false si
     * no.
     */
    private static boolean esDeMayorPre(String operador1, String operador2) {
        int precedenciaOperador1 = JERARQUIA.get(operador1);
        int precedenciaOperador2 = JERARQUIA.get(operador2);

        if (precedenciaOperador1 <= precedenciaOperador2) {
            return true;
        }
        return false;

    }

    /**
     * Evalua operaciones en notacion postfija
     *
     * @param expresionPostfija
     * @param tabla Tabla a la que pertenece la expresion
     * @param indice Indice que ocupa el simbolo dentro de la tabla
     * @return
     */
    public static Lexema evaluar(ArrayList<Simbolo> tabla, ArrayList<Lexema> expresionPostfija, int indice, TablaSimbolo ts) {

        /**
         * Pila de operadores y operandos
         */
        Stack<Lexema> operadores = new Stack<>();
        Stack<Lexema> operandos = new Stack<>();

        for (Lexema termino : expresionPostfija) {

            if (termino.getToken().equals("43") || termino.getToken().equals("48")
                    || termino.getToken().equals("14") || termino.getToken().equals("24")) {
                operandos.push(termino);
            } else if (termino.getToken().equals("41")) {

                int pos = Simbolo.buscarEnTabla(tabla, termino.getLexema());

                Simbolo s = buscarVariable(ts, termino.getLexema());

                if (s != null) {

                    Simbolo simbolo = s;
                    Lexema res = simbolo.getValorEvaluado();

                    if (res == null) {

                        ArrayList<Lexema> valorEnLexema = simbolo.getValorEnLexemas();
                        res = evaluar(tabla, valorEnLexema, pos, ts);

                    }

                    simbolo.setValorEvaluado(res);
                    operandos.push(res);

                } else {
                    tabla.get(indice).setError("Variables no declaradas");
                }

            } else if (termino.getToken().equals("36") || termino.getToken().equals("39")
                    || termino.getToken().equals("37")) {
                operadores.push(termino);

                if (operandos.size() >= 2) {

                    Lexema terminoDerecha = operandos.pop();
                    Lexema terminoIzquierda = operandos.pop();
                    Lexema operador = operadores.pop();

                    Lexema resultado = operacion(terminoIzquierda, terminoDerecha, operador);
                    operandos.push(resultado);

                }

            }

        }

        return operandos.pop();
    }

    /**
     * Metodo para evaluar las operaciones aritmeticas de una tabla de simbolos
     *
     * @param tablaSimbolos
     */
    public static void evaluarTabla(TablaSimbolo ts, ArrayList<Simbolo> tablaSimbolos) {

        ArrayList<Lexema> valorVariable;

        for (Simbolo simbolo : tablaSimbolos) {

            valorVariable = simbolo.getValorEnLexemas();

            if (valorVariable.size() == 1 && valorVariable.get(0).getToken().equals("46")) {

                simbolo.setValorEvaluado(valorVariable.get(0));

            } else {

                /**
                 * Indice del simbolo en la tabla
                 */
                int indiceSimbolo = tablaSimbolos.indexOf(simbolo);

                Lexema valorEvaluado = evaluar(tablaSimbolos, valorVariable, indiceSimbolo, ts);
                simbolo.setValorEvaluado(valorEvaluado);

            }

            /**
             * Comprobar que el resultado y el tipo de dato sean compatibles
             */
            setError(simbolo);

        }
    }

    /**
     * Compara entre el tipo de dato y el valor cuando se evalua, pone error si
     * el tipo de dato y el valor son incompatibles
     *
     * @param s Simbolo a comprobar
     */
    private static void setError(Simbolo s) {

        String error = s.getError();
        boolean existeError = false;

        if (s.getTipoDato().equals("string") && !s.getValorEvaluado().getToken().equals("46")) {

            existeError = true;

        } else if (s.getTipoDato().equals("int") && !s.getValorEvaluado().getToken().equals("43")) {

            existeError = true;

        } else if (s.getTipoDato().equals("double") && !s.getValorEvaluado().getToken().equals("48")) {

            existeError = true;

        }

        if (existeError) {
            if (!error.equals("")) {
                s.setError(error + " --- " + Simbolo.ERRORES[3]);
            } else {
                s.setError(Simbolo.ERRORES[3]);
            }
        }

    }

    private static void mapJerarquia() {
        for (Object[] op : MAP_JER) {
            JERARQUIA.put((String) op[0], (Integer) op[1]);
        }
    }

    /**
     * Evaluar operaciones aritmeticas
     *
     * @param operadorIzquierda operador izquierda
     * @param operadorDerecha operador derecha
     * @param operador operador
     * @return Resultado en lexema
     */
    public static Lexema operacion(Lexema operadorIzquierda, Lexema operadorDerecha, Lexema operador) {
        String ope = operador.getLexema();

        if (operador.getToken().equals("37")) {

            boolean opeI = Boolean.parseBoolean(operadorIzquierda.getLexema());
            boolean opeD = Boolean.parseBoolean(operadorDerecha.getLexema());

            return operacionLogica2(opeI, opeD, operador);

        }

        double opeI = Double.parseDouble(operadorIzquierda.getLexema());
        double opeD = Double.parseDouble(operadorDerecha.getLexema());

        if (operador.getToken().equals("39")) {
            return operacionLogica(opeI, opeD, operador);
        }

        double res;

        switch (ope) {
            case "+":
                res = opeI + opeD;
                break;
            case "-":
                res = opeI - opeD;
                break;
            case "*":
                res = opeI * opeD;
                break;
            case "/":
                res = opeI / opeD;
                break;
            default:
                System.err.println("Error al evaluar");
                return null;
        }

        if (res % 1 == 0) {
            int res2 = (int) (res);
            return new Lexema(Integer.toString(res2), operadorIzquierda.getRenglon(), operadorIzquierda.getRenglon(), "43");
        }

        return new Lexema(Double.toString(res), operadorIzquierda.getRenglon(), operadorIzquierda.getRenglon(), "48");

    }

    /**
     * Evaluar operaciones logicas
     *
     * @param operadorIzquierda operador izquierda
     * @param operadorDerecha operador derecha
     * @param operador operador
     * @return Resultado en lexema
     */
    private static Lexema operacionLogica(double operadorIzquierda, double operadorDerecha, Lexema operador) {

        Lexema res = new Lexema("", operador.getRenglon(), operador.getColumna(), "");
        boolean resultado = false;

        switch (operador.getLexema()) {
            case ">":
                resultado = operadorIzquierda > operadorDerecha;
                break;
            case ">=":
                resultado = operadorIzquierda >= operadorDerecha;
                break;
            case "<":
                resultado = operadorIzquierda < operadorDerecha;
                break;
            case "<=":
                resultado = operadorIzquierda <= operadorDerecha;
                break;
            default:
                res.setError(Simbolo.ERRORES[3]);
        }

        if (resultado) {
            res.setLexema("true");
            res.setToken("24");
        } else {
            res.setLexema("false");
            res.setToken("14");
        }

        return res;

    }

    private static Lexema operacionLogica2(boolean operadorIzquierda, boolean operadorDerecha, Lexema operador) {

        Lexema res = new Lexema("", operador.getRenglon(), operador.getColumna(), "");
        boolean resultado = false;

        switch (operador.getLexema()) {
            case "&":
                resultado = operadorIzquierda && operadorDerecha;
                break;
            case "|":
                resultado = operadorIzquierda || operadorDerecha;
                break;
            default:
        }

        if (resultado) {
            res.setLexema("true");
            res.setToken("24");
        } else {
            res.setLexema("false");
            res.setToken("14");
        }

        return res;

    }

    public static Simbolo buscarVariable(TablaSimbolo ts, String var) {

        for (Simbolo variable : ts.getVariables()) {
            if (variable.getVariable().equals(var)) {
                return variable;
            }
        }

        TablaSimbolo padre = ts.getTablaPadre();

        if (padre != null) {
            return buscarVariable(padre, var);
        }

        return null;

    }
}
