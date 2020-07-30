package application;
	
import java.io.File;

import GUIController.AddPizza;
import GUIController.CreateOrder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {

	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			VBox root = new VBox(20);
			scene = new Scene(root,450,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.setStyle("-fx-background-color: blue;");
			
			Label title = new Label("Pizza System");
			title.setFont(new Font("Arial BOLD", 22));
			root.setMargin(title, new Insets(20, 20, 20, 140));
			title.setTextFill(javafx.scene.paint.Color.WHITE);
			
			Button button1 = new Button("Add Pizza");
			button1.prefHeight(34);
			button1.prefWidth(117);
			root.setMargin(button1, new Insets(20, 20, 10, 180));
			
			Button button2 = new Button("Create Order");
			button2.prefHeight(34);
			button2.prefWidth(117);  
		    root.setMargin(button2, new Insets(20, 20, 10, 180)); 
		    
		    root.getChildren().addAll(title,button1,button2);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
			button1.setOnAction(e -> {
				AddPizza add_pizza = new AddPizza(primaryStage,scene);
				primaryStage.setScene(add_pizza.getScene());
			});
			button2.setOnAction(e -> {
				CreateOrder create_order = new CreateOrder(primaryStage,scene);
				primaryStage.setScene(create_order.getScene());
			});
					
			File file = new File("pizza_data.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
