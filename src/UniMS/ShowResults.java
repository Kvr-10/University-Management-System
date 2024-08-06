package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ShowResults extends JFrame implements ActionListener {
    String roll,name;
    JButton Home;
    public ShowResults(String roll){
        this.roll=roll;

        setBounds(400,60,500,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

//        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/result.jpg"));
//        Image i2= i1.getImage().getScaledInstance(500,600,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image= new JLabel(i3);
//        image.setBounds(0,0,500,600);
//        add(image);

        JLabel heading = new JLabel("Kaiju's University");
        heading.setBounds(145,20,250,30);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel sheading = new JLabel("Result of Examination 2024");
        sheading.setBounds(135,70,250,20);
        sheading.setFont(new Font("serif",Font.BOLD,18));
        add(sheading);

        JLabel lroll = new JLabel("PRN:  "+ roll);
        lroll.setBounds(50,110,150,20);
        lroll.setFont(new Font("serif",Font.PLAIN,15));
        add(lroll);

        JLabel lname = new JLabel("Name:  ");
        lname.setBounds(50,133,150,20);
        lname.setFont(new Font("serif",Font.PLAIN,15));
        add(lname);

        JLabel name = new JLabel();
        name.setBounds(100,133,150,20);
        name.setFont(new Font("serif",Font.PLAIN,15));
        add(name);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select* from student where Roll_No = '"+roll+"'");
            while (rs.next()){
                name.setText(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lsem = new JLabel("Semester: ");
        lsem.setBounds(50,155,100,20);
        lsem.setFont(new Font("serif",Font.PLAIN,15));
        add(lsem);

        JLabel sem = new JLabel();
        sem.setBounds(120,155,100,20);
        sem.setFont(new Font("serif",Font.PLAIN,15));
        add(sem);

        JLabel subject = new JLabel("Subject");
        subject.setBounds(160,220,250,20);
        subject.setFont(new Font("serif",Font.BOLD,15));
        add(subject);

        JLabel sub1 = new JLabel();
        sub1.setBounds(170,250,250,20);
        sub1.setFont(new Font("serif",Font.PLAIN,15));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(170,280,250,20);
        sub2.setFont(new Font("serif",Font.PLAIN,15));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(170,310,250,20);
        sub3.setFont(new Font("serif",Font.PLAIN,15));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(170,340,250,20);
        sub4.setFont(new Font("serif",Font.PLAIN,15));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(170,370,250,20);
        sub5.setFont(new Font("serif",Font.PLAIN,15));
        add(sub5);

        JLabel marks = new JLabel("Marks");
        marks.setBounds(270,220,250,20);
        marks.setFont(new Font("serif",Font.BOLD,15));
        add(marks);

        JLabel m1 = new JLabel();
        m1.setBounds(280,250,250,20);
        m1.setFont(new Font("serif",Font.PLAIN,15));
        add( m1);

        JLabel m2 = new JLabel();
        m2 .setBounds(280,280,250,20);
        m2 .setFont(new Font("serif",Font.PLAIN,15));
        add(m2 );

        JLabel m3  = new JLabel();
        m3.setBounds(280,310,250,20);
        m3.setFont(new Font("serif",Font.PLAIN,15));
        add(m3);

        JLabel m4 = new JLabel();
        m4.setBounds(280,340,250,20);
        m4.setFont(new Font("serif",Font.PLAIN,15));
        add(m4);

        JLabel m5 = new JLabel();
        m5.setBounds(280,370,250,20);
        m5.setFont(new Font("serif",Font.PLAIN,15));
        add(m5);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs1 =obj.statement.executeQuery("select*from subject where Roll_No = '"+roll+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("1st_Subject"));
                sub2.setText(rs1.getString("2nd_Subject"));
                sub3.setText(rs1.getString("3rd_Subject"));
                sub4.setText(rs1.getString("4th_Subject"));
                sub5.setText(rs1.getString("5th_Subject"));
                sem.setText(rs1.getString("Semester"));
            }
            ResultSet rs2 =obj.statement.executeQuery("select*from marks where Roll_No = '"+roll+"'");
            while(rs2.next()){
                m1.setText(rs2.getString("1st_Sub_Marks"));
                m2.setText(rs2.getString("2nd_Sub_Marks"));
                m3.setText(rs2.getString("3rd_Sub_Marks"));
                m4.setText(rs2.getString("4th_Sub_Marks"));
                m5.setText(rs2.getString("5th_Sub_Marks"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error.Try Again","Warning",JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }

        Home = new JButton("Home");
        Home.setBounds(185,430,100,20);
        Home.setBackground(new Color(0x0E90BA));   // Using color helper
        Home.setForeground(Color.white);
        Home.addActionListener(this);
        add(Home);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(Home);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ShowResults("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Home){
            setVisible(false);
            new MainPage();
        }
    }
}
