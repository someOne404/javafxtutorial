package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        /* Tutorial 11 - Checkbox
        window.setTitle("Checkbox Example");

            //Checkboxes
            CheckBox box1 = new CheckBox("Bacon");
            CheckBox box2 = new CheckBox("Beef");
            box2.setSelected(true);

            //Form
            button = new Button("Order Now");
            button.setOnAction(e -> handleOptions(box1, box2));

            //Layout
            VBox layout = new VBox(10);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(box1, box2, button);
        */


        // Tutorial 12 - ChoiceBox (Dropdown list)
        window.setTitle("ChoiceBox Demo");
        button = new Button("Click me");


        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems return the ObservableList object which you can add items to
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Kiwi");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().addAll("Pineapple", "Passion Fruit");
        //Set a default value
        choiceBox.setValue("Apple");

        // commented out for Tutorial 13
        // button.setOnAction(e -> getChoice(choiceBox));


        //Tutorial 13
        // Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue));


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    //Tutorial 11 - Handle checkbox options
    private void handleOptions(CheckBox box1, CheckBox box2){
        String message = "Users order:\n";
        if(box1.isSelected()){
            message += "Bacon\n";
        }
        if(box2.isSelected()){
            message += "Beef\n";
        }

        System.out.println(message);

    }

    //Tutorial 12 - to get the value of the selected item
    private void getChoice(ChoiceBox<String> choiceBox){
        String food = choiceBox.getValue();
        System.out.println(food);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private boolean isInt(TextField input, String message){
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error: " + message + " is not a number");
            return false;
        }

    }
}
