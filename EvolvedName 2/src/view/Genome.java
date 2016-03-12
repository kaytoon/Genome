/*
 * Mohamed Dahir.
 * Dara Assigment 2.
 * String Evolving Home Work.
 * 
 */
package view;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Genome implements Comparable<Genome>{
	protected final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ -'";

	//protected String target = "MOHAMED DAHIR";
	protected String target = "CHRISTOPHER PAUL MARRIOTT";
	protected String myGenome;
	protected int mySize;
	protected int myFitness = 1;
	protected double myMutationRate;
	private char[] arrayOfcrachters;
	/**
	 * A constructor that initializes every genome with 'A' .
	 * @param takes A Genome and makes the variable immutable. 
	 */
	public Genome(double myMutationRate){

		myGenome = "A";
		mySize = myGenome.length();
		this.myMutationRate = myMutationRate;
		this.fitness();
	}
	/**
	 * Creates a copy constructor of the genome constructor.
	 * @param gene-Takes A Genome and makes the variable immutable. 
	 */
	public Genome(Genome gene){
		myGenome = gene.myGenome;
		myMutationRate = gene.myMutationRate;
		myFitness = gene.myFitness;
		mySize = gene.mySize;
	}
	/**
	 * This method randomly mutates selected character in the GEnome
	 * @return newMutation-
	 */
	public Genome mutate(){
		arrayOfcrachters = abc.toCharArray();
		Random rand = new Random();
		Genome newMutation = new Genome(this);
		String newString = "";
		List<Character> geneHolder = new ArrayList<Character>();
		//puts each character into an array and checks to see if the character will mutate.
		for(int i=0;i<newMutation.mySize;i++){
			char singleGene = newMutation.myGenome.charAt(i);
			if(rand.nextDouble()<=newMutation.myMutationRate){
				singleGene = arrayOfcrachters[rand.nextInt(28)];
			}
			geneHolder.add(singleGene);
		}
		
		if(rand.nextDouble()<=newMutation.myMutationRate){
			newMutation.mySize++;
			geneHolder.add(rand.nextInt(newMutation.mySize), arrayOfcrachters[rand.nextInt(28)]);

		}
		/**
		 * Remove a Genome from a random positions in an arrayList.
		 */
		if(newMutation.mySize > 1) {
			if(rand.nextDouble()<=newMutation.myMutationRate){
				geneHolder.remove(rand.nextInt(newMutation.mySize-1));
				newMutation.mySize--;
			}
		}
		/**
		 * As long as the array is not empty remove the first index,
		 * and add it to string .
		 */
		while(!geneHolder.isEmpty()){
			newString = newString + geneHolder.remove(0);
		}
		newMutation.myGenome = newString;
		newMutation.fitness();
		return newMutation;

	}
	/**
	 * Updates current Genome 
	 * @param other- Takes another Genome.
	 * @return babyGenome - Takes two Genomes and combines them to make a knew Genome.
	 */
	public Genome crossover(Genome other){
		Genome parent2 = other;
		this.mySize = this.myGenome.length();
		parent2.mySize = parent2.myGenome.length();
		int min = Integer.min(this.mySize, parent2.mySize);
		int max = Integer.max(this.mySize, parent2.mySize);
		Random rand = new Random();
		String newString = "";
		for (int i = 0; i < min; i++){
			if(rand.nextDouble()<=0.5){
				newString = newString + this.myGenome.charAt(i);
			}
			else{
				newString = newString + parent2.myGenome.charAt(i);
			}
		}
		/**
		 * Takes care of large string characters.
		 */
		for(int i = min; i < max; i++){
			if(this.mySize==max){
				if(rand.nextDouble()<=0.5){
					newString = newString + this.myGenome.charAt(i);
				}
			}
			else{
				if(rand.nextDouble()<=0.5){
					newString = newString + parent2.myGenome.charAt(i);
				}
			}
		}
		Genome babyGenome = new Genome(this);
		babyGenome.myGenome = newString;
		babyGenome.mySize = newString.length();
		babyGenome.fitness();
		return babyGenome;
	}
	/**
	 * Calculates the fitness of Genomes
	 * @return myFitness - the fitness of the Genome
	 */
	public int fitness(){
		int n = myGenome.length();
		int m = target.length();

		int f = Math.abs(m-n)*2;
		
		int smallLength = Math.min(m, n);
		for(int i = 0; i < smallLength; i++){
			if(myGenome.charAt(i) != target.charAt(i)){
				f = f + 1;
			}
			myFitness = f;
		}
		return myFitness;
	}
	/**
	 * A string representation of the Genomes.
	 */
	public String toString(){
		return "(" + "\"" + this.myGenome + "\", " + this.myFitness+ ")";
	}
	/**
	 * Compare method for the the fitness of the Genomes.
	 */
	public int compareTo(Genome toCompare) {
		return this.myFitness-toCompare.myFitness;
	}
}

