/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexema;

/**
 *
 * @author Alan
 */
public interface LexConst {

    /**
     * Constante de numero
     */
    public static final int NUMERO = 1;

    /**
     * Constante de numero entero
     */
    public static final int NUMERO_ENTERO = 2;

    /**
     * Constante de numero real
     */
    public static final int NUMERO_REAL = 3;

    /**
     * Constante de variable
     */
    public static final int VARIABLE = 4;

    /**
     * Contstante de numero o variable
     */
    public static final int NUMERO_VARIABLE = 5;

    /**
     * Constante de cadena
     */
    public static final int STRING = 6;

    /**
     * Constante de operador logico, aritmetico o relacional
     */
    public static final int OPERADOR = 7;

    /**
     * Constante de operador aritmetico / * - +
     */
    public static final int OPERADOR_ARITMETICO = 8;

    /**
     * Constante de operador logico & |
     */
    public static final int OPERADOR_LOGICO = 9;

    /**
     * Constante de operador relacional > < >= <= != ==
     */
    public static final int OPERADOR_RELACIONAL = 10;

    /**
     * Constante de operador de asignacion = += -=
     */
    public static final int OPERADOR_ASIGNACION = 11;

    /**
     * Constante de tipo de dato String int double
     */
    public static final int TIPO_DATO = 12;

    /**
     * Constante de sentencia if
     */
    public static final int SENT_IF = 13;

    /**
     * Constante de sentencia ELSE
     */
    public static final int SENT_ELSE = 15;

    /**
     * Constante de sentencia while
     */
    public static final int SENT_WHILE = 16;

    /**
     * Constante de sentencia read
     */
    public static final int SENT_READ = 17;

    /**
     * Constante de sentencia write
     */
    public static final int SENT_WRITE = 18;

    /**
     * Constante de sentencia write string
     */
    public static final int SENT_WRITES = 19;

    /**
     * Constante de sentencia FOR
     */
    public static final int SENT_FOR = 20;

    /**
     * Constante de llave de cierre }
     */
    public static final int LLAVE_CIERRE = 14;

}
