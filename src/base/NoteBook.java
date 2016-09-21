package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
			if(F1.getName().equals(folderName))
				f=F1;
		}
		if(f==null)
		{
			f = new Folder(folderName);
			folders.add(f);
		}
		boolean Needadd=true;
		for(Note n: f.getNotes())
		{
			if(n.getTitle().equals(note.getTitle()))
			{
				System.out.println("Creating note "+note.getTitle()+" under folder "+folderName+" failed.");
				Needadd=false;
			}
		}
		if(Needadd==true)
		f.getNotes().add(note);
		
		
		return Needadd;
	}
	
	public boolean createTextNote(String folderName,String title)
	{
		TextNote note= new TextNote(title);
		return insertNote(folderName, note);
	}
	
	public boolean createTextNote(String folderName, String title, String string)
	{
		TextNote note = new TextNote(title,string);
		return insertNote(folderName,note);
	}
	
	public boolean createImageNote(String folderName, String title)
	{
		ImageNote note = new ImageNote(title);
		return insertNote(folderName,note);
	}
	
	public ArrayList<Folder> getFolders()
	{
		return folders;
	}
	
	public void sortFolders()
	{
		Collections.sort(folders);
	}
	
	public List<Note> searchNotes(String keywords)
	{
		ArrayList<Note> result = new ArrayList<Note>();
		for(Folder F: folders)
		{
			result.addAll(F.searchNotes(keywords));
		}
		return result;
	}
	
}
