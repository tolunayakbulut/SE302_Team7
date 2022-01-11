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
        Person dedeB=new Person("DedeB","ust*2",111,1960,true);
        Person babanne=new Person("Babanne","ust*2",222,1960,false);
        Person dedeA=new Person("DedeA","Ust*2",333,1960,true);
        Person annanne=new Person("Ananne","ust*2",444,1960,false);
        Person cocukK=new Person("KızCocuk","alt",555,3000,false);
        Person cocukE=new Person("ErkekCocuk","alt",666,3000,true);
        Person es=new Person("Es","Esit",777,2001,false);


        //assigning ref person
        Person.addFather(baba,reference);
        Person.relationMatcher(reference,baba);

        Person.addMother(anne,reference);
        Person.relationMatcher(reference,anne);

        //sis bro
        Person.addChildren(erkekKardes,baba);
        Person.relationMatcher(baba,erkekKardes);

        Person.addChildren(erkekKardes,anne);
        Person.relationMatcher(anne,erkekKardes);

        Person.addChildren(kızKardes,baba);
        Person.relationMatcher(baba,kızKardes);

        Person.addChildren(kızKardes,anne);
        Person.relationMatcher(anne,kızKardes);

        //Grandparents
        Person.addFather(dedeB,baba);
        Person.relationMatcher(baba,dedeB);
        Person.addMother(babanne,baba);
        Person.relationMatcher(baba,babanne);

        Person.addFather(dedeA,anne);
        Person.relationMatcher(anne,dedeA);
        Person.relationMatcher(annanne,anne);
        Person.relationMatcher(anne,annanne);



        //Hala Amca
        Person.addChildren(amca,dedeB);
        Person.relationMatcher(dedeB,amca);
        Person.addChildren(amca,babanne);
        Person.relationMatcher(babanne,amca);

        Person.addChildren(hala,dedeB);
        Person.relationMatcher(dedeB,hala);
        Person.addChildren(hala,babanne);
        Person.relationMatcher(babanne,hala);

        //Teyze Dayı
        Person.addChildren(dayı,dedeA);
        Person.relationMatcher(dedeA,dayı);
        Person.addChildren(dayı,annanne);
        Person.relationMatcher(annanne,dayı);

        Person.addChildren(teyze,dedeA);
        Person.relationMatcher(dedeA,teyze);
        Person.addChildren(teyze,annanne);
        Person.addChildren(annanne,teyze);
        //ES
        Person.addSpouse(es,reference);
        Person.relationMatcher(reference,es);
        //Çocuklar
        Person.addChildren(cocukE,reference);
        Person.relationMatcher(reference,cocukE);
        Person.addChildren(cocukE,es);
        Person.relationMatcher(es,cocukE);

        Person.addChildren(cocukK,reference);
        Person.relationMatcher(reference,cocukK);
        Person.addChildren(cocukK,es);
        Person.relationMatcher(es,cocukK);


        reference.relationCalculator(reference);

    }
}
