/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

import java.util.ArrayList;
import java.util.Stack;
import lexema.Lexema;

/**
 *
 * @author alan
 */
public class Cuadrupla {

    public static final int SENT_IF = 1;

    private static int contadorTemporales = 1;

    public static int getContadorTemporales() {
        return contadorTemporales;
    }

    public static void setContadorTemporales(int aContadorTemporales) {
        contadorTemporales = aContadorTemporales;
    }

    private Lexema operacion;
    private Lexema operando1;
    private Lexema operando2;
    private Lexema resultado;

    /**
     * *
     * Variables de cuadruplas de sentencias
     */
//    private int sentencia;
    private String etiqueta;

    /**
     * Constructor para condiciones
     *
     * @param operacion
     * @param operando1
     * @param operando2
     * @param sentencia
     * @param etiqueta
     */
    public Cuadrupla(Lexema operacion, Lexema operando1, Lexema operando2, /*int sentencia,*/ String etiqueta) {
        this.operacion = operacion;
        this.operando1 = operando1;
        this.operando2 = operando2;
//        this.sentencia = sentencia;
        this.etiqueta = etiqueta;
    }

    public Cuadrupla(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Cuadrupla(Lexema operacion, Lexema operando1, Lexema operando2, Lexema resultado) {
        this.operacion = operacion;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
    }

    public Lexema getOperacion() {
        return operacion;
    }

    public void setOperacion(Lexema operacion) {
        this.operacion = operacion;
    }

    public Lexema getOperando1() {
        return operando1;
    }

    public void setOperando1(Lexema operando1) {
        this.operando1 = operando1;
    }

    public Lexema getOperando2() {
        return operando2;
    }

    public void setOperando2(Lexema operando2) {
        this.operando2 = operando2;
    }

    public Lexema getResultado() {
        return resultado;
    }

    public void setResultado(Lexema resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        String op = "";
        String op1 = "";
        String op2 = "";
        String res = "";

        if (operacion != null) {
            op = operacion.getLexema();
        }
        if (operando1 != null) {
            op1 = operando1.getLexema();
        }
        if (operando2 != null) {
            op2 = operando2.getLexema();
        }
        if (resultado != null) {
            res = resultado.getLexema();
        }

        if (etiqueta != null) {
            return " Operando1 " + op1 + " Operacion " + op + "  Operando2 " + op2 + " Etiqueta " + etiqueta;
        }

        return "Resultado " + res + " Operando1 " + op1 + " Operacion " + op + "  Operando2 " + op2;
    }

    /**
     * Generar un ArrayList con las cuadruplas de une expresion
     *
     * @param expresion condicion en postfijo de la que se obtendren las
     * cuadruplas
     * @return ArrayList con las cuadruplas de la expresion
     */
    public static ArrayList<Cuadrupla> generaCuadrupla(ArrayList<Lexema> expresion) {

        /**
         * Copia de la condicion
         *
         * ArrayList de cuadruplas a generar
         */
        ArrayList<Lexema> expresionCopy = (ArrayList<Lexema>) expresion.clone();
        ArrayList<Cuadrupla> cuadruplas = new ArrayList<>();

        /**
         * Pila de operadores y operandos
         */
        Stack<Lexema> operadores = new Stack<>();
        Stack<Lexema> operandos = new Stack<>();

        Lexema operadorIzquierda;
        Lexema operadorDerecha;
        Lexema operador;
        Lexema aux;

        for (Lexema lexema : expresionCopy) {

            if (lexema.is(Lexema.NUMERO_VARIABLE)) {
                operandos.push(lexema);

            } else if (lexema.is(Lexema.OPERADOR)) {
                operadores.push(lexema);

                if (operandos.size() >= 2) {

                    operador = operadores.pop();
                    operadorDerecha = operandos.pop();
                    operadorIzquierda = operandos.pop();

                    aux = new Lexema("T" + contadorTemporales, 0, 0, "41");
                    operandos.push(aux);
                    cuadruplas.add(new Cuadrupla(operador, operadorIzquierda, operadorDerecha, aux));

                    contadorTemporales++;

                }

            }
        }

        return cuadruplas;

    }

    public static void printCuadruplas(ArrayList<Cuadrupla> cuadruplas) {
        for (Cuadrupla cuadrupla : cuadruplas) {
            System.out.println(cuadrupla);
        }
    }

    /**
     * Comparar si 2 cuadruplas son iguales operandos y operacion
     *
     * @param c1 cuadrupla 1
     * @param c2 cuadrupla 2
     * @return true si son iguales
     */
    public static boolean comparar(Cuadrupla c1, Cuadrupla c2) {

        if (c1.operacion.getLexema().equals(c2.operacion.getLexema())
                && (c1.operacion.getLexema().equals("*") || c1.operacion.getLexema().equals("+"))) {
            if (c1.operando1.getLexema().equals(c2.getOperando2().getLexema())
                    && c1.operando2.getLexema().equals(c2.getOperando1().getLexema())) {
                return true;
            }
        }

        return c1.operacion.getLexema().equals(c2.operacion.getLexema()) && c1.operando1.getLexema()
                .equals(c2.operando1.getLexema()) && c1.operando2.getLexema()
                .equals(c2.operando2.getLexema());
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

}
