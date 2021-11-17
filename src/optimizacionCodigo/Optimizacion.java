/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizacionCodigo;

import intermedio.Cuadrupla;
import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Optimizacion {

    /**
     * Eliminar duplicados, nulos, etc
     *
     * @param cuadruplas tabla de cuadruplas
     * @param rounds numero de pasadas
     */
    public static void optimizaCuadrupla(ArrayList<Cuadrupla> cuadruplas, int rounds) {

        for (int i = 0; i < rounds; i++) {
            eliminarDuplicados(cuadruplas);
            eliminarOperacionesNulas(cuadruplas);
        }

    }

    /**
     * Eliminar duplicados de un ArrayList Ej. (+,a,1,T1), (+,a,1,T3)
     *
     * @param cuadruplas ArrayList de cuadruplas
     */
    private static void eliminarDuplicados(ArrayList<Cuadrupla> cuadruplas) {
        ArrayList<Integer> pos = new ArrayList<>();
        /**
         * Eliminar duplicados
         */
        for (int i = 0; i < cuadruplas.size(); i++) {
            if (!(i + 1 >= cuadruplas.size())) {
                for (int j = i + 1; j < cuadruplas.size(); j++) {
                    if (Cuadrupla.comparar(cuadruplas.get(i), cuadruplas.get(j))) {
                        pos.add(j);
                    }
                }
                for (int j = 0; j < pos.size(); j++) {
                    Lexema temporal = cuadruplas.remove((int) pos.get(j)).getResultado();
                    remplazar(cuadruplas, temporal, cuadruplas.get(i).getResultado());
                }
                pos.clear();
            }
        }
    }

    /**
     * Eliminar operaciones nulas como (+,0,a,T10) o (*,0,a,T10) o (*,1,a,T10)
     *
     * @param cuadruplas ArrayList de cuadruplas
     */
    private static void eliminarOperacionesNulas(ArrayList<Cuadrupla> cuadruplas) {

        Lexema res;
        Lexema oper;
        Lexema op1;
        Lexema op2;

        for (int i = 0; i < cuadruplas.size(); i++) {

            if (!(i + 1 >= cuadruplas.size())) {
                
                res = cuadruplas.get(i).getResultado();
                oper = cuadruplas.get(i).getOperacion();
                op1 = cuadruplas.get(i).getOperando1();
                op2 = cuadruplas.get(i).getOperando2();

                if ((oper.getLexema().equals("+") || oper.getLexema().equals("-") || oper.getLexema().equals("*"))
                        && (op1.getLexema().equals("0") || op2.getLexema().equals("0"))) {

                    cuadruplas.remove(i);
                    if (op1.getLexema().equals("0")) {
                        remplazar(cuadruplas, res, op2);
                    } else {
                        remplazar(cuadruplas, res, op1);
                    }

                } else if (oper.getLexema().equals("*")
                        && (op1.getLexema().equals("1") || op2.getLexema().equals("1"))) {

                    cuadruplas.remove(i);
                    if (op1.getLexema().equals("1")) {
                        remplazar(cuadruplas, res, op2);
                    } else {
                        remplazar(cuadruplas, res, op1);
                    }

                } else if (oper.getLexema().equals("/") && op2.getLexema().equals("1")) {
                    cuadruplas.remove(i);
                    remplazar(cuadruplas, res, op1);
                } else if (op1.is(Lexema.NUMERO) && op2.is(Lexema.NUMERO)) {
                    cuadruplas.remove(i);
                    remplazar(cuadruplas, res, Postfijo.operacion(op1, op2, oper));
                }
            }
        }

    }

    /**
     * Remplaza todas las coincidencias de X por Y
     *
     * @param cuadruplas ArrayList de cuadruplas
     * @param x coincidencias a remplazar
     * @param y por lo que se remplazara
     */
    private static void remplazar(ArrayList<Cuadrupla> cuadruplas, Lexema x, Lexema y) {
        for (Cuadrupla cuadrupla : cuadruplas) {

            if (Lexema.compareTo(cuadrupla.getOperando1(), x)) {
                cuadrupla.setOperando1(y);
            } else if (Lexema.compareTo(cuadrupla.getOperando2(), x)) {
                cuadrupla.setOperando2(y);
            }
        }
    }

}
