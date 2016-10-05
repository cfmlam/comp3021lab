package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TextNote extends Note{
	
	private String content;

	public TextNote(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public TextNote(File f) {
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
		}
	
	private String getTextFromFile(String absolutePath) {
		String result = "";
		Scanner input;
		try {
			input = new Scanner(new File(absolutePath));
			while (input.hasNext())
					result.concat(input.next());
				input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void exportTextToFile(String pathFolder) {
		String titleName = this.getTitle();
		titleName = titleName.replace(" ", "_");
		try {
		File file = new File( pathFolder + titleName + ".txt");
			FileWriter fw = new FileWriter(file);
			fw.write(this.content);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	public String getContent()
	{
		return content;
	}
	
	public TextNote(String title, String content)
	{
		super(title);
		this.content=content;
	}
	
	
	
	/*//overload method CreateTextNode
	public boolean createTextNode(String folderName, String title, String content)
	{
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}

	private boolean insertNote(String folderName, TextNote note) {
		// TODO Auto-generated method stub
		return false;
	}
	*/
	
}
