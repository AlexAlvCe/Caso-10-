/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso10;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Alexander
 */
public class GestionSensores extends javax.swing.JFrame {
    private DefaultMutableTreeNode nodoUltimo;
    private DefaultMutableTreeNode nodoExtra;
    private SistemaTuverias arbol;
    private JTree interfaz;
    private DefaultTreeModel modelo; 
    private Arbol arbolN_ario;
    
    public GestionSensores(DefaultMutableTreeNode ultimoNodo, SistemaTuverias tree, JTree pInterfaz,TreePath pPath, DefaultTreeModel model, Arbol n_ario) {
        nodoUltimo = ultimoNodo;
        arbol = tree;
        interfaz = pInterfaz;
        modelo = model;
        arbolN_ario = n_ario;
        //  nodoUltimo.get
        initComponents();
        this.setTitle(nodoUltimo.toString());
        this.setLocationRelativeTo(null);
        ponerConsumo(ultimoNodo.toString());
    }
    
    
    
    public GestionSensores() {
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreSensor = new javax.swing.JTextField();
        consumoSensor = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        labelConsumo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Sensor: ");
        setBackground(java.awt.Color.darkGray);
        setForeground(java.awt.Color.cyan);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del nuevo sensor:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Consumo del nuevo sensor: ");

        nombreSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreSensorActionPerformed(evt);
            }
        });

        consumoSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumoSensorActionPerformed(evt);
            }
        });

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" ingrese los datos del nuevo sensor aquí:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Si desea Agregar un nuevo Sensor bajo este:");

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        labelConsumo.setForeground(new java.awt.Color(255, 255, 255));
        labelConsumo.setText("Cosumo");
        labelConsumo.setFocusable(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cosumo del Sensor Selecionado: ");

        botonEliminar.setBackground(new java.awt.Color(153, 255, 102));
        botonEliminar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAgregar)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(labelConsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(consumoSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(botonEliminar))
                            .addComponent(jLabel2))
                        .addContainerGap(55, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRegresar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelConsumo)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(consumoSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreSensorActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nombreSensorActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
      // Se agrega el nuevo nodo al arbol de la interfaz y al arbol n-ario
      if(!"".equals(this.nombreSensor.getText().trim()) && !"".equals(this.consumoSensor.getText().trim())){
            String nombre = this.nombreSensor.getText().trim();
            double consumo = Double.parseDouble(this.consumoSensor.getText().trim());
            TreeNode raiz = arbol.getRaiz();
            boolean agregar = true;
            for (int numeroSensor=0; numeroSensor < raiz.getChildCount(); numeroSensor++){ 
                if(agregar){ 
                     modelo.insertNodeInto(new DefaultMutableTreeNode(nombre),nodoUltimo , numeroSensor);
                     agregar = false;
                }
            }
            arbolN_ario.agregarNodo(nodoUltimo.toString(), nombre, consumo);
            arbol.expandAll();
            dispose();
            arbol.verificarConsumo();
      }else{
          JOptionPane.showMessageDialog(null, "Debe Llenar ambos datos para continuar: ", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void consumoSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumoSensorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consumoSensorActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        try{
            nodoExtra =  nodoUltimo;
            nodoUltimo = (DefaultMutableTreeNode) nodoUltimo.getParent();
            TreeNode raiz = arbol.getRaiz();
            //Agregar los hijos al nodo padre
            for (int hijo = 0; hijo < nodoExtra.getChildCount();hijo++){
                String nombre= nodoExtra.getChildAt(hijo).toString();
                boolean agregar = true;
                for (int numeroSensor=0; numeroSensor < raiz.getChildCount(); numeroSensor++){ 
                    if(agregar){ 
                        DefaultMutableTreeNode nodoMovido = new DefaultMutableTreeNode(nombre);
                        //Agregamos de nuevo los hijos al nodo movido/
                        for (int child = 0; child < nodoExtra.getChildAt(hijo).getChildCount();child++){
                            nodoMovido.add((MutableTreeNode) nodoExtra.getChildAt(hijo).getChildAt(child));
                        }
                        modelo.insertNodeInto(nodoMovido,nodoUltimo , numeroSensor);
                        agregar = false;
                    }
                }
            } 
            DefaultTreeModel md = (DefaultTreeModel)interfaz.getModel();
            md.removeNodeFromParent((MutableTreeNode) nodoExtra);
            JOptionPane.showMessageDialog(null, "Se elimino el sensor: " + nodoExtra, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "El nodo selecciondo ya se elimino", "INFO", JOptionPane.INFORMATION_MESSAGE);
        }catch(NullPointerException e){
        JOptionPane.showMessageDialog(null, "El nodo selecionado no se puede eliminar o ya se elimino:  ", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IndexOutOfBoundsException e){
        }
        arbol.expandAll();
        //Eliminamos el objeto del arbol N-ario
        arbolN_ario.eliminarNodo(nodoExtra.toString());
        dispose();
    }//GEN-LAST:event_botonEliminarActionPerformed

 
//Pone el consumo correspondiente en el label de consumo si el nodo es de los hijos de la raiz
public double ponerConsumo(String sensorName){
        ArrayList<Nodo> lista = arbolN_ario.getRaiz().getHijos();
        for(int hijo = 0; hijo < arbolN_ario.getRaiz().getNumHijos(); hijo++){
            if (lista.get(hijo).getNombre().equals(sensorName)){
                double consumo = lista.get(hijo).getConsumo();
                labelConsumo.setText(String.valueOf(consumo));
                return consumo;
                
            }
            ArrayList<Nodo> listaAux = lista.get(hijo).getHijos();
            for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){                
                double consumo = ponerConsumo2(listaAux, sensorName);
                if (consumo != 0){
                    return consumo;
                } 
            }
        }
    if( sensorName.equals(arbolN_ario.getRaiz().getNombre())){
        labelConsumo.setText(String.valueOf(arbolN_ario.getRaiz().getConsumo()));
        return arbolN_ario.getRaiz().getConsumo();
        
    }
        return 0;
    

}
//pone el consumo correspondiente en el label de consumo si el nodo esta entre los hijos de los hijos de la raiz
public double ponerConsumo2(ArrayList<Nodo> comienza, String sensorName){
        ArrayList<Nodo> lista = comienza;
        for(int hijo = 0; hijo < lista.size(); hijo++){
            if (lista.get(hijo).getNombre().equals(sensorName)){
                double consumo = lista.get(hijo).getConsumo();
                labelConsumo.setText(String.valueOf(consumo));
                return consumo;
            }
            ArrayList<Nodo> listaAux = lista.get(hijo).getHijos();
            for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){
                double consumo = ponerConsumo2(listaAux, sensorName);
                if (consumo != 0 ){
                    return consumo;
                }
                
            }
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField consumoSensor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelConsumo;
    private javax.swing.JTextField nombreSensor;
    // End of variables declaration//GEN-END:variables
}
