/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso10;


import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author sande
 */
public class SistemaTuverias extends JFrame {
    private Arbol arbolSistema;
    private JTree interfaz;
    private DefaultTreeModel modelo;
    private DefaultMutableTreeNode hijo;
    private DefaultMutableTreeNode nieto;
    private TreeNode nodoRaiz;
    private DefaultTreeModel model;
    private double aguaDisponible;
    
    public SistemaTuverias(){
    }
    
    public void expandAll() {
        int row = 0;
        while (row < interfaz.getRowCount()) {
          interfaz.expandRow(row);
          row++;
        }
    }
    
// Creación de los datos para el JTree. Un padre, con hijos y nietos.
    public void verTree(Arbol tree){
            arbolSistema = tree;
            
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(tree.getRaiz().getNombre());
                nodoRaiz = raiz;
                modelo = new DefaultTreeModel(raiz);
                model = modelo;
                agregarHijos(raiz);
		JFrame ventana = new JFrame("Sistema de tuverias");
		JTree arbol = new JTree(modelo);
                //arbol.setEditable(true);
                interfaz = arbol;
             
		ventana.getContentPane().add(arbol);
                DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)arbol.getCellRenderer();
                render.setLeafIcon(new ImageIcon("Tuveria.png"));
                render.setOpenIcon(new ImageIcon("Tuveria.png"));
                render.setClosedIcon(new ImageIcon("Tuveria.png"));
               //Expandimos el arbol
                int row = 0;
                while (row < arbol.getRowCount()) {
                arbol.expandRow(row);
                row++;
                }
                
                ventana.setResizable(false);
                ventana.pack();
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ventana.setSize(new Dimension(1190, 650));
                arbol.setSize(new Dimension(1190, 650));
                
	}
        //Agrega a la interfaz si el nodo ess hijo de la interfaz
        public void agregarHijos(DefaultMutableTreeNode raiz){                
            Nodo pNodo = arbolSistema.getRaiz();
            ArrayList<Nodo> aux =  pNodo.getHijos();
        for (int sensorActual = 0; sensorActual < pNodo.getNumHijos(); sensorActual++){
            //se inicia lo mismo con los hijos
             hijo = new DefaultMutableTreeNode(aux.get(sensorActual).getNombre());
            modelo.insertNodeInto(hijo, raiz, sensorActual);
            agregarNietos(hijo, aux.get(sensorActual), aux.get(sensorActual).getHijos(), sensorActual);
           

        }
        }
        //Agrega a la interfaz si el nodo padre es un hijo de los hijos de la raiz
        public void agregarNietos(DefaultMutableTreeNode pPadre,Nodo padre,ArrayList<Nodo> hermanos,int numeroPadre){
            
            for (int sensorActual = 0; sensorActual < padre.getNumHijos(); sensorActual++){
                
            //se inicia lo mismo con los hijos
            
            nieto = new DefaultMutableTreeNode(hermanos.get(sensorActual).getNombre());
  
            modelo.insertNodeInto(nieto, hijo, 0);
  
            
            agregarNietos2(nieto, hermanos.get(sensorActual), hermanos.get(sensorActual).getHijos(), numeroPadre);
            }
        }
        //Agrega a la interfaz si el nod padre esta en los nietos de los hijos de la raiz
        public void agregarNietos2(DefaultMutableTreeNode pPadre,Nodo padre,ArrayList<Nodo> hermanos,int numeroPadre){
            
            for (int sensorActual = 0; sensorActual < padre.getNumHijos(); sensorActual++){  
            DefaultMutableTreeNode nieto1 = new DefaultMutableTreeNode(hermanos.get(sensorActual).getNombre());
            modelo.insertNodeInto(nieto1, nieto, 0);
            agregarNietos2(nieto, hermanos.get(sensorActual), hermanos.get(sensorActual).getHijos(), numeroPadre);
            }
        }
        public void seleccion(JTree arbol, SistemaTuverias systTree){
        		
            // Nos suscribimos a la seleccion de un nodo en el arbol.
            arbol.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
		
		public void valueChanged(TreeSelectionEvent e) {
				
                    // Obtenemos y escribimos en pantalla  el path seleccionado
                    TreePath path = e.getPath();
                    Object [] nodos = path.getPath();
				
                        // Mirando el ultimo nodo del path, sabemos qué nodo en concreto se ha seleccionado
			DefaultMutableTreeNode ultimoNodo = (DefaultMutableTreeNode)nodos[nodos.length-1];
                        new GestionSensores(ultimoNodo,systTree,interfaz,interfaz.getSelectionPath(), model, arbolSistema).setVisible(true);
                        
			// Por ejemplo, para ver si se ha seleccionado el "hijo1"...
			if (ultimoNodo.getUserObject().equals("hijo1")){
                            // Necesitamos el modeloSeleccion para saber si "hijo1" se ha
                            // seleccionado o deseleccionado.
                            DefaultTreeSelectionModel modeloSeleccion = (DefaultTreeSelectionModel)e.getSource();
                            if (modeloSeleccion.isPathSelected(path))
                                System.out.println("Has seleccionado hijo 1");
                            else
                                System.out.println("Has deseleccionado hijo 1");
			} 
		}
		
            });
            JTree tree = arbol;

            MouseListener mlistener = new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    // Se obtiene el path para esa fila. Con el path podemos obtener
                    // los nodos.
                    TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                  
                        
                }
            };
            tree.addMouseListener(mlistener);
        }
        public JTree getArbol(){
            return interfaz;
        }
        public TreeNode getRaiz(){
            return nodoRaiz;
        }
        public void verificarConsumo(){
            GestionSensores getionAux = new GestionSensores();
            aguaDisponible = getionAux.ponerConsumo(nodoRaiz.toString());
            for(int sensor=0; sensor < nodoRaiz.getChildCount(); sensor++){
                aguaDisponible = getionAux.ponerConsumo(nodoRaiz.getChildAt(sensor).toString()) - aguaDisponible;
                if (aguaDisponible < 0 ){
                    JOptionPane.showMessageDialog(null, "Se sobrepaso el agua disponible de la planta.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //nodoRaiz.getChildAt(sensor).cambiar icono
                }
                for(int sens=0; sens < nodoRaiz.getChildAt(sensor).getChildCount(); sens++){
                    vrifConsuHijos(nodoRaiz.getChildAt(sensor));
                }
            }
        }
        public void vrifConsuHijos(TreeNode hijo){
            GestionSensores getionAux = new GestionSensores();
            for(int sensor=0; sensor < hijo.getChildCount(); sensor++){
                aguaDisponible = getionAux.ponerConsumo(hijo.getChildAt(sensor).toString()) - aguaDisponible;
                if (aguaDisponible < 0 ){
                    JOptionPane.showMessageDialog(null, "Se sobrepaso el agua disponible de la planta.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //hijo.getChildAt(sensor).
                }
                for(int sens=0; sens < hijo.getChildAt(sensor).getChildCount(); sens++){
                    vrifConsuHijos(hijo.getChildAt(sensor));
                }
            }
        }
}
