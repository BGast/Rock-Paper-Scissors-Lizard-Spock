package rockpaperscissorslizardspock;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * ClassName: RockPaperScissorsLizardSpock
 * @author Brock Gast
 * @since 06/15/2018
 * Description - Using JavaFX and radio buttons, you are able to play a game of 
 * Rock, Paper, Scissors, Lizard, Spock 
 */
public class RockPaperScissorsLizardSpock extends Application {
   
    private final Label lblResult = new Label("Who will win!?!");
    private int userPick, computerPick;
    private String userSelection, computerSelection;
    private String result;
	
        /**
         * @param primaryStage 
         */
    @Override
	public void start(Stage primaryStage) {
		
            BorderPane pane = new BorderPane();		
		
            HBox paneForRadioButtons = new HBox(20);
            paneForRadioButtons.setPadding(new Insets(5, 5 ,5, 5));
            paneForRadioButtons.setStyle("-fx-border-color: red");
            RadioButton rbRock = new RadioButton("Rock");
            RadioButton rbPaper = new RadioButton("Paper");
            RadioButton rbScissors = new RadioButton("Scissors");
            RadioButton rbLizard = new RadioButton("Lizard");
            RadioButton rbSpock = new RadioButton("Spock");
            paneForRadioButtons.getChildren().addAll(rbRock, rbPaper, rbScissors, rbLizard, rbSpock);
		
            pane.setBottom(paneForRadioButtons);
            
            // Allows only one button to selected at a time
            ToggleGroup group = new ToggleGroup();
            rbRock.setToggleGroup(group);
            rbPaper.setToggleGroup(group);
            rbScissors.setToggleGroup(group);
            rbLizard.setToggleGroup(group);
            rbSpock.setToggleGroup(group);	
                             
            rbRock.setOnAction(e -> {
		if(rbRock.isSelected()) {
                    userPick = 1;
                    userSelection = "Rock";
                    displayResults();
        	}
            });
            rbPaper.setOnAction(e -> {
		if(rbPaper.isSelected()) {
                    userPick = 2;
                    userSelection = "Paper";
                    displayResults();
		}
            });
            rbScissors.setOnAction(e -> {
		if(rbScissors.isSelected()) {
                    userPick = 3;
                    userSelection = "Scissors";
                    displayResults();
		}
            });
            rbLizard.setOnAction(e -> {
		if(rbLizard.isSelected()) {
                    userPick = 4;
                    userSelection = "Lizard";
                    displayResults();
		}
            });
            rbSpock.setOnAction(e -> {
		if(rbSpock.isSelected()) {
                    userPick = 5;
                    userSelection = "Spock";
                    displayResults();
		}
            });         
		
            Pane paneForText = new Pane();
            paneForText.getChildren().add(lblResult);
            pane.setCenter(paneForText);
            
            Scene scene = new Scene(pane, 400, 100);
            primaryStage.setTitle("Rock, Paper, Scissors, Lizard, Spock ");
            primaryStage.setScene(scene);
            primaryStage.show();		
	}
        /**
         * Decides what the computer will choose
         * @return computerPick 
         */
        public int getCompSelection() {
            Random random = new Random();
            computerPick = random.nextInt(5) + 1;
        switch (computerPick) {
            case 1:
                computerSelection = "Rock";
                break;
            case 2:
                computerSelection = "Paper";
                break;
            case 3:
                computerSelection = "Scissors";
                break;
            case 4:
                computerSelection = "Lizard";
                break;
            case 5:
                computerSelection = "Spock";
                break;
            default:
                System.out.print("Error! It appears something went wrong in"
                        + " getComputerSelection");
                break;
        }
            
            return computerPick;
	}
        /**
         * Figures out which player will win or if it's a tie
         * @return result 
         */
        public String runGame() {
            getCompSelection();
            
            if ((userPick == 1 && computerPick == 3)
		|| (userPick == 2 && computerPick == 1)
		|| (userPick == 3 && computerPick == 2)
                || (userPick == 1 && computerPick == 4)
                || (userPick == 5 && computerPick == 3)
                || (userPick == 3 && computerPick == 4)
                || (userPick == 4 && computerPick == 2)
                || (userPick == 2 && computerPick == 5)
                || (userPick == 5 && computerPick == 1)
                || (userPick == 4 && computerPick == 5)) {
                result = "Player Wins!";
            } else if ((computerPick == 1 && userPick == 3)
		|| (computerPick == 2 && userPick == 1)
		|| (computerPick == 3 && userPick == 2)
                || (computerPick == 1 && userPick == 4)
                || (computerPick == 5 && userPick == 3)
                || (computerPick == 3 && userPick == 4)
                || (computerPick == 4 && userPick == 2)
                || (computerPick == 2 && userPick == 5)
                || (computerPick == 5 && userPick == 1)
                || (computerPick == 4 && userPick == 5)) {
		result = "Computer Wins!";
            } else {
		result = "It's a tie!";
            }
            
            return result;
	}
        /**
         * Shows the winner on the display
         */
        public void displayResults() {
            runGame();
            lblResult.setText("You picked " + userSelection
			+ " and the computer picked " + computerSelection + ".\n" + result);
	}	
        /**
         * @param args 
         */
	public static void main(String[] args) {
            launch(args);
    }
}