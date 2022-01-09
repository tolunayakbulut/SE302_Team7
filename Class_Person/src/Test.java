public class Test {
    public static void main(String[]args) {

        Person reference=new Person("john","doe",11,2001,1);
        Person mom=new Person("anne","doe",222,1980,2);
        Person father=new Person("baba","doe",333,1980,1);

        reference.addFather(father,reference);
        father.addChildren(reference,father);

        reference.addMother(mom,reference);
        mom.addChildren(reference,mom);

        mom.addSpouse(father,mom);
        father.addSpouse(mom,father);

        reference.relationCalculator(reference);

    }
}
