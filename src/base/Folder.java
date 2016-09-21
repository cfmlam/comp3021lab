package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Folder implements Comparable<Folder> {
	
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
		keywords = keywords.toLowerCase();
		String[] kArray = keywords.split(" ");
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		int index=0;
		
		while(kArray[index]!=null)
		{
			if(kArray[index+1].compareTo("or")!=0 && kArray[index].compareTo("or")!=0)
			for(Note F : notes)
			{
				if(F instanceof TextNote)
				{
					if(F.getTitle().toLowerCase().contains(kArray[index]))
						result.add(true);
					else if(((TextNote) F).getContent().toLowerCase().contains(kArray[index]))
						result.add(true);
				}
				if(F instanceof ImageNote)
				{
					if(F.getTitle().toLowerCase().contains(kArray[index]))
						result.add(true);
				}
			}
			else
			{
				if(kArray[index].compareTo("or")==0)
				{index++;continue;}
				else 
				{
					for(Note F : notes)
					{
						boolean temp = true;
						if(F instanceof TextNote)
						{
							if(!F.getTitle().toLowerCase().contains(kArray[index]))
							temp=false;
							if(!F.getTitle().toLowerCase().contains(kArray[index+2]))
							temp=false;
							if(!((TextNote) F).getContent().toLowerCase().contains(kArray[index]))
							temp=false;
							if(!((TextNote) F).getContent().toLowerCase().contains(kArray[index+2]))
							temp=false;
						}
						if(F instanceof ImageNote)
						{
							if(!F.getTitle().toLowerCase().contains(kArray[index]))
							temp=false;
							if(!F.getTitle().toLowerCase().contains(kArray[index+2]))
							temp=false;
						}
					}
				}
			}
			index++;
		}
			
	}
	
}
