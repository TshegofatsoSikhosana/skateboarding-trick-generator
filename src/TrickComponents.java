import java.util.Random;

public class TrickComponents {
	
	Random generator = new Random();
	
	public String Stance(String str_stance)						//chooses the stance the trick will be done in
	{
		
		double stance = generator.nextInt(4);
		
		if(stance == 0)
		{
			str_stance = "";
		}
		else if(stance == 1)
		{
			stance = generator.nextInt(1);
			if(stance == 1)
			{
				str_stance = "";
			}
			else 
			{
				str_stance = "nollie";
			}
		}
		else if(stance == 2)
		{
			str_stance = "fakie";
		}
		else if(stance == 3)
		{
			stance = generator.nextInt(3);
			if(stance == 3)
			{
				str_stance = "";
			}
			else 
			{
				str_stance = "switch";
			}
			
		}
		
		
		//if the variable is not empty then add the space for next trick part
		if(str_stance != "")
		{
			str_stance = str_stance  + " " ;
		}
		
		return str_stance;
	}

	public String Pop(String str_pop)								//ollie or  pop-shuv
	{
		double pop = generator.nextInt(72);
		
		if(pop%3 == 0)
		{
			str_pop = "ollie";
		}
		else
		{
			str_pop = "pop shuv-it";
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_pop != "")
		{
			str_pop = str_pop  + " " ;
		}
		//str_pop = "pop shuv-it";
		
		return str_pop;
	}
 	
	public String Flip(String str_flip )							//generates the flip part of the trick
	{
		double flip = generator.nextInt(100);

		if(flip%3 == 1)
		{
			str_flip = "kickflip";
		}
		else if(flip%3 == 0)
		{
			str_flip =  "heelflip";
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_flip != "")
		{
			str_flip = str_flip  + " " ;
		}
		
		return str_flip;
	}
	
	public String FlipCount(String str_flip_count)
	{
		double flip_count = generator.nextInt(100);
		
		if(flip_count < 87)
		{
			str_flip_count = "" ;
		}
		else
		{
			int count = generator.nextInt(13);
			
			if(count%2 == 0)
			{
				if((count/2)%3 == 0)
				{
					str_flip_count = "quad";
				}
			}
			else if(count%5 == 0 )
			{
				str_flip_count = "triple";
			}
			else if(count%3 == 0)
			{
				str_flip_count = "double";
			}
			else
			{
				str_flip_count = "" ;
			}
			
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_flip_count != "")
		{
			str_flip_count = str_flip_count  + " " ;
		}
				
		return str_flip_count;
	}
	
	public String Board_Spin(String str_board_spin) 
	{	
		double board_spin= generator.nextInt(72);
		
		//(str_boardspin != 180,because it's then called a pop-shuv :)
		
		if(board_spin%2 == 0)
		{
			str_board_spin = "";
		}
		else
		{
			board_spin= generator.nextInt(13);
			
			if(board_spin%3  == 0)
			{
				str_board_spin = "540";
				//str_board_spin = "";
			}
			else if(board_spin%2 == 0)
			{
				str_board_spin = "360";
			}
			else
			{
				str_board_spin = "";
			}
		}
		//if the variable is not empty then add the space for next trick part
		if(str_board_spin != "")
		{
			str_board_spin = str_board_spin  + " " ;
		}
		
		//str_board_spin = "360";
		return str_board_spin;
	}
	//generates the board rotation part of the trick (based on the pop-shuv)
	public String Board_R(String str_board_rotation) 				//generates the board rotation part of the trick
	{	
		double board_rotation= generator.nextInt(72);
		
		
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
		
		return str_board_rotation;
	}
	
	public String Body_R(String str_body_rotation)					//generates the body rotation part of the trick
	{
		double body_rotation= generator.nextInt(3);
		
		if(body_rotation == 0)
		{
			str_body_rotation = "";
		}
		else if(body_rotation == 1)
		{
			str_body_rotation = "180";
		}
		else if(body_rotation == 2)
		{
			str_body_rotation = "360";
		}
		
		//if the variable is not empty then add the space for next trick part
		if(str_body_rotation != "")
		{
			str_body_rotation = str_body_rotation  + " " ;
		}
		//str_body_rotation = "180";
		return str_body_rotation;
	}
    
	/*String Special(String special)
	  {
	  		
	  		return special 
	  }
*/

}
