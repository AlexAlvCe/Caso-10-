/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import com.google.gson.Gson;
import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import ColaPrioridad.QueueImpl;
import ColaPrioridad.QueuePriorities;


public class lector {
    private String key;
    Gson gson = new Gson();
    JsonParser parser = new JsonParser();
    FileReader fr;
    public lector() {
    }
    
    
    
    public QueueImpl leer() throws FileNotFoundException{
        JsonParser parser = new JsonParser();
        JsonReader fr = new JsonReader(new FileReader("urls.json"));
        JsonElement datos= parser.parse(fr);
              
        QueueImpl<String> cola = dumpJSONElement(datos);
        
        return cola;
    
    }
    public QueueImpl dumpJSONElement(JsonElement elemento) {
        QueueImpl<String> cola = new QueueImpl<String>();
        if (elemento.isJsonObject()) {
            JsonObject obj = elemento.getAsJsonObject();
            java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
            java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
            //Siempre que haya un elemento siguiente
            while (iter.hasNext()) {
                java.util.Map.Entry<String,JsonElement> entrada = iter.next();
                key = (String)entrada.getKey();
                cola.enqueue(key,QueuePriorities.NORMAL);
                
                

            }

        }
        return cola;
    }
    
}
