package cmastache;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Welcome extends Application {
	//using pane instead of circle object allows for characters to be printed out, one by one, in the exact location you want them
	Pane pane = new Pane();
	// setting up our desired string to display and splitting it into individual characters
	String[] str = "Welcome to Java".split("");
	
	@Override
	public void start(Stage stage) 
	{
		// my favourite font!
		Font font = Font.font("Courier New", FontWeight.BOLD, 40);
		// setting the center of the circle
		Point2D center = new Point2D(300, 300);
		// setting the data for our circle
        double circleSize = 200;
        double angle = 0;
        double rotation = 90;
        double pixels = 22;
        
        // looping through each character of the string
        for (int i = 0; i < str.length; i++, angle += pixels, rotation += pixels) {
        	//some maths that sets the point where the letter will be placed
            double x = center.getX() + circleSize * Math.cos(Math.toRadians(angle));
            double y = center.getY() + circleSize * Math.sin(Math.toRadians(angle));

            // for each letter, turn into text object that will display at the intersection point of x and y
            Text text = new Text(x, y,str[i]);
            // rotate the letter
            text.setRotate(rotation);
            // set the font
            text.setFont(font);
            // add this to the pane
            pane.getChildren().add(text);

        }
        // send the pane to a scene that is 600 x 600 pixels large
	    Scene scene = new Scene(pane, 600, 600);  
	    // name the scene
	    stage.setTitle("Welcome to Java"); 
	    // send the scene to a window
	    stage.setScene(scene); 
	    // show the window
	    stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
