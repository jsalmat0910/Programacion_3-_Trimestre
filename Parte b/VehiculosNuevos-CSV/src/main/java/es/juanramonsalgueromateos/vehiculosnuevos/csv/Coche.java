package es.juanramonsalgueromateos.vehiculosnuevos.csv;



public class Coche {
   
    private String pais;
    private String codigo;
    private int año;
    private float hibridoEnchufable;
    private float hibridoCompleto;
    private float bateriaElectrica;
    private float gasolina;
    private float diesel;

    public Coche(String pais, String codigo, int año, float hibridoEnchufable, float hibridoCompleto, float bateriaElectrica, float gasolina, float diesel) {
        this.pais = pais;
        this.codigo = codigo;
        this.año = año;
        this.hibridoEnchufable = hibridoEnchufable;
        this.hibridoCompleto = hibridoCompleto;
        this.bateriaElectrica = bateriaElectrica;
        this.gasolina = gasolina;
        this.diesel = diesel;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public float getHibridoEnchufable() {
        return hibridoEnchufable;
    }

    public void setHibridoEnchufable(float hibridoEnchufable) {
        this.hibridoEnchufable = hibridoEnchufable;
    }

    public float getHibridoCompleto() {
        return hibridoCompleto;
    }

    public void setHibridoCompleto(float hibridoCompleto) {
        this.hibridoCompleto = hibridoCompleto;
    }

    public float getBateriaElectrica() {
        return bateriaElectrica;
    }

    public void setBateriaElectrica(float bateriaElectrica) {
        this.bateriaElectrica = bateriaElectrica;
    }

    public float getGasolina() {
        return gasolina;
    }

    public void setGasolina(float gasolina) {
        this.gasolina = gasolina;
    }

    public float getDiesel() {
        return diesel;
    }

    public void setDiesel(float diesel) {
        this.diesel = diesel;
    }  
}
