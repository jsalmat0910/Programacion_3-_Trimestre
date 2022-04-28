package es.juanramonsalgueromateos.vehiculosnuevos.csv;

import java.util.ArrayList;



public class Datos {
    private ArrayList<Coche> listaDatos = new ArrayList();
    
    public ArrayList<Coche> getDatos() {
        return listaDatos;
    }
    

    public void setDatos(ArrayList<Coche> listaDatos) {
        this.listaDatos = listaDatos;
    } 
}
