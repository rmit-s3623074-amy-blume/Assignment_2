
public class TooFewAthleteException extends Exception {

	public TooFewAthleteException(String message){
		super(message);
		System.out.println(message);
	}
}
