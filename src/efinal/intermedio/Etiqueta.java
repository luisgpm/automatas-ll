/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efinal.intermedio;

/**
 *
 * @author Alan
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

    public static int contadorEtiquetas = 5;

    private int eTrue;
    private int eFalse;
    private int eNext;

    private int eInicio;

    public Etiqueta(Etiqueta anterior, int sentencia) {

        if (sentencia == SENT_IF) {
            this.eTrue = contadorEtiquetas;
            this.eFalse = contadorEtiquetas + 5;
            this.eNext = contadorEtiquetas + 10;
            contadorEtiquetas += 15;
        } else if (sentencia == SENT_ELSE_IF) {
            this.eTrue = contadorEtiquetas;
            this.eFalse = contadorEtiquetas + 5;
            this.eNext = anterior.eNext;
            contadorEtiquetas += 10;
        } else if (sentencia == SENT_WHILE) {
            eInicio = contadorEtiquetas;
            eTrue = contadorEtiquetas + 5;
            eTrue = contadorEtiquetas + 10;
            contadorEtiquetas += 15;
        }

    }

    public int geteNext() {
        return eNext;
    }

    public void seteNext(int eNext) {
        this.eNext = eNext;
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

}
