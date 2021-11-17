/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fix;

import intermedio.Cuadrupla;
import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Ensamblador {

    private static String encabezado = "org 100h\n"
            + "\ninclude \"emu8086.inc\""
            + "\ninclude \"macros.inc\"\n"
            + "\nTITLE ProgramaASM"
            + "\n.MODEL lange"
            + "\n.STACK 64"
            + "\n.DATA\n";
    private static String code = "\n.CODE\n";
    private static String exit = "\n.EXIT";

    public static void toAssembly(ArrayList<Variable> variables, ArrayList<Cuadrupla> cuadruplas) {
        System.out.println(encabezado);
        printVariables(variables);
        System.out.println(code);
        printCode(cuadruplas);
        System.out.println(exit);
    }

    public static void printVariables(ArrayList<Variable> variables) {
        for (Variable variable : variables) {
            if (variable.getValor() == null) {
                System.out.println(variable.getId().getLexema() + " DW ?");
            } else if (variable.getValor().is(Lexema.STRING)) {
                System.out.println(variable.getId().getLexema() + " DB 10,13," + variable.getValor().getLexema() + ",'$'");

            }
        }
    }

    public static void printCode(ArrayList<Cuadrupla> cuadruplas) {
        for (Cuadrupla cuadrupla : cuadruplas) {
            if (cuadrupla.getResultado() != null) {
                if (cuadrupla.getOperacion().is(Lexema.OPERADOR_ARITMETICO)) {
                    switch (cuadrupla.getOperacion().getLexema()) {
                        case "+":
                            System.out.println("suma " + cuadrupla.getOperando1().getLexema()
                                    + ", " + cuadrupla.getOperando2().getLexema()
                                    + ", " + cuadrupla.getResultado().getLexema());
                            break;
                        case "-":
                            System.out.println("resta " + cuadrupla.getOperando1().getLexema()
                                    + ", " + cuadrupla.getOperando2().getLexema()
                                    + ", " + cuadrupla.getResultado().getLexema());
                            break;
                        case "*":
                            System.out.println("multiplicacion " + cuadrupla.getOperando1().getLexema()
                                    + ", " + cuadrupla.getOperando2().getLexema()
                                    + ", " + cuadrupla.getResultado().getLexema());
                            break;
                        case "/":
                            System.out.println("division " + cuadrupla.getOperando1().getLexema()
                                    + ", " + cuadrupla.getOperando2().getLexema()
                                    + ", " + cuadrupla.getResultado().getLexema());
                            break;

                    }
                } else if (cuadrupla.getOperacion().is(Lexema.OPERADOR_ASIGNACION)) {
                    System.out.println("asignar " + cuadrupla.getOperando1().getLexema() + ", "
                            + cuadrupla.getResultado().getLexema());

                } else if (cuadrupla.getOperacion().is(Lexema.SENT_WRITE)) {
                    System.out.println("printNum " + cuadrupla.getOperando1().getLexema());

                } else if (cuadrupla.getOperacion().is(Lexema.SENT_WRITES)) {
                    System.out.println("printString " + cuadrupla.getOperando1().getLexema());
                } else if (cuadrupla.getOperacion().is(Lexema.SENT_READ)) {
                    System.out.println("leerNum " + cuadrupla.getOperando1().getLexema());
                }
            } else if (cuadrupla.getEtiqueta() != null) {
                if (cuadrupla.getOperacion() != null && cuadrupla.getOperacion().is(Lexema.OPERADOR_RELACIONAL)) {
                    System.out.println("CMP " + cuadrupla.getOperando1().getLexema() + ", " + cuadrupla.getOperando2().getLexema());
                    switch (cuadrupla.getOperacion().getLexema()) {
                        case "==":
                            System.out.println("JE " + cuadrupla.getEtiqueta().replace("gt ", ""));
                            break;
                        case "!=":
                            System.out.println("JNE " + cuadrupla.getEtiqueta().replace("gt ", ""));
                            break;
                        case ">=":
                            System.out.println("JGE " + cuadrupla.getEtiqueta().replace("gt ", ""));
                            break;
                        case "<=":
                            System.out.println("JLE " + cuadrupla.getEtiqueta().replace("gt ", ""));
                            break;
                        case ">":
                            System.out.println("JG " + cuadrupla.getEtiqueta().replace("gt ", ""));
                            break;
                        case "<":
                            System.out.println("JL " + cuadrupla.getEtiqueta().replace("gt ", ""));
                            break;

                    }
                } else {
                    if (cuadrupla.getEtiqueta().contains("gt")) {
                        System.out.println(cuadrupla.getEtiqueta().replace("gt", "JMP"));
                    } else {
                        System.out.println(cuadrupla.getEtiqueta() + ":");
                    }
                }
            }
        }
    }

}
