package es.juanramonsalgueromateos.listalibros;


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
        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
       
        
        // Crear el primer libro.
        Libro libro1 = new Libro("Fichero en java", "Luisa Pérez");
        System.out.println(libro1.getTitulo());
        // Añade titulo al primer libro.
        libro1.setTitulo("Listas en java");
        System.out.println(libro1.getTitulo());
        
        // Crear el segundo libro.
        Libro libro2 = new Libro();
        
        // Crear el tercer libro.
        Libro libro3 = new Libro("XML en Java");
        // Cambia el titulo del tercer libro.
        libro3.setTitulo("XML en Java 2");
        
        //int[] listaNum = new int[10];
        //Libro[] listaLibros = new Libro[10];
        


        ListaLibros listaLibros = new ListaLibros();
        listaLibros.getListaLibros().add(libro1);
        listaLibros.getListaLibros().add(libro2);
        listaLibros.getListaLibros().add(libro3);
        
        UtilXml utilxml = new UtilXml();
        Button buttonSelecFile = new Button("Guardar xml");
        root.getChildren().add(buttonSelecFile);
        buttonSelecFile.setOnAction((t) -> {
            UtilXml.guardarDatosXML(stage, listaLibros);
        });
        

//        // Mostrar el título del segundo libro.
//        System.out.println(listaLibros.get(2).getTitulo());
//        
//        // Eliminar segundo libro.
//        listaLibros.remove(1);
//        
//        // Mostrar todos los titulos de los libros de la lista.
//        for(int i=0; i<listaLibros.size(); i++){
//            System.out.println(listaLibros.get(i).getTitulo());
//        }
//        
//        for(int i=0; i<listaLibros.size(); i++){
//            System.out.println(listaLibros.get(i));
//        }

    }
                
    public static void main(String[] args) {
        launch();
    }

}