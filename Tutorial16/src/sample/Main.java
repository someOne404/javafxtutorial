package sample;

import com.sun.source.tree.Tree;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {
    Stage window;
    TreeView<String> tree;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("TreeView Demo");

        TreeItem<String> root, sun, moon;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Sun - branch
        sun = makeBranch("Sun", root); //1st param: name, 2nd pararm: parent
        makeBranch("Earth", sun);
        makeBranch("Mars", sun);
        makeBranch("Venus", sun);

        //Moon - branch
        moon = makeBranch("Moon", root); //1st param: name, 2nd pararm: parent
        makeBranch("Atlas V", moon);
        makeBranch("Delta II", moon);

        //Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if(newValue != null){
                        System.out.println(newValue.getValue());
                    }

                });





        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
