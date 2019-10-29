/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tree;
import Tree.Arbol;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ColaPrioridad.QueueImpl;
/**
 *
 * @author sande
 */
public class Program extends javax.swing.JFrame {
    private Arbol tree;
    private Nodo raiz;
    /**
     * Creates new form Program
     */
    public Program() throws FileNotFoundException, IOException {
        initComponents();
        this.tree = new Arbol();
         
        QueueImpl<String> colaLinks = new QueueImpl<String>();
        lector jsonReafer = new lector();
        
        colaLinks = jsonReafer.leer();
        TextExtractor extractor = new TextExtractor();
        String link = colaLinks.dequeue();
        
		do {
                    ArrayList<String> palabras = extractor.extraer(link);
                    for(int word =0; word< palabras.size();word++){
                        boolean encontrada = false;
                       try{  
                        Palabra buscada = tree.buscar(palabras.get(word));
                        if (buscada!=null){
                          encontrada = true;  
                          buscada.addOcurrencia(link);
                        }
                       }catch(NullPointerException e){}
                       
                       if (!encontrada){
                        tree.insertar(palabras.get(word), link);
                        }
                        }
                        link = colaLinks.dequeue();
		}while(link != null);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ingresoPalabra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buscarPorPalabra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 0));
        setResizable(false);

        ingresoPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoPalabraActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese la palabra a buscar:");

        buscarPorPalabra.setText("BUSCAR POR NOMBRE");
        buscarPorPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorPalabraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ingresoPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarPorPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(ingresoPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(buscarPorPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresoPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoPalabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoPalabraActionPerformed

    private void buscarPorPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorPalabraActionPerformed
        // TODO add your handling code here:
        String palabra = ingresoPalabra.getText();
        Palabra word = tree.buscar(palabra);
        if (word!=null){
        String Aux[] = new String[word.getLinks().size()];
        for (int link = 0; link <  word.getLinks().size(); link++ ){
            Aux[link] = word.getLinks().get(link);
        }
        Busqueda pantallaBusqueda = new Busqueda(Aux);
        pantallaBusqueda.setVisible(true);
        }else{
         JOptionPane.showMessageDialog(null, "No se encontro la palabra", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarPorPalabraActionPerformed


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
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Program().setVisible(true);
                } catch (IOException ex) {
                    
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error, verifique su conexion a internet y que las librerias esten correctamente instaladas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPorPalabra;
    private javax.swing.JTextField ingresoPalabra;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
