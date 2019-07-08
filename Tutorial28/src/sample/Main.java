package sample;

import com.sun.source.tree.Tree;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {
    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Property");

        Person bucky = new Person();
        bucky.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to: " + newValue);
            System.out.println("firstNameProperty(): " + bucky.firstNameProperty());
            System.out.println("getFirstName(): " + bucky.getFirstName());
        });

        button = new Button("Submit");
        button.setOnAction(e -> bucky.setFirstName("Porky"));


        //Tutorial 29
        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");

        x.setValue(9);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");


        // Tutorial 30

        //Input and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());



        /* Layout for Tutorial 28 & 29
        StackPane layout = new StackPane();
        layout.getChildren().add(button);*/

        // Layout for Tutorial 30
        VBox layout = new VBox(10, userInput, bottomText);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
