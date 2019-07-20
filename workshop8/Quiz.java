/**********************************************
Workshop #8
Course: JAC 444
Last Name: Mastache
First Name: Citlalli
ID: 126275189
Section: SAB
This assignment represents my own work in accordance with Seneca Academic Policy.
electronically signed by: Citlalli Mastache
Date: July 19th, 2019.
**********************************************/

package workshop8;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Quiz extends Application {
	int num1, num2, right, wrong;
	final int range = 10;
	static boolean exit;

	public void randomize() {
		num1 = (int) (Math.random()*range);
		num2 = (int) (Math.random()*range);
	}
	
	public boolean add(String num) {
		int answer = Integer.parseInt(num);
		return answer == (num1 + num2);
	}
	
	public boolean subtract(String num) {
		int answer = Integer.parseInt(num);
		return answer == (num1 - num2);
	}
	
	public boolean multiply(String num) {
		int answer = Integer.parseInt(num);
		return answer == (num1 * num2);
	}
	
	public boolean divide(String num) {
		int answer = Integer.parseInt(num);
		return answer == (num1 / num2);
	}
	
	public boolean end(String num) {
		// asking the user if they would like to continue, Y means continue, therefore we do not exit
		if (num == "Y") {
			exit = false;
		}
		return exit == true;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// creating grid pane and setting dimensions
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 100, 30, 100)); 

////////////////////////////// START PROGRAM /////////////////////////////////
		// ensuring that we are not using zero values to avoid throwing an exception
		while (num1 == 0 || num2 == 0) {
			randomize();
		}
		String numbers = num1 + " and " + num2;
		
		grid.add(new Label("All fields are required."), 0, 0);
		Label initial = new Label("Two randomly generated numbers are: " + numbers);
		grid.add(initial, 0, 1);
		Label addLabel = new Label("What is addition of " + numbers + ":");
		grid.add(addLabel, 0, 2);
		TextField addition = new TextField();
		grid.add(addition, 1, 2);
		Label subtractLabel = new Label("What is subtraction of " + numbers + ":");
		grid.add(subtractLabel, 0, 3);
		TextField subtraction = new TextField();
		grid.add(subtraction, 1, 3);
		Label multiplyLabel = new Label("What is multiplication of " + numbers + ":");
		grid.add(multiplyLabel, 0, 4);
		TextField multiplication = new TextField();
		grid.add(multiplication, 1, 4);
		Label divideLabel = new Label("What is division of " + numbers + ":");
		grid.add(divideLabel, 0, 5);
		TextField division = new TextField();
		grid.add(division, 1, 5);
		Label correct = new Label("Number of Correct Answers" + ": " + right);
		Label incorrect = new Label("Number of Wrong Answers" + ": " + wrong);
		grid.add(correct, 0, 6);
		grid.add(incorrect, 0, 7);
		grid.add(new Label("Would you like to try with two other numbers?"), 0, 9);
		TextField restart = new TextField();
		grid.add(restart, 1, 9);
		
		Button submit = new Button("Submit");
		grid.add(submit, 1, 10);
		
		// calculating answers
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent a) {
				if (add(addition.getText())) {
					right++;
				}
				else {
					wrong++;
				}
				if (subtract(subtraction.getText())) {
					right++;
				}
				else {
					wrong++;
				}
				if (multiply(multiplication.getText())) {
					right++;
				}
				else {
					wrong++;
				}
				if (divide(division.getText())) {
					right++;
				}
				else {
					wrong++;
				}
				correct.setText("Number of Correct Answers" + ": " + right);
				incorrect.setText("Number of Wrong Answers" + ": " + wrong);
				if (end(restart.getText())) {
					stage.close();
				}
				else {
					// clear all fields
					multiplication.clear();
					division.clear();
					addition.clear();
					subtraction.clear();
					restart.clear();
					randomize();
					String numbers = num1 + " and " + num2;
					initial.setText("Two randomly generated numbers are: " + numbers);
					multiplyLabel.setText("What is multiplication of " + numbers + ":");
					addLabel.setText("What is addition of " + numbers + ":");
					divideLabel.setText("What is division of " + numbers + ":");
					subtractLabel.setText("What is subtraction of " + numbers + ":");
				}
			}
		});
	    
		// creating display and naming it
 		Scene scene = new Scene(grid);
 		stage.setTitle("Quiz Application");
 		stage.setScene(scene);
 		stage.show();
	}
	// launching the program
	public static void main(String[] args) {
		launch(args);
	}
}
