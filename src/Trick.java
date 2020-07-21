
import java.util.*;

public class Trick
{
	private Random generator = new Random();
	private TrickComponents component = new TrickComponents();
	private Level level = new Level();
	//enum ObstacteType = {'CURB','LEDGE','RAIL'};
	
	String TrickSelection()										//generates the trick-name 
	{
	
		String str_stance = "";
		String str_pop = "";
		String str_flip = "";
		String str_flip_count = "";
		String str_board_rotation = "";
		String str_body_rotation = "";
		String str_board_spin = "";
		String str_manual = "";
		boolean special = false;
		String trick = "";
		
		
		
		str_stance = component.Stance();
//	System.out.println("stance= " + str_stance);
		str_flip = component.Flip();
	//	System.out.println("flip= " + str_flip);
		str_flip_count = component.FlipCount();
		str_board_rotation = component.Board_R();
	//	System.out.println("board= " + str_board_rotation);
		str_body_rotation = component.Body_R();
	//	System.out.println("body= " + str_body_rotation);
		str_pop = component.Pop();
	//	System.out.println("pop= " + str_pop);
		str_board_spin = component.Board_Spin();
	//	System.out.println("board= " + str_board_spin);
		str_manual = component.Manual();
	 
		
		trick = TheMagic(str_stance,str_pop,str_board_rotation,str_body_rotation,str_flip,str_flip_count,str_board_spin,special,str_manual);
		
		 

		return trick;
	}
	
	
	
	String Obstacle(String type)
	{
		
		if(type == "FLAT")
		{
			//call theMagic function
		}
		else if(type == "STAIRS")
		{
			//call  theMAgic Function
		}
		else if(type == "LEDGE")
		{
			
		}
		else if(type == "RAIL")
		{
			
		}
		else if(type == "CURB")
		{
			//call Manuals;
		}
		
		return "";
	}
	
	String Manuals(String trick)
	{
		String str_combo = "";
		String str_manual = "";
		
		
		//Check if there is a trick set
		if(trick.trim().equals(""))
		{
			//just manual
			while(str_manual.trim().equals(""))
			{
				str_manual = component.Manual();
			}
			return str_manual;
			
			//need to add pivots
		}
		else
		{
			//Possible combinations are
			//Trick to manual, Manual to Trick, 
			int manual_action = generator.nextInt(3);
			
			if(manual_action == 0)		//into
			{
				//When a trick is done into manual
				while(str_manual.trim().equals(""))
				{
					str_manual = component.Manual();
				}
				
				str_combo = trick.trim() + " " + str_manual.trim();
				
				//before returning maybe a trick is done out from manual
				manual_action = generator.nextInt(2);
				if(manual_action == 0)
				{
					trick = "";
					while(trick.equals(""))
					{
						trick = TrickSelection();
					}
					
					//For the trick to make sense
					if(level.TrickDifficulty(trick) < 6)
					{
						str_combo = str_combo + " " + trick;
					}
					
					return str_combo;
				}
				
				return str_combo;
				
			}
			else if(manual_action == 1)	//out
			{
				//When a manual is done and a trick is done out of it
				while(str_manual.trim().equals(""))
				{
					str_manual = component.Manual();
				}
				
				
				if(str_manual.trim().equals("nose manual"))	//mt str_manual.trim().equals("nose manual")
				{
					//Check if the stance exists
					if(trick.split(" ")[0].trim().equals("nollie") || trick.split(" ")[0].trim().equals("fakie"))
					{
						//change the order of the trick
						//because you can't have a nose manual nollie kickflip. Maybe nollie nose manual kickflip
						
						String combo =  trick.split(" ")[0]  + " " + str_manual;
						

						//System.out.println("Hey.... " + trick);
						
						for(int i = 1; i<trick.split(" ").length ;i++)
						{
							combo = combo +  trick.split(" ")[i] + " " ; 
						}
						str_combo = combo;
					}
				}
				else if((str_manual.trim().equals("manual")))
				{
					
					//Check if the stance exists and is not fakie/nollie
					if(!trick.split(" ")[0].trim().equals("nollie") && !trick.split(" ")[0].trim().equals("fakie"))
					{
						//change the order of the trick
						//because you can't have a nose manual switch kickflip. Maybe switch manual kickflip
						if(trick.split(" ")[0].trim().equals("switch"))
						{
							//System.out.println("Hey,wassup... " + trick);
							String combo =  trick.split(" ")[0]  + " " + str_manual;
							
							for(int i = 1; i<trick.split(" ").length ;i++)
							{
								combo = combo +  trick.split(" ")[i] + " " ; 
							}
							str_combo = combo;
						}
						else
						{
							str_combo = str_manual.trim()  + " " + trick.trim();	
						}		
					}
				}
				
				return str_combo;
			}
			else
			{
				//just the trick
				return str_combo;
			}
			
		}
	
	}
	
	String Special()
	{
		
		
		return "";
	}
	
	private String TheMagic(String str_stance, String str_pop, String str_board_rotation, String str_body_rotation,String str_flip,String str_flip_count,String str_board_spin, boolean special,String str_manual)
	{
		 String trick ="";
		 
		 //creative tricks, all the caspers and stuff
		 if(special == true)
		 {
			 trick = Special();
			 return trick;
		 }
		
		if(str_pop.trim().equals("ollie") && str_stance.trim().equals(""))						//you can only ollie in one way otherwise it's a stance thing
		{	
			//System.out.println("Hey,wassup...");
			
			//just ollie or flip
			if(str_body_rotation.trim().equals("") && str_board_rotation.trim().equals("") )
			{
				if(!str_flip.trim().equals(""))
				{
					if(str_flip_count.trim().equals("")) 
					{
						trick = str_flip;
					}
					else
					{
						trick = str_flip_count + str_flip;										//e.g double heeflip
					}
					
				}
				else
				{
					trick = str_pop;			//just an ollie
				}
			}
			
			//************************************************************************************************
			//For all the trick rotations in ollie excluding pop shuv-its
			//*************************************************************************************************
			if(!str_body_rotation.trim().equals("") && !str_board_rotation.trim().equals(""))
			{
				//System.out.println("nothing much...");
				if(!str_flip.trim().equals("")) 												//already in ollie 
				{ 
					if(str_flip_count.trim().equals("")) 
					{
						trick = str_board_rotation + str_body_rotation + str_flip;					//e.g fs 180 kickflip
					}
					else
					{
						trick = str_board_rotation + str_body_rotation + str_flip_count + str_flip;					//e.g fs 180 double kickflip
					}		
				}
				else
				{
					trick = str_board_rotation + str_body_rotation + str_pop ;					//e.g fs 180 ollie
				}	
			}
		}
			
		if(!str_stance.trim().equals(""))			//eliminates all the other tricks in a different stance with an ollie "it's an error measure"                     (because perfection doesn't exist)
		{
					//special case to include the ollie...for "switch ollie and fakie ollie". and just "nollie".Oh! and also the flips  :/		(because i am epic like that))
					if(str_board_rotation.trim().equals("") && str_body_rotation.trim().equals(""))
					{

						if(str_flip.trim().equals("")) 
						{
							if(str_pop.trim().equals("ollie") && !str_stance.trim().equals("nollie"))
							{
								trick = str_stance + str_pop;
							}
							else if((str_pop.trim().equals("")||str_pop.trim().equals("ollie")) && str_stance.trim().equals("nollie")) 
							{
								trick = str_stance;
							}
						}
						else
						{
							if(str_flip_count.trim().equals("")) 
							{
								trick = str_stance + str_flip;					//e.g switch kickflip
							}
							else
							{
								trick = str_stance + str_flip_count + str_flip;					//e.g fakie double kickflip
							}
						}		
					}
					else
					{
						if(!str_board_rotation.trim().equals("") && !str_body_rotation.trim().equals(""))
						{
							if(str_flip.trim().equals("")) 
							{
								trick = str_stance + str_board_rotation + str_body_rotation;								//e.g switch fs 360
							}
							else
							{
								if(str_flip_count.trim().equals("")) 
								{
									if(!str_body_rotation.trim().equals("180"))
									{
										
										int rand = generator.nextInt(2);
										
										if(rand == 2)
										{
											trick = str_stance + str_board_rotation + str_body_rotation + str_flip;						//e.g fakie bs 360 heelfip
										}
										else
										{
											str_body_rotation = "180 ";
											trick = str_stance + str_board_rotation + str_body_rotation + str_flip;						//e.g fakie bs 180 heelfip
										}										
									}
									 
								}
								else
								{
									if(!str_body_rotation.trim().equals("180"))
									{
										int rand = generator.nextInt(6);
										
										if(rand == 2)
										{
											trick = str_stance + str_board_rotation + str_body_rotation + str_flip_count + str_flip;					//e.g switch bs 360 double kickflip
										}
										else
										{
											str_body_rotation = "180 ";
											trick = str_stance + str_board_rotation + str_body_rotation + str_flip_count + str_flip;					//e.g switch bs 180 double kickflip
										}										
									}
								}
								
							}
						}
					}		
			}
		
		//********************************************************************************************************************************************************
		//the magic is coming along pretty well
		//***********************************************************************************************************************************************************
		
		
		
		
		
		
		
		//****************************************************************************************************************************************************8
		//the mixing continues....INTRODUCING THE POP SHUV-IT COMBOS
		//****************************************************************************************************************************************************
		
		
		//stances don't matter
		
		if(str_pop.trim().equals("pop shuv-it"))					//no 180s are allowed because a shuv and a 180 is just a 180 :/ (no big spins)
		{
			if(!str_board_rotation.trim().equals("")) //bs/fs
			{
				if(str_body_rotation.trim().equals(""))														//rotation 0
				{
					//This excludes the 360+ shuv-its
					if(str_flip.trim().equals(""))
					{
						if(str_board_spin.trim().equals(""))
						{
							
							trick = str_stance + str_board_rotation + str_pop;									//e.g fakie bs pop shuv-it
						}
						else 						
						{
							if(str_board_spin.trim().equals("360"))
							{
								double board_spin = generator.nextInt(66);
								
								if(board_spin%4 == 0)
								{
									str_board_spin = "impossible";																			//special case of a 360 shuv is an impossible
									trick = str_stance + str_board_spin ;																	//e.g) switch impossible
								}
								else
								{
									trick = str_stance + str_board_rotation + str_board_spin + str_pop;										//e.g fakie bs 360 pop shuv-it
								}
								
							}
							else					
							{
								trick = str_stance + str_board_rotation + str_board_spin + str_pop;										//e.g fakie bs 360 pop shuv-it
							}
						}
					}
					else 											//these are varials,tre flips and stuff
					{
						//flip is currently happening...
						if(str_board_spin.trim().equals(""))			//(str_boardspin != 180,because it's then called a pop-shuv :)
						{
								if(str_board_rotation.trim().equals("bs"))
								{
									if(str_flip.trim().equals("kickflip"))
									{
										if(!str_flip_count.trim().equals(""))
										{
											str_flip = "varial "+ str_flip_count +str_flip;					
											trick = str_stance + str_flip;									//--> fakie varial double flip
										}
										else
										{
											str_flip = "varial " + str_flip;
											trick = str_stance + str_flip;									//--> fakie varial flip
										}
									}
									else
									{
										if(!str_flip_count.trim().equals(""))
										{
											str_flip = "inward "+ str_flip_count +str_flip;					
											trick = str_stance + str_flip;									//--> fakie inward double heelflip
										}
										else
										{
											str_flip = "inward heelflip";
											trick = str_stance  + str_flip;	
										}
									}
								}
								else
								{
									if(str_flip.trim().equals("heelflip"))
									{
										if(!str_flip_count.trim().equals(""))
										{
											str_flip = "varial "+ str_flip_count + str_flip;					
											trick = str_stance + str_flip;									//--> fakie varial double heelflip
										}
										else
										{
											str_flip = "varial " + str_flip;
											trick = str_stance + str_flip;									//--> fakie varial heelflip
										}
									}
									else
									{
										str_flip = "hardflip";
										trick = str_stance + str_flip;	//SHOULD I ADD MORE THAN ONE FliP?
									}
							}
						}
						else						//** assumption is that its 360 up ()
						{								
							if(str_board_rotation.trim().equals("bs"))
							{
								if(str_flip.trim().equals("kickflip"))
								{
									if(!str_flip_count.trim().equals(""))
									{
										trick = str_stance + str_board_spin + str_flip_count +str_flip;									//--> fakie 360 double flip
									}
									else
									{
										trick = str_stance + str_board_spin + str_flip;									//--> fakie 360 flip
									}
								}
								else //add an else if
								{
									str_flip = "inward heelflip";
									trick = str_stance + str_board_spin + str_flip;									//-->switch 360 inward heelflip
								}
							}
							else
							{
								if(str_flip.trim().equals("heelflip"))
								{
									if(!str_flip_count.trim().equals(""))
									{
										trick = str_stance + str_board_spin + str_flip_count +str_flip;									//--> fakie 360 double heelflip
									}
									else
									{
										trick = str_stance + str_board_spin + str_flip;									//--> fakie 540 heelflip
									}
								}
								else  //add an else if
								{
									str_flip = "hardflip";
									trick = str_stance + str_board_spin + str_flip;									//-->nollie 360 hardflip
								}
							}
						}
							
					}
				}
				//&& !str_body_rotation.trim().equals("180")
				
				//almost done :)
				else if(!str_body_rotation.trim().equals("") && !str_board_spin.trim().equals(""))			
				{
					//This will determine what type of spin it will be...(big spin,bigger spin...big flip)
					
					if(str_body_rotation.trim().equals("180"))
					{
							
						if(str_flip.trim().equals(""))
						{				
							if(str_board_spin.trim().equals("360") )
							{
								str_board_spin = "big spin ";
								trick = str_stance + str_board_rotation + str_board_spin ;
							}
							else if(str_board_spin.trim().equals("540"))
							{
								str_board_spin = "bigger spin ";
								trick = str_stance + str_board_rotation + str_board_spin ;
							}		
						}
						else
						{
							//need to add another condition to make doubles
							
							if(str_flip.trim().equals("kickflip"))
							{
								//change str_flip to str_b_spin 15/02/20
								if(str_board_spin.trim().equals("360") )
								{
									str_flip = "big " + str_flip;
									trick = str_stance + str_board_rotation + str_flip;
								}
								else if(str_board_spin.trim().equals("540"))
								{
									str_flip = "bigger " + str_flip;
									trick = str_stance + str_board_rotation + str_flip;
								}
							}
							else if (str_flip.trim().equals("heelflip"))
							{
								if(str_board_spin.trim().equals("360") )
								{
									str_flip = "big " + str_flip;
									trick = str_stance + str_board_rotation + str_flip;
								}
								else if(str_board_spin.trim().equals("540"))
								{
									str_flip = "bigger " + str_flip;
									trick = str_stance + str_board_rotation + str_flip;
								}
							}
						}
					}
					else if(str_body_rotation.trim().equals("360")) 
					{
						//gazelle spins :)
						if(str_board_spin.trim().equals("360"))
						{
							str_board_spin = "gazelle ";
							trick = str_stance + str_board_rotation + str_board_spin ;
						}
						
						
					}
					
				}
			}	
		}
		
		return trick;
	}

}
