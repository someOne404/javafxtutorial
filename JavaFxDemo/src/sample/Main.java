package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Title");

        button = new Button();
        button.setText("Click Me");
        button.setOnAction(this);//whenever you click the button, the code to handle the click event is in this class

        //Alternate way for events handling: anonymous inner class
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("I am an anonymous inner class");
            }
        });

        //Alternate way for events handling: new compact way (lamda)
        button.setOnAction(e -> System.out.println("hey"));
        button.setOnAction(e -> {
            System.out.println("New syntax introduced by Java 8");
            System.out.println("Second line");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {//whenever user clicks a button
        if(actionEvent.getSource()==button){
            System.out.println("thank you for clicking");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
