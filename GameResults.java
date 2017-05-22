import java.util.ArrayList;

public class GameResults {
	private String GameID;
	private Official ref;
	private ArrayList <Athlete> a;
	
	public GameResults(String GameID, Official ref, ArrayList<Athlete> a){
		this.GameID = GameID;
		this.ref = ref;
		this.a = a;
    }
	
	public GameResults(){
		
	}
	
	public Official getRef(){
		return ref;
	}
	public void addRef(Official o){
		ref = o;
	}
	
	public void addResults(ArrayList<Athlete> array){
		a = array;
	}
	
   public ArrayList getResults(){
	   return a;
   }
	
	
	
	public String getID(){
		char a = 'S';
		Integer i = 01;
		GameID = (a + i.toString());
		System.out.print(GameID);
		return GameID;
	}

	public void printInfo(){ //for printing Game info/results
	System.out.println("\n Game ID: " + GameID);
	System.out.println("\n Referee " + ref.getName()); 
	System.out.println("\n Winner: " + a.get(0).getName());
	System.out.println("\n Second:" + a.get(0).getName());
	System.out.println("\n Third:" + a.get(1).getName());
	System.out.println("_______________________");
	}

}	 

