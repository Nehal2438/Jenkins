package GUIController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Model.ModelPizza;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddPizza {

	private Scene scene;
	
	public AddPizza(Stage stage,Scene mainscene) {
	
		AnchorPane root = new AnchorPane();
		scene = new Scene(root);
		root.setLayoutX(-1.0);
		root.setPrefHeight(573.0);
		root.setPrefWidth(538.0);
		root.setStyle("-fx-background-color: blue;");
		
		Label title = new Label("Add Pizza");
		title.setFont(new Font("Arial BOLD", 22));
		title.setLayoutX(178.0);
		title.setLayoutY(14.0);
		title.setTextFill(javafx.scene.paint.Color.WHITE);
		
		Label label1 = new Label("Pizza Name");
		label1.setLayoutX(15.0);
        label1.setLayoutY(78.0);
		label1.setTextFill(javafx.scene.paint.Color.WHITE);
		label1.setFont(new Font("System Bold", 16.0));
		
		Label label2 = new Label();
		label2.setLayoutX(15.0);
		label2.setLayoutY(121.0);
		label2.setText("Pizza Price");
		label2.setFont(new Font("System Bold", 16.0));
		label2.setTextFill(javafx.scene.paint.Color.WHITE);
		
		TextField pizza_name = new TextField();
		pizza_name.setLayoutX(252.0);
		pizza_name.setLayoutY(77.0);
		pizza_name.setPrefHeight(25.0);
		pizza_name.setPrefWidth(228.0);
		pizza_name.setPromptText("pizza name");
        
		TextField pizza_price = new TextField();
		pizza_price.setLayoutX(252.0);
		pizza_price.setLayoutY(120.0);
		pizza_price.setPrefHeight(25.0);
		pizza_price.setPrefWidth(228.0);
		pizza_price.setPromptText("pizza price");
		
        Button btn_insert = new Button();
        btn_insert.setLayoutX(75.0);
        btn_insert.setLayoutY(502.0);
        btn_insert.setMnemonicParsing(false);
        btn_insert.setPrefHeight(30.0);
        btn_insert.setPrefWidth(101.0);
        btn_insert.setText("INSERT DATA");
        
        btn_insert.setOnAction(e -> {
        	ModelPizza model_pizza = new ModelPizza(pizza_name.getText(), Float.parseFloat(pizza_price.getText()));
    		try {
				insert_data_text_file(model_pizza);
				Alert alert = new Alert(AlertType.INFORMATION,"Pizza Data Inserted");
				alert.setTitle("Pizza System");
				alert.showAndWait();
    		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		pizza_name.clear();
    		pizza_price.clear();
        });
        
        Button btn_clear = new Button();
        btn_clear.setLayoutX(219.0);
        btn_clear.setLayoutY(502.0);
        btn_clear.setMnemonicParsing(false);
        btn_clear.setPrefHeight(30.0);
        btn_clear.setPrefWidth(101.0);
        btn_clear.setText("CLEAR");
        
        btn_clear.setOnAction(e->{
        	pizza_name.clear();
    		pizza_price.clear();
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
        
		root.getChildren().addAll(title,label1,label2,pizza_name,pizza_price,btn_insert,btn_clear,btn_back);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void insert_data_text_file(ModelPizza model_pizza) throws IOException {
		
		StringBuilder builder = new StringBuilder();
		builder.append(model_pizza.getPizza_name()+" ");
		builder.append(model_pizza.getPizza_price()+"\n");
		
		File file = new File("pizza_data.txt");
		FileWriter fr = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.print(builder.toString());
		pr.close();
		br.close();
		fr.close();
		
	}
}
