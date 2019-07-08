package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("TableView Demo");

        // Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");


        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        //Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(table, hBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("laptop", 859.99, 20));
        products.add(new Product("Basketball", 25.99, 120));
        products.add(new Product("Toilet", 99.49, 55));
        products.add(new Product("Corn", 1.29, 567));
        return products;
    }

    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().addAll(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }
}