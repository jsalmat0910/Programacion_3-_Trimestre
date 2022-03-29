package es.juanramonsalgueromateos.listacoches;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaCoches {
    
    private ArrayList<Coche> listaCoches = new ArrayList();
    
    public ArrayList<Coche> getListaCoches() {
        return listaCoches;
    }
    
    @XmlElement(name = "coches")
    public void setListaCoches(ArrayList<Coche> ListaCohes) {
        this.listaCoches = listaCoches;
    } 
}
