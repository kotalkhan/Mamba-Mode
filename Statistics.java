package application;

public class Statistics {
		
	public int done = 0;
	public int missed = 0;
	
	/**
	 * updateCounters - updates values for counting done and missed
	 * @param TaskManager - the TaskManager object that holds the Habit data
	 */
	public void updateCounters(TaskManager t) {
		done = 0;
		missed = 0;
	
		for(Habit h: t.getHabits()) 
		{
			done += t.getWeeklyHabitStats(h)[0];
			missed += t.getWeeklyHabitStats(h)[1];
			
		}
	}
	
	public int getNumberDone() {
		return done;
	}
	
	public int getMissed() {
		return missed;
	}
	
}