package application;

public class Statistics {
		
		public int done;
		public int missed;
			
		/**
		 * updateCounters - updates values for counting done and missed
		 * 
		 * @param TaskManager - the TaskManager object that holds the Habit data
		 */
		public void updateCounters(TaskManager t) {
			
			done = 0;
			missed = 0;
		
			for(Habit h: t.getHabits()) {
				done += t.getOverallHabitStats(h)[0];
				missed += t.getOverallHabitStats(h)[1];
			}
			
			
		
		}
		
		public int getNumberDone() {
			return done;
		}
		
		public int getMissed() {
			return missed;
		}
}
