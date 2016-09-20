package base;

public class TextNote extends Note{
	
	private String content;

	public TextNote(String title) {
		super(title);
		// TODO Auto-generated constructor stub
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
	
	//overload method CreateTextNode
	public boolean createTextNode(String folderName, String title, String content)
	{
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}

	private boolean insertNote(String folderName, TextNote note) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
