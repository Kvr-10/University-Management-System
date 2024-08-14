package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class FeeForm extends JFrame implements ActionListener {
    JButton ShowPay,UpdateD,MakeP;
    Choice name,sem;
    JLabel Roll,Branch,Fname,Course,Totalpay;
    public FeeForm(){
        setBounds(350,70,700,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/feepaid.jpg"));
        Image i2= i1.getImage().getScaledInstance(350,350,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(380,70,250,250);
        add(image);

        JLabel heading = new JLabel("Fee-Form");
        heading.setBounds(310,20,200,20);
        heading.setFont(new Font("Serif",Font.BOLD,20));
        add(heading);

        JLabel head1 = new JLabel("Search By Name:");
        head1.setBounds(40,60,130,20);
        head1.setFont(new Font("Serif",Font.BOLD,15));
        add(head1);

        name = new Choice();
        name.setBounds(170,60,105,20);
        name.add("");
        add(name);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select*from student");
            while (rs.next()){
                name.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateuser();
            }
        });

        JLabel Rolll = new JLabel("PRN:");
        Rolll.setBounds(60,100,100,20);
        Rolll.setFont(new Font("serif",Font.BOLD,15));
        add(Rolll);

        Roll = new JLabel();
        Roll.setBounds(110,100,100,20);
        Roll.setFont(new Font("serif",Font.BOLD,15));
        add(Roll);

        JLabel Flname = new JLabel("Father's Name:");
        Flname.setBounds(60,130,130,20);
        Flname.setFont(new Font("serif",Font.BOLD,15));
        add(Flname);

        Fname = new JLabel();
        Fname.setBounds(175,130,180,20);
        Fname.setFont(new Font("serif",Font.BOLD,15));
        add(Fname);

        JLabel Cour = new JLabel("Course:");
        Cour.setBounds(60,160,100,20);
        Cour.setFont(new Font("serif",Font.BOLD,15));
        add(Cour);

        Course = new JLabel();
        Course.setBounds(125,160,100,20);
        Course.setFont(new Font("serif",Font.BOLD,15));
        add(Course);

        JLabel Branc = new JLabel("Branch:");
        Branc.setBounds(60,190,100,20);
        Branc.setFont(new Font("serif",Font.BOLD,15));
        add(Branc);

        Branch = new JLabel();
        Branch.setBounds(125,190,200,20);
        Branch.setFont(new Font("serif",Font.BOLD,15));
        add(Branch);

        JLabel seml = new JLabel("Semester:");
        seml.setBounds(60,220,70,20);
        seml.setFont(new Font("serif",Font.BOLD,15));
        add(seml);

        sem = new Choice();
        sem.setBounds(136,220,110,20);
        sem.add("");
        add(sem);

        try {
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select* from fee");
            while (rs.next()) {
                sem.add(rs.getString("Semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Totalp = new JLabel("Total Payment:");
        Totalp.setBounds(40,280,150,20);
        Totalp.setFont(new Font("serif",Font.BOLD,15));
        add(Totalp);

        Totalpay = new JLabel();
        Totalpay.setBounds(150,280,150,20);
        Totalpay.setFont(new Font("serif",Font.BOLD,15));
        add(Totalpay);

        ShowPay = new JButton("Show Amount");
        ShowPay.setBounds(80,360,120,25);
        ShowPay.addActionListener(this);
        ShowPay.setBackground(Color.gray);
        ShowPay.setForeground(Color.WHITE);
        add(ShowPay);

        MakeP = new JButton("Make Payment");
        MakeP.setBounds(220,360,120,25);
        MakeP.setBackground(Color.gray);
        MakeP.setForeground(Color.white);
        MakeP.addActionListener(this);
        add(MakeP);

        UpdateD = new JButton("Update Details");
        UpdateD.setBounds(360,360,120,25);
        UpdateD.setBackground(Color.gray);
        UpdateD.setForeground(Color.white);
        UpdateD.addActionListener(this);
        add(UpdateD);

        JButton Back = new JButton("Back");
        Back.setBounds(500,360,100,25);
        Back.setBackground(Color.gray);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(ShowPay);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeForm();
    }
    private void setPay(){
        String course=Course.getText();
        String Sem =sem.getSelectedItem();

        if (course.isEmpty()||Sem.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Select Name and Semester!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }

//        System.out.println(course);
//        System.out.println(Sem);
        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select "+course+" as payment from fee where Semester='"+Sem+"'");
            while (rs.next()){
                int amount = rs.getInt("payment");
                Totalpay.setText(String.valueOf(amount));
            }
        }catch (Exception ae){
            JOptionPane.showMessageDialog(null,"Check Course Name!","Warning",JOptionPane.WARNING_MESSAGE);
            ae.printStackTrace();
        }
    }

    private void updateuser(){
        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select * from student where name='"+name.getSelectedItem()+"'");
            while (rs.next()){
                Roll.setText(rs.getString("Roll_No"));
                Fname.setText(rs.getString("Fathers_Name"));
                Course.setText(rs.getString("Course"));
                Branch.setText(rs.getString("Branch"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ShowPay){
                setPay();
        } else if (e.getSource()==UpdateD) {
            setVisible(false);
            new StdUpdate();
        }else if (e.getSource()==MakeP) {
            String N = name.getSelectedItem();
            String roll = Roll.getText();
            String branc = Branch.getText();
            String c = Course.getText();
            String Sem = sem.getSelectedItem();
            String  total =Totalpay.getText();

            if(N.isEmpty() || roll.isEmpty() || branc.isEmpty() || c.isEmpty()|| Sem.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Select Name and Semester!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (total.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Check the Amount to be paid!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }

            try{
                Connectionmysql obj = new Connectionmysql();
                obj.statement.executeUpdate("insert into feepaid values('"+N+"','"+roll+"','"+c+"','"+branc+"','"+Sem+"','"+total+"')");
                JOptionPane.showMessageDialog(null,"Fees Paid Successfully!");
            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,"Error.Try Again!","Warning",JOptionPane.WARNING_MESSAGE);
                ae.printStackTrace();
            }
        }else {
            setVisible(false);
            new MainPage();
        }
    }
}
