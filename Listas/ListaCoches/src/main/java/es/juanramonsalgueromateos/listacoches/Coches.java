package es.juanramonsalgueromateos.listacoches;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coches {
    private ArrayList<Coche> coches = new ArrayList();
    
    public ArrayList<Coche> getCoches() {
        return coches;
    }
    
    @XmlElement(name = "coches")
    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    } 
    
    public void fusionCoches(Coches cochesNuevos){
        this.getCoches().addAll(cochesNuevos.getCoches());
        for (int i = 0; i < cochesNuevos.getCoches().size(); i++){
            this.getCoches().add(cochesNuevos.getCoches().get(i));
        }
    }
    
//    public static void fusionCoches(Coches cochesOrigen, Coches cochesNuevos){
//        cochesOrigen.getCoches().addAll(cochesNuevos.getCoches());
//    }
}
