

//pretty much a reverse of the class Trick. I use this class to find out if a trick of a certain
// difficulty(Level) which are beginner,intermediate,novice, amateur, pro ,expert and god.
public class Level {
	
	//rating is from 1-5 for the trick
	BreakdownComponents bdc = new BreakdownComponents();
	
	
	public double TrickDifficulty(String str_trick)										//breaks the trick provided into different trick components from a given trick name
	{
	
		String str_stance = "";
		String str_pop = "";
		String str_flip = "";
		String str_board_rotation = "";
		String str_body_rotation = "";
		String str_board_spin = "";
		String special = "";
		String str_difficulty = "not changed";  //difficulty levels {beginner,amateur,pro,}
		double difficulty = 0;
		
		String[] trick_components = str_trick.split(" ");
		
		
		//System.out.println("\n");
		
		//isManual(trick_components);
		
		difficulty = Difficulty(trick_components);

		/*for(int i =0; i < trick_components.length ; i++)
		{
			System.out.println(trick_components[i]);
		}*/
		
		return difficulty;
	}
	
	//later return an ENUM
	public boolean isManual(String[] trick)
	{
		boolean type = false;
		
		//Start from the back
		for(int i = trick.length - 1; i >= 0; i--)
		{
			if(trick[i].trim().equals("manual"))
			{
				//System.out.println("Heya \n");
				//Split the manual tricks into its components {t1,m,t2}*
				type = true;;
				return type;
			}
		}
		
		return type;
	}
	
	//checks if a trick is a valid trick
	public boolean isTrick(String trick)
	{
		bdc = new BreakdownComponents();
		
		boolean valid = false;
		
		String[] tc = trick.split(" ");
		
		//the already known single word tricks
		if(tc.length == 1 && (tc[0].trim().equals("ollie") || tc[0].trim().equals("nollie") || tc[0].trim().equals("kickflip") || tc[0].trim().equals("hardflip") || tc[0].trim().equals("impossible") || tc[0].trim().equals("heelflip")))
		{		
			valid = true;
		}
		else if (tc.length == 2)
		{		
			//start with flips from the back and tricks do end in hardflip
			if(bdc.Flip(tc[1]) != 0 && (!tc[1].trim().equals("varial") && !tc[1].trim().equals("inward")))
			{			
				if(bdc.FlipCount(tc[0]) != 0)
				{
					valid = true;
				}
				else if(bdc.Stance(tc[0]) != 0)
				{
					valid = true;
				}
				else if(tc[0].trim().equals("varial") || tc[0].trim().equals("inward"))
				{
					valid = true;
				}
				else if(bdc.Board_Spin(tc[0]) !=0)
				{
					valid = true; //360 flip
				}
			}
			else if(bdc.Stance(tc[0]) != 0)
			{			
				
				//switch and fakie ollie's only
				if(!tc[0].trim().equals("nollie"))
				{
				
					if(tc[1].trim().equals("ollie"))
					{
						valid = true;				//e.g fakie ollie
					}
				}
				
				if(tc[1].trim().equals("impossible"))
				{
					valid = true;
				}
			}
			else 
			{
				valid = false;
			}
		}
		else
		{
			//the real magic starts here wc > 2
			//checking from the back
			
			for(int i = tc.length-1 ; i >0 ;i-- )
			{
				//pop shuvs
				if(tc[i].trim().equals("shuv-it"))
				{
					if(i-4 >= 0) //nollie bs 360 pop shuv-it
					{
						if(tc[i-1].trim().equals("pop")) 
						{
							if(bdc.Board_Spin(tc[i-2]) != 0)
							{
								if(bdc.Board_Rotaiton(tc[i-3]) !=0)
								{
									if(bdc.Stance(tc[i-4]) !=0)
									{
										valid = true;
										break;
									}
								}
							}
						}
					}
					else if(i-3 >=0) 
					{
						if(tc[i-1].trim().equals("pop")) 
						{
							if(bdc.Board_Spin(tc[i-2]) != 0)
							{
								if(bdc.Board_Rotaiton(tc[i-3]) !=0)
								{
									valid = true;  // bs 360 pop shuv-it
									break;
								}
							}
							else if(bdc.Board_Rotaiton(tc[i-2]) !=0)
							{
								if(bdc.Stance(tc[i-3]) !=0)
								{
									valid = true;	//nollie bs pop shuv-it
									break;
								}
							}
						}
					}
					else if(i-2 >=0)
					{
						if(tc[i-1].trim().equals("pop")) 
						{
							if(bdc.Board_Rotaiton(tc[i-2]) !=0)
							{
								valid = true;	//bs pop shuv-it
								break;
							}
						}
					}
				}
				else if(tc[i].trim().equals("spin")) //for big spins
				{
					//passing the big part
					boolean isBig = bdc.Spins(tc[i-1]);
					
					
					if(isBig)
					{
						if(bdc.Board_Rotaiton(tc[i-2]) !=0)
						{
							if(i-2 >0)
							{
								if(bdc.Stance(tc[i-3]) !=0)
								{
									valid = true; //nollie bs bigger spin
									System.out.println("Heya");
									break;
								}	
							}
							else if(i-2 == 0) //i have reached the end of the string
							{
								valid = true; //bs big spin
								break;
							}
						}
					}
					
				}
				else if(tc[i].trim().equals("ollie")) //for 360 ollies
				{
					if(i-2 >= 0)
					{
						if(bdc.Body_Rotation(tc[i-1]) != 0) 
						{
							if(bdc.Board_Rotaiton(tc[i-2]) !=0)
							{
								valid = true;
								break;
							}
						}
					}
				}
				else if(bdc.Flip(tc[i]) != 0 && (!tc[i].trim().equals("varial") && !tc[i].trim().equals("inward"))) //for flip tricks
				{
					
					if(bdc.FlipCount(tc[i-1]) != 0)
					{
						
						if(i-2 ==0)
						{
							if(tc[i-2].trim().equals("varial") || tc[i-2].trim().equals("inward")) //either inward or varial
							{
								valid = true; //varial double flip
								break;
							}
							else if(bdc.Stance(tc[i-2]) != 0)
							{
								valid = true; //fakie double flip
								break;
							}
							else if(bdc.Board_Spin(tc[i-2]) != 0) //for your tre flips and lasers
							{
								valid = true;  // 540 double heelflip
								break;
							}
						}			
						else if(i-2 > 0)
						{
							//for your tre flips and lasers in a stance
							if(bdc.Board_Spin(tc[i-2]) != 0)
							{
								if(i-3 ==0)
								{
									if(bdc.Stance(tc[i-3]) != 0)
									{
										valid = true;  //nollie 540 double heelflip
										break;
									}
								}
							}
							
							if(bdc.Body_Rotation(tc[i-2]) != 0)
							{
								if(i-3 >=0)
								{
									if(bdc.Board_Rotaiton(tc[i-3]) != 0)
									{
										if(i-4 >= 0)
										{
											if(bdc.Stance(tc[i-4]) != 0)
											{
												valid = true; //fakie fs 180 double flip
												break;
											}
											else 
											{
												valid = false; // cant have random invalid words in front of the trick name
											}
										}
										else //we at the end of the trick
										{
											valid = true; // fs 180 double flip
											break;
										}
									}
								}
							}
							else if(tc[i-2].trim().equals("varial") || tc[i-2].trim().equals("inward")) //either inward or varial
							{
								if(i-3 >=0)
								{
									if(bdc.Stance(tc[i-3])!= 0)
									{
										valid = true; // fakie varial double flip
										break;
									}
								}
							}
	
							/*
							 * Not sure how to check big double flip tricks
							else if(bdc.Spins(tc[i-2]))  //if its big 
							{
								if(i-3 >=0)
								{
									if(bdc.Board_Rotaiton(tc[i-3]) != 0)
									{
										valid = true; //fs big flip
									}
								}
							}
							*/		
						}
					}
					else
					{
						//for your tre flips and lasers in a stance
						if(bdc.Board_Spin(tc[i-1]) != 0)
						{
							if(i-2 ==0)
							{
								if(bdc.Stance(tc[i-2]) != 0)
								{
									valid = true;  //nollie 540 heelflip
									break;
								}
							}
						}
						
						if(bdc.Body_Rotation(tc[i-1]) != 0)
						{
							if(i-2 >=0)
							{
								if(bdc.Board_Rotaiton(tc[i-2]) != 0)
								{
									if(i-3 >= 0)
									{
										if(bdc.Stance(tc[i-3]) != 0)
										{
											valid = true; //fakie fs 180 flip
											break;
										}
										else 
										{
											valid = false; // cant have random invalid words in front of the trick name
											break;
										}
									}
									else //we at the end of the trick
									{
										if(i-2 == 0)
										{
											valid = true; // fs 180 flip
											break;
										}									
									}
								}
							}
						}
						else if(bdc.Spins(tc[i-1]))  //if its big 
						{
							if(i-2 >=0)
							{
								if(bdc.Board_Rotaiton(tc[i-2]) != 0)
								{
									valid = true; //fs big flip
									break;
								}
							}
						}
						else if(tc[i-1].trim().equals("varial") || tc[i-1].trim().equals("inward")) //either inward or varial
						{
							if(i-2==0)
							{
								if(bdc.Stance(tc[i-2]) != 0)
								{
									valid = true; //fakie varial flip
									break;
								}
								else if(bdc.Board_Spin(tc[i-2]) != 0)
								{
									valid = true; //360 inward flip
									break;
								}
							}
							
							if(tc[i-1].trim().equals("inward"))
							{
								if(i-3 >=0 )
								{
									if(bdc.Board_Spin(tc[i-2]) != 0)
									{
										if(bdc.Stance(tc[i-3]) != 0)
										{
											valid = true; // fakie 360 inward flip
											break;
										}			
									}
								}		
							}
						}
					}
					
				}
				else if(bdc.Body_Rotation(tc[i]) != 0) //for stance with 180/360
				{
					//System.out.print(i + " " + tc[i] + " Phakati inside\n");
					
					if(bdc.Board_Rotaiton(tc[i-1]) != 0)
					{
						if(i-2 >= 0)
						{
							if(bdc.Stance(tc[i-2]) != 0)
							{
								valid = true; //fakie fs 180
								break;
							}
							else 
							{
								valid = false; // can't have random invalid words in front of the trick name
								break;
							}
						}
					}
				}
			}		
		}
			
		return valid;
	}
	

	private double Difficulty(String[] tc)
	{
		
		double avg =0;
		//System.out.println("Let's reverse this magic \n");
		//Trick layout
		
		/*if(tc[tc.length-1].trim().equals("flip") || tc[tc.length-1].trim().equals("heel"))
		{
			bdc.Board_Spin(tc[-]);
		}*/
		
		
		//The difficulty is calculated by splitting trick into its components
		//and then weigh each and getting the average
		
		
		if(isManual(tc))
		{
			//Manual tricks
			
			//Possible configurations
			// M = {m,n}, which are manual and nose manual respectively
			// word lengths: 1 = manual = {m} , 2 = {mt,tM,n = nose}, 3 = {tm,mt, tmt = kickflip manual heelfip}, 4 = {}
		}
		else
		{
			//Flat-ground tricks
			for(int i =0; i < tc.length ; i++)
			{	
				
				//System.out.println(tc[i]);
				
				
				if((tc[i].trim().equals("360") || tc[i].trim().equals("180") || tc[i].trim().equals("540")))
				{
					
					//Decide if the 360/180 is a body or board rotation
					if(i-1 >= 0 )
					{
						if(bdc.Board_Rotaiton(tc[i-1]) !=0 )
						{
							bdc.Body_Rotation(tc[i]); 		//e.g bs 360...
							
							if(i+1 <= tc.length-1)
	                        {
	                            if(bdc.Pop(tc[i+1]) != 0)
	                            {
	                            	//System.out.println("\n Phakati inside the shuvs \n");
	                                bdc.Board_Spin(tc[i]); //e.g bs 360 pop shuv-it
	                            }
	                        }
						}
						else
						{
							bdc.Board_Spin(tc[i]);		//e.g switch 360 flip
						}
					}
					else
					{
						bdc.Board_Spin(tc[i]);		//e.g 360 flip
					}
				}
				else
				{
					bdc.Stance(tc[i]);
					bdc.Board_Rotaiton(tc[i]);
					bdc.Pop(tc[i]);
					bdc.Flip(tc[i]);
					bdc.FlipCount(tc[i]);
					bdc.Spins(tc[i]);		
				}
			}
		}
		
		//get the manual configurations
			
		//System.out.println(bdc.Avg());
		avg = bdc.Avg();
		bdc.Reset();
		//bdc = new BreakdownComponents();
		return avg;
	}
	
}
