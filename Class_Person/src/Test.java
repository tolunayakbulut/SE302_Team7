import java.util.Scanner;
public class Test {
    public static void main(String[]args) {

        Person reference= new Person("Referans","Insan",11,2001,true);
        Person baba= new Person("Baba","Ust",22,1980,true);
        Person anne= new Person("Anne","Ust",33,1980,false);
        Person erkekKardes=new Person("ErkekKardes","esit",44,2000,true);
        Person kızKardes=new Person("KızKardes","esit",55,2000,false);
        Person amca=new Person("Amca","ust",66,1980,true);
        Person hala=new Person("Hala","ust",77,1980,false);
        Person dayı=new Person("Dayı","ust",88,1980,true);
        Person teyze=new Person("Teyze","ust",99,1980,false);

        Person.addFather(baba,reference);
        Person.relationMatcher(reference,baba);

        Person.addMother(anne,reference);
        Person.relationMatcher(reference,anne);

        Person.addChildren(erkekKardes,baba);
        Person.relationMatcher(baba,erkekKardes);

        Person.addChildren(erkekKardes,anne);
        Person.relationMatcher(anne,erkekKardes);

        Person.addChildren(kızKardes,baba);
        Person.relationMatcher(baba,kızKardes);

        Person.addChildren(kızKardes,anne);
        Person.relationMatcher(anne,kızKardes);



        reference.relationCalculator(reference);

    }
}
