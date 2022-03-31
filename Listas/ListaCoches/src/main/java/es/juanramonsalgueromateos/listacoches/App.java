package es.juanramonsalgueromateos.listacoches;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        //Se crea la pantalla del proyecto.
        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        //Coches añadidos para relaizar el XML.
        Coche coche1 = new Coche("Opel", "Astra", "1HGBH41JXMN109186", "1889FRM", "2006/01/21", 5, (float)3500);
        Coche coche2 = new Coche();
        Coche coche3 = new Coche("Renault", "Clio", "2RGBT41JXHJ254585", "1478FLM", "2005/10/05", 3);
        Coche coche4 = new Coche("Volkswagen", "Arteon", "VF7S6NFXB57818400", "7828KRB", "2018/05/10", 5, (float)35000);
        
        //Se añaden los coches a la lista de coches del XML.
        Coches coches = new Coches();
        coches.getCoches().add(coche1);
        coches.getCoches().add(coche2);
        coches.getCoches().add(coche3);
        coches.getCoches().add(coche4);
        
        
        //Se muentran todos los coches que estan introducidos en la lista de los coches.
        for(int i=0; i<coches.getCoches().size(); i++) {
            System.out.println(coches.getCoches().get(i));
        }
        
        //Se crea el boton para realizar el guardado del XML en la carpeta que se seleccione.
        Button botonSelectorGuardar = new Button("Guardar XML en: ");
        root.getChildren().add(botonSelectorGuardar);
        botonSelectorGuardar.setOnAction((ActionEvent t) -> {
            UtilXML.guardarDatosXML(stage, coches);
        });
        
        //Se crea el boton para realizar la importación del XML de la  carpeta que se seleccione.
        Button botonSelectorImportar = new Button("Importar el XML: ");
        root.getChildren().add(botonSelectorImportar);
        botonSelectorImportar.setOnAction((ActionEvent t) -> {
            Coches cochesImport = UtilXML.importarDatosXML(stage);
            System.out.print("Números de coches importados: ");
            System.out.println(cochesImport.getCoches().size());
            coches.fusionCoches(cochesImport);
//            coches.fusionCoches(coches, cochesImport);
        });
        
        //Se crea boton para pasar de un coche a otro utilizandolo como índice.
        Button botonSiguienteCoche = new Button("Siguiente");
        root.getChildren().add(botonSiguienteCoche);

        //Se crea boton para pasar de un coche a otro utilizandolo como índice.        
        Button botonAnteriorCoche = new Button("Anterior");
        root.getChildren().add(botonAnteriorCoche);
        
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}