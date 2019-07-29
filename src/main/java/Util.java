import java.math.BigDecimal;
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
            }else if (person.highestLevelOfEducation == "College") {
                college++;
            }else other++;
        }
        if (college > highSchool) {
            return collegeString;
        }else if (highSchool > college) {
            return highSchoolString;
        }else return otherString;
    }

}
