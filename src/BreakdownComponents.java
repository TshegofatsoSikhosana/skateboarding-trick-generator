
public class BreakdownComponents {	//rating is from 1-5 for the trick
	
	public int pop,stance,flip,board_spin,board_rotation,body_rotation,flip_count,flip_pop,manual;
	
	public double avg = Avg();
	
	public double Avg()
	{
		double avg = (pop + stance + flip + board_rotation + board_spin + body_rotation + flip_count+flip_pop + manual);
		return avg;
	}
	
	
	public int Manual(String str_manual)
	{
		
		if(str_manual.trim().equals("nose"))
		{
				manual = 3;
		}                     
		else if(str_manual.trim().equals("manual"))
		{
			manual = 2;
		}
		else 
		{
			return 0;
		}

		return manual;
	}
	
	
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
		else //error measure for when i am sending random text in
		{
			return 0;
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
		else //error measure for when i am sending random text in
		{
			return 0;
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
			flip_pop = 3;
		}
		else if(trick_component.trim().equals("inward"))
		{
			flip_pop = 6;
		}
		else if(trick_component.trim().equals("hardflip"))
		{
			flip_pop = 5;
		}
		else //error measure for when i am sending random text in
		{
			return 0;
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
			board_spin = 6;
		}
		else //error measure for when i am sending random text in
		{
			return 0;
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
		else //error measure for when i am sending random text in
		{
			return 0;
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
		else //error measure for when i am sending random text in
		{
			
			return 0;
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
			flip_count = 6;
		}
		else  if(trick_component.trim().equals("quad"))
		{
			flip_count = 8;
		}
		else //error measure for when i am sending random text in
		{
			return 0;
		}
		
		return flip_count;
	}

	public boolean Spins(String tc)
	{
		
		if(tc.trim().equals("big"))
		{
			//add spin
			Pop("pop");
			Board_Spin("360");
			Body_Rotation("180");	
			return true;
		}
		else if(tc.trim().equals("bigger"))
		{
			Pop("pop");
			Board_Spin("540");
			Body_Rotation("180");
			return true;
		}
		else if(tc.trim().equals("gazelle"))
		{
			Pop("pop");
			Board_Spin("540");
			Body_Rotation("360");
			return true;	
		}
		
		return false;
	}
	
	
	public void Reset(){
		pop =0;
		stance =0;
		flip =0;
		flip_pop=0;
		board_rotation =0;
		board_spin =0;
		body_rotation=0;
		flip_count =0;
	}
}
