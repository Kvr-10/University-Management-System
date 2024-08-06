package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
        Choice name;
        JLabel laroll;
        JComboBox csem;
        JTextField tsub1,tsub2,tsub3,tsub4,tsub5,tmarks1,tmarks2,tmarks3,tmarks4,tmarks5;
        JButton Submit,Back;
    public EnterMarks(){
        setBounds(250,70,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/exam.png"));
        Image i2 = i1.getImage().getScaledInstance(350,350,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(340,-20,500,600);
        add(image);

        JLabel heading = new JLabel("Submit Student Scores");
        heading.setBounds(290,20,300,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel search =new JLabel("Select Student Name:");
        search.setBounds(70,85,160,20);
        search.setFont(new Font("serif",Font.BOLD,15));
        add(search);

        name = new Choice();
        name.setBounds(230,87,110,40);
        name.add("");
        add(name);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from student");
            while(rs.next()) {
                name.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lroll =new JLabel("PRN:");
        lroll.setBounds(80,115,160,20);
        lroll.setFont(new Font("serif",Font.BOLD,15));
        add(lroll);

        laroll =new JLabel();
        laroll.setBounds(130,115,160,20);
        laroll.setFont(new Font("serif",Font.BOLD,15));
        add(laroll);

        JLabel  lcourse=new JLabel("Course:");
        lcourse.setBounds(80,145,160,20);
        lcourse.setFont(new Font("serif",Font.BOLD,15));
        add(lcourse);

        JLabel  lacourse=new JLabel();
        lacourse.setBounds(150,145,160,20);
        lcourse.setFont(new Font("serif",Font.BOLD,15));
        add(lacourse);

        JLabel lbranch =new JLabel("Branch:");
        lbranch.setBounds(80,175,160,20);
        lbranch.setFont(new Font("serif",Font.BOLD,15));
        add(lbranch);

        JLabel labranch =new JLabel();
        labranch.setBounds(150,175,300,20);
        labranch.setFont(new Font("serif",Font.BOLD,15));
        add(labranch);

        try{
            Connectionmysql obj = new Connectionmysql();
            String query="select * from student where name ='"+name.getSelectedItem()+"'";
            ResultSet rs = obj.statement.executeQuery(query);
            while (rs.next()){
                laroll.setText(rs.getString("Roll_No"));
                lacourse.setText(rs.getString("Course"));
                labranch.setText(rs.getString("Branch"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Connectionmysql obj = new Connectionmysql();
                    String query="select * from student where name ='"+name.getSelectedItem()+"'";
                    ResultSet rs = obj.statement.executeQuery(query);
                    while (rs.next()){
                        laroll.setText(rs.getString("Roll_No"));
                        lacourse.setText(rs.getString("Course"));
                        labranch.setText(rs.getString("Branch"));
                    }
                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        JLabel lsemester =new JLabel("Select Semester:");
        lsemester.setBounds(80,205,160,20);
        lsemester.setFont(new Font("serif",Font.BOLD,15));
        add(lsemester);

        String Sem[] ={"","1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        csem = new JComboBox(Sem);
        csem.setBounds(210,205,120,20);
        csem.setFont(new Font("serif",Font.BOLD,15));
        csem.setBackground(Color.white);
        add(csem);

        JLabel lsubject =new JLabel("Subject");
        lsubject.setBounds(100,255,160,20);
        lsubject.setFont(new Font("serif",Font.BOLD,15));
        add(lsubject);

        JLabel lmarks =new JLabel("Marks Obtained");
        lmarks.setBounds(240,255,160,20);
        lmarks.setFont(new Font("serif",Font.BOLD,15));
        add(lmarks);

//        JLabel arr1 = new JLabel("->");
//        arr1.setBounds(200,285,160,20);
//        arr1.setFont(new Font("serif",Font.BOLD,20));
//        add(arr1);

        tsub1 = new JTextField();
        tsub1.setBounds(60,285,130,20);
        tsub1.setFont(new Font("serif",Font.BOLD,15));
        add(tsub1);

        tsub2 = new JTextField();
        tsub2.setBounds(60,310,130,20);
        tsub2.setFont(new Font("serif",Font.BOLD,15));
        add(tsub2);

        tsub3 = new JTextField();
        tsub3.setBounds(60,335,130,20);
        tsub3.setFont(new Font("serif",Font.BOLD,15));
        add(tsub3);

        tsub4 = new JTextField();
        tsub4.setBounds(60,360,130,20);
        tsub4.setFont(new Font("serif",Font.BOLD,15));
        add(tsub4);

        tsub5 = new JTextField();
        tsub5.setBounds(60,385,130,20);
        tsub5.setFont(new Font("serif",Font.BOLD,15));
        add(tsub5);

        tmarks1 = new JTextField();
        tmarks1.setBounds(230,285,130,20);
        tmarks1.setFont(new Font("serif",Font.BOLD,15));
        add(tmarks1);

        tmarks2 = new JTextField();
        tmarks2.setBounds(230,310,130,20);
        tmarks2.setFont(new Font("serif",Font.BOLD,15));
        add(tmarks2);

        tmarks3 = new JTextField();
        tmarks3.setBounds(230,335,130,20);
        tmarks3.setFont(new Font("serif",Font.BOLD,15));
        add(tmarks3);

        tmarks4 = new JTextField();
        tmarks4.setBounds(230,360,130,20);
        tmarks4.setFont(new Font("serif",Font.BOLD,15));
        add(tmarks4);

        tmarks5 = new JTextField();
        tmarks5.setBounds(230,385,130,20);
        tmarks5.setFont(new Font("serif",Font.BOLD,15));
        add(tmarks5);

        Submit = new JButton("Submit");
        Submit.setBounds(90,460,100,25);
        Submit.setBackground(new Color(0x0E90BA));   // Using color helper
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        Back = new JButton("Back");
        Back.setBounds(230,460,100,25);
        Back.setBackground(new Color(0x0E90BA));   // Using color helper
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(Submit);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==Submit){
            String Name =name.getSelectedItem();
            String Roll =laroll.getText();
            String Semester =(String) (csem.getSelectedItem());
            String sub1 =tsub1.getText();
            String marks1 =tmarks1.getText();
            String sub2 =tsub2.getText();
            String marks2 =tmarks2.getText();
            String sub3 =tsub3.getText();
            String marks3 =tmarks3.getText();
            String sub4 =tsub4.getText();
            String marks4 =tmarks4.getText();
            String sub5 =tsub5.getText();
            String marks5 =tmarks5.getText();

            if(Name.isEmpty() || Roll.isEmpty() || Semester.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please choose Name and Semester!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (sub1.isEmpty() && marks1.isEmpty() && sub2.isEmpty() && marks2.isEmpty() && sub3.isEmpty() && marks3.isEmpty() && sub4.isEmpty() && marks4.isEmpty() && sub5.isEmpty() && marks5.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Subject-Name and Marks of atleast one Subject","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (sub1.isEmpty() || marks1.isEmpty()){
                tsub1.setText("-");
                tmarks1.setText("0");
            }
            if(sub2.isEmpty() || marks2.isEmpty()){
                tsub2.setText("-");
                tmarks2.setText("0");
            }
            if (sub3.isEmpty() || marks3.isEmpty()) {
                tsub3.setText("-");
                tmarks3.setText("0");
            }
            if (sub4.isEmpty() || marks4.isEmpty()) {
                tsub4.setText("-");
                tmarks4.setText("0");
            }
            if (sub5.isEmpty() || marks5.isEmpty()) {
                tsub5.setText("-");
                tmarks5.setText("0");
            }

            try{
                String query1= "insert into subject values('"+Name+"','"+Roll+"', '"+Semester+"', '"+tsub1.getText()+"', '"+tsub2.getText()+"', '"+tsub3.getText()+"', '"+tsub4.getText()+"', '"+tsub5.getText()+"')";
                String query2= "insert into marks values('"+Name+"','"+Roll+"', '"+Semester+"', '"+tmarks1.getText()+"', '"+tmarks2.getText()+"', '"+tmarks3.getText()+"', '"+tmarks4.getText()+"', '"+tmarks5.getText()+"')";

                Connectionmysql obj = new Connectionmysql();
                obj.statement.executeUpdate(query1);
                obj.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Marks entered Successfully!");

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Error. Please Retry !!","Warning",JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
            new MainPage();
        }
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}
