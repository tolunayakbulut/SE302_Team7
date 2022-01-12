import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class Test implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel succes;

    public static void main(String[]args) {

        // GUI


        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10,80,80,25);
        button.addActionListener(new Test());
        panel.add(button);

        succes = new JLabel("");
        succes.setBounds(10,110,300,25);
        panel.add(succes);


        frame.setVisible(true);
        // GUI

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println( user + "," + password);

        if (user.equals("John") && password.equals("123")){
            succes.setText("Login successful!");
        }
    }
}
