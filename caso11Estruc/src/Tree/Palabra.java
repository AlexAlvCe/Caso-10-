/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;

/**
 *
 * @author sande
 */
class Palabra {
    private String palabra;
    private int numOcurrencias;
    private ArrayList<String> links;

    public Palabra(String pPalabra, String pLink) {
        ArrayList<String> listLinks = new ArrayList<String>();
        palabra = pPalabra;
        listLinks.add(pLink);
        links = listLinks;
        numOcurrencias = 0;
    }
    
    public void addOcurrencia(String pLink){
        if (!contains(links, pLink)){
            links.add(pLink);
            numOcurrencias++;
        }else{
            numOcurrencias++;
        }
        //System.out.println("si se anadio la ocurrencia");
        //for(String l : links){
       // System.out.println(l);
      //  }
    }
    public boolean contains(ArrayList<String> list, String name) {
        for (String item : list) {
            if (item.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getNumOcurrencias() {
        return numOcurrencias;
    }

    public ArrayList<String> getLinks() {
        return links;
    }
    public String getPalabra() {
        return palabra;
    }
}
