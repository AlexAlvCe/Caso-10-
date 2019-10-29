/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.*;

public class Arbol
{
    private Nodo nodoRaiz;
    private int idNodo=0;

    public Arbol(){
    nodoRaiz= new Nodo (idNodo);
    idNodo++;
    }
    public void insertar (String valor, String link) {
         ayudanteInsertar(nodoRaiz,valor, link);
    }
    
    public void ayudanteInsertar(Nodo pNodo,String pValor, String pLink){
        Palabra newWord = new Palabra(pValor, pLink);
        
        if (!pNodo.isTengoHijos()) {
            if (!pNodo.lleno()){
                for (int word = 0; word < pNodo.palabras.length; word++) {
                    if (pNodo.palabras[word] == null) {
                        
                        pNodo.palabras[word] = newWord;
                        
                        ordenar(pNodo.palabras);
                        break;
                    }else if (newWord.getPalabra().equals(pNodo.palabras[word].getPalabra())){
                        pNodo.palabras[word].addOcurrencia(pLink);
                        break;
                    }
                }
            }else {
                    boolean necesarioDividir = true;
                    for(int palabra = 0; palabra< pNodo.palabras.length;palabra++){
                        if(pNodo.palabras[palabra].getPalabra().equals(newWord.getPalabra())){
                            pNodo.palabras[palabra].addOcurrencia(pLink);
                            necesarioDividir = false;
                        }
                    }
              
                    if (necesarioDividir){
                        dividir(pNodo, newWord);
                    }
            }
            
        } else {
            boolean anadido = false;
            int count = 0;
            for(int  palabra = 0; palabra < pNodo.palabras.length; palabra++ ){
                count++;
                try{
                    if(pValor.compareTo(pNodo.palabras[palabra].getPalabra()) == -1){  
                        ayudanteInsertar(pNodo.nodos[palabra], pValor, pLink);
                        anadido = true;
                        break;
                        
                    }
                }catch(NullPointerException e){
                    break;
                }
            }
            if (!anadido){
                if(pNodo.nodos[count]!=null){
                ayudanteInsertar(pNodo.nodos[count],pValor, pLink);
                }else{
                Nodo nodoNuevo = new Nodo(idNodo);
                idNodo++;
                nodoNuevo.padre=pNodo;
                ayudanteInsertar(nodoNuevo, pValor, pLink);
                pNodo.nodos[count] = nodoNuevo;
                
                }
            }
        }
    }

     public void  dividir(Nodo pNodo, Palabra pPalabra){
         ArrayList<Palabra> Aux = new ArrayList();
         Palabra[] palabras = pNodo.getPalabras();
         for (Palabra palabra : palabras ){
                 Aux.add(palabra);
                
             
         }
     
         for(int  palabra = 0;palabra < Aux.size();palabra++){
             if(Aux.get(palabra).getPalabra().compareTo(pPalabra.getPalabra()) == 1){
                 Aux.add(palabra, pPalabra);
                 break;
             }else if (palabra == Aux.size() -1){
                 Aux.add(pPalabra);
                 break;
             }
         }
        
        Palabra[] media = new Palabra[pNodo.getPalabras().length];
        Palabra[] palaH1 = new Palabra[pNodo.getPalabras().length];
        Palabra[] palaH2 = new Palabra[pNodo.getPalabras().length];
        Palabra paraAgregar = null;
        int agregaH1 = 0;
        int agregaH2 =0;
        for(int palabra = 0; palabra < pNodo.getPalabras().length; palabra++ ){
            if (palabra < pNodo.getPalabras().length/2 + 1){
                palaH1[agregaH1] = pNodo.getPalabras()[palabra];
                agregaH1 ++;
            }else if(palabra > pNodo.getPalabras().length/2 + 1){
                palaH2[agregaH2] = pNodo.getPalabras()[palabra];
                agregaH2 ++;
            }else if(palabra == pNodo.getPalabras().length / 2 + 1){
                media[0] = pNodo.getPalabras()[palabra];
                paraAgregar = pNodo.getPalabras()[palabra];
            }
        }
        Nodo Hijo1 = new Nodo(idNodo);
        idNodo++;
        Nodo Hijo2 = new Nodo(idNodo);
        idNodo++;
        Hijo1.setPalabras(palaH1);
        Hijo1.setPadre(pNodo);
        Hijo2.setPadre(pNodo);
        Hijo2.setPalabras(palaH2);      
        if (pNodo.getId() == nodoRaiz.getId() || pNodo.padre.lleno()){
            if (media[0]!=null){
            pNodo.palabras = media;
            Nodo[] nodos = pNodo.getNodos();
            nodos[0] = Hijo1;
            Hijo1.padre=pNodo;
            nodos[1] = Hijo2;
            Hijo2.padre = pNodo;
            pNodo.setNodos(nodos);
            pNodo.setTengoHijos(true);
            }
        }else{
            Palabra[] palabrasPadre = pNodo.padre.getPalabras();
            for(int palabra = 0 ; palabra < palabrasPadre.length ; palabra++ ){
                if (palabrasPadre[palabra] == null){
                    palabrasPadre[palabra] = paraAgregar;
                    pNodo.padre.setPalabras(ordenar(palabrasPadre));
                    Palabra[] AuxPalabras = pNodo.padre.addPalabra(media[0]);
                    pNodo.padre.setPalabras(AuxPalabras);
                    Nodo[] nodosCorregidos = corregirNodo(pNodo.padre, pNodo, pPalabra, Hijo1, Hijo2);
                    pNodo.padre.setNodos(nodosCorregidos);
                }
            }     
        }
     
     }
    public Palabra[] ordenar(Palabra arr[]){
        int longitud = 0;
        for(int i = 0; i < arr.length; i++){
            if(null==arr[i]){
               longitud++;
            }else{
                break;
            }
        }
        for(int ord = 0; ord < longitud; ord++){
            for(int ord1 = 0; ord1 < longitud -1 ; ord1++){
                if(arr[ord1+1].getPalabra().compareTo(arr[ord1].getPalabra()) == -1){
                        Palabra tmp = arr[ord1+1];
                        Palabra tmp2 = arr[ord1];
                        arr[ord1] = tmp;
                        arr[ord1+1] = tmp2;
                      
              }
           }
       }
       return arr;
    }
    public Nodo[] corregirNodo(Nodo nodoPadre, Nodo pNodo,Palabra pPalabra,Nodo hijo1,Nodo hijo2){

        
        Nodo[] nodosCorregidos = new Nodo[nodoPadre.nodos.length];
        int anadidos = 0;
        for(int actual =0; actual < nodoPadre.palabras.length; actual++){
            if(nodoPadre.palabras[actual]!=null){
                try{
                if(nodoPadre.palabras[actual].getPalabra().equals(pPalabra.getPalabra())){
                    nodosCorregidos[anadidos] = hijo1;
                    hijo1.setPadre(nodoPadre);
                    anadidos++;
                    nodosCorregidos[anadidos] = hijo2;
                    hijo2.setPadre(nodoPadre);
                    anadidos++;
                    for(int palAux = actual + 1; palAux < nodoPadre.nodos.length ; palAux++ ){
                        if(pNodo.getId() != nodoPadre.nodos[palAux].getId()){
                            nodosCorregidos[anadidos]=nodoPadre.nodos[palAux];
                            anadidos++;
                        }
                    }
                    break;
                }else if(pNodo.getId() != nodoPadre.nodos[actual].getId()){
                    nodosCorregidos[anadidos]= nodoPadre.nodos[actual];
                    anadidos++;
                }else if(nodoPadre.nodos[actual].getId() == pNodo.getId()){
                }}catch(NullPointerException e){}
            }
        }
        return nodosCorregidos;
            
    }
 
    
    public Palabra buscar(String searchedWord){
        return ayudanteBuscar(nodoRaiz , searchedWord);
        
    }
    public Palabra ayudanteBuscar(Nodo pNodo,String pSearchedWord){
        boolean encontrada = false;
      
        if (!pNodo.isTengoHijos()){
            for (Palabra word : pNodo.palabras){
                if (pSearchedWord.equals(word.getPalabra())){
                    encontrada = true;
                    return word;
                }
            }
            if(!encontrada){
                
                return null;
            }
        }else{
            for (int word = 0 ;word <  pNodo.palabras.length; word++){
                if(pSearchedWord.compareTo(pNodo.palabras[word].getPalabra()) == 0){
                    encontrada = true;
                    return pNodo.palabras[word];
                    
                }else if (pSearchedWord.compareTo(pNodo.palabras[word].getPalabra()) == -1){
                    return ayudanteBuscar(pNodo.nodos[word], pSearchedWord);
                    
                }else if(word == pNodo.palabras.length -1 ){
                    return ayudanteBuscar(pNodo.nodos[word+1], pSearchedWord);
                    
                }
            }
            if(!encontrada){
                
            }
            
        
        }
        
        
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/*
    public String recorrer(Nodo nodo) {
         setArbol(getArbol() + "\n");
        for (int i =0; i<2*getGrado()+1; i++) {
            if (nodo.nodos[i] != null) {
                if (i == 0) {
                    setNivel(getNivel() + 1);
                    setImprimir(1);
                } else {
                    setImprimir(getImprimir() + 1);
                }
                recorrer(nodo.nodos[i]);
            }
            setArbol(getArbol() + "[ ");
            for (int j = 0; nodo.nodos[i]!=null && j<nodo.nodos[i].palabras.length; j++) {
                if (nodo.nodos[i].palabras[j] != null) {
                    setArbol(getArbol() + nodo.nodos[i].palabras[j]);
                }
            }
            setArbol(getArbol() + " ]");
        }
        if (getArbol().length() > (2*getGrado()+3)*4) {
            System.out.println (getArbol());
            return getArbol();
        }
        return getArbol();
    }
    public String llamarRecorrer() {
        String mostrar = recorrer(getPrimerNodo());
        setNivel(1);
        setImprimir(1);
        return getArbol();
    }*/
    
}
