

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Search
{
	static Trick trick = new Trick();
	public int loop_count = 0;
 
	
	//its pretty much a search function to find a trick in the trickbook.txt file
	public void exists(String str_trick) throws IOException
	{		
		java.io.File trickbook = new java.io.File("trickbook.txt");
				
		Scanner glasses = new Scanner(trickbook);

		int count = 0;
		String inline = "";
		
		while(glasses.hasNext())
		{
			inline = glasses.nextLine().toString().trim();

			if(str_trick.toString().trim().equals(inline.toString().trim()))
			{				
				count = count + 1;
			}
		}
		
		if(count == 0 )
		{
			System.out.println("damn shame \n");
		}
		else
		{
			System.out.println("Yes \n");
		}

		

		System.out.println("Bye bye punk \n");
		
		glasses.close();
	}

	
	//fixes the trickbook by removing and replacing the tricks that repeat
	public String[] theFix( String[] list)
	{
		String str_trick = "";
		String[] temp = list;
		
		for(int i =0;i < temp.length ; i++)
		{		
			for(int j = 0;j < list.length ; j++)
			{
				if(temp[i].toString().trim().equals(list[j].toString().trim()) && i!=j)		// i != j because temp is a copy of list and therefore the elements are at the same index
				{
					str_trick = "";
					while(str_trick.trim().equals("")) 		//only exits once i have a trick
					{
						str_trick = trick.TrickSelection();
						loop_count ++;
					}
					//System.out.println("\n at "  + j + " : " + list[j]  + "  from " + i + " in temp[] : to ->  "  + str_trick);
					
					list[j] = str_trick;
					theFix(list);
				}
			}
		}
		
		return list;
	}
	
	//counts how many times a trick appears in the trickbook
	public String[] theCount(String[] list) throws IOException
	{
		
		int count = 0;
		
		String[] stats = new String[list.length];
		
		String[] temp = list;
		
		for(int i =0;i < temp.length ; i++)
		{		
			for(int j = 0;j < list.length ; j++)
			{
				if(temp[i].toString().trim().equals(list[j].toString().trim()))	
				{
					count = count + 1 ; 
				}
			}
			stats[i] = temp[i].toString().trim() + "----> " + count ;
			count= 0;
		}
		
		return stats;
	}
	
}