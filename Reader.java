import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Math;
public class Reader {
	private String path;
	
	public Reader(String filePath){
		path = filePath;
	}
	
	public Reader() {
		// TODO Auto-generated constructor stub
	}

	public String [] OpenFile() throws IOException{
		FileReader file = new FileReader(path);
		BufferedReader textReader = new BufferedReader(file);
		
		int lines = readLines();
		String fileData [] = new String[lines];
		
		int i;
		for (i = 0; i < lines; i++){
			fileData[i] = textReader.readLine();}
			textReader.close();
			return fileData;
		}
	
	public int readLines() throws IOException {
		FileReader fileRead = new FileReader(path);
		BufferedReader bf = new BufferedReader(fileRead);
		
		
		String aLine;
		int numLines = 0;
		
		while ((aLine = bf.readLine()) != null){
			numLines++;
		}
		return numLines;
	}
}
