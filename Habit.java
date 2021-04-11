package kobe;

import java.util.ArrayList;
import java.util.List;

public class Habit {
	private String habit;
	private boolean[] daysOfWeek;
	private int goal;

	public Habit(String habit, int goal, boolean[] dOW) {
		this.habit = habit;
		this.daysOfWeek = dOW;
		this.goal = goal;
	}

	/**
	 * editgoal - edits the goal of a certain habit
	 * 
	 * @param hab     - the habit you want to change
	 * @param newGoal - the new int value you want to change goal to
	 */
	public void editGoal(Habit hab, int newGoal) {
		hab.goal = newGoal;
	}

	/**
	 * editDaysOfWeek - edits the days of the week
	 * 
	 * @param hab     - the habit you want to change
	 * @param newGoal - the days of the week that the habit should be done
	 */
	public void editDaysOfWeek(Habit hab, boolean[] days) {
		hab.daysOfWeek = days;
	}

	public String getHabit() {
		return this.habit;
	}

	public boolean[] getDays() {
		return daysOfWeek;
	}

	public int getGoal() {
		return this.goal;
	}

	/**
	 * 
	 * @return an array where the first value is the habit, the second value is the
	 *         days of the week, and the last value is goals
	 */
	public String[] getHabitInfo() {
		String[] info = new String[3];
		String days = "";

		for (int i = 0; i < 7; i++) {
			if (daysOfWeek[i] == true) {
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

	public String toString() {
		return "Habit: " + habit + " | Days of the week: " + getHabitInfo()[1] + " | Goal: " + goal;
	}

}
