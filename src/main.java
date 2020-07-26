
import java.io.IOException;
import java.util.*;
import javax.swing.*;



public class main {

	static JTextPane txtTrick = new JTextPane();
	
	//Objectifying My classes 
	static Search search = new Search();
	static Trick trick = new Trick();
	static String str_manaul;
	static String str_trick = "";
	static Level level = new Level();
	private static int count =0;
	private static int size =0; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("\n Start: "+ CurrentTime.GetTime().toString()+ "\n \n");
		

		System.out.println("\n Select trick type: \n 1) Flatground \n 2) Manuals(pad) \n 3) Ledges + Rails \n  Input: ");
		Scanner selected = new Scanner(System.in);
		int type = Integer.parseInt(selected.next());

		//The trick list
		String[] list;
		
		if(type > 1)
		{
			size = 500;
		}
		else
		{
			size = 200;
		}
		
		list = new String[size];
		
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
		
		
		while(end < list.length)
		{
			str_trick = trick.getTrick(type);
			
			//ensure no empty tricks
			if(!str_trick.trim().equals(""))
			{
				count++;
				list[end] = str_trick; 		
				str_trick = "";
				end = end + 1;
			}
		}
		
		System.out.println("\n Program looped " + count + " times when making the unorder list \n");
		

		//list = search.theCount(list);
		list = search.theFix(list,type);
		
		
		System.out.println("\n Program looped "+ search.loop_count + " times while fixing the trickbook(removing duplicates) \n");
		
		//print tricks in array to file
		for(int i = 0; i<list.length ; i++)
		{
			
			output.println(list[i].toString().trim());
		}
		
		output.close();
		
	
		//System.out.println("\n Stopped "+CurrentTime.GetTime().toString());		
		//System.out.println(" \n \nDo a:\n "+ str_trick);	
		
		
		//results is a list of averages for each trick
		double[] track = new double[size];
		
		for(int i = 0; i <= track.length-1; i++)
		{
			track[i] = level.TrickDifficulty(list[i].toString().trim());
			
			dirt.println(list[i].toString().trim() + "		" +  level.TrickDifficulty(list[i].toString().trim()));
		}
		
		dirt.close();
		
		//gets the max
		//Max(track,list);
		
		
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
		
		System.out.println("\n Done \n");
		
		System.out.println("\n Stopped "+CurrentTime.GetTime().toString());		

		
		
		System.out.println("\n \n Check if trick exists: (enter \"stop\") to end search session. \n");
		Scanner input = new Scanner(System.in);
		String key = input.nextLine();

		while(!key.equals("stop"))
		{
			
			if(search.exists(key))
			{
				System.out.println("\n  Hypothetical score of: " + level.TrickDifficulty(key.trim()) + " \n");
			}
			else
			{
				System.out.println("\n Hypothetical score of: "  + level.TrickDifficulty(key.trim()) + " \n");
			}
			key = input.nextLine();
		}
		
			
		//tricks.close();
		//results.close();
		selected.close();
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
		
		System.out.println("\n average trick difficulty: "+ sum/track.length );
		
	}


}
