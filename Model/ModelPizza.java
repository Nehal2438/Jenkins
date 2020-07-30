package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ModelPizza {

	private String pizza_name;
	private float pizza_price;
	
	public ModelPizza() {
		super();
	}

	public ModelPizza(String pizza_name, float pizza_price) {
		super();
		this.pizza_name = pizza_name;
		this.pizza_price = pizza_price;
	}

	public String getPizza_name() {
		return pizza_name;
	}

	public void setPizza_name(String pizza_name) {
		this.pizza_name = pizza_name;
	}

	public float getPizza_price() {
		return pizza_price;
	}

	public void setPizza_price(float pizza_price) {
		this.pizza_price = pizza_price;
	}
	
public ArrayList<ModelPizza> load_data() throws NumberFormatException, IOException{
		
		ArrayList<ModelPizza> list = new ArrayList<ModelPizza>();
		FileInputStream fs= new FileInputStream("pizza_data.txt");
		BufferedReader brr = new BufferedReader(new InputStreamReader(fs));
		String line = brr.readLine();
		while(line != null)
		{
			String[] xx = line.split(" ");
			ModelPizza employee_model = new ModelPizza(xx[0],Float.parseFloat(xx[1]));
			list.add(employee_model);
			line = brr.readLine();
		}
		return list;
	}

	
}
