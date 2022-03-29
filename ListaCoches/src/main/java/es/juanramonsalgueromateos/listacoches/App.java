package es.juanramonsalgueromateos.listacoches;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
        Coche coche1 = new Coche("Opel", "Astra", "1HGBH41JXMN109186", "1889FRM", "2006/01/21", "5", "3.500");
        Coche coche2 = new Coche();
        Coche coche3 = new Coche("Renault", "Clio", "2RGBT41JXHJ254585", "1478FLM", "2005/10/05", "3", "8.500");
        Coche coche4 = new Coche("Volkswagen", "Arteon", "VF7S6NFXB57818400", "7828KRB", "2018/05/10", "5", "35.000");
        
        ListaCoches listaCoches = new ListaCoches();
        listaCoches.getListaCoches().add(coche1);
        listaCoches.getListaCoches().add(coche2);
        listaCoches.getListaCoches().add(coche3);
        listaCoches.getListaCoches().add(coche4);
        
        
        for(int i=0; i<ListaCoches.size(); i++){
            System.out.println(ListaCoches.get(i).getTitulo());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}