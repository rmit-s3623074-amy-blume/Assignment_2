import java.util.Random;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class Sprinter extends Athlete{
	
	String a;
	
	public Sprinter(String ID, String name, int score, double time){
		super(ID, name, score, time);
	}
	
	public Sprinter(String ID, String name, int age, String state, double time, int score) {
		super(ID, name, age, state, score, time);
		
	}
    
	public Sprinter(String s){
		super(s);
		a = s;
	}

		
	
	public String getInfo(){
		return a;
	}
	// Generates random time for sprinters
	public double compete(){
		double a;
		Random rand = new Random();
		
		a = this.getTime();
		a = rand.nextInt(11) + 10;
		setTime(a);
		
		return getTime();
	}
	 public void printTime(){
		 System.out.println(this.getTime());
		 
	 }


	@Override
	public void addListener(ChangeListener<? super String> listener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removeListener(ChangeListener<? super String> listener) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}
	 
	
 
 
 
 
}
