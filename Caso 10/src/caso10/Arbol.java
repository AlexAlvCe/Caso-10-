package caso10;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import caso10.Nodo;
import java.util.ArrayList;

/**
 *
 * @author sande
 */
public class Arbol {
    private Nodo raiz;
    private double consDisponible;
    
    public Arbol (){

    }
    public Nodo insertarRaiz(String pNombre, double pConsumo){
        raiz = new Nodo(pNombre, pConsumo);
        consDisponible = pConsumo;
        return raiz;
    }
    public void verHijos(Nodo pNodo){
        //Se iniciaa con los padre
        pNodo.verNodo();
        ArrayList<Nodo> aux = pNodo.getHijos();
        for (int sensorActual = 0; sensorActual < pNodo.getNumHijos(); sensorActual++){
            aux.get(sensorActual).verNodo();
            //se inicia lo mismo con los hijos
            verHijos(pNodo.getHijos().get(sensorActual));

        }

    }
    

    public void insertarSensor(Nodo pNodo, String pNombre,double pConsumo , String padre){
        //Nodo newSensor = new Nodo(pNombre , pConsumo);

        //Si el padre es la raiz
        if(pNodo.getNombre().equals(raiz.getNombre())){
            pNodo.agregarHijo(pNodo, pNombre, pConsumo);
        }else{
            //si el padre es alguno de los hijos
            for (int hijo = 0; hijo < pNodo.getNumHijos(); hijo++){
                if(pNodo.getHijos().get(hijo).getNombre().equals(padre)){
                    //se coloca el hijo en el nodo
                    pNodo.getHijos().get(hijo).agregarHijo(pNodo, pNombre, pConsumo);
                }else{
                    //busca el padre en los hijos del nodo
                    insertarSensor(pNodo.getHijos().get(hijo), pNombre, pConsumo, padre);
                }
            }

        }
    }
    public void insertarSensor(Nodo pNodo,Nodo nodoaInsertar, Nodo inicia){
        //Nodo newSensor = new Nodo(pNombre , pConsumo);

        //Si el padre es la raiz
        if(pNodo.getNombre().equals(raiz.getNombre())){
            pNodo.agregarHijo(pNodo, nodoaInsertar.getNombre(), nodoaInsertar.getConsumo());
        }else{
            //si el padre es alguno de los hijos
                                                                    System.out.println("bbb");
            for (int hijo = 0; hijo < inicia.getNumHijos(); hijo++){
                if(inicia.getHijos().get(hijo).getNombre().equals(pNodo.getNombre())){
                    //se coloca el hijo en el nodo
                    pNodo.getHijos().get(hijo).agregarHijo(pNodo, nodoaInsertar.getNombre(), nodoaInsertar.getConsumo());
                }else{
                    //busca el padre en los hijos del nodo
                    insertarSensor(pNodo, nodoaInsertar, inicia.getHijos().get(hijo));
                }
            }

        }
    }
    public Nodo getRaiz(){
        return raiz;
    }
    public void agregarNodo(String nombrePadre,String nombreHijo, double consumoHijo){
        ArrayList<Nodo> lista = raiz.getHijos();
        for(int hijo = 0; hijo < raiz.getNumHijos(); hijo++){
            if (lista.get(hijo).getNombre().equals(nombrePadre)){
                lista.get(hijo).agregarHijo(lista.get(hijo), nombreHijo, consumoHijo);
              
            }
            ArrayList<Nodo> listaAux = lista.get(hijo).getHijos();
            for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){
                agregarNodo(listaAux, nombrePadre,  nombreHijo,  consumoHijo);
            }
        }
        if (nombrePadre.equals(raiz.getNombre())){
            raiz.agregarHijo(raiz, nombreHijo, consumoHijo);
        }
    }
    public void agregarNodo(ArrayList <Nodo> comienza,String nombrePadre,String nombreHijo, double consumoHijo){
        ArrayList<Nodo> lista = comienza;
        for(int hijo = 0; hijo < lista.size(); hijo++){
            if (lista.get(hijo).getNombre().equals(nombrePadre)){
                lista.get(hijo).agregarHijo(lista.get(hijo), nombreHijo, consumoHijo);
             
            }
            ArrayList<Nodo> listaAux = lista.get(hijo).getHijos();
            for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){
                agregarNodo(listaAux, nombrePadre, nombreHijo, consumoHijo);
            }
        }
    }
    //Elimina los nodos si el padre es la raiz
    public void eliminarNodo(String nombreSensor){
         ArrayList<Nodo> lista = raiz.getHijos();
         Nodo padre;
        for(int hijo = 0; hijo < raiz.getNumHijos(); hijo++){
            if (lista.get(hijo).getNombre().equals(nombreSensor)){
                padre = lista.get(hijo).getPadre();
                padre.getHijos().addAll(lista.get(hijo).getHijos()); 
                padre.getHijos().remove(hijo);
            }
            Nodo nodoAux = lista.get(hijo);
            for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){
                    eliminarNodo2(nodoAux, nombreSensor);
            }
        }
    }
    //Elimina los nodos si el padre esta en otro lugar que no sea la raiz
    public void eliminarNodo2(Nodo parent,String nombreSensor){
        try{
            ArrayList<Nodo> lista = parent.getHijos();
            Nodo padre;
           for(int hijo = 0; hijo < parent.getNumHijos(); hijo++){
               if (lista.get(hijo).getNombre().equals(nombreSensor)){
                   padre = lista.get(hijo).getPadre();
                   padre.getHijos().addAll(lista.get(hijo).getHijos()); 
                   padre.getHijos().remove(hijo);
               }
               Nodo nodoAux = lista.get(hijo);
               for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){
                       eliminarNodo2(nodoAux, nombreSensor);
               }
           }
        }catch(IndexOutOfBoundsException e){}
    }
   
    public boolean verificarConsumo(String sensorVerificar){
        ArrayList<Nodo> lista = raiz.getHijos();
        Nodo padre;
        for(int hijo = 0; hijo < raiz.getNumHijos(); hijo++){
            if (lista.get(hijo).getNombre().equals(sensorVerificar)){
            consDisponible = consDisponible - lista.get(hijo).getConsumo();
            }
            Nodo nodoAux = lista.get(hijo);
            if(consDisponible < 0){
                return true;
            }
            for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){
                   verifCons(nodoAux, sensorVerificar);
            }
        }
        return false;
    }
    //Elimina los nodos si el padre esta en otro lugar que no sea la raiz
    public boolean verifCons(Nodo parent,String nombreSensor){
         ArrayList<Nodo> lista = parent.getHijos();
         Nodo padre;
        for(int hijo = 0; hijo < parent.getNumHijos(); hijo++){
            if (lista.get(hijo).getNombre().equals(nombreSensor)){
                consDisponible = consDisponible - lista.get(hijo).getConsumo();
            }
            if(consDisponible < 0){
                return true;
            }
            Nodo nodoAux = lista.get(hijo);
            for (int hij = 0; hij < lista.get(hijo).getNumHijos(); hij++){
                    verifCons(nodoAux, nombreSensor);
            }
        }
        return false;
    }
 
}
