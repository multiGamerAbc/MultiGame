package mainPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserStatsData {
	// data structure to hold user stats
	Map<String,ArrayList<String>> userStats = new HashMap<String,ArrayList<String>>();
	// data structure to hold user's SuperMath quiz results
	ArrayList<String> superMathScoresWithTimeStamps = new ArrayList<String>();
	private String userName;
	// set userName in constructor
	public UserStatsData(String userName) {
		this.userName = userName;
	}
	// insert new statistic into results list according to game 
	public void addStatistic(String game, String newStatistic) {
		if(game.compareTo("SuperMath") == 0) {
			superMathScoresWithTimeStamps.add(newStatistic);	
		} else if (game.compareTo("Some Other Game") == 0) {
			//...
		}
	}
	// get user's stats
	public Map<String,ArrayList<String>> getUserStats(){
		userStats.put("SuperMath", superMathScoresWithTimeStamps);
		return userStats;
	}	
}
