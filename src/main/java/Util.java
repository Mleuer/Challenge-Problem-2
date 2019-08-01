import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Util {

    public static int convertIncomeStringToInt(String income) {
        StringBuilder newIncome = new StringBuilder(income);

        char currentChar = ' ';
        for (int i = 0; i < newIncome.length(); i++) {
            currentChar = newIncome.charAt(i);
            if (currentChar == '$' || currentChar == ',') {
                newIncome.deleteCharAt(i);
            }
        }
        String incomeAsString = newIncome.toString();
        int incomeAsInt = Integer.parseInt(incomeAsString);
        return incomeAsInt;
    }

    public static String convertIncomeIntToString(int income) {
        StringBuilder incomeAsString = new StringBuilder();
        incomeAsString.append(income);
        incomeAsString.insert(0, '$');
        for (int i = incomeAsString.length() - 3; i >= 2; i -= 3) {
            incomeAsString.insert(i, ',');
        }
        return incomeAsString.toString();
    }

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

    public static int calculateMedianIncome(List<Person> people) {
        ArrayList incomeList = new ArrayList();
        int medianIncome = 0;

        for (Person person : people) {
            incomeList.add(person.income);
        }
        Collections.sort(incomeList);

        if (incomeList.size() % 2 == 0) {
            int lowerMiddleIndex = (incomeList.size() / 2) - 1;
            int higherMiddleIndex = (incomeList.size() / 2);
            int lowerMiddleIncome = (int)incomeList.get(lowerMiddleIndex);
            int higherMiddleIncome = (int)incomeList.get(higherMiddleIndex);
            medianIncome = ((higherMiddleIncome - lowerMiddleIncome) / 2) + lowerMiddleIncome;
            return medianIncome;
        }
        medianIncome = (int)incomeList.get((incomeList.size()) / 2);

        return medianIncome;
    }

    public static void alphabetizeByLastName(List<Person> people) {

    }

    public static void printExpectedOutput(List<Person> people) {
        System.out.println("Total Respondents: " + people.size());
        System.out.println("Average Age: " + Util.calculateAverageAge(people));
        String mostCommonHighestLevelOfEducation = Util.calculateMostCommonHighestLevelOfEducation(people);
        System.out.println("Most Common Highest Level of Education: " + mostCommonHighestLevelOfEducation);
        int medianIncome = Util.calculateMedianIncome(people);
        System.out.println("Median Income: " + Util.convertIncomeIntToString(medianIncome));

    }
















}
