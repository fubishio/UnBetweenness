# UnBetweenness

This is a solver for a problem similar to the [Betweenness](https://en.wikipedia.org/wiki/Betweenness) problem. It was originally an attempt to create a solver on my own but it was too slow so I just adapted the [Glucose](http://www.labri.fr/perso/lsimon/glucose/) SAT solver.

## Getting Started

Requires Python 2.7+, Java 8+, and [Glucose](http://www.labri.fr/perso/lsimon/glucose/). Also it's nice to have a seperate computer if it is run on extremely large sets of constraints.

### The Problem
The problem is to find the optimal ordering of people given the constraints in the form of {a, b, c} where person c cannot be between a and b. This is a slightly modified version of the [Betweenness](https://en.wikipedia.org/wiki/Betweenness) problem where instead of a variable having to be included between two other variables, a variable must be excluded between the other two. The Betweenness problem is proven np complete and this problem is also np complete because it reduces down to a 3SAT problem. This solution relies on this reduction.

### Features and Usage
There are 5 different files excluding the Glucose SAT solver:  
PreProcessor.java - takes in a input with the constraints and turns them into a file that can be fed into the Glucose SAT solver  
PostProcessor.java - takes the output of the Glucose solver and turns it back into a list of names from the original input 
testing.java - generates lists of constraints that are valid with a correct ordering  
input_validator.py - takes in a input with the correct ordering passed in and checks if the constraints conflict  
output_validator.py - takes in the result and a input file and checks if the solution is correct  

The format of the input for the preprocessor is that the first line must contain the number of unique names, the 2nd line must contain the amount of constraints provided, and the subsequent lines are the constraints in the form {a, b, c} where c cannot be between a and b. For the input to be validated by the input validator and checked against the output validator, the format must be different because we would need to give it the correct optimal ordering for it to be checked. The first line is still the number of unique names, but the second line must be the optimal ordering. The third line is going to be the number of constraints while the subsequent lines are all the constraints. 

Path and file specifications are in the mains of PreProcessor.java and PostProcessor.java so to change the input, just change the file specifications within the java files.  

To use:  
1. Get a valid input either through the testing.java or elsewhere and validate with input_validator.py if needed
1. Submit a valid input into the PreProcessor.java  
2. Take the resulting file, defaulted to "result.cnf", and run with  `./glucose-syrup -model [filename.cnf] > [destination]`
3. Take the resulting file at the destination and delete everything except the string of numbers at the bottom and run that through the PostProcessor  
4. Done! validate with output_validator.py if needed

## Concepts
Please check the [writeup](https://github.com/fubishio/UnBetweenness/blob/master/writeup.pdf) file in the repository for details on how the reduction was done in the PreProcessor.  

## Testing
The testing file is formatted so that every valid input is appended after the last input. The testing.java output should look similar to the the `.in` files in the folder testingBatch. This makes it easier to just pick a desired input and copy it into a file. For examples, please check the examples folder as it shows valid inputs for the PreProcessor.java and the input_validator.py. Note that testing.java's default optimal ordering lexicographic and only supports a certain amount of characters. To increase the amount of unique "names", please add more elements to `templist` in testing.java. If actual names are necessary, then take a valid input, and replace every instance of a "name" with a name of choice. Please refer to the examples folder for reference. 

## Acknowledgements
Thanks to friend Holly for checking my input_validator.py and output_validator.py.
