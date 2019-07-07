package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
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
    ListView<String> listView;


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("List View Demo"); // can select multiple items, unlike dropdown list
        button = new Button("Submit");

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man", "Titanic", "Home Alone");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e -> buttonClicked());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    //Print out movies
    private  void buttonClicked(){
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();
        for (String s : movies){
            message += s + "\n";
        }
        System.out.println(message);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
