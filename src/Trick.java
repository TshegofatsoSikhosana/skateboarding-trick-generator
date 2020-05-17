
import java.util.*;

public class Trick
{
	Random generator = new Random();
	
	String TrickSelection()										//generates the trick-name 
	{
	
		String str_stance = "";
		String str_pop = "";
		String str_flip = "";
		String str_flip_count = "";
		String str_board_rotation = "";
		String str_body_rotation = "";
		String str_board_spin = "";
		String special = "";
		String trick = "";		
		TrickComponents component = new TrickComponents();
		
		str_stance = component.Stance(str_stance);
//	System.out.println("stance= " + str_stance);
		str_flip = component.Flip(str_flip);
	//	System.out.println("flip= " + str_flip);
		str_flip_count = component.FlipCount(str_flip_count);
		str_board_rotation = component.Board_R(str_board_rotation);
	//	System.out.println("board= " + str_board_rotation);
		str_body_rotation = component.Body_R(str_body_rotation);
	//	System.out.println("body= " + str_body_rotation);
		str_pop = component.Pop(str_pop);
	//	System.out.println("pop= " + str_pop);
		str_board_spin = component.Board_Spin(str_board_spin);
	//	System.out.println("board= " + str_board_spin);
		trick = TheMagic(str_stance,str_pop,str_board_rotation,str_body_rotation,str_flip,str_flip_count,str_board_spin,special);

		return trick;
	}

	private String TheMagic(String str_stance, String str_pop, String str_board_rotation, String str_body_rotation,String str_flip,String str_flip_count,String str_board_spin, String special)
	{
		 String trick ="";
		
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
					//make an else if for gazelle spins :)	
				}
			}	
		}
		
		return trick;
	}

}
