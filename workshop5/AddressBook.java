package cmastache;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage; // stage is the actual window

public class AddressBook extends Application {
	@Override
	public void start(Stage stage) 
	{				
		// creating grid pane and setting dimensions
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER); 
		grid.setPadding(new Insets(10, 10, 10, 10)); 
	    
		// creating text boxes and adding to grid at coordinates: col, row
		grid.add(new Label("First Name:"), 0, 0);
	    TextField firstName = new TextField();
	    GridPane.setColumnSpan(firstName, 5);
	    grid.add(firstName, 1, 0);
	    
		grid.add(new Label("Last Name:"), 0, 1);
	    TextField lastName = new TextField();
	    GridPane.setColumnSpan(lastName, 5);
	    grid.add(lastName, 1, 1);
		
	    
	    grid.add(new Label("City:"), 0, 3);
	    TextField city = new TextField();
	    grid.add(city, 1, 3);
	    
	    grid.add(new Label("Province:"), 2, 3);
	    ChoiceBox<Text> provinceField = new ChoiceBox<Text>();
	    provinceField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	    grid.add(provinceField, 3, 3);
	    
	    grid.add(new Label("Postal Code: "), 4, 3);
	    TextField postalCode = new TextField();
	    grid.add(postalCode, 5, 3);
		
		 // creating buttons
		Button add = new Button("Add");
		Button first = new Button("First");
		Button next = new Button("Next");
		Button previous = new Button("Previous");
		Button last = new Button("Last");
		Button update = new Button("Update");
	 	
		// resizing buttons and adding buttons to window
		add.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		grid.add(add, 0, 4);
		
		first.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		grid.add(first, 1, 4);
		
		next.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		grid.add(next, 2, 4);
		
		previous.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		grid.add(previous, 3, 4);
		
		last.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		grid.add(last, 4, 4);
		
		update.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		grid.add(update, 5, 4); 

		// creating display and naming it
		Scene scene = new Scene(grid);
		stage.setTitle("Address Book");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
