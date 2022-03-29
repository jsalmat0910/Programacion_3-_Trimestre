package es.juanramonsalgueromateos.listacoches;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        //Se crea la pantalla del proyecto.
        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        //Coches añadidos para relaizar el XML.
        Coche coche1 = new Coche("Opel", "Astra", "1HGBH41JXMN109186", "1889FRM", "2006/01/21", 5, (float)3.500);
        Coche coche2 = new Coche();
        Coche coche3 = new Coche("Renault", "Clio", "2RGBT41JXHJ254585", "1478FLM", "2005/10/05", 3);
        Coche coche4 = new Coche("Volkswagen", "Arteon", "VF7S6NFXB57818400", "7828KRB", "2018/05/10", 5, (float)35.000);
        
        //Se añaden los coches a la lista de coches del XML.
        ListaCoches listaCoches = new ListaCoches();
        listaCoches.getListaCoches().add(coche1);
        listaCoches.getListaCoches().add(coche2);
        listaCoches.getListaCoches().add(coche3);
        listaCoches.getListaCoches().add(coche4);
        
        //Se muentran todos los coches que estan introducidos en la lista de los coches.
        for(int i=0; i<listaCoches.getListaCoches().size(); i++) {
            System.out.println(listaCoches.getListaCoches().get(i));
        }
        
        Button botonSelector = new Button("Guardar XML en: ");
        root.getChildren().add(botonSelector);
        botonSelector.setOnAction((t) -> {
            
        });
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}