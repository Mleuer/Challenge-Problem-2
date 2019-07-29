import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        Person.createPeopleFromText(new File("./Persons.txt"));


    }
}
