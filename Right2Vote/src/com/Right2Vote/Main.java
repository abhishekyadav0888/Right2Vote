package com.Right2Vote;

public class Main {
	
	public static void main (String[] args) {
		int budget = 600;

        double Tshirt = 50.00;
        double Jeans = 80.00;
        double Jacket = 100.00;
        
        findCombination(budget, Tshirt, Jeans, Jacket);
	}
	
	public static void findCombination(int budget, double Tshirt, double Jeans, double Jacket) {
		
		if(budget < Math.min(Tshirt, (Math.min(Jeans, Jacket)))) {
			System.out.println("No combination is possible in this budget.");
		}
		
        int maxTshirt = (int) (budget / Tshirt);
        int maxJeans = (int) (budget / Jeans);
        int maxJacket = (int) (budget / Jacket);

        for (int i = 1; i <= maxTshirt; i++) {
            for (int j = 1; j <= maxJeans; j++) {
                int k = (int) Math.min(maxJacket, (budget - (i * Tshirt + j * Jeans)) / Jacket);
                double totalcost = i*Tshirt + j*Jeans + k*Jacket;
                if(i>=1 && j>=1 && k>=1 && totalcost<=budget && totalcost>=(budget- Math.min(Tshirt, (Math.min(Jeans, Jacket))))) {
                    System.out.println("Tshirt = " + i + " Jeans = " + j + " Jacket = " + k);
                }
            }
        }
    }
}
