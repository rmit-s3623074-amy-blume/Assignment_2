import java.util.Random;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
public class Cyclist extends Athlete {
    
	public Cyclist(String ID, String name, int score, double time){
		super(ID, name, score, time);
	}
    
    public Cyclist(String ID, String name, int age, String state, int score, double time) {
		super(ID, name, age, state, score, time);
		
	}
	
	public double compete(){
		Random r = new Random();
		double c = this.getTime();
	    c = r.nextInt(500)+ 300;
	    setTime(c);
		return getTime() ;
	}

	@Override
	public void addListener(ChangeListener<? super String> arg0) {
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
