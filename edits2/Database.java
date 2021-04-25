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
			//
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
			String sql = "INSERT INTO HABITS " + "VALUES ('" + habit + "', '" + goal + "', '" + days + "', '" + status
					+ "', '000', '000')";
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
	 * updateHabit - gets the habit you want from the database and changes the
	 * string of the habit
	 * 
	 * @param habit - the String that you would like to change the current string in
	 *              habit to
	 */
	public void updateHabit(Habit h, String habit) {
		try {
			statement = connection.createStatement();
			String sql = "UPDATE HABITS " + "SET habit = '" + habit + "' WHERE habit LIKE '%" + h.getHabit() + "%'";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * updateStatus -updates the status of the habit within the database
	 * @param h - the habit that you like to update
	 * @param status - the new status that you would like to pass into the database
	 */
	public void updateStatus(Habit h, String status) {
		try {
			statement = connection.createStatement();
			String sql = "UPDATE HABITS " + "SET status = '" + status + "' WHERE habit LIKE '%" + h.getHabit() + "%'";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * updateDays - updates the days of the habit within the database
	 * @param h - the habit that you would like to change
	 * @param days - the new string of days that you would like to update days to
	 */
	public void updateDays(Habit h, String days) {
		try {
			statement = connection.createStatement();
			String sql = "UPDATE HABITS " + "SET days = '" + days + "' WHERE habit LIKE '%" + h.getHabit() + "%'";
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
		if (test.length != 3) {
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
	 * 
	 * 
	 */
	public void updateOverallStat(Habit h, String stat) {
		// to make sure that an invalid argument cannot reach the code
		int[] test = stringToIntArr(stat);
		if (test.length != 2) {
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
	
	public void updateGoal(Habit h, int i) {
		// to make sure that an invalid argument cannot reach the code
		try {
			statement = connection.createStatement();
			String sql = "UPDATE HABITS " + "SET goal = '" + i + "' WHERE habit LIKE '%" + h.getHabit() + "%'";
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
				int[] status = stringToIntArrStatus(rs.getString("status"));

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
	 * getStatus - Gets the status of the habit
	 * 
	 * @param h - the habit that you are looking for in the database
	 * @return an int[] where the index represents the days of week and the
	 *         corresponding number tells the status of the habit of that day
	 */
	public int[] getStatus(Habit h) {
		int stats[] = new int[3];
		try {
			// gets the data from the database
			statement = connection.createStatement();
			String sql = "SELECT stat " + "FROM HABITS" + " WHERE habit LIKE '%" + h.getHabit() + "%'";
			ResultSet rs = statement.executeQuery(sql);

			String statString = rs.getString("overall");

			// puts the values into the array
			stats = stringToIntArrStatus(statString);

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
	private int[] stringToIntArrStatus(String s) {
		try {
			int[] intArr = new int[7];

			for (int i = 0; i < 7; i++) {
				intArr[i] = charToInt(s.charAt(i));
			}
			return intArr;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

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

	public boolean[] stringToBoolArr(String goal) {
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

	public static void main(String[] args) {
		Database db = new Database("New db");
		boolean[] dow = { true, true, true, false, false, false, false };
		int[] completed = { 0, 0, 0, 0, 1, 0, 2 };

		Habit h = new Habit("Go on a walk everyday", 3, dow, completed);

		db.printValues();

	}

}
