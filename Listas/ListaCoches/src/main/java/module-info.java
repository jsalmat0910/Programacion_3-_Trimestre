module es.juanramonsalgueromateos.listacoches {
    requires javafx.controls;
    exports es.juanramonsalgueromateos.listacoches;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    opens es.juanramonsalgueromateos.listacoches to java.xml.bind;
}
