### Overview
For this coding challenge, you will write a program to compute various demographics data based on a given list of persons.

### Input
Your program will read in its input from `Persons.txt`, which will contain a list of people in the following format:

```Name: [Name], Age: [Age], Highest Level of Education: [Highest Level of Education], Income: [Income in USD]```

So an example `Persons.txt` might look like the following:

```Name: Edgar McCormick, Age: 57, Highest Level of Education: College, Income: $80,000```

```Name: Percy Hoffman, Age: 39, Highest Level of Education: High School, Income: $55,000```

```Name: Tammy Ard, Age: 27, Highest Level of Education: College, Income: $70,000```

### Expected Output
Your program will need to compute the following data based on the given input: number of respondents, average (mean) age of all respondents, most common highest level of education achieved, and median income among all respondents, and finally a list of all names sorted in alphabetical order by last name. For the exact expected results and output format, see `Expected Output.txt`, which contains the expected output corresponding to the input given in `Persons.txt`.  Your program's output must match that given in `Expected Ouput.txt` character-for-character. However, you have the option to output your results as you see fit (e.g. printing to the console, printing to a new file, or some other means entirely - it's left to your discretion).

### Other Considerations
You can write your solution in whatever language you like, but ThoughtWorks will likely require your solution to their challenge problem to be in Java, so you may want to code this one in Java if only for practice. C# wouldn't be a bad second choice, however.

Assume that your program will be tested with a completely different set of data than the one you're provided (in other words, don't make any assumptions that are specific to the particular `Persons.txt` file included in this repo).

The following guidelines are not strict requirements, but will make for much better code and are likely to impress your reviewer in an actual ThoughtWorks coding challenge:
1.  Unit test your classes and methods.
2.  Key concepts (e.g. "person") should be represented by classes in your code, key operations/verbs (e.g. "compute the average", "list all persons") should probably be represented by methods/functions.  
2.  Write small methods. If you find a method is doing more than one thing, or is more than, say, 10 lines long or so (this of course is a rough metric, and will vary on a case-by-case basis), split that method into several methods.
3. Include a `ReadMe` explaining how to build and run your code.
