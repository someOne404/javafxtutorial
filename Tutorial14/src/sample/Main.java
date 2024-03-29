package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("ComboBox Demo");
        button = new Button("Submit");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Red", "Black", "White"
        );

        comboBox.setPromptText("What is your favorite color?");
        comboBox.setEditable(true);

        button.setOnAction(e -> printColor());

        // No need to add a listener like in the ChoiceBox
        comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void printColor(){
        System.out.println(comboBox.getValue());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
