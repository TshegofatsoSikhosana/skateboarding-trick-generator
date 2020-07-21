
public class Translate {	//rating is from 1-5 for the trick
	
	public int pop,stance,flip,board_spin,board_rotation,body_rotation,flip_count;
	
	
	//The component_positions is going to keep track of the trick's component positions
	//in the trick eg. "fakie ollie" will be saved in a more generic way by using it's components
	//so it will become [stance + pop] and in the component_positions array it will save the position
	//of the component like 0=pop, 1=stance, 2=board_rotation, 3=body_rotaion,4=board_spin
	// 5=flipCount, 6=flip so the resultant of "fakie ollie" is [2,1,0,0,0,0,0] and i will see what i can do with this.
	
	public int[] component_positions = new int[7];
	
	public int Stance(String trick_component)
	{
		
		if(trick_component.trim().equals(""))
		{
			stance = 1;
		}
		else if(trick_component.trim().equals("nollie"))
		{
			stance = 2;
		}
		else if(trick_component.trim().equals("switch"))
		{
			stance = 3;
		}
		else if(trick_component.trim().equals("fakie"))
		{
			stance = 1;
		}
		
		return stance;
	}
	
	
	public int Pop(String trick_component)
	{
		
		if(trick_component.trim().equals(""))
		{
			pop = 0;
		}
		else if(trick_component.trim().equals("ollie"))
		{
			pop = 1;
		}
		else if(trick_component.trim().equals("pop"))
		{
			pop = 1;
		}
		
		return pop;
	}

	//Type of flip
	//public String[] flip = {"","kickflip","heelflip"};
	
	public int Flip(String trick_component)
	{
		
		if(trick_component.trim().equals(""))
		{
			flip = 0;
		}
		else if(trick_component.trim().equals("kickflip"))
		{
			flip = 2;
		}
		else if(trick_component.trim().equals("heelflip"))
		{
			flip = 2;
		}
		else if(trick_component.trim().equals("varial"))
		{
			flip = 3;
		}
		else if(trick_component.trim().equals("inward"))
		{
			flip = 4;
		}
		else if(trick_component.trim().equals("hardflip"))
		{
			flip = 4;
		}
		else if(trick_component.trim().equals("flip"))
		{
			flip = 4;
		}
		else if(trick_component.trim().equals("heel"))
		{
			flip = 4;
		}
		return flip;
	}
	
	//
	//( board_spin != 180,because it's then called a pop-shuv :)
	//public String[] board_spin = {"","360","540"};
	public int Board_Spin(String trick_component)
	{
		
		if(trick_component.trim().equals(""))
		{
			board_spin = 0;
		}
		else if(trick_component.trim().equals("360"))
		{
			board_spin = 4;
		}
		else  if(trick_component.trim().equals("540"))
		{
			board_spin = 5;
		}
		
		return board_spin;
	}
	//
	//generates the board rotation part of the trick (based on the pop-shuv)
	public int Board_Rotaiton(String trick_component)
	{
		
		if(trick_component.trim().equals(""))
		{
			board_rotation = 0;
		}
		else if(trick_component.trim().equals("bs"))
		{
			board_rotation = 1;
		}
		else  if(trick_component.trim().equals("fs"))
		{
			board_rotation = 1;
		}
		
		return board_rotation;
	}
	
	//
	public int Body_Rotation(String trick_component)
	{
		if(trick_component.trim().equals(""))
		{
			body_rotation = 0;
		}
		else if(trick_component.trim().equals("180"))
		{
			body_rotation = 2;
		}
		else  if(trick_component.trim().equals("360"))
		{
			body_rotation = 5;
		}
		
		return body_rotation;
	}
	
	public int FlipCount(String trick_component)
	{

		if(trick_component.trim().equals(""))
		{
			flip_count = 0;
		}
		else if(trick_component.trim().equals("double"))
		{
			flip_count  = 3;
		}
		else  if(trick_component.trim().equals("triple"))
		{
			flip_count = 4;
		}
		else  if(trick_component.trim().equals("quad"))
		{
			flip_count = 6;
		}
		
		return flip_count;
	}

	public void Other(String tc)
	{

		if(tc.trim().equals("big"))
		{
			//add spin
			Pop("pop shuv-it");
			Board_Spin("360");
			Body_Rotation("180");			
		}
		else if(tc.trim().equals("bigger"))
		{
			Pop("pop shuv-it");
			Board_Spin("540");
			Body_Rotation("180");
		}
	}
}
