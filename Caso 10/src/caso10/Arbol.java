package caso10;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import caso10.Nodo;
import java.io.IOException;



/**
 *
 * @author sande
 */
public class Arbol {
    private Nodo raiz;
    
    
    public Arbol (){

    }
    public Nodo insertarRaiz(String pNombre, double pConsumo){
        raiz = new Nodo(pNombre, pConsumo);
        return raiz;
    }
    public void verHijos(Nodo pNodo){
        //Se iniciaa con los padre
        Nodo[] aux = pNodo.getHijos();
        for (int sensorActual = 0; sensorActual < pNodo.getNumHijos(); sensorActual++){
            aux[sensorActual].verNodo();
            //se inicia lo mismo con los hijos
            verHijos(pNodo.getHijos()[sensorActual]);

        }

    }

    public void insertarSensor(Nodo pNodo, String pNombre,double pConsumo , String padre){
        //Nodo newSensor = new Nodo(pNombre , pConsumo);

        //Si el padre es la raiz
        if(pNodo.getNombre().equals(padre)){
            pNodo.agregarHijo(pNodo, pNombre, pConsumo);
        }else{
            //si el padre es alguno de los hijos
            for (int hijo = 0; hijo < pNodo.getNumHijos(); hijo++){
                if(pNodo.getHijos()[hijo].getNombre().equals(padre)){
                    //se coloca el hijo en el nodo
                    pNodo.getHijos()[hijo].agregarHijo(pNodo, pNombre, pConsumo);
                }else{
                    //busca el padre en los hijos del nodo
                    insertarSensor(pNodo.getHijos()[hijo], pNombre, pConsumo, padre);
                }
            }

        }
    }
 
}
