package es.juanramonsalgueromateos.listacoches;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class UtilXML {
    public static void guardarDatosXML(Stage stage, Coches coches) {
        JAXBContext contexto;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar XML en");
            File fileCoches = fileChooser.showSaveDialog(stage);

            //File fileListaLibros = new File("ListaLibros.xml");
            contexto = JAXBContext.newInstance(Coches.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(coches, System.out);
            marshaller.marshal(coches, fileCoches);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
        }            
    }
    
    public static Coches importarDatosXML(Stage stage) {
        
        try {
            JAXBContext contexto = JAXBContext.newInstance(Coches.class);
            Coches coches;
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar XML en");
            File fileCoches = (File) fileChooser.showOpenDialog(stage);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            coches = (Coches)unmarshaller.unmarshal(fileCoches);
            System.out.println(coches.getCoches().size());
            return coches;
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
            return null;
        }
    }
}
