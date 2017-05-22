import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public abstract class Athlete extends Participant implements ObservableValue<String> {
	private int score;
	private double time;
	
	public Athlete(String ID, String name, int score, double time){
		super(ID, name, score, time);
		this.time = time;
	}

	public Athlete(String ID, String name, int age, String state, int score, double time){
		super(ID, name, age, state);	
		this.score = score;
	}
	public Athlete(String s){
		super(s);
	}
	
	
   
	//will randomly generate a time for different types of athletes
	public double compete(){
		return time;
	};
	
	
	//returns score
	public int getScore(){
		return score;
	}
	
	public double getTime(){
		return this.time;
	}
	

	public void printTime(){
		
	}
	
	public void setTime(double a){
		time = a;
	}
	//print name of current athlete
	public void printName(){
		getName();
		System.out.print(" " + this.getName());
	}
	
   //print the score of the athlete
   public void printScore(){
	   System.out.println(this.score);
   }
   //add a score depending on what place athlete finishes
   public int addScore(int place){
	   score =+ place;
	   return score;
   }
	

}
