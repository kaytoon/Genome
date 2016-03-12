/*
 * Mohamed Dahir.
 * Dara Assigment 2.
 * String Evolving Home Work.
 * 
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Population {
	public Genome mostFit;
	List<Genome> myGenomeList;
	/**
	 * A constructor that initialize myGenomeList to the most fit Genome.
	 * @param takes A Genome and makes the variable immutable. 
	 */
	public Population(int numGenomes, Double mutationRate){
		myGenomeList = new ArrayList<Genome>(numGenomes);
		for(int i = 0; i < numGenomes; i++){
			myGenomeList.add(new Genome(mutationRate));
		}
		mostFit =myGenomeList.get(0);
	}
	/**
	 * This method is called evey breeding cycle, updates the most fit,
	 * delete the least­fit half of the population and creates a new Genome from the 
	 * remaining Popluation. 
	 */
	public void day(){
		Collections.sort(myGenomeList);
		mostFit = myGenomeList.get(0);
		int populationSize = myGenomeList.size();
		for (int i = populationSize-1; i >= populationSize/2; i--){
			myGenomeList.remove(i);
		}
		Random rand = new Random(); 
		while(myGenomeList.size()<populationSize){
			if(rand.nextDouble()<=0.5){
				myGenomeList.add(myGenomeList.get(rand.nextInt(myGenomeList.size())).mutate());
			}
			else{
				int index1 = rand.nextInt(myGenomeList.size());
				Genome mother = myGenomeList.remove(index1);
				Genome father = myGenomeList.get(rand.nextInt(myGenomeList.size()));
				
				myGenomeList.add(index1, mother);
				myGenomeList.add(mother.crossover(father));
			}
		}
	}
	/**
	 * String representation of the mostFit in the genome.  
	 */
	public String toString(){
		return mostFit.toString();
	}
}
