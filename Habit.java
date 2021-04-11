package kobe;

import java.util.ArrayList;
import java.util.List;

public class Habit 
{
	private String habit;
	private boolean[] daysOfWeek;
	private int goal;
	
	public Habit(String habit, boolean[] daysOfWeek, int goal) 
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
		hab.goal = newGoal;
	}
	
	/*
	 * I'm gonna index each day of the week so Sunday is 0 and Saturday is 7. We'll
	 * handle representing the numbers in the array as actual days/Strings later. 
	 */
	public void editDaysOfWeek(Habit hab, boolean[] days) 
	{
		hab.daysOfWeek = days;
	}
	
	public String getHabit() 
	{
		return this.habit;
	}
	
	
	public boolean[] getDays()
	{
		return daysOfWeek;
	}
	
	public int getGoal() 
	{
		return this.goal;
	}
	
	public String[] getHabitInfo(){
		String[] info = new String[3];
		String days = "";
		for(boolean i : daysOfWeek) {
			if(i == true) {
				days += "1";
			} else {
				days += "0";
			}
		}
		info[0] = habit;
		info[1] = days;
		info[2] = String.valueOf(goal);
		
		return info;
				
	}
	
	public String toString() 
	{
		return "This habit is called " + this.habit + ". It is scheduled to be done on " + this.daysOfWeek.toString() + ". You are aiming to do it " + this.goal + " times per day.";
				
	}

}
