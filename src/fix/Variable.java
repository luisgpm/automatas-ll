/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fix;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Variable {

    private Lexema id;
    private Lexema valor;
    private ArrayList<Lexema> valorLexemas;

    public Variable(Lexema id, Lexema valor) {
        this.id = id;
        this.valor = valor;
    }

    public Lexema getId() {
        return id;
    }

    public ArrayList<Lexema> getValorLexemas() {
        return valorLexemas;
    }

    public Lexema getValor() {
        return valor;
    }

    public void setValor(Lexema valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        String v = "null";
        if (valor != null) {
            v = valor.getLexema();
        }
        return id.getLexema() + "  " + v;
    }

}
