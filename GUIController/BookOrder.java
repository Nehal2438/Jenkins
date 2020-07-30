package GUIController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BookOrder {

	private Scene scene;
	float amount;
    
	public BookOrder(Stage stage,Scene mainscene,float a) {
	
		AnchorPane root = new AnchorPane();
		scene = new Scene(root);
		root.setLayoutX(-1.0);
		root.setPrefHeight(573.0);
		root.setPrefWidth(538.0);
		root.setStyle("-fx-background-color: blue;");
		
		amount = a;
		
		Label title = new Label("Customer Details");
		title.setFont(new Font("Arial BOLD", 22));
		title.setLayoutX(178.0);
		title.setLayoutY(14.0);
		title.setTextFill(javafx.scene.paint.Color.WHITE);
		
		Label label1 = new Label("customer’s name");
		label1.setLayoutX(15.0);
        label1.setLayoutY(78.0);
		label1.setTextFill(javafx.scene.paint.Color.WHITE);
		label1.setFont(new Font("System Bold", 16.0));
		
		Label label2 = new Label();
		label2.setLayoutX(15.0);
		label2.setLayoutY(121.0);
		label2.setText("customer’s phone number");
		label2.setFont(new Font("System Bold", 16.0));
		label2.setTextFill(javafx.scene.paint.Color.WHITE);
		
		Label label3 = new Label();
		label3.setLayoutX(15.0);
        label3.setLayoutY(168.0);
		label3.setText("size");
		label3.setFont(new Font("System Bold", 16.0));
		label3.setTextFill(javafx.scene.paint.Color.WHITE);
		
		TextField name = new TextField();
		name.setLayoutX(252.0);
		name.setLayoutY(77.0);
		name.setPrefHeight(25.0);
		name.setPrefWidth(228.0);
		name.setPromptText("enter name");
        
		TextField phone = new TextField();
		phone.setLayoutX(252.0);
		phone.setLayoutY(120.0);
		phone.setPrefHeight(25.0);
		phone.setPrefWidth(228.0);
		phone.setPromptText("enter phone");

		ComboBox size = new ComboBox();
		size.setLayoutX(252.0);
		size.setLayoutY(167.0);
		size.setPrefHeight(25.0);
		size.setPrefWidth(228.0);
		size.setPromptText("select size");
		
		ObservableList oblist = FXCollections.observableArrayList("Small","Medium","Large");
		size.setItems(oblist);
	
		
		
        Button btn_insert = new Button();
        btn_insert.setLayoutX(75.0);
        btn_insert.setLayoutY(502.0);
        btn_insert.setMnemonicParsing(false);
        btn_insert.setPrefHeight(30.0);
        btn_insert.setPrefWidth(101.0);
        btn_insert.setText("PRESS");
        
        StringBuilder builder = new StringBuilder();
        builder.append("Name : "+name.getText().toString()+"\n");
        builder.append("Phone : "+phone.getText().toString()+"\n");
        builder.append("Total Cost : "+amount);
        
        btn_insert.setOnAction(e -> {
        	String k = (String) size.getValue();
    		if(k.equals("Small")) {
    			amount = amount;
    		}
    		else if(k.equals("Medium")) {
    			amount = amount + 150;
    		}
    		else if(k.equals("Large")) {
    			amount = amount + 250;
    		}
        	
        	Alert alert = new Alert(AlertType.CONFIRMATION,"Name : "+name.getText()+"\nPhone : "+phone.getText()+"\nTotal Cost : "+amount);
				alert.setTitle("Employee");
				alert.showAndWait();
				
        });
        
        Button btn_clear = new Button();
        btn_clear.setLayoutX(219.0);
        btn_clear.setLayoutY(502.0);
        btn_clear.setMnemonicParsing(false);
        btn_clear.setPrefHeight(30.0);
        btn_clear.setPrefWidth(101.0);
        btn_clear.setText("CLEAR");
        
        btn_clear.setOnAction(e->{
        	name.clear();
        	phone.clear();
        });
        
        Button btn_back = new Button();
        btn_back.setLayoutX(366.0);
        btn_back.setLayoutY(502.0);
        btn_back.setMnemonicParsing(false);
        btn_back.setPrefHeight(30.0);
        btn_back.setPrefWidth(101.0);
        btn_back.setText("BACK");
        
        btn_back.setOnAction(e->{
        	stage.setScene(mainscene);
        });
        
		root.getChildren().addAll(title,label1,label2,label3,name,phone,size,btn_insert,btn_clear,btn_back);
	}
	
	public Scene getScene() {
		return scene;
	}
	
}