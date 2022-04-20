package es.juanramonsalgueromateos.vehiculosnuevos.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.application.Application;
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

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        String nombreFichero = "vehículos-nuevos-tipo-compartir.csv";
        
    //Se leen los datos del CSV seleccionado.
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            String texto = br.readLine();
            // Repetir mientras no se llegue al final del fichero
            while(texto != null) {
                String[] valores = texto.split(",");
                String coches = valores[3];
                System.out.println(coches);
                // Leer la siguiente línea
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
    /*    
    //Escribe sobre el CSV elegido.
        String texto = "Texto de prueba";
        BufferedWriter bw = null;
        try {
            //Crear un objeto BufferedWriter. Si ya existe el fichero, 
            //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
            //Escribir en el fichero el texto con un salto de línea
            bw.write(texto + "\n");
        }
        // Comprobar si se ha producido algún error
        catch(Exception ex) {
           System.out.println("Error de escritura del fichero");
           ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(bw != null)
                    bw.close();
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }*/
        
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        
        //Creacion del label donde se muestra la informacion seleccionada.
        Label seleccionado = new Label("Hola");
        root.getChildren().add(seleccionado);
        
        //Creacion de la caja donde se selecciona lo deseado de la lista de los tipos de coches.
        ComboBox<String> cajaTipoCoche = new ComboBox();
        cajaTipoCoche.setOnAction((t) -> {
            seleccionado.setText(cajaTipoCoche.getValue());
        });
        hbox.getChildren().add(cajaTipoCoche);
        
        //Creacion de la caja donde se selecciona lo deseado de la lista de los años.
        ComboBox<String> cajaAño = new ComboBox();
        cajaAño.setOnAction((t) -> {
            seleccionado.setText(cajaAño.getValue());
        });
        hbox.getChildren().add(cajaAño);
        
        //Mostrar hbox en pantalla.
        root.getChildren().add(hbox);
        
    }

    public static void main(String[] args) {
        launch();
    }

}