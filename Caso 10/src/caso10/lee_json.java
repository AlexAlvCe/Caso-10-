/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso10;
 
import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.Map.Entry;
 
public class lee_json {
    private String key;
    private String canton;
    private String distrito;
    private String barrio;
    private double capacidad;
    private Nodo raiz;
    private Arbol arbolAux;
    private int count;
    public Arbol leer(Arbol pArbol) throws java.io.IOException {
        arbolAux = pArbol;
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("sensores.json");
        JsonElement datos = parser.parse(fr);
        dumpJSONElement(datos);
        return arbolAux;
    }
    public void dumpJSONElement(JsonElement elemento) {
    if (count == 5 && "Planta".equals(key)){
        raiz = arbolAux.insertarRaiz(key, capacidad);
        count = 0;
    }else{
        if(count==4 && !"Sensores".equals(key)){
            arbolAux.insertarSensor(raiz, canton, capacidad, raiz.getNombre());
               if (!"".equals(distrito)){
                   arbolAux.insertarSensor(raiz, distrito, capacidad, canton);
               }
               if (!"".equals(barrio)){
                   arbolAux.insertarSensor(raiz, barrio, capacidad, distrito);
               }
               
        }
    }
        
    if (elemento.isJsonObject()) {
        System.out.println("Es objeto");
        JsonObject obj = elemento.getAsJsonObject();
        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
        while (iter.hasNext()) {
            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
            System.out.println("Clave: " + entrada.getKey());
            key = (String)entrada.getKey();
            System.out.println("Valor:");
            dumpJSONElement(entrada.getValue());
            
        }
 
    } else if (elemento.isJsonArray()) {
        JsonArray array = elemento.getAsJsonArray();
        System.out.println("Es array. Numero de elementos: " + array.size());
        java.util.Iterator<JsonElement> iter = array.iterator();
        while (iter.hasNext()) {
            JsonElement entrada = iter.next();
            dumpJSONElement(entrada);
        }
    } else if (elemento.isJsonPrimitive()) {
        System.out.println("Es primitiva");
        JsonPrimitive valor = elemento.getAsJsonPrimitive();
        if (valor.isBoolean()) {
            System.out.println("Es booleano: " + valor.getAsBoolean());
        } else if (valor.isNumber()) {
            capacidad =  valor.getAsDouble();
            System.out.println("Es numero: " + valor.getAsNumber());
        } else if (valor.isString()) {
 //           if (key == "Capacidad"){
   //           
    //        }
            if (key == "Barrio"){
                barrio = valor.getAsString();
            }
            if (key == "Distrito"){
                distrito =valor.getAsString();
            }
            if (key == "Canton"){
                canton = valor.getAsString();
            }
            System.out.println("Es texto: " + valor.getAsString());
        }
    } else if (elemento.isJsonNull()) {
        System.out.println("Es NULL");
    } else {
        System.out.println("Es otra cosa");
    }
}
}