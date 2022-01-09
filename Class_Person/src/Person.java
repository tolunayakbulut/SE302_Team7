import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    String name;
    String surname;
    float ID;
    float birthDate;
    int gender;

    /*These relation definitions need to be defined, but also they need to refer a person*/

    Person mother,father,child,spouse;

    enum Relation {
        mother,father,child,spouse,uncle,aunt;
    }

    Scanner input=new Scanner(System.in);


    //constructor
    public Person(String pName, String pSurname, float pID, float pBirthDate, int pGender) {
        setName(pName);
        setSurname(pSurname);
        setID(pID);
        setBirthDate(pBirthDate);
        setGender(pGender);
    }
    public Person() {
        setName("not given");
        setSurname("not given");
        setID(0);
        setBirthDate(0);
        setGender(0);
    }

    //region getters and setters
    public String getName() {
        return name;
    }
    public void setName(String pName) {
        name=pName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String pSurname) {
        surname=pSurname;
    }
    public float getID() {
        return ID;
    }
    public void setID(float pID) {
        ID=pID;
    }
    public float getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(float pBirthDate) {
        birthDate=pBirthDate;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getChild() {
        return child;
    }

    public void setChild(Person child) {
        this.child = child;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
    //endregion

    ArrayList<Person> children=new ArrayList<Person>();
    //in case of reference person having multiple children.

    public void relationFinder(Person refPer) {
        System.out.println("Mother name: " + refPer.getMother().getName());
        System.out.println("Father name: "+ refPer.getFather().getName());
        System.out.println("number of children is "+children.size());
        System.out.println("children names are");
        for(int i=0;i<children.size();i++) {
            System.out.println(children.getClass().getName());
        }
    }

    //Method to add new person
    public Person personCreator() {
        String pName, pSurname;
        float ID, birthDate;
        int gender;

        System.out.println("Enter name: ");
        pName=input.next();
        System.out.println("Enter surname: ");
        pSurname=input.next();
        System.out.println("Enter id: ");
        ID=input.nextFloat();
        System.out.println("Enter birthdate: ");
        birthDate=input.nextFloat();
        System.out.println("Enter gender: ");
        gender=input.nextInt();

        return new Person(pName,pSurname,ID,birthDate,gender);

    }

    //a method to add mother father children and spouse.
    public void addMother(Person pMother, Person pPerson) {
        pPerson.setMother(pMother);
    }
    public void addFather(Person pFather, Person pPerson) {
        pPerson.setFather(pFather);
    }
    public void addSpouse(Person pSpouse, Person pPerson) {
        pPerson.setSpouse(pSpouse);
    }
    public void addChildren(Person pChildren, Person pPerson) {
        pPerson.children.add(pChildren);
    }

    public void relationCalculator(Person refPer) {
        System.out.println("mother name "+refPer.getMother().getName());
        System.out.println("father name "+refPer.getFather().getName());
        //System.out.println("spouse name "+refPer.getSpouse().getName());
        System.out.println("Children name ");
        for(int i=0; i<refPer.children.size();i++) {
            System.out.println(children.get(i).getName());
        }

        System.out.println("Uncle or uncles name: ");
        for(int i=0;i<refPer.getFather().children.size();i++) {
            System.out.println(refPer.getFather().children.get(i).getName());
        }


    }






}
