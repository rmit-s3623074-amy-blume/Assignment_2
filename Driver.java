import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Driver extends Application implements Comparable {
	Stage stage;
	int athNum = 0;
	
	ObservableList alist = FXCollections.observableArrayList();
	ComboBox<String> c;
	ArrayList<Athlete> competes = new ArrayList<Athlete>();
	Official official = null;
	private Athlete winner;
	private Athlete second;
	private GameResults results;

	
	public void start(Stage primaryStage)  {
		stage = primaryStage;
		primaryStage.setTitle("Ozlympics-Menu");
		//All of the buttons to be displayed on menu screen
		Button bt1 = new Button("Cycling");
		Button bt2 = new Button("Swimming");
		Button bt3 = new Button("Running");
		Button bt4 = new Button("Display All Results"); //shows all results 
		Button bt5 = new Button("Display Athlete Scores"); //displays all scores of athletes
		
		
		bt1.setTextFill(Color.WHITE);
		bt1.setStyle("-fx-background-color: maroon;");
		bt1.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 16));
		
		bt2.setTextFill(Color.WHITE);
		bt2.setStyle("-fx-background-color: maroon;");
		bt2.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 16));
		
		bt3.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 16));
		bt3.setTextFill(Color.WHITE);
		bt3.setStyle("-fx-background-color: maroon;");
		
		bt4.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 16));
		bt4.setTextFill(Color.WHITE);
		bt4.setStyle("-fx-background-color: maroon;");
		
		bt5.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 16));
		bt5.setTextFill(Color.WHITE);
		bt5.setStyle("-fx-background-color: maroon;");
		
		ButtonHandler handler = new ButtonHandler();
		bt1.setOnAction(handler);
		
		ButtonHandler3 handler3 = new ButtonHandler3();
		bt2.setOnAction(handler3);
		
		//choose running from main menu
		bt3.setOnAction(e ->{
			running();
		});
		
		bt4.setOnAction(e -> {
			seeResults();
		});
				
		
		ButtonHandler5  handler5 = new ButtonHandler5();
		bt5.setOnAction(handler5);
		
		Pane buttons = new VBox(30);
		Pane sports = new HBox(50);
		sports.getChildren().addAll(bt1, bt2, bt3);
		StackPane.setAlignment(sports,Pos.CENTER);
		
		Text text3 = new Text("OZLYMPICS");
		Text text1 = new Text("To start a game, please select an event from below");
		Text text2 = new Text("Other options");
		
		text3.setFill(Color.INDIANRED);
		text3.setFont(Font.font("Rockwell Extra Bold", 80));
		
		text1.setFont(Font.font("Calbri",FontWeight.BOLD, 15));
		text1.setFill(Color.WHITE);
		text2.setFont(Font.font("Calibri", FontWeight.BOLD, 15));
		text2.setFill(Color.WHITE);
		buttons.getChildren().addAll( text3,   text1 ,sports, text2, bt4, bt5);
		Color back = Color.rgb(23, 200, 49);
		Scene scene1 = new Scene (buttons, 600,600);
		buttons.setStyle("-fx-background-color: black;");
		
		stage.setScene(scene1);
		
		primaryStage.show();
		
		
	}
	
	class ButtonHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			cycling();
		}	
		
	}
		class ButtonHandler2 implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e){
				start(stage);
			}
		}
		class ButtonHandler3 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			swimming();
			athNum = 0;
		}
   }	
		// add athletes chosen from combobox
		class Add implements EventHandler<ActionEvent> {
			public void handle(ActionEvent e){
			addList();
		}
	}	
		
		class ButtonHandler4 implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e){
				
			}
		}
		

		class ButtonHandler5 implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e){
				scores();
			}
		}

		
		class ButtonHandler6 implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e){
				try{
				runGame();
				}catch(TooFewAthleteException f){
					showAlert();
				}
				 catch(NoRefereeException g){	
					 noRefAlert();
				 }
	
			}	
		
		}
		
		class combo implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e){
				alist.add(c.getValue().toString());
				
			}
		}	
		
	public Text addList(){
		Reader r = new Reader();
		ArrayList<String> athleteList = new ArrayList<String>(8);
		
		Text athletes = new Text(athleteList.toString());
		athletes.setFill(Color.WHITE);
		Pane list = new Pane();
		list.getChildren().add(athletes);
		Scene scene3 = new Scene(list);
		try{	r.OpenFile();
		
		stage.setScene(scene3);
		}
	
		catch(Exception d){
			System.out.println("nah");
		}
      return  athletes;
   }
	
	public GameResults cycling() { //Cycling game run page
		//TODO: need to set one method to use for all
		Button bt1 = new Button("Back");
		Button bt2 = new Button("Add");
		Button bt3 = new Button("Remove");
		Button bt4 = new Button("START GAME");
		Button bt5 = new Button("Add Official");
		
		ButtonHandler2 handler = new ButtonHandler2();
		bt1.setOnAction(handler);  // returns to first menu screen
		
		GridPane list = new GridPane();
		list.setHgap(6);
		list.setVgap(30);
		Scene scene2 = new Scene(list, 500,400);
		stage.setScene(scene2);
		stage.setTitle("Ozlympics: Cycling");
		list.setStyle("-fx-background-color: black;");
		
	    ButtonHandler6 game = new ButtonHandler6();
		bt4.setOnAction(game);
		
		Text text1 = new Text("CYCLING");
		text1.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 30));
		Text text3 = new Text("Add athletes from below to compete in game");
		text3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		Text text6 = new Text("Please select an offcial");
		text6.setFill(Color.WHITE);
		text6.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		text3.setFill(Color.WHITE);
		text1.setFill(Color.TAN);
		bt4.setTextFill(Color.YELLOW);
		bt4.setStyle("-fx-font-size: 16");
		bt4.setStyle("-fx-background-color: black");
		
		ComboBox<String> c = choiceList();
		ComboBox<String> off = officialBox();
		
		list.add(text1, 0, 0);
		list.add(text3, 0, 1);
		list.add(bt2, 2, 2);
		list.add(bt3, 3, 2);
		list.add(c, 0, 2);
		list.add(bt1, 0, 5);
		list.add(bt4, 3, 5);
		list.add(bt5, 2, 4);
		list.add(off, 0, 4);
		list.add(text6, 0, 3);
		
		
		bt5.setOnAction(e ->{
			GameResults r = new GameResults("a", null, null);
			FindString f = new FindString();
			String choice = off.getValue().toString();
			f.findName(choice.toString());
			f.getID(choice.toString());
			Official ref = new Official(f.findName(choice), f.getID(choice));
			official = ref;
		  //  list.add(offName, 0, 7);
		   r.addRef(ref);
		   results = r;
		});
		
	    bt2.setOnAction(e ->{
			
			String choice = c.getValue().toString();
			FindString f = new FindString();
			f.findName(choice.toString());
			f.getID(choice.toString());
			f.getType(choice);
			
			alist.add(choice);
			for(int i =0; i < alist.size(); i++){
			i++; //prints next name below
			athNum++; //adds athlete counter every time button is pressed
			Cyclist s = new Cyclist( f.findName(choice), f.getID(choice), 0, 0);
			competes.add(s);
			
			}
	   
		});
	        
		return results;	
	    
	    
	}
	
public GameResults swimming(){ //Swimming game run page
		
		Button bt1 = new Button("Back");
		Button bt2 = new Button("Add");
		Button bt3 = new Button("Remove");
		Button bt4 = new Button("START GAME");
		Button bt5 = new Button("Add Official");	
		ButtonHandler2 handler = new ButtonHandler2();
		bt1.setOnAction(handler);
		GridPane list = new GridPane();
		list.setHgap(6);
		list.setVgap(30);
		Scene scene2 = new Scene(list, 500,400);
		stage.setScene(scene2);
		stage.setTitle("Ozlympics: Swimming");
		list.setStyle("-fx-background-color: black;");
		
	   ButtonHandler6 game = new ButtonHandler6();
		bt4.setOnAction(game);
		
		Text text1 = new Text("SWIMMING");
		text1.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 30));
		Text text3 = new Text("Add athletes from below to compete in game");
		Text text4 = new Text("Please choose an official");
		text3.setFill(Color.WHITE);
		text3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		text4.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		text1.setFill(Color.LIGHTBLUE);
		bt4.setTextFill(Color.YELLOW);
		text4.setFill(Color.WHITE);
		bt4.setStyle("-fx-font-size: 16");
		bt4.setStyle("-fx-background-color: black");
		
		ComboBox<String> c = choiceList();
		ComboBox<String> off = officialBox();
		
		list.add(text1, 0, 0);
		list.add(text3, 0, 1);
		list.add(bt2, 2, 2);
		list.add(bt3, 3, 2);
		list.add(c, 0, 2);
		list.add(bt1, 0, 6);
		list.add(bt4, 3, 6);
		list.add(bt5, 2, 5);
		list.add(off, 0, 5);
		list.add(text4, 0, 4);
   
		 bt5.setOnAction(e ->{
			 GameResults r = new GameResults("a", null, null);
			FindString f = new FindString();
			String choice = off.getValue().toString();
			f.findName(choice.toString());
			f.getID(choice.toString());
			Official offi = new Official(f.findName(choice), f.getID(choice));
			official = offi;
			  r.addRef(offi);
			   results = r;
			});
			
		    bt2.setOnAction(e ->{
				
				String choice = c.getValue().toString();
				FindString f = new FindString();
				f.findName(choice.toString());
				f.getID(choice.toString());
				f.getType(choice);
				
				alist.add(choice);
				Swimmer s = new Swimmer( f.findName(choice), f.getID(choice), 0, 0);
				competes.add(s);
				for(int i =0; i < alist.size(); i++){;
				i++; //prints next name below
				athNum++; //adds athlete counter every time button is pressed
				
				}
				
			});
			
		return results;
	}

public GameResults running() { //Running game run page
	
	Button bt1 = new Button("Back");
	Button bt2 = new Button("Add");
	Button bt3 = new Button("Remove");
	Button bt4 = new Button("START GAME");
	Button bt8 = new Button("Add Official");
	
	ButtonHandler2 handler = new ButtonHandler2();
	bt1.setOnAction(handler);
	
	GridPane list = new GridPane();
	list.setHgap(6);
	list.setVgap(30);
	Scene scene2 = new Scene(list, 500,400);
	stage.setScene(scene2);
	stage.setTitle("Ozlympics: RUNNING");
	list.setStyle("-fx-background-color: black;");
	
    ButtonHandler6 game = new ButtonHandler6();
	bt4.setOnAction(game);
	
	Text text1 = new Text("RUNNING");
	text1.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 30));
	Text text3 = new Text("Add athletes from below to compete in game");
	text3.setFill(Color.WHITE);
	text3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	text1.setFill(Color.LIGHTGREEN);
	bt4.setTextFill(Color.YELLOW);
	bt4.setStyle("-fx-font-size: 16");
	bt4.setStyle("-fx-background-color: black");
	
	ComboBox<String> c = choiceList();
	ComboBox<String> off = officialBox();
	
	list.add(text1, 0, 0);
	list.add(text3, 0, 1);
	list.add(bt2, 2, 2);
	list.add(bt3, 3, 2);
	list.add(c, 0, 2);
	list.add(off, 0, 4);
	list.add(bt1, 0, 6);
	list.add(bt4, 3, 6);
	list.add(bt8, 2, 6);
	
	bt8.setOnAction(e ->{
		GameResults r = new GameResults("a", null, null);
		FindString f = new FindString();
		String choice = off.getValue().toString();
		f.findName(choice.toString());
		f.getID(choice.toString());
		Official offi = new Official(f.findName(choice), f.getID(choice));
		official = offi;
		Label offName = new Label("Your official is " + offi.getName());
	    list.add(offName, 0, 7);
	   r.addRef(offi);
	   results = r;
	});
	
    bt2.setOnAction(e ->{
		
		
		String choice = c.getValue().toString();
		FindString f = new FindString();
		f.findName(choice.toString());
		f.getID(choice.toString());
		f.getType(choice);
		

		alist.add(choice);
		Sprinter s = new Sprinter( f.findName(choice), f.getID(choice), 0, 0);
		
		competes.add(s);
		for(int i =0; i < alist.size(); i++){
		athNum++; //adds athlete counter every time button is pressed
		
		}
		
	});
	return results;	
	
    	
    }

	public Label resultInfo(){
		Label label = new Label();
		return label;
	}

    public void seeResults() { //to go to results page and display results
    	Text results = new Text("Results so far");
    	results.setFont(Font.font("Rockwell Extra Bold", 30));
    	Button back = new Button("Back");
    	displayResults();
    	Label resultsT = new Label();
    	resultsT = showResults();
    	resultsT.setTextFill(Color.WHITE);
    	resultsT.setFont(Font.font("Rockwell Extra Bold", 15));
    	ButtonHandler2 handler = new ButtonHandler2();
		back.setOnAction(handler);
		results.setFill(Color.WHITE);
    	GridPane list = new GridPane();
    	list.setStyle("-fx-background-color: black;");
    	list.setVgap(50);
    	list.add(results, 0, 0);
    	list.add(back,  1, 1);
    	list.add(resultsT, 0, 1);
    	Scene scene4 = new Scene(list, 300, 400);
    	stage.setScene(scene4);
    }

	   
	public void scores(){ //shows all scores so far
		Text scores = new Text("SCORES");
		Button back = new Button("Back");
		ButtonHandler2 handler = new ButtonHandler2();
		back.setOnAction(handler); //goes back to first menu
		scores.setFont(Font.font("Rockwell Extra Bold", 30));
		scores.setFill(Color.BEIGE);
    	GridPane list = new GridPane();
    	
    	Label label = new Label(competes.get(0).getName() + " " + competes.get(0).getScore() + "\n"
    							+competes.get(1).getName() + " " + competes.get(1).getScore() + "\n"
    							+ competes.get(2).getName() + " " + competes.get(2).getScore()
    			                );
    	label.setTextFill(Color.WHITE);
    	label.setFont(Font.font("Rockwell Extra Bold", 16));
    	list.setVgap(50);
    	list.setStyle("-fx-background-color: black;");
    	list.add(scores, 0, 0);
    	list.add(back,  0, 6);
    	list.add(label, 0, 2);
    	Scene scene4 = new Scene(list, 300, 400);
    	stage.setScene(scene4);
	
	}	//makes sure enough athletes have been added
	public void checkAthletes() throws TooFewAthleteException{
	if (athNum < 4){
	
	
		throw new TooFewAthleteException("Not enough athletes");
		} 
	}
	
	
	
	public void showAlert(){ //if less than 4 athletes are in a game
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setContentText("Not enough athletes");
	alert.show();
	}
	
	public void checkForRef() throws NoRefereeException{ //shows message when no referee has been added
		if (official == null){
			throw new NoRefereeException("Please assign an official before starting your game");
		}
	}
	
	public void noRefAlert(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("No Referee Assigned");
		alert.show();
	}
	

	
	public void noResultsAlert(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Results are empty!");
	}
	
	public void checkIfFull() throws GameFullException{
		if (athNum ==8){
			throw new GameFullException("Game already Full");
		}
	}
	
	public void gameFullAlert(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Game Already Full");
	}
	  //run and show results of game
	public void runGame() throws TooFewAthleteException, NoRefereeException {
	checkAthletes();	// makes sure correct number of athletes
	checkForRef(); //makes sure official is assigned
	getAthletes(); 

	getTimes();
	writeFile(); //writes results to file gameResults

	stage.setScene(animate());
   // competes = null;
	}
	
	public void showScores(){
		Text endGame = new Text("Game Over");
		endGame.setFont(Font.font("Rockwell Extra Bold", FontWeight.BOLD, 30));
		endGame.setFill(Color.RED);
		
		Button menu = new Button("Menu"); // go back to first menu after game is run
		ButtonHandler2 handler = new ButtonHandler2();
		menu.setOnAction(handler);
		GridPane end = new GridPane();
		end.setVgap(50);
		
	    Label label = new Label();
	    label = showResults();
	    label.setTextFill(Color.RED);
	    end.add(endGame, 0, 0);
		end.add(menu, 2, 4);
		end.add(label, 1, 2);

		Scene scene5 = new Scene(end, 500, 400);
		end.setStyle("-fx-background-color: black");
		stage.setScene(scene5);
	}
	
	public void startGame(){
		Application.launch();
		}	
	
	// fill the drop down list witch choices from the text file
	public ComboBox<String>  choiceList(){
		FileData g = new FileData();
		ComboBox<String> athletes = new ComboBox<String>();
		athletes.getItems().addAll(g.getFile());
		c = athletes;
		return c;
	}
	
	// uses compete method to generate times
	public void getTimes(){
		ArrayList<Double> list = new ArrayList <Double>();
		double d = 0;
		int i;
		
		for (i = 0; i <competes.size(); i++){
		competes.get(i).compete();
		d =	competes.get(i).getTime();
		  list.add(d);
		}
		for(i = 0; i<list.size(); i++)  {
			if(list.get(0) == competes.get(i).getTime()){
				
				winner = competes.get(i);
				setWinner(winner);
				second = competes.get(1);
				setSecond(second);
				winner.addScore(5);
				second.addScore(2);
				}
			
			  Collections.sort(competes, new Comparator<Athlete>() { //sorts the athletes by their times
			        public int compare(Athlete o1, Athlete o2) {
			            return o1.getTime()<o2.getTime()?-1:o1.getTime()>o2.getTime()?1: 0;
			        }
			  });
			  
			  for (int j = 0; j < competes.size(); j++){
				  competes.get(j).printName();
		        	competes.get(j).printTime();
		        winner = competes.get(0);
		        second = competes.get(1);   
			  }
		
		//return list;
		}
		
	}
	
public	Athlete setWinner(Athlete a){
		this.winner = a;
		return winner;
}

public Athlete setSecond(Athlete a){
	this.second = a;
	return second;
}

public Athlete getWinner(){
	
	return winner;
}


	public Label showResults(){
		
		Label label = new Label((competes.get(0).getName() + competes.get(0).getTime() + "\n"
				+ competes.get(1).getName() + " " + competes.get(1).getTime() + "\n"
				+ competes.get(2).getName() + competes.get(2).getTime() + "\n"
				+ competes.get(3).getName() + competes.get(3).getTime() + "\n"
				+ competes.get(4).getName() + competes.get(4).getTime() + "\n"
				+ competes.get(5).getName()+ competes.get(5).getTime() + "\n"));
			//	+ competes.get(6).getName()+ competes.get(6).getTime() + "\n");
		label.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		
		return label;
	}

	public ComboBox officialBox(){
		ComboBox<String> official = new ComboBox();
		FileData f = new FileData();
		official.getItems().addAll(f.getFile());
		return  official;
	}
   
	
	public GameResults getResults(){
		
		return results;
	}
	// print info stored  in the game results
	public Label displayResults(){
		GameResults res = new GameResults();
		res = results;
		String names = "";
		System.out.println();
		String id = res.getID();
		for (int i = 0; i <competes.size(); i++){
			names = competes.get(i).getName();
			System.out.print(" ");
		}
		Label a = new Label("Game ID " + id + " \n Referee " + official.getName() + "\n" + competes.get(0).getName() + names);
//	System.out.println("Referee " + referee + "\n" + names);	
		
	
return a;
	}
	public Athlete getAthletes(){
		return winner;
	}
		

	public Scene animate() {
			
			stage.setTitle("Ozlympics-Race");
			Button bt1 = new Button("Skip to results");
			Button bt2 = new Button("Back to menu");
			Button bt3 = new Button("REPLAY");
			bt3.setLayoutX(50);
			bt3.setLayoutY(450);
			bt3.setStyle("-fx-background-color: maroon;");
			bt3.setFont(Font.font("Rockwell Extra Bold", 20));
			bt3.setTextFill(Color.LIGHTBLUE);
			bt3.setOnAction(e ->{
				animate();
			});
			bt1.setLayoutX(550);
			bt1.setLayoutY(450);
			bt1.setStyle("-fx-background-color: maroon;");
			bt1.setFont(Font.font("Rockwell Extra Bold", 20));
			bt1.setTextFill(Color.LIGHTBLUE);
			
			bt1.setOnAction(e -> {
				showScores();
			});
			
			bt2.setLayoutX(350);
			bt2.setLayoutY(450);
			bt2.setStyle("-fx-background-color: maroon;");
			bt2.setFont(Font.font("Rockwell Extra Bold", 20));
			bt2.setTextFill(Color.LIGHTBLUE);
			bt2.setOnAction(e -> {
				start(stage);
			});
			Label label1 = new Label(competes.get(0).getName());
			label1.setLayoutY(50);
		    label1.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		    label1.setTextFill(Color.WHITE);
		   
		    Label label2 = new Label(competes.get(1).getName());
		    label2.setLayoutY(100);
		    label2.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		    label2.setTextFill(Color.WHITE);
		   
		    Label label3 = new Label(competes.get(2).getName());
		    label3.setLayoutY(150);
		    label3.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		    label3.setTextFill(Color.WHITE);
		  
		    Label label4 = new Label(competes.get(3).getName());
		    label4.setLayoutY(200);
		    label4.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		    label4.setTextFill(Color.WHITE);
		  
		
		    Group root = new Group();
		    Scene scene = new Scene(root, 800, 600, Color.BLACK);
		    stage.setScene(scene);

		 
		    
		    
		    stage.show();
		    Group rectangles = new Group();
		    Rectangle r = new Rectangle(100, 50, 100, 20);
		    r.setFill(Color.ORANGE);
		    Rectangle r2 = new Rectangle(100, 100, 100, 20);
		    r2.setFill(Color.AQUA);
		    Rectangle r3 = new Rectangle(100, 150, 100, 20);
		    r3.setFill(Color.PURPLE);
		    Rectangle r4 = new Rectangle(100, 200, 100, 20);
		    r4.setFill(Color.FORESTGREEN);
		   
		  
		    
		 
		    rectangles.getChildren().addAll(r, r2, r3, r4);
			root.getChildren().addAll(rectangles, bt1, label1, label2, label3, label4, bt2, bt3);
			
		
			    
			Timeline timeline = new Timeline();
			
			timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
					new KeyValue(r.translateXProperty(), 0),
					new KeyValue(r.translateYProperty(), 0)),
					new KeyFrame(new Duration(competes.get(0).getTime() * 1000),
					new KeyValue(r.translateXProperty(), 500),
					new KeyValue(r.translateYProperty(), 0)));
		
			timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
					new KeyValue(r2.translateXProperty(), 0),
					new KeyValue(r2.translateYProperty(), 0)),
					new KeyFrame(new Duration(competes.get(1).getTime() * 1000),
					new KeyValue(r2.translateXProperty(), 500),
					new KeyValue(r2.translateYProperty(), 0)));	
			
			timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
					new KeyValue(r3.translateXProperty(), 0),
					new KeyValue(r3.translateYProperty(), 0)),
					new KeyFrame(new Duration(competes.get(2).getTime() * 1000),
					new KeyValue(r3.translateXProperty(), 500),
					new KeyValue(r3.translateYProperty(), 0)));
			
			timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
					new KeyValue(r4.translateXProperty(), 0),
					new KeyValue(r4.translateYProperty(), 0)),
					new KeyFrame(new Duration(competes.get(3).getTime() * 1000),
					new KeyValue(r4.translateXProperty(), 500),
					new KeyValue(r4.translateYProperty(), 0)));
			
			timeline.play();
			Rectangle r5 = new Rectangle(100, 250, 100, 20);
			  r5.setFill(Color.RED);
			    Rectangle r6 = new Rectangle(100, 300, 100, 20);
			    r6.setFill(Color.BLUEVIOLET);
			    
			    
			    if (competes.get(4) != null){  Label label5 = new Label(competes.get(4).getName());
			    label5.setLayoutY(250);
			    label5.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
			    label5.setTextFill(Color.WHITE);
			    root.getChildren().add(label5);
			    }
			    
			    if (competes.get(5) != null){  Label label6 = new Label(competes.get(5).getName());
			    label6.setLayoutY(250);
			    label6.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
			    label6.setTextFill(Color.WHITE);
			    root.getChildren().add(label6);
			    }
			    
		if (competes.get(4) != null){	timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
					new KeyValue(r5.translateXProperty(), 0),
					new KeyValue(r5.translateYProperty(), 0)),
					new KeyFrame(new Duration(competes.get(4).getTime() * 1000),
					new KeyValue(r5.translateXProperty(), 500),
					new KeyValue(r5.translateYProperty(), 0)));
		            rectangles.getChildren().add(r5);
		            } 

			if (competes.get(5) != null) { timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
					new KeyValue(r6.translateXProperty(), 0),
					new KeyValue(r6.translateYProperty(), 0)),
					new KeyFrame(new Duration(competes.get(5).getTime() * 1000),
					new KeyValue(r6.translateXProperty(), 500),
					new KeyValue(r6.translateYProperty(), 0)));
	
			}
			
			
			timeline.play();
		
			
		 return scene;
	}
	
		public void writeFile(){
			FileWriter writer = null; //create text file of results
			try {
				writer = new FileWriter("gameResults.txt");
				
				writer.write(results.getID() +" "+ official.getName());
				writer.write(competes.get(0).getName() +  competes.get(0).getTime() + competes.get(0).getScore() + "\n");
				writer.write(competes.get(1).getName() +  competes.get(1).getTime() + "\n");
				writer.write(competes.get(2).getName() +  competes.get(2).getTime() + "\n");
			//	writer.write(competes.get(3).getName() +  competes.get(3).getTime() + "\n");
			//	writer.write(competes.get(4).getName() +  competes.get(4).getTime() + " \n");
			//	writer.write(competes.get(0).getName() +  competes.get(0).getTime() + " \n");
			//	writer.write(competes.get(0).getName() +  competes.get(0).getTime() + " \n");
			//	writer.write(competes.get(0).getName() +  competes.get(0).getTime() + " \n");
				
			

				writer.close();
					
			} catch (IOException e) {
				System.err.println("File cannot be created, or cannot be opened");
				System.exit(0);
			}
		}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
	

