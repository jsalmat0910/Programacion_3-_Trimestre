package es.juanramonsalgueromateos.vehiculosnuevos.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    Coche coche;
    Datos datos = new Datos();
    ArrayList listaPaises = new ArrayList();
    static int textoActual = 0;
    
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
     // Fichero CSV que se utiliza.
        String nombreFichero = "vehículos-nuevos-tipo-compartir.csv";
        
     // Se leen los datos del CSV seleccionado.
     // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
         // Crear un objeto BufferedReader al que se le pasa 
         // un objeto FileReader con el nombre del fichero.
            br = new BufferedReader(new FileReader(nombreFichero));
         // Leer la primera línea, guardando en un String
            String texto = br.readLine();
            
         // Salto de línea.
            texto = br.readLine();
            
            
            
         // Variable para saber el pais que seha usado.
            String paisAnterior = "";
            
         // Repetir mientras no se llegue al final del fichero
            while(texto != null) {
                String[] valores = texto.split(",");
                
             // Introduccion de los valores dependiendo de las columnas.
                coche = new Coche(valores[0], valores[1], Integer.parseInt(valores[2]), Float.parseFloat(valores[3]), Float.parseFloat(valores[4]), Float.parseFloat(valores[5]), Float.parseFloat(valores[6]), Float.parseFloat(valores[7]));
                
             // Varible que se utiliza para saber el pais de la línea actual.
                String paisActual = coche.getPais();
                
             // Comparativa de los paises para que no se repita el valor dentro de la Array.
                if(!paisAnterior.equals(paisActual)){
                  // Introduce los valores de las banderas en la array.
                    listaPaises.add(coche.getPais()); 
                    //System.out.println("Introduce Pais en el Array");
                    
                }else{
                    //System.out.println("No se introduce Pais en el Array");
                }
                
                datos.getDatos().add(coche);
                
                System.out.println();
                
                
             // Actualizar variable del pais anterior.
                paisAnterior = paisActual;
                
             // Salto de línea.
                texto = br.readLine();
                
            }
        }
        
     // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
     // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
     // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
             // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    
     // Crea pantalla horizontal en la que se muestra el indice de los datos que se van a mostrar.
        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        
        Label indicePais = new Label("País");
        
        Label indiceCodigo = new Label("Código");
        
        Label indiceAño = new Label("Año");        
        
        Label indiceTipo1 = new Label("Híbrido Enchufable");        
        
        Label indiceTipo2 = new Label("Híbrido Completo");        
        
        Label indiceTipo3 = new Label("Batería Eléctrica");        
        
        Label indiceTipo4 = new Label("Gasolina");        
        
        Label indiceTipo5 = new Label("Diesel");
        
        hbox1.getChildren().add(indicePais);
        hbox1.getChildren().add(indiceCodigo);
        hbox1.getChildren().add(indiceAño);
        hbox1.getChildren().add(indiceTipo1);
        hbox1.getChildren().add(indiceTipo2);
        hbox1.getChildren().add(indiceTipo3);
        hbox1.getChildren().add(indiceTipo4);
        hbox1.getChildren().add(indiceTipo5);
        
     // Crear segunda pantalla horizontal en la que se muestran los datos que hemos seleccionado.
        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setSpacing(10);

     // Creacion del label donde se muestra la informacion seleccionada.
        Label textoPais = new Label();
        
        
        Label textoCodigo = new Label();
        
        
        Label textoAño = new Label();
        
        
        Label textoTipo1 = new Label( );
        
        
        Label textoTipo2 = new Label();
        
        
        Label textoTipo3 = new Label();
        
        
        Label textoTipo4 = new Label();
        
        
        Label textoTipo5 = new Label();

     // Creacion de la caja donde se selecciona lo deseado de la lista.
        ComboBox<String> cajaPais = new ComboBox(FXCollections.observableList(listaPaises));
        cajaPais.setOnAction((ActionEvent t) -> {
         // Valor seleccionado del combo box.
            String valorCaja = cajaPais.getValue();
            if (valorCaja.equals(datos.getDatos())){
                textoPais.setText(datos.getDatos().get(textoActual).getPais());
                textoCodigo.setText(datos.getDatos().get(textoActual).getCodigo());
                
            }
        });
        
        hbox2.getChildren().add(textoPais);
        hbox2.getChildren().add(textoCodigo);
        hbox2.getChildren().add(textoAño);
        hbox2.getChildren().add(textoTipo1);
        hbox2.getChildren().add(textoTipo2);
        hbox2.getChildren().add(textoTipo3);
        hbox2.getChildren().add(textoTipo4);
        hbox2.getChildren().add(textoTipo5);
        

     // Mostrar en pantalla.
        root.getChildren().add(cajaPais);
        root.getChildren().add(hbox1);
        root.getChildren().add(hbox2);
        

    }

    public static void main(String[] args) {
        launch();
    }

}