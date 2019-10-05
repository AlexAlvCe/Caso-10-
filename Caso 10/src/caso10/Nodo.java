/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso10;

/**
 *
 * @author sande
 */
public class Nodo {
    private double consumo; //para almacenar cualquier valor
    private String Nombre;
    private Nodo padre;//variable nodo padre
    //private Nodo[] hermanos;//variable nodo hermano
    private Nodo[] hijos;
    private Nodo[] hijosTemporal;
    private int numHijos=0;
    private int numHermanos=0;
    //Creando los constructores
    public Nodo(String pNombre,double pConsumo){
        this. consumo = pConsumo;
        this. Nombre = pNombre;
        this.numHijos = 0;
    }
     
    
    public void copiarHijos(){
        //Aumenta en 1 el numero de hijos que puede tener el padre en su arreglo
        hijosTemporal = new Nodo[numHijos + 1];
        for (int copHijo = 0; copHijo < this.numHijos; copHijo++){
            hijosTemporal[copHijo] = hijos[copHijo];
        }
    }
    public void agregarHijo(Nodo pPadre,String nombreHijo, double consumoHijo){
        pPadre.copiarHijos();
        Nodo auxHijo = new Nodo(nombreHijo, consumoHijo);
        pPadre.hijosTemporal[pPadre.numHijos] = auxHijo;
        pPadre.hijos = pPadre.hijosTemporal;
        pPadre.numHijos++;
        

// this(consumo);//invoca la variable valor del constructor
     //   this.hermanos[numHermanos] = hermano;
      //  this.hijos[numHijos] = hijo;
       //umHijos++;
       // numHermanos++;
    }
 
    /*
    Creando los metodos get a set para valor,padre e hijo
    */
   public String getNombre(){
        return this.Nombre;
   }
   public double getConsumo() {
        return consumo;
   }
    public int getNumHijos(){
        return numHijos;
    }
    public void setConsumo(double pConsumo) {
        this.consumo = pConsumo;
    }
 
   /* public Nodo[] getHermanos() {
        return hermanos;
    }
    
    public void setPadre(Nodo pPadre) {
        this.hermanos[0] = pPadre;
    }*/
    public void verNodo(){
        System.out.println(this.Nombre);
    }
    public Nodo[] getHijos() {
        return hijos;
    }
 
   // public void setHijos(Nodo hijo) {
    //    this.hijos[0] = hijo;
    //}
 
    /* */
   // public void nuevoHijo(Nodo nhj)
    //{
     //   this.hijos[0] = nhj;
      //  numHijos++;
   // }
}