/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efinal;

import java.util.ArrayList;
import lexema.Lexema;

/**
 *
 * @author Alan
 */
public class Stream {

    public static ArrayList<Lexema> getListLexemas(String file) {
        return lexema.Lexema.getTablaLexema(file);
    }

}
