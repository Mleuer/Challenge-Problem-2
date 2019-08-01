import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class UtilTest {

    @Test
    public void convertIncomeStringToIntShouldReturnIncomeAsAnInt() {
        String income = "$80,000";

        int actualIncome = Util.convertIncomeStringToInt(income);

        Assert.assertEquals(80000, actualIncome);
    }

    @Test
    public void convertIncomeIntToStringShouldReturnIncomeAsAString() {
        int income = 80000;

        String actualIncome = Util.convertIncomeIntToString(income);

        Assert.assertEquals("$80,000", actualIncome);
    }

    @Test
    public void calculateNumberOfRespondentsShouldReturn3AsNumberOfRespondents() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", "$80,000");
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", "$55,000");
        Person person3 = new Person("Tammy", "Ard", 27, "College", "$70,000");

        List<Person> people = Arrays.asList(person1, person2, person3);

        BigDecimal avgAge = Util.calculateAverageAge(people);

        Assert.assertEquals(new BigDecimal(41), avgAge);
    }

    @Test
    public void CalculateMostCommonHighestLevelOfEducationShouldReturnCollege() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", "$80,000");
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", "$55,000");
        Person person3 = new Person("Tammy", "Ard", 27, "College", "$70,000");

        List<Person> people = Arrays.asList(person1, person2, person3);

        String mostCommon = Util.calculateMostCommonHighestLevelOfEducation(people);

        Assert.assertEquals("College", mostCommon);

    }

    @Test
    public void calculateMedianIncomeShouldReturnMedianIncomeWhenEvenNumberOfPeople() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", "$80,000");
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", "$55,000");
        Person person3 = new Person("Tammy", "Ard", 27, "College", "$70,000");
        Person person4 = new Person("Tom", "Hanks", 63, "College", "$60,000");

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        int expectedMedianIncome = Util.calculateMedianIncome(people);

        Assert.assertEquals(65000, expectedMedianIncome);
    }

    @Test
    public void calculateMedianIncomeShouldReturnMedianIncomeWhenOddNumberOfPeople() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", "$80,000");
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", "$55,000");
        Person person3 = new Person("Tammy", "Ard", 27, "College", "$70,000");

        List<Person> people = Arrays.asList(person1, person2, person3);

        int expectedMedianIncome = Util.calculateMedianIncome(people);

        Assert.assertEquals(70000, expectedMedianIncome);
    }

    @Test
    public void alphabetizeByLastNameShouldAlphabetizeNamesOrderedByLastName() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", "$80,000");
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", "$55,000");
        Person person3 = new Person("Tammy", "Ard", 27, "College", "$70,000");
        Person person4 = new Person("Tammy", "Ark", 27, "College", "$70,000");

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        List<Person> actualOrderOfPeople = Util.alphabetizeByLastName(people);
        List<Person> expectedOrderOfPeople = Arrays.asList(person3, person4, person2, person1);

        Assert.assertEquals(expectedOrderOfPeople, actualOrderOfPeople);
    }

    @Test
    public void printNamesShouldReturnNamesOfEveryPersonInAListAsOneString() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", "$80,000");
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", "$55,000");
        Person person3 = new Person("Tammy", "Ard", 27, "College", "$70,000");
        Person person4 = new Person("Tammy", "Ark", 27, "College", "$70,000");

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        String names = Util.printNames(people);

        Assert.assertEquals("Edgar McCormick, Percy Hoffman, Tammy Ard, Tammy Ark", names);
    }
}
