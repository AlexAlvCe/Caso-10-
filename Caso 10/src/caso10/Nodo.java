/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso10;

import java.util.ArrayList;

/**
 *
 * @author sande
 */
public class Nodo {
    private double consumo; //para almacenar cualquier valor
    private String Nombre;
    private Nodo padre;//variable nodo padre
    ArrayList<String> nombreArrayList = new ArrayList<String>();
    ArrayList<Nodo> hijos = new ArrayList<Nodo>();
    //private Nodo[] hijos;
    private Nodo[] hijosTemporal;
    private int numHijos=0;
    //Creando los constructores
    public Nodo(String pNombre,double pConsumo){
        this. consumo = pConsumo;
        this. Nombre = pNombre;
        this.numHijos = 0;
    }

    public Nodo agregarHijo(Nodo pPadre,String nombreHijo, double consumoHijo){
       // pPadre.copiarHijos();
        Nodo auxHijo = new Nodo(nombreHijo, consumoHijo);
        auxHijo.padre = pPadre;
        //pPadre.hijosTemporal[pPadre.numHijos] = auxHijo;
        pPadre.hijos.add(auxHijo);
        pPadre.numHijos++;
        return auxHijo;

    }
    
    /*
    Creando los metodos get a set para valor,padre e hijo
    */
    public Nodo getPadre(){
        return padre;
    }
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
 
    public void verNodo(){
        System.out.println(this.Nombre);
    }
    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
 
}