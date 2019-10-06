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
    private int numSensors = -1;
    public Arbol leer(Arbol pArbol) throws java.io.IOException {
        arbolAux = pArbol;
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("sensores.json");
        JsonElement datos = parser.parse(fr);
        dumpJSONElement(datos);
        return arbolAux;
    }
    public void dumpJSONElement(JsonElement elemento) {
    //valida si el elemento del json es de tipo object
    if (elemento.isJsonObject()) {
        JsonObject obj = elemento.getAsJsonObject();
        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
        //Siempre que haya un elemento siguiente
        while (iter.hasNext()) {
            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
            key = (String)entrada.getKey();
            count ++;
            dumpJSONElement(entrada.getValue());
            
        }
 
    } else if (elemento.isJsonArray()) {
        JsonArray array = elemento.getAsJsonArray();
        numSensors = array.size();
        java.util.Iterator<JsonElement> iter = array.iterator();
        while (iter.hasNext()) {
            JsonElement entrada = iter.next();
            dumpJSONElement(entrada);
        }
    //valida si el elemento del json es de tipo primitivo
    } else if (elemento.isJsonPrimitive()) {
        JsonPrimitive valor = elemento.getAsJsonPrimitive();
        //valida si el valor es un boolean
        if (valor.isBoolean()) {
        //valida si el valor es un numero
        } else if (valor.isNumber()) {
            //Si es un numero se lo pone a la variable capacidad
            capacidad =  valor.getAsDouble();
            count ++;
         //valida si el valor es un string
        } else if (valor.isString()) {
            //pone el contenido de la llave Barrio en la variable barrrio
            if ("Barrio".equals(key)){
                barrio = valor.getAsString();
                count++;
            }
            //pone el contenido de la llave Distrito en la variable distrito
            if ("Distrito".equals(key)){
                distrito =valor.getAsString();
                count++;
            }
            //Pone el contenido de la llave Canton en la variable canton
            if ("Canton".equals(key)){
                canton = valor.getAsString();
                count++;
            }
        }
    } else if (elemento.isJsonNull()) {
        System.out.println("Es NULL");
    } else {
        System.out.println("Es otra cosa");
    }
    if (count == 4 && "".equals(key)){
        raiz = arbolAux.insertarRaiz("Planta", (double)capacidad);
        count = -1;
    }else{
        if( "Capacidad".equals(key) || numSensors == 0 ){
            if (count == 8){
                count =0;
                //Agrega al arbol si le dan solo el canton
                if( !"".equals(canton) && "".equals(distrito) && "".equals(barrio)){
                    Nodo cantonAux = new Nodo(canton, capacidad);
                    arbolAux.insertarSensor(raiz, cantonAux,raiz);
                    count =0;
                    numSensors--;

                }
                //Agrega al arbol si no le dan el barrio pero si el distrito
               if ( !"".equals(distrito) && "".equals(barrio) ){
                   Nodo cantonAux = new Nodo(canton, 0);
                   cantonAux.agregarHijo(cantonAux, distrito, capacidad);
                   arbolAux.insertarSensor(raiz, cantonAux, raiz);
                   count = 0;
                   numSensors--;
                   
               }
               //Agrega al arbol si le dan el barrio
               if (!"".equals(barrio)){
                   Nodo cantonAux = new Nodo(canton, 0);
                   Nodo distritoAux = cantonAux.agregarHijo(cantonAux, distrito, 0);
                   distritoAux.agregarHijo(distritoAux, barrio, capacidad);
                   
                   arbolAux.insertarSensor(raiz, cantonAux , raiz);

                   count = 0;
                   numSensors--;
                  
               }
            }   
        }
    }
}
}