
import java.util.*;


public class TrickC {
	
	private String Stance(String str_stance)					//chooses the stance the trick will be done in
	{
		Random generator = new Random();
		double stance = generator.nextInt(100);
		
		if(stance%2 == 0)
		{
			str_stance = "";
		}
		else if(stance%5 == 0)
		{
			str_stance = "nollie";
		}
		else if(stance%3 == 0)
		{
			str_stance = "fakie";
		}
		else if(stance%7 == 1)
		{
			str_stance = "switch";
		}
		
		
		//if the variable is not empty then add the space for next trick part
		if(str_stance != "")
		{
			str_stance = str_stance  + " " ;
		}
		System.out.println("stance= " + str_stance);
		
		return str_stance;
	}

	private String Pop(String str_pop)
	{
		Random generator = new Random();
		double pop = generator.nextInt(100);
		
		if(pop%3 != 0)
		{
			str_pop = "ollie";
		}
		else if(pop%3 == 1)
		{
			str_pop = "";
		}
		else {
			str_pop = "pop shuv-it";
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_pop != "")
		{
			str_pop = str_pop  + " " ;
		}
		
		System.out.println("pop= " + str_pop);
		return str_pop;
	}
	
	private String Flip(String str_flip )							//generates the flip part of the trick
	{
		Random generator = new Random();
		double flip = generator.nextInt(100);

		if(flip%2 == 1)
		{
			str_flip = "kickflip";
		}
		else if(flip%2 == 0)
		{
			str_flip =  "heelflip";
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_flip != "")
		{
			str_flip = str_flip  + " " ;
		}
		System.out.println("flip= " + str_flip);
		
		return str_flip;
	}
	
	private String Board_Spin(String str_board_spin) 
	{	
		
		Random generator = new Random();
		double board_rotation= generator.nextInt(87);
		
		
		if(board_rotation%3 == 0)
		{
			str_board_spin = "";
		}
		else
		{
			board_rotation= generator.nextInt(13);
			
			if(board_rotation%3 == 1)
			{
				str_board_spin = "180";
			}
			else if(board_rotation%3 == 0)
			{
				str_board_spin = "360";
			}
		}
		
		return str_board_spin;
}
	//generates the board rotation part of the trick
	private String Board_R(String str_board_rotation) 				//generates the board rotation part of the trick
	{	
		
		Random generator = new Random();
		double board_rotation= generator.nextInt(87);
		
		
		if(board_rotation%3 == 0)
		{
			str_board_rotation = "";
		}
		else
		{
			board_rotation= generator.nextInt(13);
			
			if(board_rotation%3 == 1)
			{
				str_board_rotation = "fs";
			}
			else if(board_rotation%3 == 0)
			{
				str_board_rotation = "bs";
			}
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_board_rotation != "")
		{
			str_board_rotation = str_board_rotation  + " " ;
		}
		
		System.out.println("board= " + str_board_rotation);
		return str_board_rotation;
	}
	
	private String Body_R(String str_body_rotation)					//generates the body rotation part of the trick
	{
		Random generator = new Random();
		double body_rotation= generator.nextInt(66);
		
		if(body_rotation%2 == 0)
		{
			str_body_rotation = "";
		}
		else if(body_rotation%3 == 0)
		{
			str_body_rotation = "180";
		}
		else if(body_rotation%5 == 0)
		{
			str_body_rotation = "360";
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_body_rotation != "")
		{
			str_body_rotation = str_body_rotation  + " " ;
		}
		System.out.println("body= " + str_body_rotation);
		return str_body_rotation;
	}
	
	/*String Special(String special)
	 * {
	 * 		
	 * 		return special 
	 * }
*/
	
	String TrickSelection()										//generates the trick-name 
	{
	
		String str_stance = "";
		String str_pop = "";
		String str_flip = "";
		String str_board_rotation = "";
		String str_body_rotation = "";
		String special = "";
		String trick = "";		
		
		
		str_stance = Stance(str_stance);
		
		str_flip = Flip(str_flip);
		
		str_board_rotation = Board_R(str_board_rotation);
		
		str_body_rotation = Body_R(str_body_rotation);
		
		str_pop = Pop(str_pop);
		
		System.out.println("its :" + str_pop);
		
		trick = TheMagic(str_stance,str_pop,str_board_rotation,str_body_rotation,str_flip,special , trick);

		return trick;
	}

	private String TheMagic(String str_stance, String str_pop, String str_board_rotation, String str_body_rotation,String str_flip, String special, String trick)
	{
		// TODO Auto-generated method stub
		
		
		
		if(str_pop.trim().equals("ollie") && str_stance.trim().equals(""))						//only can ollie in one way otherwise it's a stance thing
		{	
			System.out.println("Hey,wassup...");
			
			//just ollie or flip
			if(str_body_rotation.trim().equals("") && str_board_rotation.trim().equals(""))
			{
				if(!str_flip.trim().equals(""))
				{
					trick = str_flip;
				}
				else
				{
					trick = str_pop;
				}
			}
			
			//************************************************************************************************
			//For all the trick spins in ollie excluding pop shuv-its
			//*************************************************************************************************
			if(!str_body_rotation.trim().equals("") && !str_board_rotation.trim().equals(""))
			{
				
				System.out.println("nothing much...");
				if(!str_flip.trim().equals("")) 												//already in ollie 
				{
					trick = str_board_rotation + str_body_rotation + str_flip;
				}
				else
				{
					trick = str_board_rotation + str_body_rotation + str_pop;
				}	
			}
			else if(str_pop.trim().equals("ollie") && !str_stance.trim().equals(""))			//all the other tricks in a different stance with an ollie "it's an error measure"                     (because perfection doesn't exist)
			{
				//All the nollie tricks
				if(str_stance.trim().equals("nollie"))
				{
					if(( str_board_rotation.trim().equals("") && str_body_rotation.trim().equals("")))
					{
						if(str_flip.trim().equals(""))
						{
							trick = str_stance;
						}
						else
						{
							trick = str_stance + str_flip;							//because you can have flip without direction nor rotation
						}						
					}
					else
					{
						trick = str_stance + str_board_rotation + str_body_rotation + str_flip;					//eg. nollie bs 180 kickflip
					}
				}
				else if(!str_stance.trim().equals("nollie"))
				{
					//special case to include the ollie...for "switch ollie and fakie ollie"..Oh! and also the flips  :/		(because i am epic like that))
					if(str_board_rotation.trim().equals("") && str_body_rotation.trim().equals(""))
					{
						if(str_flip.trim().equals("")) 
						{
							trick = str_stance + str_pop;
						}
						else
						{
							trick = str_stance + str_flip;
						}		
					}
					else
					{
						if(str_flip.trim().equals("")) 
						{
							trick = str_stance + str_board_rotation + str_body_rotation;								//e.g switch fs 360
						}
						else
						{
							trick = str_stance + str_board_rotation + str_body_rotation + str_flip;						//e.g fakie bs 180 heelfip 
						}
					}
					
				}				
			}
			
		}
		//********************************************************************************************************************************************************
		//the magic is coming along pretty well
		//***********************************************************************************************************************************************************
		
		
		
		
		
		
		
		//****************************************************************************************************************************************************8
		//the mixing continues
		//****************************************************************************************************************************************************
		
		
		
		if(str_pop.trim().equals("pop shuv-it") && !str_body_rotation.trim().equals("180"))					//no 180s are allowed because a shuv and a 180 is just a 180 :/ (no big spins)
		{
			if(!str_board_rotation.trim().equals(""))
			{
				if(str_body_rotation.trim().equals(""))														//rotation 0
				{
					if(str_flip.trim().equals(""))
					{
						trick = str_stance + str_board_rotation + str_pop;									//fakie bs pop shuv-it
					}
					else																						//***need to come back to part this****** (varials and stuff)
					{
						//Specials first hardflip and inward
						if(str_board_rotation.trim().equals("bs"))
						{
							if(str_flip.trim().equals("heelflip"))
							{
								str_flip = "inward heelflip";
								trick = str_stance + str_flip;												//-->inward heelflip
							}
							else
							{
								str_board_rotation = "varial";
								str_flip = "flip";
								trick = str_stance + str_board_rotation +  str_flip;						//-->varial flip
							}
						}
						if(str_board_rotation.trim().equals("fs"))
						{
							if(str_flip.trim().equals("kickflip"))
							{
								str_flip = "hardflip";
								trick = str_stance + str_flip;												//-->hardflip
							}
							else
							{
								str_board_rotation = "varial";
								str_flip = "heelflip";
								trick = str_stance + str_board_rotation +  str_flip;						//-->switch varial heelflip
							}
						}
					}
				}
				else
				{
					Random gen = new Random();
					int rand = gen.nextInt(31);
					
					if(str_flip.trim().equals("") && rand%3 == 1)
					{
						trick = str_stance + str_board_rotation + str_body_rotation + str_pop;				//e.g nollie bs 360 pop shuv-it
					}
					else if(str_flip.trim().equals("") && rand%3 == 2)			//for the big-spins and other stuff
					{
						if(str_flip.trim().equals(""))							//no flip thus yet
						{
							//***need to come back and finish of the tricks****
							
							if(str_body_rotation.trim().equals("360"))
							{
								str_body_rotation = "big spin";									//e.g fs bigspin
								trick = str_stance + str_board_rotation + str_body_rotation;
							}
						}
						else																//we start flipping out here 
						{
							//***need to come back and finish of the tricks****
							
							
							if(str_body_rotation.trim().equals("360"))
							{
								str_body_rotation = "big";
								if(str_flip.trim().equals("kickflip"))
								{
									str_flip = "flip";
									trick = str_stance + str_board_rotation + str_body_rotation + str_flip;				//e.g fakie bs big flip
								}
								else
								{									
									str_flip = "heel";
									trick = str_stance + str_board_rotation + str_board_rotation + str_flip;			//e.g fs big heel
								}
							}							
						}
					}
					else
					{
						trick = str_stance + str_board_rotation + str_body_rotation + str_flip;				//e.g switch fs 360 flip
					}
				}
			}
		}
		
		/*
			else if(str_body_rotation.trim().equals("") && str_board_rotation.trim().equals(""))		//no rotation or direction thus it's a single trick(need to make a function here)
			{
				if(!str_flip.trim().equals(""))
				{
					trick = str_flip;
				}
				else
				{
					trick = str_pop;
				}
			}
		}*/
		
		
		//shuv related shandis
		if(str_pop.trim().equals("pop shuv-it") && !str_board_rotation.trim().equals(""))
		{
			
		}
		
		//trick = str_board_rotation + str_body_rotation + str_pop + str_flip;
			/*else if(str_body_rotation == "180" && str_board_rotation  != "")			//special case for 180s
			{
				trick = str_body_rotation + str_board_rotation;			
			}
			else
			{
				trick = str_pop;
			}
		}
		else
		{
			trick = str_stance + str_body_rotation  + str_board_rotation + str_flip ;
		}
		
		}*/
		
		return trick;
	}


}
