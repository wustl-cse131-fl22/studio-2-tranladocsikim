package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter start amount: ");
		int startAmount = in.nextInt();
		
		System.out.print("Enter win chance: ");
		double winChance = in.nextDouble();
		
		System.out.print("Enter win limit: ");
		int winLimit = in.nextInt();
		
		int totalSimulations = 500;
		int lossCount = 0;
		double expectedRR;
		
		for (int i = 1; i <= totalSimulations; i++) {
			int numPlays = 0;
			int currAmount = startAmount;
			String status;
			
			while (currAmount <= winLimit && currAmount != 0) {
			
			if (Math.random() <= winChance) {
				currAmount += 1;
				numPlays += 1;
			}	
			else {
				currAmount -= 1;
				numPlays += 1;
			}
		}
			if (currAmount == 0) {
				status = "LOSE";
				lossCount += 1;
			}
			else {
				status = "WIN";
			}
		System.out.println("Simulation " + i + ": " + numPlays + " " + status);
	}
	if (winChance == 0.5) {
		expectedRR = 1 - ((double) startAmount / (double) winLimit);
		
	}
	else {
		double alpha = (1 - winChance) / winChance;
		expectedRR = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
	}
	System.out.println("\nLosses: " + lossCount + ", Simulations: " + totalSimulations);
	System.out.println("Ruin Rate From Simulation: " + ((double) lossCount / (double) totalSimulations));
	System.out.println("Expected Ruin Rate: " + expectedRR);
}

}
