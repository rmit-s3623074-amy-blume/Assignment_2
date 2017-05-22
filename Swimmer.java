import java.util.Random;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
public class Swimmer  extends Athlete {
	
	public Swimmer(String ID, String name, int age, String state, int time, int score) {
		super(ID, name, age, state, time, score);
	}
	

	public Swimmer(String ID, String name, int score, double time){
		super(ID, name, score, time);
		
	}

	public double compete() {
		Random r = new Random();
		double x = this.getTime();
		x = r.nextInt(200)+100;
		setTime(x);
		return getTime();
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
	public void removeListener(ChangeListener<? super String> arg0) {
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
