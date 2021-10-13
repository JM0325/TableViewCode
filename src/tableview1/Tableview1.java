/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview1;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ADMIN
 */
public class Tableview1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TableView<Persona> tableview = new TableView();
        
        TableColumn<Persona, String> colPersona = new TableColumn<>("Persona"); //tbla padre
        
        
        TableColumn<Persona, String> colnombre = new  TableColumn<>("Nombre"); //Direccion Class Persona -> ObservableList Mejor uso
        TableColumn<Persona, String> colapellido = new TableColumn<>("Apellido");
        TableColumn<Persona, String> colfechanacimiento = new TableColumn<>("Fecha Nacimiento");
        
        tableview.getColumns().addAll(colPersona, colfechanacimiento);// agregando a la tabla principal col persona y colfecha
        
        colPersona.getColumns().addAll(colnombre, colapellido); //tablas hijas que se agregan en la tabla padre(Persona)
        
        colnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colapellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colfechanacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        
        Persona p1 = new Persona("Juan","Perez",LocalDate.parse("2012-11-01"));
        Persona p2 = new Persona("Juan","Perez",LocalDate.parse("2012-11-01"));
        Persona p3 = new Persona("Juan","Perez",LocalDate.parse("2012-11-01"));
        Persona p4 = new Persona("Juan","Perez",LocalDate.parse("2012-11-01"));
        
        
        tableview.getItems().addAll(p1, p2, p3, p4);// Agregando items al table viewPrincipal
        
        //Menu permite usuario decidir que tablas se viosualizan
        tableview.setTableMenuButtonVisible(true);
        //Si deseamos cambiar el texto que se muestra cuando el TableView está vacío Label de fondo
        
        tableview.setPlaceholder(new Label("El tableView no contiene datos ..."));
        
        //Columnas anidadas
        
        Label lbl1 = new Label("Este es un label CSS = .label");
        Label lbl2 = new Label("Este es un label CSS = .label");
        Label lbl3 = new Label("Este es un label ID = texto, CSS = #texto");
        lbl3.setId("texto");
        
        VBox roots = new VBox();
        roots.setStyle("-fx-alignment: CENTER; -fx-background-color: gray;");
        roots.getChildren().addAll(lbl1, lbl2, lbl3);
        
        StackPane root = new StackPane();
        root.getChildren().add(tableview);
        
        Application.setUserAgentStylesheet(STYLESHEET_MODENA); // temas de web a modificar
        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
