import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class  TreeUI  implements ActionListener {

    JFrame mainPage;
    JPanel panel;
    JButton ekleB;
    JTextField tfIsim, tfSoyisim, tfID, tfDy;
    JLabel isimLabel,soyisimLabel,IDLabel,dyLabel, cinsiyetLabel, akrabaLabel;
    JComboBox cbCinsiyet, cbAkraba;
    JTree famT;
    DefaultMutableTreeNode refPer, mother, father, siblings, spouse, children;

    public void labelFontChanger(JLabel pLabel) {//A method to change all fonts of the labels at the program.
        pLabel.setFont(new Font("Bold",Font.PLAIN,15));

    }

    public TreeUI() {
        //Main page initialization
        mainPage=new JFrame();

        //options in the panel
        //isim
        isimLabel=new JLabel("Ad: ");
        isimLabel.setBounds(1530,100,50,30);
        labelFontChanger(isimLabel);
        mainPage.add(isimLabel);
        tfIsim=new JTextField();
        tfIsim.setBounds(1640,100,250,30);
        mainPage.add(tfIsim);


        //soyisim
        soyisimLabel=new JLabel("Soyad: ");
        soyisimLabel.setBounds(1530,150,50,30);
        labelFontChanger(soyisimLabel);
        mainPage.add(soyisimLabel);
        tfSoyisim=new JTextField();
        tfSoyisim.setBounds(1640,150,250,30);
        mainPage.add(tfSoyisim);


        //ID
        IDLabel=new JLabel("ID: ");
        IDLabel.setBounds(1530,200,50,30);
        labelFontChanger(IDLabel);
        mainPage.add(IDLabel);
        tfID=new JTextField();
        tfID.setBounds(1640,200,250,30);
        mainPage.add(tfID);

        //Dogum yılı
        dyLabel=new JLabel("Doğum yılı: ");
        dyLabel.setBounds(1530,250,100,30);
        labelFontChanger(dyLabel);
        mainPage.add(dyLabel);
        tfDy=new JTextField();
        tfDy.setBounds(1640,250,250,30);
        mainPage.add(tfDy);

        //Cinsiyet
        cinsiyetLabel=new JLabel("Cinsiyet: ");
        cinsiyetLabel.setBounds(1530,300,100,30);
        labelFontChanger(cinsiyetLabel);
        mainPage.add(cinsiyetLabel);
        String []gender={"Kadın","Erkek"};
        cbCinsiyet=new JComboBox(gender);
        cbCinsiyet.setBounds(1640,300,100,30);
        mainPage.add(cbCinsiyet);

        //Akrabalık
        akrabaLabel=new JLabel("Cinsiyet: ");
        akrabaLabel.setBounds(1530,400,100,30);
        labelFontChanger(akrabaLabel);
        mainPage.add(akrabaLabel);
        String []relatives={"Kendisi ","Annesi ","Babası ","Çocuğu ","Eşi "};
        cbAkraba=new JComboBox(relatives);
        cbAkraba.setBounds(1640,400,100,30);
        mainPage.add(cbAkraba);

        //Tree creation
        refPer=new DefaultMutableTreeNode("Kendisi");
        famT=new JTree(refPer);
        famT.setBounds(40,50,1300,900);
        mother=new DefaultMutableTreeNode("Annesi");refPer.add(mother);
        father=new DefaultMutableTreeNode("Babası");refPer.add(father);
        siblings=new DefaultMutableTreeNode("Kardeşleri");refPer.add(siblings);
        spouse=new DefaultMutableTreeNode("Eşi ");refPer.add(spouse);
        children=new DefaultMutableTreeNode("Çocukları ");refPer.add(children);
        famT.setFont(new Font("Bold",Font.PLAIN,20));
        mainPage.add(famT);













        //Main page
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setLayout(null);
        mainPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPage.setVisible(true);

        //Panel div for the options.
        JPanel panel=new JPanel();
        panel.setBounds(1500,0,500,1200);
        panel.setBackground(Color.LIGHT_GRAY);
        mainPage.add(panel);





    }

    public void actionPerformed(ActionEvent e) {}


    public static void main(String[]args) {

        new TreeUI();




    }




}