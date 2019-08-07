import Challenge.Person;
import Challenge.PersonController;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static Challenge.Person.EducationLevel;
public class PersonControllerTest {

    @Test
    public void calculateNumberOfRespondentsShouldReturn3AsNumberOfRespondents() {
        Person person1 = new Person("Edgar", "McCormick", 57, EducationLevel.College, Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, EducationLevel.HighSchool, Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3);

        BigDecimal avgAge = PersonController.calculateAverageAge(people);

        Assert.assertEquals(new BigDecimal(41), avgAge);
    }

    @Test
    public void CalculateMostCommonHighestLevelOfEducationShouldReturnCollege() {
        Person person1 = new Person("Edgar", "McCormick", 57, EducationLevel.College, Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, EducationLevel.HighSchool, Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3);

        EducationLevel mostCommon = PersonController.calculateMostCommonHighestLevelOfEducation(people);

        Assert.assertEquals(EducationLevel.College, mostCommon);

    }

    @Test
    public void calculateMedianIncomeShouldReturnMedianIncomeWhenEvenNumberOfPeople() {
        Person person1 = new Person("Edgar", "McCormick", 57, EducationLevel.College, Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, EducationLevel.HighSchool, Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));
        Person person4 = new Person("Tom", "Hanks", 63, EducationLevel.College, Money.of(CurrencyUnit.USD, 60000));

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        Money expectedMedianIncome = PersonController.calculateMedianIncome(people);

        Assert.assertEquals(Money.of(CurrencyUnit.USD, 65000), expectedMedianIncome);
    }

    @Test
    public void calculateMedianIncomeShouldReturnMedianIncomeWhenOddNumberOfPeople() {
        Person person1 = new Person("Edgar", "McCormick", 57, EducationLevel.College, Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, EducationLevel.HighSchool, Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3);

        Money expectedMedianIncome = PersonController.calculateMedianIncome(people);

        Assert.assertEquals(Money.of(CurrencyUnit.USD, 70000), expectedMedianIncome);
    }

    @Test
    public void alphabetizeByLastNameShouldAlphabetizeNamesOrderedByLastName() {
        Person person1 = new Person("Edgar", "McCormick", 57, EducationLevel.College, Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, EducationLevel.HighSchool, Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));
        Person person4 = new Person("Tammy", "Ark", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        List<Person> actualOrderOfPeople = PersonController.alphabetizeByLastName(people);
        List<Person> expectedOrderOfPeople = Arrays.asList(person3, person4, person2, person1);

        Assert.assertEquals(expectedOrderOfPeople, actualOrderOfPeople);
    }

    @Test
    public void alphabetizeByLastNameShouldAlphabetizeNamesOrderedByLastNameWhenMoreThanOnePersonHasTheSameLastName() {
        Person person1 = new Person("Edgar", "McCormick", 57, EducationLevel.College, Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, EducationLevel.HighSchool, Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));
        Person person4 = new Person("Marvin", "McCormick", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));


        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        List<Person> actualOrderOfPeople = PersonController.alphabetizeByLastName(people);
        List<Person> expectedOrderOfPeople = Arrays.asList(person3, person2, person1, person4);

        Assert.assertEquals(expectedOrderOfPeople, actualOrderOfPeople);
    }

    @Test
    public void printNamesShouldReturnNamesOfEveryPersonInAListAsOneString() {
        Person person1 = new Person("Edgar", "McCormick", 57, EducationLevel.College, Money.of(CurrencyUnit.USD, 80000));
        Person person2 = new Person("Percy", "Hoffman", 39, EducationLevel.HighSchool, Money.of(CurrencyUnit.USD, 55000));
        Person person3 = new Person("Tammy", "Ard", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));
        Person person4 = new Person("Tammy", "Ark", 27, EducationLevel.College, Money.of(CurrencyUnit.USD, 70000));

        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        String names = PersonController.printNames(people);

        Assert.assertEquals("Edgar McCormick, Percy Hoffman, Tammy Ard, Tammy Ark", names);
    }
}
