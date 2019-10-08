/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso10;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Alexander
 */
public class GestionSensores extends javax.swing.JFrame {
    private DefaultMutableTreeNode nodoUltimo;
    private TreeNode nodoEstra;
    private SistemaTuverias arbol;
    private JTree interfaz;
    private TreePath path;
    private DefaultTreeModel modelo; 
    private Arbol arbolN_ario;
    public GestionSensores(DefaultMutableTreeNode ultimoNodo, SistemaTuverias tree, JTree pInterfaz,TreePath pPath, DefaultTreeModel model, Arbol n_ario) {
        nodoUltimo = ultimoNodo;
        arbol = tree;
        interfaz = pInterfaz;
        path = pPath;
        modelo = model;
        arbolN_ario = n_ario;
        //  nodoUltimo.get
        initComponents();
        this.setLocationRelativeTo(null);
        ponerConsumo(ultimoNodo.toString());
        
        //DefaultMutableTreeNode newHijo = new DefaultMutableTreeNode("pepe");
	//ultimoNodo.add(newHijo);
    }
    
    
    
    private GestionSensores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addContainerGap(83, Short.MAX_VALUE))))
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
       String nombre = this.nombreSensor.getText().trim();
       double consumo = Double.parseDouble(this.consumoSensor.getText().trim());
       System.out.println("se agrego "+nodoUltimo);
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
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        //interfaz.removeSelectionPath(path);
        //nodoEstra = nodoUltimo.getParent();
       // nodoUltimo.removeFromParent();
        //interfaz.remove(nodoUltimo);
      //  System.out.println("se elimino" + path);
        dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void consumoSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumoSensorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consumoSensorActionPerformed

 
//Pone el consumo correspondiente en el label de consumo si el nodo es de los hijos de la raiz
public void ponerConsumo(String sensorName){
    Nodo [] lista = arbolN_ario.getRaiz().getHijos();
        for(int hijo = 0; hijo < arbolN_ario.getRaiz().getNumHijos(); hijo++){
            if (lista[hijo].getNombre().equals(sensorName)){
                double consumo = lista[hijo].getConsumo();
                labelConsumo.setText(String.valueOf(consumo));
            }
            Nodo[] listaAux = lista[hijo].getHijos();
            for (int hij = 0; hij < lista[hijo].getNumHijos(); hij++){                
                ponerConsumo2(listaAux, sensorName);
            }
        }

}
//pone el consumo correspondiente en el label de consumo si el nodo esta entre los hijos de los hijos de la raiz
public void ponerConsumo2(Nodo[] comienza, String sensorName){
        Nodo [] lista = comienza;
        for(int hijo = 0; hijo < lista.length; hijo++){
            if (lista[hijo].getNombre().equals(sensorName)){
                double consumo = lista[hijo].getConsumo();
                labelConsumo.setText(String.valueOf(consumo));
            }
            Nodo[] listaAux = lista[hijo].getHijos();
            for (int hij = 0; hij < lista[hijo].getNumHijos(); hij++){
                ponerConsumo2(listaAux, sensorName);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
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
