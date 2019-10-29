/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 *
 * @author sander
 */
public class TextExtractor {
    public TextExtractor(){}
    
    
    public ArrayList<String> extraer(String pUrl) throws IOException{
        ArrayList<String> words = new ArrayList<String>();
        Elements texts;
        Elements links;
        Document info = Jsoup.connect(pUrl).get();
        texts = info.select("p");
        String parrafo = texts.text();
        String Text = texts.toString();
        int guia  = 0;
        int count = 0;
        for(int subPalabra = 0 ;subPalabra < parrafo.length(); subPalabra++ ){
            count++;
            if (" ".equals(parrafo.substring(subPalabra, subPalabra+1)) || ".".equals(parrafo.substring(subPalabra, subPalabra+1))||",".equals(parrafo.substring(subPalabra, subPalabra+1))||":".equals(parrafo.substring(subPalabra, subPalabra+1))||"/".equals(parrafo.substring(subPalabra, subPalabra+1)) ){
                String aux = parrafo.substring(guia, subPalabra);
                if(aux.length() >= 4){
                words.add(parrafo.substring(guia, subPalabra));

                count = 0;
                }
                guia = subPalabra+1; 
            }
        }
        return words;
        
    }
    
    
}
