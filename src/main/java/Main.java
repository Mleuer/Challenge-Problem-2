import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        List<Person> people = Person.createPeopleFromText(new File("./Persons.txt"));
        PersonController.printExpectedOutput(people);
    }
}
