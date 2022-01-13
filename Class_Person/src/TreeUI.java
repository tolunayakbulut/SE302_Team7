import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class  TreeUI  implements ActionListener {

    JFrame mainPage;
    JPanel panel;
    JButton ekleB, kaldırB;
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
        akrabaLabel=new JLabel("Akrabalık: ");
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
        spouse=new DefaultMutableTreeNode("Eşi ");refPer.add(spouse);
        children=new DefaultMutableTreeNode("Çocukları ");refPer.add(children);
        siblings=new DefaultMutableTreeNode("Kardeşleri");refPer.add(siblings);
        famT.setFont(new Font("Bold",Font.PLAIN,20));
        mainPage.add(famT);

        //Button
        ekleB=new JButton("Kişi ekle ");
        ekleB.setBounds(1530,500,100,30);
        mainPage.add(ekleB);
        kaldırB=new JButton("Kişi kaldır ");
        kaldırB.setBounds(1640,500,100,30);
        mainPage.add(kaldırB);
        ekleB.addActionListener(this::addPerson);

        //NOTE: The info box will be implemented here (The box that shows the info of a selected person.)






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

    public void actionPerformed(ActionEvent e) {
        addPerson(e);

    }

    public void addPerson(ActionEvent e) {
        if(e.getSource()==ekleB && (cbAkraba.getSelectedIndex()==0)) {//Relative field "Kendisi" is empty case
            emptyBoxChecker();
            DefaultTreeModel model = (DefaultTreeModel) famT.getModel();
            refPer.setUserObject(tfIsim.getText() + " " + tfSoyisim.getText()+"( Kendisi )");
            model.nodeChanged(refPer);
            SwingUtilities.updateComponentTreeUI(mainPage);
        }
        if(e.getSource()==ekleB&&(cbAkraba.getSelectedIndex()==1)) {//Relative field "annesi" case
            emptyBoxChecker();
            DefaultTreeModel model=(DefaultTreeModel) famT.getModel();
            DefaultMutableTreeNode upMother=new DefaultMutableTreeNode(tfIsim.getText()+" "+
                    tfSoyisim.getText());//up mother= updated mother name.
            mother.add(upMother);
            model.nodeChanged(mother);
            SwingUtilities.updateComponentTreeUI(mainPage);
        }
        if(e.getSource()==ekleB&&(cbAkraba.getSelectedIndex()==2)) {//Relative field "babası" case
            emptyBoxChecker();
            DefaultTreeModel model=(DefaultTreeModel) famT.getModel();
            DefaultMutableTreeNode upFather=new DefaultMutableTreeNode(tfIsim.getText()+" "+
                    tfSoyisim.getText());//up father= updated father name.
            father.add(upFather);
            model.nodeChanged(upFather);
            SwingUtilities.updateComponentTreeUI(mainPage);
        }
        if(e.getSource()==ekleB&&(cbAkraba.getSelectedIndex()==3)) {//Relative field "çocuğu" case
            emptyBoxChecker();
            DefaultTreeModel model=(DefaultTreeModel) famT.getModel();
            DefaultMutableTreeNode upChild=new DefaultMutableTreeNode(tfIsim.getText()+" "+
                    tfSoyisim.getText());//up child= updated children name.
            children.add(upChild);
            model.nodeChanged(children);
            SwingUtilities.updateComponentTreeUI(mainPage);
        }
        if(e.getSource()==ekleB&&(cbAkraba.getSelectedIndex()==4)) {//Relative field "Eşi" case
            emptyBoxChecker();
            DefaultTreeModel model=(DefaultTreeModel) famT.getModel();
            DefaultMutableTreeNode upSpouse=new DefaultMutableTreeNode(tfIsim.getText()+" "+
                    tfSoyisim.getText());//up father= updated father name.
            spouse.add(upSpouse);
            model.nodeChanged(upSpouse);
            SwingUtilities.updateComponentTreeUI(mainPage);
        }
    }

    public void emptyBoxChecker() {//A method to check if the following boxes are empty or not in person addition.
        if(tfIsim.getText().equals("")) {//Isim box is empty case
            JOptionPane nameErr=new JOptionPane();
            nameErr.showMessageDialog(null,"Ad eklenmedi. ");
            throw new StringIndexOutOfBoundsException("uyarı ");
        }
        else if(tfSoyisim.getText().equals("")) {// Soyisim box is empty case
            JOptionPane surnameErr=new JOptionPane();
            surnameErr.showMessageDialog(null,"Soyad eklenmedi. ");
            throw new StringIndexOutOfBoundsException("uyarı ");
        }
        else if(tfID.getText().equals("")) {
            JOptionPane IDErr=new JOptionPane();
            IDErr.showMessageDialog(null,"ID eklenmedi ");
            throw new StringIndexOutOfBoundsException("uyarı ");
        }
        else {
            JOptionPane added=new JOptionPane();
            added.showMessageDialog(null,"Kişi eklenmiştir.");
        }
    }


    public static void main(String[]args) {

        new TreeUI();

    }

}