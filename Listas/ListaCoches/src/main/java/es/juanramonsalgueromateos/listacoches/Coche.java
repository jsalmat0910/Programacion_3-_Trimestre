package es.juanramonsalgueromateos.listacoches;

public class Coche {
    
    private String marca;
    private String modelo;
    private String bastidor;
    private String matricula;
    private String fechaFabricacion;
    private int numPuertas;
    private float precio;

    public Coche() {
        
    }
    public Coche(String marca, String modelo, String bastidor, String matricula, String fechaFabricacion, int numPuertas){
        this.marca = marca.toUpperCase();
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.fechaFabricacion = fechaFabricacion;
        this.numPuertas = numPuertas;
    }
    
    public Coche(String marca, String modelo, String bastidor, String matricula, String fechaFabricacion, int numPuertas, float precio){
        this.marca = marca.toUpperCase();
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.fechaFabricacion = fechaFabricacion;
        this.numPuertas = numPuertas;
        this.precio = precio;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca.toUpperCase();
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getBastidor() {
        return bastidor;
    }
    
    public void setBastidor(String bastidor){
        this.bastidor = bastidor;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula.toUpperCase();
    }
    
    public String getFechaFabricacion() {
        return fechaFabricacion;
    }
    
    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }
    
    public int getNumPuertas() {
        return numPuertas;
    }
    
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    
    public float getPrecio() {
        return precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        String indice = "";
        
        indice += "Marca: " + marca + "\n";
        indice += "Modelo: " + modelo + "\n";
        indice += "Bastidor: " + bastidor + "\n";
        indice += "Matricula: " + matricula + "\n";
        indice += "Fecha Fabricacion: " + fechaFabricacion + "\n";
        indice += "Numero de Puertas: " + numPuertas + "\n";
        indice += "Precio: " + precio + "\n";
        
        return indice;
    }
}
