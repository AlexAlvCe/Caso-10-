package caso10;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import caso10.Nodo;



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
        pNodo.verNodo();
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
        if(pNodo.getNombre().equals(raiz.getNombre())){
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
    public void insertarSensor(Nodo pNodo,Nodo nodoaInsertar, Nodo inicia){
        //Nodo newSensor = new Nodo(pNombre , pConsumo);

        //Si el padre es la raiz
        if(pNodo.getNombre().equals(raiz.getNombre())){
            pNodo.agregarHijo(pNodo, nodoaInsertar.getNombre(), nodoaInsertar.getConsumo());
        }else{
            //si el padre es alguno de los hijos
                                                                    System.out.println("bbb");
            for (int hijo = 0; hijo < inicia.getNumHijos(); hijo++){
                if(inicia.getHijos()[hijo].getNombre().equals(pNodo.getNombre())){
                    //se coloca el hijo en el nodo
                    pNodo.getHijos()[hijo].agregarHijo(pNodo, nodoaInsertar.getNombre(), nodoaInsertar.getConsumo());
                }else{
                    //busca el padre en los hijos del nodo
                    insertarSensor(pNodo, nodoaInsertar, inicia.getHijos()[hijo]);
                }
            }

        }
    }
    public Nodo getRaiz(){
        return raiz;
    }
    public void agregarNodo(String nombrePadre,String nombreHijo, double consumoHijo){
        Nodo [] lista = raiz.getHijos();
        for(int hijo = 0; hijo < raiz.getNumHijos(); hijo++){
            if (lista[hijo].getNombre().equals(nombrePadre)){
                lista[hijo].agregarHijo(lista[hijo], nombreHijo, consumoHijo);
              
            }
            Nodo[] listaAux = lista[hijo].getHijos();
            for (int hij = 0; hij < lista[hijo].getNumHijos(); hij++){
                agregarNodo(listaAux, nombrePadre,  nombreHijo,  consumoHijo);
            }
        }
        if (nombrePadre.equals(raiz.getNombre())){
            raiz.agregarHijo(raiz, nombreHijo, consumoHijo);
        }
    }
    public void agregarNodo(Nodo[] comienza,String nombrePadre,String nombreHijo, double consumoHijo){
        Nodo [] lista = comienza;
        for(int hijo = 0; hijo < lista.length; hijo++){
            if (lista[hijo].getNombre().equals(nombrePadre)){
                lista[hijo].agregarHijo(lista[hijo], nombreHijo, consumoHijo);
             
            }
            Nodo[] listaAux = lista[hijo].getHijos();
            for (int hij = 0; hij < lista[hijo].getNumHijos(); hij++){
                agregarNodo(listaAux, nombrePadre, nombreHijo, consumoHijo);
            }
        }
    }
    
 
}
