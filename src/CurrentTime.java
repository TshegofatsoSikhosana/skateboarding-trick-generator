
public class CurrentTime {

	public static String GetTime() {
		// TODO Auto-generated method stub
		
		//System.currentTimeMillis() displays the time since 1 Jan 1970(default)
		double totalMilliseconds = System.currentTimeMillis();
		//Conversion to seconds
		double totalSeconds = totalMilliseconds / 1000 ;
		//Currents seconds
		int currSeconds = (int) (totalSeconds % 60);
		//Total minutes
		double totalMinutes = totalSeconds / 60;
		//Current minutes
		int currMinutes = (int) (totalMinutes % 60);
		//Total hours
		double totalHours = totalMinutes / 60;
		//Current Hours
		int currHours = (int) (totalHours % 24);
	    currHours = currHours + 2;//Because South Africa is 2 GMT
	    
	    String current_time = "";
		current_time = currHours + ":" + currMinutes + ":" + currSeconds;
		return current_time;
	}
	
}