
public class GameFullException extends Exception {
	
	public GameFullException(String message){
		super(message);
		System.out.println(message);
	}
}
