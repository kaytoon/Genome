# Genome

Imagine a virtual world in which all that exists are strings of characters from the set
{ A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, _, ­, ’ }
(The ‘_’ represents the space character.) Strings in this world can reproduce new strings and die if they are not fit enough. I evolve strings in this world until they spell my name. To do this i create a Genome class which will contain a list of characters from the above set representing a string in my world, and create a Population class which will contain a list of Genomes representing all the strings in my world.
my Genome class must:
● have some internal representation of the string of characters.
● initialize a new string to the default value ‘A’.
● be able to m utate b y:
○ possibly a dding a new character somewhere in the string.
○ possibly d eleting a randomly selected character from the string.
○ possibly c hanging a character in the string to a different value.
● be able to c rossover w ith another genome:
○ given two Genomes create a third that is a combination of the two.
● beabletomeasureGenomef itness: 
○ using one of the two zero­based fitness methods listed here:
■ calculate how close the string in the Genome is from your name using the simple method detailed below.
■ (Optional) calculate how close the string in the Genome is from my name using the Levenshtein edit­distance.
● display:
○ output the string and its fitness in an easy to read format.
 
my Population class must:
● maintain a list of Genomes representing the current population.
● initialize the population with a fixed number of default Genomes.
● update the list of Genomes every breeding cycle by:
○ removing the least­fit members of the population.
○ mutating or breeding the most­fit members of the population.
○ Note: Because we are using a zero­based fitness the “most fit” member of the
population has the lowest fitness score not the highest.
● display the entire population.
● display the most­fit individual in the population.
The Main class is a controller and will:
● instantiate the Population class.
○ I use 100 genomes and a mutation rate of 0.05.
● call day() from the Population class until the fitness of the most fit genome is zero.
● output simulation progress.
● output runtime statistics.
