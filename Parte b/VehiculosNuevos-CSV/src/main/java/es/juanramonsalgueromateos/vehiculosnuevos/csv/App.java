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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    ArrayList listaTodosPaises = new ArrayList();
    static int totalPaguinas = 0;
    String[] valores;
    
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
                valores = texto.split(",");
                
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
                //listaTodosPaises.add(coche.getPais());
                datos.getDatos().add(coche);
                
                
                
             // Actualizar variable del pais anterior.
                paisAnterior = paisActual;
                
             // Salto de línea.
                texto = br.readLine();
                totalPaguinas += 1;
                
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
        
        Label indicePais = new Label(" País ");
        indicePais.setAlignment(Pos.TOP_CENTER);
        indicePais.setStyle("-fx-border-color:GRAY;");
        
        Label indiceCodigo = new Label(" Código ");
        indiceCodigo.setAlignment(Pos.TOP_CENTER);
        indiceCodigo.setStyle("-fx-border-color:GRAY;");
        
        Label indiceAño = new Label(" Año ");        
        indiceAño.setAlignment(Pos.TOP_CENTER);
        indiceAño.setStyle("-fx-border-color:GRAY;");
        
        Label indiceTipo1 = new Label(" Híbrido Enchufable ");        
        indiceTipo1.setAlignment(Pos.TOP_CENTER);
        indiceTipo1.setStyle("-fx-border-color:GRAY;");
        
        Label indiceTipo2 = new Label(" Híbrido Completo ");        
        indiceTipo2.setAlignment(Pos.TOP_CENTER);
        indiceTipo2.setStyle("-fx-border-color:GRAY;");
        
        Label indiceTipo3 = new Label(" Batería Eléctrica ");        
        indiceTipo3.setAlignment(Pos.TOP_CENTER);
        indiceTipo3.setStyle("-fx-border-color:GRAY;");
        
        Label indiceTipo4 = new Label(" Gasolina ");        
        indiceTipo4.setAlignment(Pos.TOP_CENTER);
        indiceTipo4.setStyle("-fx-border-color:GRAY;");
        
        Label indiceTipo5 = new Label(" Diesel ");
        indiceTipo5.setAlignment(Pos.TOP_CENTER);
        indiceTipo5.setStyle("-fx-border-color:GRAY;");
        
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

     // Creacion del label donde se muestra la informacion seleccionada.
        Label textoPais = new Label();
        textoPais.setAlignment(Pos.TOP_CENTER);
        textoPais.setStyle("-fx-border-color:GRAY;");
        
        Label textoCodigo = new Label();
        textoCodigo.setAlignment(Pos.TOP_CENTER);
        textoCodigo.setStyle("-fx-border-color:GRAY;");
        
        Label textoAño = new Label();
        textoAño.setAlignment(Pos.TOP_CENTER);
        textoAño.setStyle("-fx-border-color:GRAY;");
        
        Label textoTipo1 = new Label( );
        textoTipo1.setAlignment(Pos.TOP_CENTER);
        textoTipo1.setStyle("-fx-border-color:GRAY;");
        
        Label textoTipo2 = new Label();
        textoTipo2.setAlignment(Pos.TOP_CENTER);
        textoTipo2.setStyle("-fx-border-color:GRAY;");
        
        Label textoTipo3 = new Label();
        textoTipo3.setAlignment(Pos.TOP_CENTER);
        textoTipo3.setStyle("-fx-border-color:GRAY;");
        
        Label textoTipo4 = new Label();
        textoTipo4.setAlignment(Pos.TOP_CENTER);
        textoTipo4.setStyle("-fx-border-color:GRAY;");
        
        Label textoTipo5 = new Label();
        textoTipo5.setAlignment(Pos.TOP_CENTER);
        textoTipo5.setStyle("-fx-border-color:GRAY;");
        
     // Creacion de la caja donde se selecciona lo deseado de la lista.
        ComboBox<String> cajaPais = new ComboBox(FXCollections.observableList(listaPaises));
        cajaPais.setOnAction((ActionEvent t) -> {
         // Valor seleccionado del combo box.
            String valorCaja = cajaPais.getValue();
            

            for(int nDato = 0; nDato < totalPaguinas; nDato++)  {
                if(valorCaja.equals(datos.getDatos().get(nDato).getPais())){
                    textoPais.setText(datos.getDatos().get(nDato).getPais());
                    textoCodigo.setText(datos.getDatos().get(nDato).getCodigo());
                    textoAño.setText(String.valueOf(datos.getDatos().get(nDato).getAño()));
                    textoTipo1.setText(String.valueOf(datos.getDatos().get(nDato).getHibridoEnchufable()));
                    textoTipo2.setText(String.valueOf(datos.getDatos().get(nDato).getHibridoCompleto()));
                    textoTipo3.setText(String.valueOf(datos.getDatos().get(nDato).getBateriaElectrica()));
                    textoTipo4.setText(String.valueOf(datos.getDatos().get(nDato).getGasolina()));
                    textoTipo5.setText(String.valueOf(datos.getDatos().get(nDato).getDiesel()));
                }            
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
        
//        TableView<Datos> tablaDatos = new TableView();
//        TableColumn<Datos, String> colPais = new TableColumn("Pais");

     // Mostrar en pantalla.
        root.getChildren().add(cajaPais);
        root.getChildren().add(hbox1);
        root.getChildren().add(hbox2);
        

    }

    public static void main(String[] args) {
        launch();
    }

}