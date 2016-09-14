package base;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<Folder> folders;
	public NoteBook()
	{
		folders = new ArrayList<Folder>();
	}
	
	private boolean insertNote(String folderName, Note note)
	{
		Folder f=null;
		for(Folder F1: folders)
		{
			if(folderName.equals(F1))
				f=F1;
		}
		if(f==null)
		{
			f = new Folder(folderName);
			folders.add(f);
		}
		boolean added=false;
		for(Note n: f.getNotes())
		{
			if(note.equals(n))
			{
				System.out.println("Creating note "+note.getTitle()+" under folder "+folderName+" failed.");
				added=true;
				return
			}
		}
		if(added==false)
		f.add(note);
	}
	
	public boolean createTextNote(String folderName, String title)
	{
		TextNote note = new TextNote(title);
		return insertNote
	}
}
