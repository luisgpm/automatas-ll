/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import static automatas.Automatas.table;
import intermedio.Cuadrupla;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import lexema.Lexema;
import postfijo.Postfijo;
import postfijo.Simbolo;
import postfijo.TablaSimbolo;

/**
 *
 * @author luisg
 */
public class Timer extends javax.swing.JFrame {

    /**
     * Creates new form Timer
     */
    String archivo = "fuentes/declaraciones.txt";


    
    public Timer() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaContenido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel1.setText("Tiempos de ejecucion");

        jToggleButton1.setText("Ejecutar Metodos");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Metodo", "tiempo inicio ", "Tiempo fin", "tiempo en Mili"
            }
        ));
        jScrollPane1.setViewportView(tablaContenido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jToggleButton1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
        tiempoLecturaArch();
        tiempoEjecucionSeparaPalabra();
        ejecucionTablaLexemas();
        ejecucionTablaSimbolos();
        ejecucionPostFijo();
        ejecuconObtenerPostfijo();
        ejecutarObtenerCuadruplas();
        
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    
    
    public void tiempoLecturaArch(){
        long tiempo_inicio = 0;
        long tiempo_fin = 0;
        long tiempo_transcurrido = 0;
        DefaultTableModel model = (DefaultTableModel) tablaContenido.getModel();
        tiempo_inicio = System.currentTimeMillis();
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer(archivo);
        tiempo_fin = System.currentTimeMillis();
        tiempo_transcurrido = tiempo_fin - tiempo_inicio;
        model.addRow(new Object[]{"Lectura archivo", tiempo_inicio, tiempo_fin, tiempo_transcurrido});  
    }
    
    public void tiempoEjecucionSeparaPalabra(){
        long tiempo_inicio = 0;
        long tiempo_fin = 0;
        long tiempo_transcurrido = 0;
        DefaultTableModel model = (DefaultTableModel) tablaContenido.getModel();
        tiempo_inicio = System.currentTimeMillis();
        ArrayList<String> lineas = separarPalabras.SeparaPalabras.leer(archivo);
        ArrayList<Lexema> temp = separarPalabras.SeparaPalabras.separa(lineas);
        tiempo_fin = System.currentTimeMillis();
        tiempo_transcurrido = tiempo_fin - tiempo_inicio;
        model.addRow(new Object[]{"separa palabras", tiempo_inicio, tiempo_fin, tiempo_transcurrido});
    }
    
    public void ejecucionTablaLexemas(){
        long tiempo_inicio = 0;
        long tiempo_fin = 0;
        long tiempo_transcurrido = 0;
        DefaultTableModel model = (DefaultTableModel) tablaContenido.getModel();
        tiempo_inicio = System.currentTimeMillis();
        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("fuentes/declaraciones.txt");
        tiempo_fin = System.currentTimeMillis();
        tiempo_transcurrido = tiempo_fin - tiempo_inicio;
        model.addRow(new Object[]{"Tabla lexemas", tiempo_inicio, tiempo_fin, tiempo_transcurrido});
    }
    
    public void ejecucionTablaSimbolos(){
        long tiempo_inicio = 0;
        long tiempo_fin = 0;
        long tiempo_transcurrido = 0;
        DefaultTableModel model = (DefaultTableModel) tablaContenido.getModel();
        tiempo_inicio = System.currentTimeMillis();
        ArrayList<Lexema> tablaLexema = Lexema.getTablaLexema("fuentes/declaraciones.txt");
        TablaSimbolo tablaGlobal = Simbolo.getTablasDeSimbolos(tablaLexema);
        tiempo_fin = System.currentTimeMillis();
        tiempo_transcurrido = tiempo_fin - tiempo_inicio;
        model.addRow(new Object[]{"Tabla Simbolos", tiempo_inicio, tiempo_fin, tiempo_transcurrido});
    }
    
    public void ejecucionPostFijo(){
        long tiempo_inicio = 0;
        long tiempo_fin = 0;
        long tiempo_transcurrido = 0;
        DefaultTableModel model = (DefaultTableModel) tablaContenido.getModel();
        tiempo_inicio = System.currentTimeMillis();
        ArrayList<Lexema> fuente = Lexema.getTablaLexema("post");
        tiempo_fin = System.currentTimeMillis();
        tiempo_transcurrido = tiempo_fin - tiempo_inicio;
        model.addRow(new Object[]{"obtener tabla post", tiempo_inicio, tiempo_fin, tiempo_transcurrido});
    }
    
    public void ejecuconObtenerPostfijo(){
        long tiempo_inicio = 0;
        long tiempo_fin = 0;
        long tiempo_transcurrido = 0;
        DefaultTableModel model = (DefaultTableModel) tablaContenido.getModel();
        ArrayList<Lexema> fuente = Lexema.getTablaLexema("post");
        tiempo_inicio = System.currentTimeMillis();
        fuente = Postfijo.convertirPostfijo(fuente);
        tiempo_fin = System.currentTimeMillis();
        tiempo_transcurrido = tiempo_fin - tiempo_inicio;
        model.addRow(new Object[]{"Convertir a postfijo", tiempo_inicio, tiempo_fin, tiempo_transcurrido});
        
    }
    
    public void ejecutarObtenerCuadruplas(){
        long tiempo_inicio = 0;
        long tiempo_fin = 0;
        long tiempo_transcurrido = 0;
        DefaultTableModel model = (DefaultTableModel) tablaContenido.getModel();
        tiempo_inicio = System.currentTimeMillis();
        ArrayList<Lexema> fuente = Lexema.getTablaLexema("post");
        fuente = Postfijo.convertirPostfijo(fuente);
        ArrayList<Cuadrupla> cuadruplas = Cuadrupla.generaCuadrupla(fuente);
        tiempo_fin = System.currentTimeMillis();
        tiempo_transcurrido = tiempo_fin - tiempo_inicio;
        model.addRow(new Object[]{"Obtener Cuadruplas", tiempo_inicio, tiempo_fin, tiempo_transcurrido});

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Timer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tablaContenido;
    // End of variables declaration//GEN-END:variables
}