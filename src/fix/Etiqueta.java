/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fix;

/**
 *
 * @author Alan
 */
public class Etiqueta {

    private static int nEtiqueta = 5;

    public static final int IF = 1;
    public static final int ELSE = 2;
    public static final int ELSE_IF = 3;
    public static final int FOR = 4;
    public static final int WHILE = 5;

    public static int getnEtiqueta() {
        return nEtiqueta;
    }

    public static void setnEtiqueta(int anEtiqueta) {
        nEtiqueta = anEtiqueta;
    }

    private int tipoSent;
    private int eInit;
    private int eSig;
    private int eTrue;
    private int eFalse;

    public Etiqueta(int tipoSent, Etiqueta anterior) {
        this.tipoSent = tipoSent;

        if (tipoSent == IF) {

            eSig = nEtiqueta;
            eTrue = nEtiqueta + 5;
            eFalse = nEtiqueta + 10;

            nEtiqueta = nEtiqueta + 15;

        } else if (tipoSent == ELSE) {

            eSig = anterior.eSig;
            eFalse = anterior.eFalse;

        } else if (tipoSent == WHILE) {

            eInit = nEtiqueta;
            eTrue = nEtiqueta + 5;
            eFalse = nEtiqueta + 10;
            nEtiqueta += 15;

        } else if (tipoSent == FOR) {
            eInit = nEtiqueta;
            eTrue = nEtiqueta + 5;
            eFalse = nEtiqueta + 10;
            nEtiqueta += 15;
        }

    }

    public int getTipoSent() {
        return tipoSent;
    }

    public void setTipoSent(int tipoSent) {
        this.tipoSent = tipoSent;
    }

    public int geteInit() {
        return eInit;
    }

    public void seteInit(int eInit) {
        this.eInit = eInit;
    }

    public int geteSig() {
        return eSig;
    }

    public void seteSig(int eSig) {
        this.eSig = eSig;
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
