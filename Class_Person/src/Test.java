import java.util.ArrayList;

public class Test {
    public static void main(String[]args) {


        Person reference=new Person("john","doe",11,2001,1);
        Person mom=new Person("anne","doe",222,1980,2);
        Person father=new Person("baba","doe",333,1980,1);
        Person children=new Person("cocuk","doe",333,1980,1);

        Person.addFather(father,reference);
        Person.relationMatcher(reference,father);

        Person.addMother(mom,reference);
        Person.relationMatcher(reference,mom);

        Person.addSpouse(father,mom);
        Person.relationMatcher(mom,father);



        reference.relationCalculator(reference);

    }
}
