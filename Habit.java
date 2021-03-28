import java.util.ArrayList;
import java.util.List;

public class Habit 
{
	private String habit;
	private List<String> daysOfWeek;
	private int goal;
	
	public Habit(String habit, List<String> daysOfWeek, int goal) 
	{
		this.habit = habit;
		this.daysOfWeek = daysOfWeek;
		this.goal = goal;
	}
	
	/* We don't need a method to change the name of the Habit, they can
	 * just make a new Habit in that case and delete the one they
	 * don't want anymore. lmk if you guys think otherwise.
	 * */
	public void editGoal(Habit hab, int newGoal) 
	{
		this.goal = newGoal;
	}
	
	/*
	 * I'm gonna index each day of the week so Sunday is 0 and Saturday is 7. We'll
	 * handle representing the numbers in the array as actual days/Strings later. 
	 */
	public void editDaysOfWeek(Habit hab, ArrayList<String> newDays) 
	{
		this.daysOfWeek = newDays;
	}
	
	public String getHabit() 
	{
		return this.habit;
	}
	
	
	public List<String> getDaysOfWeek()
	{
		return this.daysOfWeek;
	}
	
	public int getGoal() 
	{
		return this.goal;
	}
	
	public String toString() 
	{
		return "This habit is called " + this.habit + ". It is scheduled to be done on " + this.daysOfWeek.toString() + ". You are aiming to do it " + this.goal + " times per day.";
	
				
	}

}
