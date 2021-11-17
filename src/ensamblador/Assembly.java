///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ensamblador;
//
//import intermedio.Cuadrupla;
//import intermedio.Pruebas;
//import java.util.ArrayList;
//
///**
// *
// * @author alanm
// */
//public class Assembly {
//
//    public static ArrayList<Cuadrupla> variables = Pruebas.variablesEncabezado;
//    public static ArrayList<ArrayList<Cuadrupla>> cuadruplas = Pruebas.listaCuadruplas;
//
//    public static final String encabezado = "TITLE operaciones"
//            + "\n.MODEL SMALL"
//            + "\n.STACK 64"
//            + "\n.DATA";
//
//    public static final String codigo = ".CODE";
//    public static final String fin = ".EXIT";
//    public static final String defWord = ":var DW ?";
//
//    public static final String suma = "MOV AX, :var1"
//            + "\nMOV CX, :var2"
//            + "\nADD AX,CX"
//            + "\nMOV :res, AX";
//
//    public static final String resta = "MOV AX, :var1"
//            + "\nMOV CX, :var2"
//            + "\nSUB AX,CX"
//            + "\nMOV :res, AX";
//
//    public static final String multiplicacion = "MOV AX, :var1"
//            + "\nMOV CX, :var2"
//            + "\nMUL CX"
//            + "\nMOV :res, AX";
//
//    public static final String convertirAscii = "MOV AX,:var"
//            + "\nADD AX,48"
//            + "\nMOV :var,AX";
//
//    public static final String imprNum = "MOV DX,:var"
//            + "\nMOV AH,2"
//            + "\nINT 21h";
//
//    public static void toAssembly(ArrayList<Cuadrupla> cuadruplas) {
//        String aux;
//        System.out.println(encabezado + "\n");
//        for (int i = 0; i < variables.size(); i++) {
//            System.out.println(defWord.replace(":var", cuadruplas.get(i).getResultado().getLexema()));
//        }
//        System.out.println("\n" + codigo + "\n");
//        for (int i = 0; i < cuadruplas.size(); i++) {
//            if (cuadruplas.get(i).getOperacion().getLexema().equals("+")) {
//                aux = suma.replace(":var1", cuadruplas.get(i).getOperando1().getLexema());
//                aux = aux.replace(":var2", cuadruplas.get(i).getOperando2().getLexema());
//                aux = aux.replace(":res", cuadruplas.get(i).getResultado().getLexema());
//                System.out.println(aux + "\n");
//            } else if (cuadruplas.get(i).getOperacion().getLexema().equals("-")) {
//                aux = resta.replace(":var1", cuadruplas.get(i).getOperando1().getLexema());
//                aux = aux.replace(":var2", cuadruplas.get(i).getOperando2().getLexema());
//                aux = aux.replace(":res", cuadruplas.get(i).getResultado().getLexema());
//                System.out.println(aux + "\n");
//            } else if (cuadruplas.get(i).getOperacion().getLexema().equals("*")) {
//                aux = multiplicacion.replace(":var1", cuadruplas.get(i).getOperando1().getLexema());
//                aux = aux.replace(":var2", cuadruplas.get(i).getOperando2().getLexema());
//                aux = aux.replace(":res", cuadruplas.get(i).getResultado().getLexema());
//                System.out.println(aux + "\n");
//            }
//        }
//        String convA = convertirAscii.replace(":var", cuadruplas.get(cuadruplas.size() - 1).getResultado().getLexema());
//        System.out.println(convA + "\n");
//
//        String imp = imprNum.replace(":var", cuadruplas.get(cuadruplas.size() - 1).getResultado().getLexema());
//        System.out.println(imp + "\n");
//
//        System.out.println(fin);
//
//    }
//
//    public static void addVariables() {
//        for (ArrayList<Cuadrupla> cua : cuadruplas) {
//            for (Cuadrupla c : cua) {
//                if (c.getResultado() != null) {
//                    variables.add(c);
//                }
//            }
//        }
//    }
//
//}
