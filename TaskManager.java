package application;

/**
 * TaskManager - takes care of manipulating the data from the data given from the GUI input of the user and pushes the data to the Database
 * @author Edward P, Mohammad N, Aravind U
 *
 */
public class TaskManager {
	private Database db;

	public TaskManager(String dataBaseName) {
		db = new Database("New db");
	}

	/**
	 * gets the information from the GUI and adds the habit to the Database
	 */

	/**
	 * addFromGUIToDB - gets the information from the GUI and turns the information
	 * into the habit and pushes it to the database
	 * 
	 * @param habit - the string of the habit to be made
	 * @param days  - the boolean array representing the days of the week that the
	 *              habit is planned to be done on
	 */
	public void addFromGUIToDB(String habit, boolean[] days) {
		Habit h = new Habit(habit, daysToGoal(days), days);
		db.addHabit(h);
	}

//--------------------------------METHODS HANDLING HABIT STATISTICS--------------------------------
//	/**
//	 * int array where a[0] = days completed, days[1] = days missed, days[2] = days to occur
//	 *
//	 */
//	public updateDatabaseStats(Habit h, int[] days) {
//		
//	}
//	
//	/**
//	 * int array where a[0] = days completed, days[1] = days missed, days[2] = days to occur
//	 *
//	 */
//	public int[] getWeeklyHabitStats(Habit habit, int[] days) {
//	
//	}
//	
//	
//	/**
//	 * int array where a[0] = days completed, days[1] = days missed, days[2] = days to occur
//	 *
//	 */
//	public int[] getAllTimeHabitStats() {
//		
//	}


//-----------------------------------------HELPER METHODS--------------------------------------

	/**
	 * daysToGoals - takes in a boolean array and counts the number of true values
	 * in the boolean
	 * 
	 * @param days - the array of the days that a habit is planned to be done
	 * @return the number of days that the habit should be done per day.
	 */
	private int daysToGoal(boolean[] days) {
		int count = 0;

		for (boolean bool : days) {
			if (bool) {
				count++;
			}
		}

		return count;
	}
}
