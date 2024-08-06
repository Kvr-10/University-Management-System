package UniMS;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    JTextField stextf,ftextf,address,phonef,Emailf,classxf,classxiif,adf;
    JLabel prn;
    JDateChooser sdob;
    JButton Submit,Back;
    JComboBox course,branch;

    Random ran = new Random();
    long rnum = Math.abs((ran.nextLong()%9000)+1000L);

    public AddStudent(){
        setBounds(250,30,800,650);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/qwe.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("New Student Information");
        heading.setBounds(290,20,300,50);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel sname = new JLabel("Student name:");
        sname.setBounds(130,100,160,20);
        sname.setFont(new Font("serif",Font.BOLD,15));
        add(sname);

        stextf =new JTextField();
        stextf.setBounds(235,100,100,20);
        add(stextf);

        JLabel fname = new JLabel("Father's name:");
        fname.setBounds(450,100,220,20);
        fname.setFont(new Font("serif",Font.BOLD,15));
        add(fname);

        ftextf =new JTextField();
        ftextf.setBounds(565,100,100,20);
        add(ftextf);

        JLabel Prn = new JLabel("PRN:");
        Prn.setBounds(130,160,220,20);
        Prn.setFont(new Font("serif",Font.BOLD,15));
        add(Prn);

        prn = new JLabel("2024"+rnum);
        prn.setBounds(235,160,220,20);
        prn.setFont(new Font("serif",Font.BOLD,15));
        prn.setForeground(Color.RED);
        add(prn);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(450,160,220,20);
        dob.setFont(new Font("serif",Font.BOLD,15));
        add(dob);

        sdob = new JDateChooser();
        sdob.setBounds(570,160,100,20);
        add(sdob);

        JLabel add = new JLabel("Address:");
        add.setBounds(130,220,160,20);
        add.setFont(new Font("serif",Font.BOLD,15));
        add(add);

        address =new JTextField();
        address.setBounds(235,220,100,20);
        add(address);

        JLabel phone = new JLabel("Phone No.:");
        phone.setBounds(450,220,220,20);
        phone.setFont(new Font("serif",Font.BOLD,15));
        add(phone);

        phonef =new JTextField();
        phonef.setBounds(570,220,100,20);
        add(phonef);

        JLabel Email = new JLabel("Email:");
        Email.setBounds(130,280,160,20);
        Email.setFont(new Font("serif",Font.BOLD,15));
        add(Email);

        Emailf =new JTextField();
        Emailf.setBounds(235,280,100,20);
        add(Emailf);

        JLabel classx = new JLabel("Class X %:");
        classx.setBounds(450,280,220,20);
        classx.setFont(new Font("serif",Font.BOLD,15));
        add(classx);

        classxf =new JTextField();
        classxf.setBounds(570,280,100,20);
        add(classxf);

        JLabel Classxii = new JLabel("Class XII %:");
        Classxii.setBounds(130,340,160,20);
        Classxii.setFont(new Font("serif",Font.BOLD,15));
        add(Classxii);

        classxiif =new JTextField();
        classxiif.setBounds(235,340,100,20);
        add(classxiif);

        JLabel Ad = new JLabel("Aadhar Number:");
        Ad.setBounds(450,340,220,20);
        Ad.setFont(new Font("serif",Font.BOLD,15));
        add(Ad);

        adf =new JTextField();
        adf.setBounds(570,340,100,20);
        add(adf);

        JLabel cour =new JLabel("Course:");
        cour.setBounds(130,400,160,20);
        cour.setFont(new Font("serif",Font.BOLD,15));
        add(cour);

        String crse[]={"","BTech","MTech","BBA","Bsc","Msc","Bca","Mca","Bcom","Mcom","BA","MA"};
        course =new JComboBox(crse);
        course.setBackground(Color.white);
        course.setBounds(235,400,100,20);
        add(course);

        JLabel bran =new JLabel("Branch:");
        bran.setBounds(450,400,160,20);
        bran.setFont(new Font("serif",Font.BOLD,15));
        add(bran);

        String b[] = {"", "Computer Engg", "Computer Science Engg", "Entc", "Mech Engg.", "Ece"};
        branch = new JComboBox(b);
        branch.setBackground(Color.white);
        branch.setBounds(570, 400, 100, 20);
        add(branch);



        Submit = new JButton("Submit");
        Submit.setBounds(260,500,100,25);
        Submit.setBackground(new Color(0x0E90BA));   // Using color helper
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        Back = new JButton("Back");
        Back.setBounds(460,500,100,25);
        Back.setBackground(new Color(0x0E90BA));   // Using color helper
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        add(image);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(Submit);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AddStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Submit){
            String name=stextf.getText();
            String fname=ftextf.getText();
            String rollno=prn.getText();
            String dob=((JTextField) sdob.getDateEditor().getUiComponent()).getText();
            String addrss=address.getText();
            String phone=phonef.getText();
            String email=Emailf.getText();
            String x=classxf.getText();
            String xii=classxiif.getText();
            String adhar=adf.getText();
            String cours=(String)course.getSelectedItem();
            String branc=(String)branch.getSelectedItem();

            if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || addrss.isEmpty() || cours.isEmpty() || branc.isEmpty() || phone.isEmpty() || !phone.matches("\\d+") || x.isEmpty() || !x.matches("\\d+") || xii.isEmpty() || !xii.matches("\\d+") || adhar.isEmpty() || !adhar.matches("\\d+")){ // int in the query (Condition:If nothing is entered)
                JOptionPane.showMessageDialog(null, "Please Enter All Details.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            } else if (email.isEmpty() || !email.contains("@")) {
                JOptionPane.showMessageDialog(null, "Please enter correct Email.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                String query ="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+addrss+"','"+phone+"','"+email+"','"+x+"',+'"+xii+"',+'"+adhar+"','"+cours+"','"+branc+"')";

                        Connectionmysql obj = new Connectionmysql();
                        obj.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Submitted Successfully!");
                setVisible(false);
                new MainPage();

            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,"Error. Please Retry !!","Warning",JOptionPane.WARNING_MESSAGE);
                ae.printStackTrace();
            }


        } else if (e.getSource()==Back) {
            setVisible(false);
            new MainPage();
        }
    }
}
