
package Tree;

public class Nodo
{
    public Palabra[] palabras;
    public Nodo []nodos;
    public boolean tengoHijos = false;
    public Nodo padre;
    private int id;
    
    public Nodo(int pId){
        id=pId;
       nodos = new Nodo [12];
       palabras = new Palabra [11];
       tengoHijos = false;
       
    }

    
    public Palabra[] getPalabras() {
        return palabras;
    }

   
    public void setPalabras(Palabra[] palabras) {
        this.palabras = palabras;
    }
    
    public Palabra[] addPalabra(Palabra pPalabra){
        Palabra[] palabras = this.palabras;
        for(int palabra = 0; palabra<palabras.length; palabra++){
            if(palabras[palabra] == null){
                palabras[palabra] = pPalabra;
                break;
            }
        }
        Arbol aux = new Arbol();
        Palabra[] palabrasOrdenadas = aux.ordenar(palabras);
        this.setPalabras(palabrasOrdenadas);
        return palabrasOrdenadas;
     
    }
   
    public Nodo[] getNodos() {
        return nodos;
    }

   
    public void setNodos(Nodo[] nodo) {
        this.nodos = nodo;
    }

    public boolean lleno(){
        for (Palabra palabra : getPalabras()) {
            if (palabra == null) {
                return false;
            }
        }
        return true;
    }
  
    public boolean isTengoHijos() {
        return tengoHijos;
    }

    public void setTengoHijos(boolean tengoHijos) {
        this.tengoHijos = tengoHijos;
    }
    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public int getId() {
        return id;
    }
    
}
