import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Person {

    public String name;
    public int age;
    public String highestLevelOfEducation;
    public int income;

    public Person(String name, int age, String highestLevelOfEducation, String income) {
        this.name = name;
        this.age = age;
        this.highestLevelOfEducation = highestLevelOfEducation;
        this.income = Util.convertIncomeStringToInt(income);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;

            if (this.name.equals(person.name) &&
                    this.age == person.age &&
                    this.highestLevelOfEducation.equals(person.highestLevelOfEducation) &&
                    this.income == person.income
            )
            {
                return true;
            }

        }
        return false;
    }

    public static String extractPropertyFromText(String descriptionOfPerson, String propertyIdentifier) {
        StringBuilder property = new StringBuilder();

        int index = descriptionOfPerson.indexOf(propertyIdentifier);
        int startingIndex = index + propertyIdentifier.length();
        char currentCharacter = ' ';

        for (int i = startingIndex;; i++) {
            if (i >= descriptionOfPerson.length()) {
                break;
            }
            currentCharacter = descriptionOfPerson.charAt(i);
            if (currentCharacter == ',' && propertyIdentifier != "Income: ") {
                break;
            }
            property.append(currentCharacter);
        }
        return property.toString();
    }

    public static Person createPersonFromText(String descriptionOfPerson) {
        String name = Person.extractPropertyFromText(descriptionOfPerson, "Name: ");

        String age = Person.extractPropertyFromText(descriptionOfPerson, "Age: ");
        int resultAge = Integer.parseInt(age);

        String highestLevelOfEducation = Person.extractPropertyFromText(descriptionOfPerson, "Highest Level of Education: ");

        String income = Person.extractPropertyFromText(descriptionOfPerson, "Income: ");

        Person person = new Person(name, resultAge, highestLevelOfEducation, income);

        return person;

    }

    public static List<Person> createPeopleFromText(File input) throws IOException {
        BufferedReader inputFileReader = new BufferedReader(new FileReader(input));
        String line = inputFileReader.readLine();

        ArrayList<Person> people = new ArrayList<>();
        while (line != null) {
            people.add(Person.createPersonFromText(line));
            line = inputFileReader.readLine();
        }
        return people;
    }


}
