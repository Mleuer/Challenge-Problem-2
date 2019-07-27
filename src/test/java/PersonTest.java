import org.junit.Assert;
import org.junit.Test;


public class PersonTest {

    @Test
    public void extractPropertyFromTextShouldExtractNameFromText() {
        String name = Person.extractPropertyFromText("Name: Edgar McCormick, Age: 57, Highest Level of Education: College, Income: $80,000", "Name: ");

        Assert.assertEquals("Edgar McCormick", name);
    }

    @Test
    public void extractPropertyFromTextShouldExtractAgeFromText() {
        String age = Person.extractPropertyFromText("Name: Edgar McCormick, Age: 57, Highest Level of Education: College, Income: $80,000", "Age: ");

        Assert.assertEquals("57", age);
    }

    @Test
    public void extractPropertyFromTextShouldExtractHighestLevelOfEducationFromText() {
        String highestLevelOfEducation = Person.extractPropertyFromText("Name: Edgar McCormick, Age: 57, Highest Level of Education: College, Income: $80,000", "Highest Level of Education: ");

        Assert.assertEquals("College", highestLevelOfEducation);
    }

    @Test
    public void extractPropertyFromTextShouldExtractIncomeFromText() {
        String income = Person.extractPropertyFromText("Name: Edgar McCormick, Age: 57, Highest Level of Education: College, Income: $80,000", "Income: ");

        Assert.assertEquals("$80,000", income);
    }

    @Test
    public void createPersonFromTextShouldCreateAPersonObject() {
        Person expectedPerson = new Person("Percy Hoffman", 39, "High School", "$55,000");

        Person actualPerson = Person.createPersonFromText("Name: Percy Hoffman, Age: 39, Highest Level of Education: High School, Income: $55,000");

        Assert.assertEquals(expectedPerson, actualPerson);

    }

    @Test
    public void equalsShouldReturnTrueForEqualVehicles() {
        Person person1 = new Person("Percy Hoffman", 39, "High School", "$55,000");
        Person person2 = new Person("Percy Hoffman", 39, "High School", "$55,000");

        Assert.assertTrue(person1.equals(person2));
    }

    @Test
    public void equalsShouldReturnFalseForUnequalVehicles() {
        Person person1 = new Person("Percy Hoffman", 39, "High School", "$55,000");
        Person person2 = new Person("Edgar McCormick", 57, "College", "$80,000");

        Assert.assertFalse(person1.equals(person2));
    }
}
