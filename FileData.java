import java.io.IOException;
import java.util.*;
public  class FileData  {
	  

	public String [] getFile() {
		int i = 10;
	    String [] aryLines = new String[i];
		String rfile = "C:/Users/amybl/Documents/participants.txt";
		List<String> strings = new ArrayList<String>();
	try {
		Reader file = new Reader(rfile);
	    aryLines = file.OpenFile( );
		
		for ( i=0; i < aryLines.length; i++ ) {
		System.out.println( aryLines[i]);
		
		}
	
		}
	catch (IOException e){
		System.out.println(e.getMessage());
	}
	return aryLines;
	}
	
	public static void main(String[] args) throws IOException {
	
	}
}
