import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class UtilTest {

    @Test
    public void calculateNumberOfRespondentsShouldReturn3AsNumberOfRespondents() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, "College", Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3);

        BigDecimal avgAge = Util.calculateAverageAge(people);

        Assert.assertEquals(new BigDecimal(41), avgAge);
    }

    @Test
    public void CalculateMostCommonHighestLevelOfEducationShouldReturnCollege() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, "College", Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3);

        String mostCommon = Util.calculateMostCommonHighestLevelOfEducation(people);

        Assert.assertEquals("College", mostCommon);

    }

    @Test
    public void calculateMedianIncomeShouldReturnMedianIncomeWhenEvenNumberOfPeople() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, "College", Money.of(CurrencyUnit.USD, 70000));
        Person person4 = new Person("Tom", "Hanks", 63, "College", Money.of(CurrencyUnit.USD, 60000));

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        Money expectedMedianIncome = Util.calculateMedianIncome(people);

        Assert.assertEquals(Money.of(CurrencyUnit.USD, 65000), expectedMedianIncome);
    }

    @Test
    public void calculateMedianIncomeShouldReturnMedianIncomeWhenOddNumberOfPeople() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, "College", Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3);

        Money expectedMedianIncome = Util.calculateMedianIncome(people);

        Assert.assertEquals(Money.of(CurrencyUnit.USD, 70000), expectedMedianIncome);
    }

    @Test
    public void alphabetizeByLastNameShouldAlphabetizeNamesOrderedByLastName() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, "College", Money.of(CurrencyUnit.USD, 70000));
        Person person4 = new Person("Tammy", "Ark", 27, "College", Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        List<Person> actualOrderOfPeople = Util.alphabetizeByLastName(people);
        List<Person> expectedOrderOfPeople = Arrays.asList(person3, person4, person2, person1);

        Assert.assertEquals(expectedOrderOfPeople, actualOrderOfPeople);
    }

    @Test
    public void printNamesShouldReturnNamesOfEveryPersonInAListAsOneString() {
        Person person1 = new Person("Edgar", "McCormick", 57, "College", Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, "High School", Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, "College", Money.of(CurrencyUnit.USD, 70000));
        Person person4 = new Person("Tammy", "Ark", 27, "College", Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        String names = Util.printNames(people);

        Assert.assertEquals("Edgar McCormick, Percy Hoffman, Tammy Ard, Tammy Ark", names);
    }

    @Test
    public void parseStringIntoMoneyShouldReturnMoneyObjectWithValueOfThreeHundredThousandDollars() {
        String moneyString = "$300,000";

        Money money = Util.parseStringIntoMoney(moneyString);

        Assert.assertEquals(Money.of(CurrencyUnit.USD, 300000), money);
    }
}
