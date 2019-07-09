package cmastache;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Checkerboard extends Application 
{
	// 8 squares wide and high
	static int width = 8;
	static int height = 8;
	// big enough to see the title of my window
	static int pixels = 40;
	@Override
	public void start(Stage stage) 
	{
		// this is the element that will hold the grid
		Pane grid = new Pane();
		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < height; col++)
			{
				// making a new rectangle, and, based on pixels size, 
				// setting each side of the rectangle in one go
				Rectangle rectangle = new Rectangle(col * pixels, row * pixels, pixels, pixels);
				if (row % 2 == col % 2)
				{
					rectangle.setFill(Color.BLACK);
				}
				else 
				{
					rectangle.setFill(Color.WHITE);
				}
				// adding current rectangle to grid
				grid.getChildren().add(rectangle);
			}
		}
		Scene scene = new Scene(grid);
		stage.setTitle("Chessboard");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) 
	{
		launch(args);
	}

}
