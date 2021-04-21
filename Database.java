package application;

import java.sql.*;
import java.util.ArrayList;

/**
 * DataBase - a class that handles pulling and pushing data from and to a
 * database through SQLLite
 * 
 * @author Edward P, Mohammad N, Aravind U
 *
 */
public class Database {
	static Connection connection = null;
	String url;
	Statement statement;

	/**
	 * Constructor - sets up the data base and will put in a table if a table does
	 * not already exist within the database
	 * 
	 * @param fileName - the name of the data base
	 */
	public Database(String fileName) {

		url = "jdbc:sqlite:" + fileName;

		try {
			connection = DriverManager.getConnection(url);

			if (connection == null) {
				System.out.println("A new database has been created.");

			} else {
				System.out.println("A database already exists");
			}

			statement = connection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS HABITS " + " (habit VARCHAR(255), " + " goal INTEGER, "
					+ " days VARCHAR(7), " + " status VARCHAR(7), " + " weekly VARCHAR(5)," + " overall VARCHAR(15))";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void closeDB() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//-------------------------------------DATABASE MANIPULATION METHODS--------------------------------------------------------
	/**
	 * addHabit - adds a habit to the data base
	 * 
	 * @param h - the habit that you want to add to the database
	 */
	public void addHabit(Habit h) {
		String[] info = h.getHabitInfo();
		String habit = info[0];
		int goal = Integer.parseInt(info[1]);
		String days = info[2];
		String status = info[3];

		try {
			// gets a connection
			statement = connection.createStatement();
			String sql = "INSERT INTO HABITS " + "VALUES ('" + habit + "', '" + goal + "', '" + days
					+ "', '" + status + "', '000', '000')";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * addHabit - deletes a habit to the data base
	 * 
	 * @param h - the habit that you want to add to the database
	 */
	public void deleteHabit(Habit h) {
		String[] info = h.getHabitInfo();
		String habit = info[0];

		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM HABITS " + "WHERE habit LIKE '%" + habit + "%'";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * updateWeeklyStat - changes the value within the DB table for the column
	 * 'weekly' which holds on to tthe stats of the week
	 * 
	 * @param stat - should have three characters in the string where charAt(0) is
	 *             the days completed, chatAt(1) is the days missed, and charAt(2)
	 *             is the days still to come
	 */
	public void updateWeeklyStat(Habit h, String stat) {
		int[] test = stringToIntArr(stat);
		if(test.length != 3) {
			throw new IllegalArgumentException("The value provided is not valid");
		}
		try {
			statement = connection.createStatement();
			String sql = "UPDATE HABITS " + "SET weekly = '" + stat + "' WHERE habit LIKE '%" + h.getHabit() + "%'";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * updateWeeklyStat - changes the value within the DB table for the column
	 * 'overall' which holds the stats for all time
	 * 
	 * @param stat - should have two Integer characters in the string where
	 *             charAt(0) is the days completed and chatAt(1) is the days missed
	 */
	public void updateOverallStat(Habit h, String stat) {
		//to make sure that an invalid argument cannot reach the code
		int[] test = stringToIntArr(stat);
		if(test.length != 2) {
			throw new IllegalArgumentException("The value provided is not valid");
		}
		
		try {
			statement = connection.createStatement();
			String sql = "UPDATE HABITS " + "SET overall = '" + stat + "' WHERE habit LIKE '%" + h.getHabit() + "%'";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * resetWeeklyStat - resets the weekly stat in the data base to 000
	 * 
	 * @param h - the habit where you want to change the weekly stat
	 */
	public void resetWeeklyStat(Habit h) {
		updateWeeklyStat(h, "000");
	}

//----------------------------------------DATA RETRIVAL METHODS-------------------------------------------------------------
	/**
	 * getHabits - gets all the habits from the database
	 * 
	 * @return - an arraylist<Habit> with all the habits that are stored in the
	 *         database
	 */
	public ArrayList<Habit> getHabits() {
		ArrayList<Habit> habits = new ArrayList<Habit>();
		String sql = "SELECT habit, goal, days, status FROM HABITS";
		try {
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String habit = rs.getString("habit");
				boolean[] goal = stringToBoolArr(rs.getString("goal"));
				int days = rs.getInt("days");
				int[] status = stringToIntArr(rs.getString("status"));

				Habit h = new Habit(habit, days, goal, status);
				habits.add(h);
			}

			return habits;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * getOverallStat - gets the overall column for a certain habit
	 * 
	 * @param h - the habit that you are looking for in the database
	 * @return a int[] where int[0] is the number of times completed and int[1] is
	 *         the number of days missed
	 */
	public int[] getWeeklyStat(Habit h) {
		int[] stats = new int[3];
		try {
			statement = connection.createStatement();
			String sql = "SELECT weekly " + "FROM HABITS" + " WHERE habit LIKE '%" + h.getHabit() + "%'";
			ResultSet rs = statement.executeQuery(sql);

			String statString = rs.getString("weekly");

			// puts the values into the array
			stats = stringToIntArr(statString);

			return stats;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stats;
	}

	/**
	 * getOverallStat - gets the overall column for a certain habit
	 * 
	 * @param h - the habit that you are looking for in the database
	 * @return a int[] where int[0] is the number of times completed and int[1] is
	 *         the number of days missed
	 */
	public int[] getOverallStat(Habit h) {
		int stats[] = new int[3];
		try {
			// gets the data from the database
			statement = connection.createStatement();
			String sql = "SELECT overall " + "FROM HABITS" + " WHERE habit LIKE '%" + h.getHabit() + "%'";
			ResultSet rs = statement.executeQuery(sql);

			String statString = rs.getString("overall");

			// puts the values into the array
			stats = stringToIntArr(statString);

			return stats;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stats;
	}
	
	

	/**
	 * printValues - prints the values into the the console
	 */
	public void printValues() {
		ArrayList<Habit> h = getHabits();

		for (Habit habit : h) {
			System.out.println(habit);
		}
	}

//------------------------------------HELPER METHODS------------------------------------------------------------------------
	/**
	 * charToInt - converts a char to an int
	 * 
	 * @param a - the char value that you would like to convert
	 * @return an integer value of the char given
	 */
	private int charToInt(char a) {
		return Integer.parseInt(String.valueOf(a));
	}

	/**
	 * stringToIntArr - takes a string of Intgers seperated by a whitespace and puts
	 * it into an int array
	 * 
	 * @param s - the string that you would like to convert into a int array
	 * @return the int array containing the values from the string;
	 */
	private int[] stringToIntArr(String s) {
		try {
			String[] sArr = s.split(" ");
			int[] intArr = new int[sArr.length];

			for (int i = 0; i < intArr.length; i++) {
				intArr[i] = Integer.parseInt(sArr[i]);
			}

			return intArr;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean[] stringToBoolArr(String goal) {
		boolean[] daysBool = new boolean[7];
		for (int i = 0; i < goal.length(); i++) {
			if (goal.charAt(i) == '1') {
				daysBool[i] = true;
			} else {
				daysBool[i] = false;
			}
		}
		return daysBool;
	}

}
