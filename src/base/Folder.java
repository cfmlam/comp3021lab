package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Folder implements Comparable<Folder>,java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Note> notes;
	private String name;
	
	public Folder(String name)
	{
		this.name = name;
		notes = new ArrayList<Note>();
	}
	public void addNote(Note note)
	{
		notes.add(note);
	}
	
	public String getName()
	{
		return name;
	}
	public ArrayList<Note> getNotes()
	{
		return notes;
	}
	
	
	
	@Override
	public String toString() {
		int nText=0;
		int nImage=0;
		
		for(Note F: notes)
		{
			if(F instanceof TextNote)
				nText++;
			if(F instanceof ImageNote)
				nImage++;
		}
		
		return name+":"+nText+":"+nImage;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Folder o) {
		// TODO Auto-generated method stub
			if(name.compareTo(o.name)>0)
				return 1;
			else if(name.compareTo(o.name)<0)
				return -1;
			else
		return 0;
	}
	
	public void sortNotes()
	{
		Collections.sort(notes);
	}
	
	public List<Note> searchNotes(String keywords)
	{
		List<Note> RNote = new ArrayList<Note>();
		keywords = keywords.toLowerCase();
		String[] kArray = keywords.split(" ");
		Boolean titlecheck;
		Boolean contentcheck = false;
		for(Note F:notes)
		{
			titlecheck = true;
			for(int i=0; i < kArray.length; i++)
			{
				if(kArray[i].compareTo("or")==0)
				{
					if( !(F.getTitle().toLowerCase().contains(kArray[i-1]) 
							|| F.getTitle().toLowerCase().contains(kArray[i+1]) ))
					{
						titlecheck = false;
						break;
					}
					else
						continue;
				}
				else if( !(i-1 > 0 && kArray[i-1].compareTo("or")==0)
						|| (i+2 < kArray.length && kArray[i+1].compareTo("or")==0))
				{
					if(!(F.getTitle().toLowerCase().contains(kArray[i])))
					{
						titlecheck = false;
						break;
					}
				}
			}
			if (F instanceof TextNote)
			{
				//TextNote newNote = new TextNote(F.getTitle(),((TextNote) F).getContent());
				//String content = ((TextNote) F).getContent().toLowerCase();
				//System.out.println(content);
				contentcheck = true;
				for(int i=0; i < kArray.length; i++)
				{
					if(kArray[i].compareTo("or")==0 )
					{
						if( !( ((TextNote) F).getContent().toLowerCase().contains(kArray[i-1]) || ((TextNote) F).getContent().toLowerCase().contains(kArray[i+1]) ))
						{
							contentcheck = false;
							break;
						}
						else
							continue;
					}
					else if( !((i-1 > 0 && kArray[i-1].compareTo("or")==0) || (i+2 < kArray.length && kArray[i+1].compareTo("or")==0)))
					{
						if(!((TextNote) F).getContent().toLowerCase().contains(kArray[i]))
						{
							contentcheck = false;
							break;
						}
					}
				}
			}
			if (titlecheck || contentcheck)
			{
				RNote.add(F);
			}
		}
		
		return RNote;
		
	}
	
}
