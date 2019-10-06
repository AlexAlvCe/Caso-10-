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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author sande
 */
public class SistemaTuverias extends JFrame {
    private Arbol arbolSistema;
    private DefaultTreeModel modelo;
    public SistemaTuverias(){
    }
    // Creación de los datos para el JTree. Un padre, con hijo1 e hijo2. hijo1 tiene
		// ademas un nieto.
    public void verTree(Arbol tree){
            //System.out.println(tree.getRaiz().getConsumo());
            arbolSistema = tree;
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(tree.getRaiz().getNombre());
                modelo = new DefaultTreeModel(raiz);
                
                agregarHijos(raiz);
        
                /*
		DefaultMutableTreeNode hijo1 = new DefaultMutableTreeNode("dd");
		DefaultMutableTreeNode hijo2 = new DefaultMutableTreeNode("hijo2");
		DefaultMutableTreeNode nieto1 = new DefaultMutableTreeNode("mexico");
                DefaultMutableTreeNode sensor = new DefaultMutableTreeNode("Alajuela");
                DefaultMutableTreeNode sensor1= new DefaultMutableTreeNode("perez");
                DefaultMutableTreeNode sensor2 = new DefaultMutableTreeNode("sa mano");
                DefaultMutableTreeNode sensor3 = new DefaultMutableTreeNode("mama");
		
		modelo.insertNodeInto(hijo1, raiz, 0);
		modelo.insertNodeInto(hijo2, raiz, 1);
		modelo.insertNodeInto(nieto1, hijo1, 0);
                modelo.insertNodeInto(sensor, nieto1, 0);
                modelo.insertNodeInto(sensor1, sensor, 0);
                modelo.insertNodeInto(sensor2, sensor, 0);
                modelo.insertNodeInto(sensor3, sensor, 0);*/
		
		// Creacion y visualizacion de la ventana
		JFrame v = new JFrame("Sistema de tuverias");
		JTree arbol = new JTree(modelo);
             
		v.getContentPane().add(arbol);
                DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)arbol.getCellRenderer();
                render.setLeafIcon(new ImageIcon("Tuveria.png"));
                render.setOpenIcon(new ImageIcon("Tuveria.png"));
                render.setClosedIcon(new ImageIcon("Tuveria.png"));
		 //  v.setSize(900, 300);
                //arbol.setSize(900, 300);
                
                v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                v.setSize(new Dimension(1190, 650));
                arbol.setSize(new Dimension(1190, 650));
		/*
		// Nos suscribimos a la seleccion de un nodo en el arbol.
		arbol.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
		
			public void valueChanged(TreeSelectionEvent e) {
				
				// Obtenemos y escribimos en pantalla  el path seleccionado
				TreePath path = e.getPath();
				Object [] nodos = path.getPath();
				System.out.print("Path seleccionado: ");
				for (Object nodo: nodos)
					System.out.print (nodo.toString() + " | ");
				System.out.println("");
				
				// Mirando el ultimo nodo del path, sabemos qué nodo en concreto
				// se ha seleccionado.
				DefaultMutableTreeNode ultimoNodo = 
					(DefaultMutableTreeNode)nodos[nodos.length-1];
				
				// Por ejemplo, para ver si se ha seleccionado el "hijo1"...
				if (ultimoNodo.getUserObject().equals("hijo1"))
				{
					// Necesitamos el modeloSeleccion para saber si "hijo1" se ha
					// seleccionado o deseleccionado.
					DefaultTreeSelectionModel modeloSeleccion = 
						(DefaultTreeSelectionModel)e.getSource();
					if (modeloSeleccion.isPathSelected(path))
						System.out.println("Has seleccionado hijo 1");
					else
						System.out.println("Has deseleccionado hijo 1");
				}
			}
		
		});
                JTree tree = arbol;

                MouseListener ml = new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        // Se obtiene el path para esa fila. Con el path podemos obtener
                        // los nodos.
                        TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                        Object nodo = selPath.getLastPathComponent();

                        //...
                        
                    }
};
tree.addMouseListener(ml);*/
	}
        
        public void agregarHijos(DefaultMutableTreeNode raiz){                
            Nodo pNodo = arbolSistema.getRaiz();
            Nodo[] aux =  pNodo.getHijos();
        for (int sensorActual = 0; sensorActual < pNodo.getNumHijos(); sensorActual++){
            //se inicia lo mismo con los hijos
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(aux[sensorActual].getNombre());
            modelo.insertNodeInto(hijo, raiz, sensorActual);
            agregarNietos(hijo, aux[sensorActual], aux[sensorActual].getHijos(), sensorActual);
           

        }
        }
        public void agregarNietos(DefaultMutableTreeNode pPadre,Nodo padre,Nodo[] hermanos,int numeroPadre){
            
            for (int sensorActual = 0; sensorActual < padre.getNumHijos(); sensorActual++){
                System.out.println("aaaa");
            //se inicia lo mismo con los hijos
            
            DefaultMutableTreeNode nieto = new DefaultMutableTreeNode(hermanos[sensorActual].getNombre());
            modelo.insertNodeInto(nieto, pPadre, numeroPadre);
            agregarNietos2(nieto, hermanos[sensorActual], hermanos[sensorActual].getHijos(), numeroPadre);
            }
        }
        public void agregarNietos2(DefaultMutableTreeNode hijo,Nodo padre,Nodo[] hermanos,int numeroPadre){
            for (int sensorActual = 0; sensorActual < padre.getNumHijos(); sensorActual++){
            //se inicia lo mismo con los hijos
            DefaultMutableTreeNode nieto2 = new DefaultMutableTreeNode(hermanos[sensorActual].getNombre());
            modelo.insertNodeInto(nieto2, hijo, numeroPadre);
            agregarNietos2(nieto2, hermanos[sensorActual], hermanos[sensorActual].getHijos(), sensorActual);
            }
        }
}
