package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Java FX");

        button = new Button("click me");
        // Tutorial 5
        button.setOnAction(e -> AlertBox.display("Title of Window", "Wow"));

        // Tutorial 6
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title of Window", "Are you sure to send?");
            System.out.println(result);
        });

        //Tutorial 7
        button = new Button("Close Program");
        button.setOnAction(e -> closeProgram());
        window.setOnCloseRequest(e -> {
            e.consume(); // tell java we are gonna take care of it
            closeProgram();
        });

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram(){
        //System.out.println("File is saved!");
        //window.close();

        Boolean answer = ConfirmBox.display("Title", "You sure you want to exit?");
        if(answer)
            window.close();
    }
}
