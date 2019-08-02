import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Util {

    public static BigDecimal calculateAverageAge(List<Person> people) {
        BigDecimal totalAge = new BigDecimal(0);
        for (Person person :
                people) {
            BigDecimal personsAge = new BigDecimal(person.age);
            totalAge = totalAge.add(personsAge);
        }
        BigDecimal avgAge;
        BigDecimal numberOfPeople = new BigDecimal(people.size());
        avgAge = totalAge.divide(numberOfPeople);

        return avgAge;
    }

    public static String calculateMostCommonHighestLevelOfEducation(List<Person> people) {
        String collegeString = "College";
        String highSchoolString = "High School";
        String gradeSchoolString = "Grade School";
        int college = 0;
        int highSchool = 0;
        int gradeSchool = 0;

        for (Person person : people) {
            if (person.highestLevelOfEducation.equals("High School")) {
                highSchool++;
            }
            else if (person.highestLevelOfEducation.equals("College")) {
                college++;
            }
            else if (person.highestLevelOfEducation.equals("Grade School")) {
                gradeSchool++;
            }
        }
        if (college > highSchool && college > gradeSchool) {
            return collegeString;
        }else if (highSchool > college && highSchool > gradeSchool) {
            return highSchoolString;
        }
        else if (gradeSchool > college && gradeSchool > highSchool) {
            return gradeSchoolString;
        }
        else return "Other";
    }

    public static Money calculateMedianIncome(List<Person> people) {
        ArrayList<Money> incomeList = new ArrayList<>();
        Money medianIncome;

        for (Person person : people) {
            incomeList.add(person.income);
        }
        Collections.sort(incomeList);

        if (incomeList.size() % 2 == 0) {
            medianIncome = calculateMedianIncomeOnEvenNumberOfPeople(incomeList);
            return medianIncome;
        }
        medianIncome = incomeList.get((incomeList.size()) / 2);

        return medianIncome;
    }

    private static Money calculateMedianIncomeOnEvenNumberOfPeople(List<Money> incomeList) {
        Money medianIncome;
        int lowerMiddleIndex = (incomeList.size() / 2) - 1;
        int higherMiddleIndex = (incomeList.size() / 2);

        Money lowerMiddleIncome = incomeList.get(lowerMiddleIndex);
        Money higherMiddleIncome = incomeList.get(higherMiddleIndex);
        Money difference = higherMiddleIncome.minus(lowerMiddleIncome);

        medianIncome = difference.dividedBy(2, RoundingMode.HALF_UP);
        medianIncome = medianIncome.plus(lowerMiddleIncome);

        return medianIncome;
    }

    public static List<Person> alphabetizeByLastName(List<Person> people) {
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<Person> orderedNames = new ArrayList<>();

        for (Person person : people) {
            lastNames.add(person.lastName);
        }
        Collections.sort(lastNames);

        for (String lastName : lastNames) {
            for (Person person : people) {
                if (person.lastName == lastName) {
                    orderedNames.add(person);
                }
            }
        }
        return orderedNames;
    }

    public static String printNames(List<Person> people) {
        StringBuilder names = new StringBuilder();

        for (int i = 0; i < people.size(); i++) {
            names.append(people.get(i).firstName + " ");
            if (i >= people.size() - 1) {
                names.append(people.get(i).lastName);
                return names.toString();
            }
            names.append(people.get(i).lastName + ", ");
        }
        return names.toString();
    }

    public static void printExpectedOutput(List<Person> people) {
        System.out.println("Total Respondents: " + people.size());
        System.out.println("Average Age: " + Util.calculateAverageAge(people));
        String mostCommonHighestLevelOfEducation = Util.calculateMostCommonHighestLevelOfEducation(people);
        System.out.println("Most Common Highest Level of Education: " + mostCommonHighestLevelOfEducation);
        Money medianIncome = calculateMedianIncome(people);
        System.out.println("Median Income: " + medianIncome);
        System.out.println("Names of All Respondents: " + Util.printNames(Util.alphabetizeByLastName(people)));
    }
















}
