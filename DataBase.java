package kobe;

import java.sql.*;
import java.util.ArrayList;

/**
 * DataBase - a class that handles pulling and pushing data from and to a database through SQLLite
 * @author Edward P, Mohammad N, Aravind U
 *
 */
public class DataBase {
	Connection connection = null;
	String url;
	Statement statement;

	/**
	 * Constructor - sets up the data base and will put in a table if a table does not already exist within the database
	 * @param fileName - the name of the data base
	 */
	public DataBase(String fileName) {

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
					+ " days VARCHAR(7))";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * addHabit - adds a habit to the data base
	 * @param h - the habit that you want to add to the database
	 */
	public void addHabit(Habit h) {
		String[] info = h.getHabitInfo();
		String habit = info[0];
		int goal = Integer.parseInt(info[1]);
		String days = info[2];

		try {
			// gets a connection
			statement = connection.createStatement();
			String sql = "INSERT INTO HABITS " + "VALUES ('" + habit + "', '" + goal + "', '" + days + "')";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * addHabit - deletes a habit to the data base
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
	 * getHabits - gets all the habits from the database
	 * @return - an arraylist<Habit> with all the habits that are stored in the database
	 */
	public ArrayList<Habit> getHabits(){
		ArrayList<Habit> habits = new ArrayList<Habit>();
		String sql = "SELECT habit, goal, days FROM HABITS";
		try {
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String habit = rs.getString("habit");
				int goal = rs.getInt("goal");
				String days = rs.getString("days");
				
				boolean[] daysBool = new boolean[7];
				
				for(int i =0; i < days.length(); i++) {
					if(days.charAt(i) == '1') {
						daysBool[i] = true;
					} else {
						daysBool[i] = false;
					}
				}
				
				Habit h = new Habit(habit, daysBool, Integer.parseInt(days));
				habits.add(h);
			}
			
			return habits;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * printValues - prints the values into the the console
	 */
	public void printValues() {
		String sql = "SELECT habit, goal, days FROM HABITS";
		try {
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String habit = rs.getString("habit");
				int goal = rs.getInt("goal");
				String days = rs.getString("days");
			

				System.out.print("Habit: " + habit);
				System.out.print(" | Goal: " + goal);
				System.out.print(" | Days: " + days + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DataBase DB = new DataBase("New db");
		boolean[] days = {true, false, true, true, false, false, false };
		Habit h = new Habit("Climbing rocks", days, 3);
		
		DB.printValues();
	}
}
