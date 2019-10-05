/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso10;

import com.google.gson.Gson; 
/**
 *
 * @author Alexander
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
   // public static void main(String[] args) {
        // TODO code application logic here
        //
        //SistemaTuverias hola = new SistemaTuverias();
        //hola.setVisible(true);
       /* Arbol sensores = new Arbol();
        Nodo raiz = sensores.insertarRaiz("Planta", 50000.00);
        sensores.insertarSensor(raiz, "San Antonio", 15.00, raiz.getNombre());
        sensores.insertarSensor(raiz, "Perez", 19.00, "San Antonio");
        sensores.verHijos(raiz);
    }*/
    public static void main(String args[]) throws java.io.IOException {
        Arbol tuverias = new Arbol();
       lee_json gson = new lee_json();
       gson.leer(tuverias);
    //   JsonParser parser = new JsonParser();
     //   FileReader fr = new FileReader("sensores.json");
      //  JsonElement datos = parser.parse(fr);
       // dumpJSONElement(datos);
    }
}
