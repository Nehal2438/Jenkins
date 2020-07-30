package GUIController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Model.ModelPizza;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CreateOrder {

	private Scene scene;
	List<ModelPizza> data = null;
	float total_amount = 0;
	
	public CreateOrder(Stage stage,Scene mainscene) {
	
		AnchorPane root = new AnchorPane();
		
		root.setLayoutX(-1.0);
		root.setPrefHeight(573.0);
		root.setPrefWidth(538.0);
		root.setStyle("-fx-background-color: blue;");
		
		Label title = new Label("Create Order");
		title.setFont(new Font("Arial BOLD", 22));
		title.setLayoutX(200.0);
		title.setLayoutY(14.0);
		title.setTextFill(javafx.scene.paint.Color.WHITE);
		
		Label label1 = new Label("Pizza Name");
		label1.setLayoutX(15.0);
        label1.setLayoutY(78.0);
		label1.setTextFill(javafx.scene.paint.Color.WHITE);
		label1.setFont(new Font("System Bold", 16.0));
		
		Label label2 = new Label("Pizza Price");
		label2.setLayoutX(200.0);
		label2.setLayoutY(78.0);
		label2.setTextFill(javafx.scene.paint.Color.WHITE);
		label2.setFont(new Font("System Bold", 16.0));
		
		Label label3 = new Label("Pizza Quantity");
		label3.setLayoutX(390.0);
		label3.setLayoutY(78.0);
		label3.setTextFill(javafx.scene.paint.Color.WHITE);
		label3.setFont(new Font("System Bold", 16.0));
		
		ModelPizza mp = new ModelPizza();
		
		try {
			data = mp.load_data();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int k = 0;
			
		Label name[] = new Label[data.size()];
		Label price[] = new Label[data.size()];
		TextField quantity[] = new TextField[data.size()];
		
		for (int i = 0; i < data.size(); i++) {
			
			String qnt = "quantity"+i;
			
			name[i] = new Label(data.get(i).getPizza_name());
			name[i].setLayoutX(15.0);
			name[i].setLayoutY(118.0+k);
			name[i].setTextFill(javafx.scene.paint.Color.WHITE);
			name[i].setFont(new Font("System Bold", 16.0));
			
			price[i] = new Label(String.valueOf(data.get(i).getPizza_price()));
			price[i].setLayoutX(200.0);
			price[i].setLayoutY(118.0+k);
			price[i].setTextFill(javafx.scene.paint.Color.WHITE);
			price[i].setFont(new Font("System Bold", 16.0));
			
			quantity[i] = new TextField();
			quantity[i].setLayoutX(420.0);
			quantity[i].setLayoutY(118.0+k);
			quantity[i].setPrefHeight(25.0);
			quantity[i].setPrefWidth(70.0);
			quantity[i].setPromptText("quantity");
			
			root.getChildren().addAll(name[i],price[i],quantity[i]);
			
			k = k + 45;
		}
		
		Button btn_back = new Button();
        btn_back.setLayoutX(366.0);
        btn_back.setLayoutY(118+k);
        btn_back.setMnemonicParsing(false);
        btn_back.setPrefHeight(30.0);
        btn_back.setPrefWidth(101.0);
        btn_back.setText("BACK");
        
        btn_back.setOnAction(e->{
        	stage.setScene(mainscene);
        });
		
		Button btn_insert = new Button();
        btn_insert.setLayoutX(75.0);
        btn_insert.setLayoutY(118 + k);
        btn_insert.setMnemonicParsing(false);
        btn_insert.setPrefHeight(30.0);
        btn_insert.setPrefWidth(101.0);
        btn_insert.setText("PRESS");
        
        btn_insert.setOnAction(e -> {
        		
		for (int i = 0; i < quantity.length; i++) {
			
			if(quantity[i].getText() == null || quantity[i].getText().trim().isEmpty()) {
				
			}else {
				
				float p = data.get(i).getPizza_price();
				int aa = Integer.parseInt(quantity[i].getText());
				
				total_amount = total_amount + ( p * aa );
			}
			
		}
		
		BookOrder b = new BookOrder(stage, mainscene, total_amount);
		stage.setScene(b.getScene());
		stage.show();
        });
        
        
		root.getChildren().addAll(label1,label2,label3,title,btn_insert,btn_back);
		
		ScrollPane sp = new ScrollPane();
        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sp.setContent(root);
        sp.setPannable(true);
        
        scene = new Scene(sp);	
	}
	
	public Scene getScene() {
		return scene;
	}
	
}
