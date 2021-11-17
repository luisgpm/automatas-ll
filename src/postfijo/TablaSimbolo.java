/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import lexema.Lexema;

/**
 * Clase para representar las tablas de simbolos
 *
 * @author alanm
 */
public class TablaSimbolo {

    private ArrayList<Lexema> lexemas;
    private ArrayList<Simbolo> variables;
    private ArrayList<TablaSimbolo> tablasHijas;
    private TablaSimbolo tablaPadre;
    
    DefaultTableModel modelo;
    

    public TablaSimbolo() {
        this.lexemas = new ArrayList<>();
        this.tablasHijas = new ArrayList<>();
        this.tablaPadre = null;
    }

    public TablaSimbolo(TablaSimbolo tablaPadre) {
        this.lexemas = new ArrayList<>();
        this.tablasHijas = new ArrayList<>();
        this.tablaPadre = tablaPadre;
    }

    public ArrayList<Simbolo> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Simbolo> variables) {
        this.variables = variables;
    }

    public ArrayList<TablaSimbolo> getTablasHijas() {
        return tablasHijas;
    }

    public void setTablasHijas(ArrayList<TablaSimbolo> tablasHijas) {
        this.tablasHijas = tablasHijas;
    }

    public ArrayList<Lexema> getLexemas() {
        return lexemas;
    }

    public void setLexemas(ArrayList<Lexema> lexemas) {
        this.lexemas = lexemas;
    }

    public void setTablaHija(TablaSimbolo tablaHija) {
        this.tablasHijas.add(tablaHija);
    }

    public TablaSimbolo getTablaPadre() {
        return tablaPadre;
    }

    public void setTablaPadre(TablaSimbolo tablaPadre) {
        this.tablaPadre = tablaPadre;
    }

    public void imprime(int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }

        System.out.println("------------------------------------------------------------------------"
                + "------------------------------------------------------------------------");

        for (Simbolo s : variables) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            System.out.println(s);
            for (int i = 0; i < nivel; i++) {
                System.out.print("\t");
            }
            System.out.println("------------------------------------------------------------------------"
                    + "------------------------------------------------------------------------");
        }

        for (TablaSimbolo hija : tablasHijas) {
            hija.imprime(nivel + 1);
        }
    }
    public void imprimeTextArea(int nivel, JTextArea txt) {
        for (int i = 0; i < nivel; i++) {
            txt.append("\t");
        }
        txt.append("------------------------------------------------------------------------"
                + "------------------------------------------------------------------------\n");
        for (Simbolo s : variables) {
            for (int i = 0; i < nivel; i++) {
                txt.append("\t");
            }
            txt.append(s.toString()+"\n");
            for (int i = 0; i < nivel; i++) {
                txt.append("\t");
            }
            txt.append("------------------------------------------------------------------------"
                    + "------------------------------------------------------------------------\n");
        }
        for (TablaSimbolo hija : tablasHijas) {
            hija.imprimeTextArea(nivel + 1,txt);
        }
    }
   

}
