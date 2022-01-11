import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    String name;
    String surname;
    float ID;
    float birthDate;
    boolean isMale;


    Person mother,father,child,spouse;
    ArrayList<Person> children=new ArrayList<Person>();

    Scanner input=new Scanner(System.in);

    //constructor
    public Person(String pName, String pSurname, float pID, float pBirthDate, boolean isMale) {
        setName(pName);
        setSurname(pSurname);
        setID(pID);
        setBirthDate(pBirthDate);
        setMale(isMale);
    }
    public Person() {
        setName("not given");
        setSurname("not given");
        setID(0);
        setBirthDate(0);
        setMale(false);
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
    public boolean isMale() {
        return isMale;
    }
    public void setMale(boolean male) {
        isMale = male;
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
        boolean isMale;

        System.out.println("Enter name: ");
        pName=input.next();
        System.out.println("Enter surname: ");
        pSurname=input.next();
        System.out.println("Enter id: ");
        ID=input.nextFloat();
        System.out.println("Enter birthdate: ");
        birthDate=input.nextFloat();
        System.out.println("Enter gender: ");
        isMale=input.nextBoolean();

        return new Person(pName,pSurname,ID,birthDate,isMale);

    }

    //a method to add mother father children and spouse.
    public static void addMother(Person pMother, Person pPerson) {
        pPerson.setMother(pMother);
    }
    public static  void addFather(Person pFather, Person pPerson) {
        pPerson.setFather(pFather);
    }
    public static void addSpouse(Person pSpouse, Person pPerson) {
        pPerson.setSpouse(pSpouse);
    }
    public static void addChildren(Person pChildren, Person pPerson) {
        pPerson.children.add(pChildren);
    }

    public void relationCalculator(Person refPer) {

        System.out.println("mother name: "+refPer.getMother().getName());
        System.out.println("father name: "+refPer.getFather().getName());

        try {
            System.out.println("spouse name: "+refPer.getSpouse().getName());
        } catch (Exception e) {
            System.out.println("spouse name: " + refPer.getName() + "has not a spouse!");
        }

        try {
            System.out.println("Children name: ");
            for(int i=0; i<refPer.children.size();i++) {
                System.out.println(children.get(i).getName());
            }
        } catch (Exception e) {
            System.out.println(refPer.getName() + "has not got a child!");
        }

        System.out.println("--------------------------------------------------------------");
        try {
            System.out.println("Father's side/Uncle or uncles name: ");
            for(int i=0;i<refPer.getFather().getFather().children.size();i++) {
                if(refPer.getFather().getFather().children.get(i).isMale==true) {
                    System.out.println(refPer.getFather().getFather().children.get(i).getName());
                }
            }
        } catch (Exception e) {
            System.out.println(refPer.getName() + "has not got an uncle!");
        }
        System.out.println("--------------------------------------------------------------");


        try {
            System.out.println("Father's side/ aunt name: ");
            for(int i=0;i<refPer.getFather().getFather().children.size();i++) {
                if(refPer.getFather().getFather().children.get(i).isMale==false) {
                    System.out.println(refPer.getFather().getFather().children.get(i));
                }
            }
        }catch (Exception e) {
            System.out.println(refPer.getName()+"hasn't got an aunt.(Father's side) ");
        }
        System.out.println("--------------------------------------------------------------");

        try {
            System.out.println("Mother's side/ uncle name: ");
            for(int i=0;i<refPer.getMother().getFather().children.size();i++) {
                if(refPer.getMother().getFather().children.get(i).isMale==true) {
                    System.out.println(refPer.getMother().getFather().children.get(i).getName());
                }
            }
        }catch (Exception e) {
            System.out.println("hasn't got an uncle. (mother's side)");
        }
        System.out.println("--------------------------------------------------------------");

        try {
            System.out.println(refPer.getName()+"Mother's side aunt name. ");
            for(int i=0;i<refPer.getMother().getFather().children.size();i++) {
                if(refPer.getMother().getFather().children.get(i).isMale==false) {
                    System.out.println(refPer.getMother().getFather().children.get(i).getName());
                }
            }
        }catch (Exception e) {
            System.out.println(refPer.getName()+"hasn't got an aunt (mothers side). ");
        }
        System.out.println("--------------------------------------------------------------");
    }



    public static void relationMatcher(Person refPer, Person toBeAdded) {
        if(refPer.getMother()==toBeAdded) {
            addChildren(refPer,toBeAdded);
        }
        if(refPer.getFather()==toBeAdded) {
            addChildren(refPer,toBeAdded);
        }
        if(refPer.getSpouse()==toBeAdded) {
            addSpouse(refPer,toBeAdded);
        }
        for(int i=0;i<refPer.children.size();i++) {
            if(refPer.children.get(i)==toBeAdded) {//this if section may have faults.
                if(refPer.isMale==true) {//if father
                    addFather(refPer,refPer.children.get(i));
                }
                else {//if mother
                    addMother(refPer,refPer.children.get(i));
                }
            }
        }

    }


}
