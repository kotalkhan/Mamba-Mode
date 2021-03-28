import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a habit you want to keep track of: ");
		String habit = input.nextLine();
		System.out.println("Enter the days of the week you want to do this habit: ");
		String daysOfWeekAsString = input.nextLine();
		System.out.println("Enter the amount of times on the days of the week you \n want to keep up this habit");
		int goal = input.nextInt();
		input.close();
		
		//parsing daysOfTheWeek to make an array
		String daysOfWeekAsArray[] = daysOfWeekAsString.split(",");
		//making an ArrayList object to store the String
		List<String> daysOfWeek = new ArrayList<String>();
		//Putting the array's contents into the ArrayList
		daysOfWeek = Arrays.asList(daysOfWeekAsArray);
		
		
		//Converts all the days of the week into a number representation
		/*
			ArrayList<Integer> daysOfWeek = new ArrayList<Integer>();
			
			if(daysOfWeekAsArrayList.contains("Sunday"))
			{
				daysOfWeek.add(0);
			}
			else if(daysOfWeekAsArrayList.contains("Monday"))
			{
				daysOfWeek.add(1);
			}
			else if(daysOfWeekAsArrayList.contains("Tuesday"))
			{
				daysOfWeek.add(2);
			}
			else if(daysOfWeekAsArrayList.contains("Wednesday")) 
			{
				daysOfWeek.add(3);
			}
			else if(daysOfWeekAsArrayList.contains("Thursday")) 
			{
				daysOfWeek.add(4);
			}
			else if(daysOfWeekAsArrayList.contains("Friday")) 
			{
				daysOfWeek.add(5);
			}
			else if(daysOfWeekAsArrayList.contains("Saturday")) 
			{
				daysOfWeek.add(6);
			}
		*/
		
		Habit hab = new Habit(habit, daysOfWeek, goal);
		
		System.out.println(hab);

	}

}
