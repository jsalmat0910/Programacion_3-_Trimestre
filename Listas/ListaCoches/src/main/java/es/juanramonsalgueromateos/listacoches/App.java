package es.juanramonsalgueromateos.listacoches;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    static int cocheActual = 0;

    @Override
    public void start(Stage stage) {
        
        //Se crea la pantalla 1 del proyecto.
        VBox vRoot = new VBox();
        vRoot.setBorder(Border.EMPTY);
        vRoot.setAlignment(Pos.BOTTOM_CENTER);
        vRoot.setSpacing(10);
        vRoot.setStyle("-fx-background-color: CORNFLOWERBLUE");
        var scene = new Scene(vRoot, 300, 250);
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
        
        
        
        //Se crea un label en el cual mo¡uestra en pantalla los coches seleccionados en ese momento.
        Label texto = new Label();
        texto.setAlignment(Pos.TOP_CENTER);
        texto.setStyle(STYLESHEET_MODENA);
        vRoot.getChildren().add(texto);

        
        HBox hRoot = new HBox();
        hRoot.setBorder(Border.EMPTY);
        hRoot.setAlignment(Pos.TOP_CENTER);
        hRoot.setSpacing(10);
        vRoot.getChildren().add(hRoot);
        
        //Se crea boton para pasar de un coche a otro utilizandolo como índice.
        Button botonSiguienteCoche = new Button("Siguiente");
        botonSiguienteCoche.setStyle("-fx-background-color: LIGHTBLUE");
        hRoot.getChildren().add(botonSiguienteCoche);
        botonSiguienteCoche.setOnAction((ActionEvent t) -> {
           cocheActual++;
            if (cocheActual > coches.getCoches().size() - 1){
                cocheActual = coches.getCoches().size() -1 ;
            }
            try {
                texto.setText(coches.getCoches().get(cocheActual).toString());

            } catch(Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Ha habido un error con el botón siguiente");
                alert.showAndWait();
            }
        });

        //Se crea boton para pasar de un coche a otro utilizandolo como índice.        
        Button botonAnteriorCoche = new Button("Anterior");
        botonAnteriorCoche.setStyle("-fx-background-color: LIGHTBLUE");
        hRoot.getChildren().add(botonAnteriorCoche);
        botonAnteriorCoche.setOnAction((ActionEvent t) -> {
            cocheActual--;
            if (cocheActual < 0){
                cocheActual = 0;
            }
            try {
                texto.setText(coches.getCoches().get(cocheActual).toString());

            } catch(Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Ha habido un error con el botón anterior");
                alert.showAndWait();
            }
        });
        
        //Se muentran todos los coches que estan introducidos en la lista de los coches.
        for(int i=0; i<coches.getCoches().size(); i++) {
            System.out.println(coches.getCoches().get(i));
        }
        
        
        HBox hRoot2 = new HBox();
        hRoot2.setAlignment(Pos.BOTTOM_CENTER);
        hRoot2.setBorder(Border.EMPTY);
        hRoot2.setSpacing(95);
        vRoot.getChildren().add(hRoot2);
        
        //Se crea el boton para realizar el guardado del XML en la carpeta que se seleccione.
        Button botonSelectorGuardar = new Button("Guardar XML en: ");
        botonSelectorGuardar.setStyle("-fx-background-color: AQUAMARINE");
        hRoot2.getChildren().add(botonSelectorGuardar);
        botonSelectorGuardar.setOnAction((ActionEvent t) -> {
            UtilXML.guardarDatosXML(stage, coches);
        });
        
        //Se crea el boton para realizar la importación del XML de la  carpeta que se seleccione.
        Button botonSelectorImportar = new Button("Importar XML: ");
        botonSelectorImportar.setStyle("-fx-background-color: AQUAMARINE");
        hRoot2.getChildren().add(botonSelectorImportar);
        botonSelectorImportar.setOnAction((ActionEvent t) -> {
            Coches cochesImport = UtilXML.importarDatosXML(stage);
            System.out.print("Números de coches importados: ");
            System.out.println(cochesImport.getCoches().size());
            
            coches.fusionCoches(cochesImport);
//            coches.fusionCoches(coches, cochesImport);
        });
    }
    
    public static void main(String[] args) {
        launch();
    }

}