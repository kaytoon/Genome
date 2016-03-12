/*
 * Mohamed Dahir
 * Assignment 2
 * Name evolving home work.
 */
package view;

public class Main {

	public static void main(String[] args) {
		//testGenome();
		//testPopulation();
		//starts the timer.
		long start = System.currentTimeMillis();
		int dayCount = 0;
		Population population = new Population(100,0.05);
		System.out.println(population);
		while(population.mostFit.fitness() != 0){
			population.day();
			System.out.println(population);
			dayCount++;
		}
		
		long runTime = System.currentTimeMillis() - start;
		System.out.println("Generations: " + dayCount);
		System.out.println("Running Time: " + runTime + " ms");

	}

	public static void testGenome(){
Genome testGenome1 = new Genome(.05);
		
		System.out.println(testGenome1);
		System.out.println(testGenome1.myMutationRate);
		System.out.println(testGenome1.mySize);
		for(int i = 0; i < 100; i++){
			testGenome1 = testGenome1.mutate();
			
			System.out.println(testGenome1);
			System.out.println(testGenome1.mySize);
		}
		Genome tempGenome1 = new Genome(.05);
		Genome tempGenome2 = new Genome(.05);
		tempGenome1.myGenome = "NOT COOL";
		tempGenome2.myGenome = "THIS IS NOT COOL MAN";
		System.out.println(tempGenome1);
		System.out.println(tempGenome2);
		Genome testGenome2 = tempGenome1.crossover(tempGenome2);
		System.out.println(testGenome2);
	}


	public static void testPopulation(){
		Population testPop = new Population(100, 0.05);
		System.out.println(testPop);
		System.out.println(testPop.myGenomeList);
		for(int i = 0; i <= 100; i++){
			testPop.day();
			System.out.println(testPop);
		}
	}
}
