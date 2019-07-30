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
        String otherString = "Other";
        int college = 0;
        int highSchool = 0;
        int other = 0;

        for (Person person :
                people) {
            if (person.highestLevelOfEducation == "High School") {
                highSchool++;
            }
            if (person.highestLevelOfEducation == "College") {
                college++;
            }
            else other++;
        }
        if (college > highSchool) {
            return collegeString;
        }else if (highSchool > college) {
            return highSchoolString;
        }else return otherString;
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

    public static List<String> alphabetizeByLastName(List<Person> people) {
        ArrayList names = new ArrayList();
        for (Person person : people) {
            names.add(person.name);
        }
        Collections.sort(names);
        return names;
    }
}
