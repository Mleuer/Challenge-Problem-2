package Challenge;

import org.joda.money.Money;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public String firstName;
    public String lastName;
    public int age;
    public EducationLevel highestLevelOfEducation;
    public Money income;

    public Person(String firstName, String lastName, int age, EducationLevel highestLevelOfEducation, Money income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.highestLevelOfEducation = highestLevelOfEducation;
        this.income = income;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;

            if (this.firstName.equals(person.firstName) &&
                    this.lastName.equals(person.lastName) &&
                    this.age == person.age &&
                    this.highestLevelOfEducation.equals(person.highestLevelOfEducation) &&
                    this.income.equals(person.income)
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
        String fullName = Person.extractPropertyFromText(descriptionOfPerson, "Name: ");
        String firstName = fullName.substring(0, fullName.indexOf(' '));
        String lastName = fullName.substring(fullName.indexOf(' ') + 1);

        String age = Person.extractPropertyFromText(descriptionOfPerson, "Age: ");
        int resultAge = Integer.parseInt(age);

        String highestLevelOfEducation = Person.extractPropertyFromText(descriptionOfPerson, "Highest Level of Education: ");
        EducationLevel educationLevel = EducationLevel.fromString(highestLevelOfEducation);

        String incomeString = Person.extractPropertyFromText(descriptionOfPerson, "Income: ");

        Money income = Util.parseStringIntoMoney(incomeString);
        Person person = new Person(firstName, lastName, resultAge, educationLevel, income);

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

    public enum EducationLevel {
        GradeSchool("Grade School"),
        HighSchool("High School"),
        College("College");

        public String prettyName;

        EducationLevel(String prettyName) {
            this.prettyName = prettyName;
        }

        public static EducationLevel fromString(String text) {
            for (EducationLevel educationLevel : EducationLevel.values()) {
                if (educationLevel.prettyName.equalsIgnoreCase(text)) {
                    return educationLevel;
                }
            }
            return null;
        }
    }
}
