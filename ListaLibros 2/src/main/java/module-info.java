module es.juanramonsalgueromateos.listalibros {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.juanramonsalgueromateos.listalibros;
    opens es.juanramonsalgueromateos.listalibros to java.xml.bind;
}
