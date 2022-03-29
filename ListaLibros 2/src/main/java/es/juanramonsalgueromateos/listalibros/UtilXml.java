package es.juanramonsalgueromateos.listalibros;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class UtilXml {
    public static void guardarDatosXml(Stage stage, ListaLibros listaLibros){
        JAXBContext contexto;
            try{
                FileChooser fc = new FileChooser();
                fc.setTitle("Guardar XML en");
                File fileListaLibros = fc.showSaveDialog(stage);
                
                //File fileListaLibros = new File("ListaLibros.xml");
                contexto = JAXBContext.newInstance(ListaLibros.class);
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(listaLibros, System.out);
                marshaller.marshal(listaLibros, fileListaLibros);
            } catch(JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
            }
    }

    static void guardarDatosXML(Stage stage, ListaLibros listaLibros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
