/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermedio;

import java.util.ArrayList;
import lexema.Lexema;
import postfijo.Postfijo;

/**
 *
 * @author alan
 */
public class Etiqueta {

    /**
     * Sentencias
     */
    public static final int SENT_IF = 0;
    public static final int SENT_ELSE_IF = 1;
    public static final int SENT_FOR = 2;
    public static final int SENT_ELSE = 3;
    public static final int SENT_WHILE = 4;

    private static int contador = 5;

    private int eTrue;
    private int eFalse;
    private int eSig;
    private int eInicio;

    private int sentencia;

    /**
     * Solo para for
     */
    private ArrayList<Lexema> variable;
    private ArrayList<Lexema> condicion;
    private ArrayList<Lexema> aumento;

    public Etiqueta() {
        
    }

    public Etiqueta(int sentencia) {

        this.sentencia = sentencia;
        if (sentencia == SENT_IF) {
            eSig = contador;
            eTrue = (contador += 5);
            eFalse = (contador += 5);
        } else if (sentencia == SENT_WHILE) {
            eInicio = (contador += 5);
            eTrue = (contador += 5);
            eFalse = (contador += 5);
        }
    }

    public Etiqueta(int sentencia, Etiqueta anterior) {
        this.sentencia = sentencia;
        if (sentencia == SENT_ELSE) {
            eFalse = anterior.geteFalse();
            eSig = anterior.geteSig();
        }
        if (sentencia == SENT_ELSE_IF) {
            eTrue = (contador += 5);
            eFalse = (contador += 5);
            eSig = anterior.geteSig();
        }

    }

    public Etiqueta(ArrayList<Lexema> variable, ArrayList<Lexema> condicion, ArrayList<Lexema> aumento) {
        this.sentencia = SENT_FOR;
        this.variable = variable;
        this.condicion = condicion;
        this.aumento = aumento;
        /**
         *
         */
        eInicio = (contador += 5);
        eTrue = (contador += 5);
        eFalse = (contador += 5);
    }

    public int geteTrue() {
        return eTrue;
    }

    public void seteTrue(int eTrue) {
        this.eTrue = eTrue;
    }

    public int geteFalse() {
        return eFalse;
    }

    public void seteFalse(int eFalse) {
        this.eFalse = eFalse;
    }

    public int geteSig() {
        return eSig;
    }

    public void seteSig(int eSig) {
        this.eSig = eSig;
    }

    public int geteInicio() {
        return eInicio;
    }

    public void seteInicio(int eInicio) {
        this.eInicio = eInicio;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int aContador) {
        contador = aContador;
    }

    public void printEnc(ArrayList<Lexema> condicion) {

        if (this.sentencia == SENT_IF) {
            System.out.println("");
            ArrayList<Lexema> condicionAux = Postfijo.convertirPostfijo((ArrayList<Lexema>) condicion.clone());

            ArrayList<Cuadrupla> c = Cuadrupla.generaCuadrupla(condicionAux);
//            optimizacionCodigo.Optimizacion.optimizaCuadrupla(c, 3);
//            Pruebas.listaCuadruplas.add(c);
            Cuadrupla.printCuadruplas(c);

            System.out.println("");

            String res = c.get(c.size() - 1).getResultado().getLexema();

            System.out.println("if " + res + " goto " + eTrue);
            System.out.println("goto " + eFalse);
            System.out.println(eTrue + ":");
        } else if (this.sentencia == SENT_WHILE) {
            System.out.println("");
            ArrayList<Lexema> condicionAux = Postfijo.convertirPostfijo((ArrayList<Lexema>) condicion.clone());
            ArrayList<Cuadrupla> c = Cuadrupla.generaCuadrupla(condicionAux);
//            optimizacionCodigo.Optimizacion.optimizaCuadrupla(c, 3);
            //Pruebas.listaCuadruplas.add(c);
            Cuadrupla.printCuadruplas(c);
            System.out.println("");
            String res = c.get(c.size() - 1).getResultado().getLexema();

            System.out.println(eInicio + ":");
            System.out.println("if " + res + " goto " + eTrue);
            System.out.println("goto " + eFalse);
            System.out.println(eTrue + ":");
        } else if (this.sentencia == SENT_FOR) {
            System.out.println("");
            ArrayList<Lexema> condicionAux = Postfijo.convertirPostfijo((ArrayList<Lexema>) this.condicion.clone());
            ArrayList<Cuadrupla> c = Cuadrupla.generaCuadrupla(condicionAux);
//            optimizacionCodigo.Optimizacion.optimizaCuadrupla(c, 3);
            //Pruebas.listaCuadruplas.add(c);
            Cuadrupla.printCuadruplas(c);
            System.out.println("");

            String res = c.get(c.size() - 1).getResultado().getLexema();

            System.out.println(getVariable());
            System.out.println(eInicio + ":");
            System.out.println("if " + res + " goto " + eTrue);
            System.out.println("goto " + eFalse);
            System.out.println(eTrue + ":");

        } else if (this.sentencia == SENT_ELSE_IF) {

            System.out.println("if " + getCondicionEnPostfijo(condicion) + " goto " + eTrue);
            System.out.println("goto " + eFalse);
            System.out.println(eTrue + ":");
        }

    }

    public void printFin(ArrayList<Lexema> programa, int pos) {
        if (this.sentencia == SENT_IF) {
            if (pos != programa.size() - 1) {
                if (programa.get(pos + 1).getLexema().equals("else")) {
                    System.out.println("goto " + eSig);
                }
            }
            System.out.println(eFalse + ":");
        } else if (this.sentencia == SENT_ELSE) {
            System.out.println(eSig + ":");
        } else if (this.sentencia == SENT_WHILE) {

            System.out.println("goto " + eInicio);
            System.out.println(eFalse + ":");

        } else if (this.sentencia == SENT_FOR) {

            System.out.println(getAumento());
            System.out.println("goto " + eInicio);
            System.out.println(eFalse + ":");

        } else if (this.sentencia == SENT_ELSE_IF) {

            System.out.println("goto " + eSig);
            System.out.println(eFalse + ":");
        }
    }

    public String getCondicionEnPostfijo(ArrayList<Lexema> condicion) {
        ArrayList<Lexema> condicionPostfijo = Postfijo.convertirPostfijo(condicion);

        String cond = "";

        for (Lexema lexema : condicionPostfijo) {
            cond += lexema.getLexema();
        }

        return cond;
    }

    public String getVariable() {
        String var = "";
        for (int i = 1; i < variable.size() - 1; i++) {
            var += variable.get(i).getLexema();
        }

        return var;
    }

    public String getAumento() {
        if (Lexema.compareTo(aumento, variable.get(1).getLexema() + "++")) {
            return variable.get(1).getLexema() + "=" + variable.get(1).getLexema() + "+1";
        }
        return "";
    }

    public int getSentencia() {
        return sentencia;
    }

    public void setSentencia(int sentencia) {
        this.sentencia = sentencia;
    }
}
