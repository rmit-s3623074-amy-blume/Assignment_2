import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindString {
	private String name;
	private String ID;
	public String findName(String s){
		
	    
		String patternID = "(R+\\d+)";
		Pattern p = Pattern.compile(patternID);
		Matcher m = p.matcher(s.toString());
		
		while (m.find()){
			String name = m.group(1);
			System.out.print(" " + m.group(1));
			this.name = name;
		}
		return name;	
	}
	
	public String getID(String s){
		
		String patternID = "([A-Z]+[a-z]+)";
			Pattern p = Pattern.compile(patternID);
			Matcher m = p.matcher(s.toString());
			while (m.find()){
				String ID = m.group(1);
				System.out.print(" " + m.group(1));
				this.ID = ID;
			}
			return ID;	
		}
	
	public void getType(String s){
		String patternID = "(sprinter|swimmer|cyclist|offcial)";
		Pattern p = Pattern.compile(patternID);
		Matcher m = p.matcher(s.toString());
		while (m.find()){
			System.out.println(" " + m.group(1));
			
	
		}
			
	}
		
	
	public void findOfficials(){
		
	}
}
