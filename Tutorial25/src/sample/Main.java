package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("CSS FX");

        // Tutorial 9
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name label
        Label nameLabel = new Label("Username");
        nameLabel.setId("bold-label");
        //nameLabel.setStyle("-fx-text-fill: #e8e8e8");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input
        TextField nameInput = new TextField("Bilibili");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 1); // 1st row, 2nd col

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1); //2nd col, 2nd row

        //Login
        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton, 1, 2);

        /* Internalized style
        loginButton.setOnAction(e ->{
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
        });*/

        //Sign up
        Button signUpButton = new Button("Sign Up");
        signUpButton.getStyleClass().add("button-blue");
        GridPane.setConstraints(signUpButton, 1, 3);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("sample/Viper.css");
        window.setScene(scene);


        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
