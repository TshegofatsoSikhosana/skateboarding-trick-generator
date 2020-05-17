
import java.io.IOException;
import java.util.*;
import javax.swing.*;



public class main {

	static JTextPane txtTrick = new JTextPane();
	
	//Objectifying My classes 
	static Search search = new Search();
	static Trick trick = new Trick();
	static String str_trick = "";
	static Level level = new Level();

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("\n Start: "+ CurrentTime.GetTime().toString()+ "\n \n");
		
		String[] list = new String[250];
		
		for(int i = 0 ;i < list.length;i++)
		{
			list[i] = "";
		}

		int end = 0;
		
		//Creates the files
		java.io.File trickbook = new java.io.File("trickbook.txt");
		
		//This file will have the list of unordered tricks and how many times they repeat in the trickbook
		java.io.File dirtybook = new java.io.File("dirtybook.txt");
		
		//For testing
		//java.io.File testCases = new java.io.File("test.txt");
		//java.io.File testResults = new java.io.File("testResults.txt");
		
		
		
		//Defines the IO for the file trickbook
		java.io.PrintWriter output = new java.io.PrintWriter(trickbook);
		java.io.PrintWriter dirt = new java.io.PrintWriter(dirtybook);
		
		//Defines the IO for the file test
		//Scanner tests = new Scanner(testResults);
		int count =0;
		
		while(end < list.length)
		{
			while(str_trick.trim().equals("")) 		//only exits once i have a trick
			{
				count++;
				str_trick = trick.TrickSelection();//NB*
				if(end == 125)
				{
					if(!str_trick.trim().equals(""))
					{
						System.out.println("Half way done...i am still thinking but here is a trick you can track in the trickbook : " + str_trick);
						//System.out.println(str_difficulty);					
					}
				}
				else if(end == 126) 
				{
					System.out.println(" \n i am still thinking \n");
				}
			}
			
			list[end] = str_trick;
			str_trick = "";
			end = end + 1;
		}

		//list = search.theCount(list);
		list = search.theFix(list);
		
		System.out.println("\n Program looped " + count + " times when making the unorder list \n");
		
		System.out.println("\n Program looped "+ search.loop_count + " times while fixing the trickbook(removing duplicates) \n");
		
		//print tricks in array to file
		for(int i = 0; i<list.length ; i++)
		{
			
			output.println(list[i].toString().trim());
		}
		
		output.close();
		
	
		//System.out.println("\n Stopped "+CurrentTime.GetTime().toString());		
		//System.out.println(" \n \nDo a:\n "+ str_trick);	
		
		
		//results is a list of averages for each trick and max
		double[] track = new double[250];
		
		for(int i = 0; i <= track.length-1; i++)
		{
			track[i] = level.TrickDifficulty(list[i].toString().trim());
			
			dirt.println(list[i].toString().trim() + "		" +  level.TrickDifficulty(list[i].toString().trim()));
		}
		
		dirt.close();
		//gets the max
		Max(track,list);
		
		
		String str_trick ="";		
		
		//
		/*Scanner tricks = new Scanner(trickbook);
		
		//printing to results file
		//java.io.PrintWriter results = new java.io.PrintWriter(testResults);
				
		while(tricks.hasNextLine())
		{
			str_trick = tricks.nextLine();
			
			level.TrickDifficulty(str_trick);
			
			if(level.isTrick(str_trick))
			{
				//System.out.println("\n PASS \n");
				
			}
			else
			{
				//results.println(str_trick +  " FAILED \n");
			}
		}*/
		
		System.out.println("\n Stopped "+CurrentTime.GetTime().toString());		
		System.out.println("\n Done \n");
		
		
		System.out.println("\n Check if trick exists: (enter \"stop\") to end search session. \n");
		Scanner input = new Scanner(System.in);
		String key = input.nextLine();

		while(!key.equals("stop"))
		{
			if(level.isTrick(key.trim()))
			{
				//search.exists(key);
				System.out.println("\n Hooray...It is a trick  and its score is " + level.TrickDifficulty(key.trim()) + " \n");
			}
			else
			{
				System.out.println("\n Boo hoo...It is not a trick ");
			}
			key = input.nextLine();
		}
		
			
		//tricks.close();
		//results.close();
		input.close();
		
	}
	
	private static void Max(double[] track,String[] list)
	{
		double max = 0;
		double sum=0;
		int pos =0;
		
		
		for(int i = 0;i <track.length;i++)
		{
			if(max < track[i])
			{
				max = track[i];
			}
			sum = sum + track[i];
		}
		
		
		//check which tricks have the same difficulty level
		for(int i = 0; i <track.length;i++)
		{
			if(max == track[i])
			{
				pos = i+1;
				System.out.println("Max trick");
				System.out.println("\n"+ list[i] +" at " + pos + ": " + max + "\n");
			}
		}
		
		System.out.println("\n average trick difficulty: "+ sum/track.length + "\n");
		
	}


}
