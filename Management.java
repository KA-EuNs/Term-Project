import java.util.Scanner;
public class Management {
	
	private int goal;
	private int targetPeriod;
	private int monthGoal;
	
	Scanner keyboard = new Scanner(System.in);
	
	public void readInput() {
		System.out.print("Enter a goal: ");
		goal = keyboard.nextInt();
		System.out.print(("Enter a targetPeriod: "));
		targetPeriod = keyboard.nextInt();
		
	}
	public int getGoalAsset() {
		return this.goal;
	}
	
	public int getTargetPeriod() {
		return this.targetPeriod;
	}
	public void setGoalAsset(int newGoalAsset) {
		this.goal = newGoalAsset;
	}
	public void setTargetPeriod(int newTarget) {
		this.targetPeriod = newTarget;
	}
	public void writeMonthGoal() {
		System.out.println("monthGoal = " + monthGoal);
	}
	public int calMonthGoal(int goal, int targetPeriod) {
		monthGoal = goal / targetPeriod;
		return monthGoal;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Management sample = new Management();
		int goal;
		int targetPeriod;
		int monthGoal;
		
		sample.readInput();
		sample.setGoalAsset(sample.goal);
		sample.setTargetPeriod(sample.targetPeriod);
		goal = sample.getGoalAsset();
		targetPeriod = sample.getTargetPeriod();
		monthGoal = sample.calMonthGoal(goal, targetPeriod);
		sample.writeMonthGoal();
		
	}

}










