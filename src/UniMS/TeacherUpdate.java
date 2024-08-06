package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class TeacherUpdate extends JFrame implements ActionListener {

    JLabel slname;
    JTextField phonef,Emailf,address,dept;
    JButton Update,Back;
    Choice name;
    JComboBox quili;


    public TeacherUpdate(){
        setBounds(250,30,800,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel search =new JLabel("Select Faculty Name:");
        search.setBounds(80,85,160,20);
        search.setFont(new Font("serif",Font.BOLD,15));
        add(search);

        name = new Choice();
        name.setBounds(240,87,100,40);
        name.add("");
        add(name);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from teacher");
            while(rs.next()) {
                name.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel heading = new JLabel("Update Faculty Details");
        heading.setBounds(290,20,300,50);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel sname = new JLabel("Faculty name:");
        sname.setBounds(130,130,160,20);
        sname.setFont(new Font("serif",Font.BOLD,15));
        add(sname);

        slname = new JLabel();
        slname.setBounds(235,130,100,20);
        add(slname);

        JLabel fname = new JLabel("Father's name:");
        fname.setBounds(450,130,220,20);
        fname.setFont(new Font("serif",Font.BOLD,15));
        add(fname);

        JLabel flname = new JLabel();
        flname.setBounds(565,130,220,20);
        add(flname);

        JLabel eid = new JLabel("Employ ID:");
        eid.setBounds(130,190,220,20);
        eid.setFont(new Font("serif",Font.BOLD,15));
        add(eid);

        JLabel id = new JLabel();
        id.setBounds(235,190,220,20);
        id.setFont(new Font("serif",Font.BOLD,15));
        add(id);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(450,190,220,20);
        dob.setFont(new Font("serif",Font.BOLD,15));
        add(dob);

        JLabel ldob = new JLabel();
        ldob.setBounds(450,190,220,20);
        ldob.setFont(new Font("serif",Font.BOLD,15));
        add(ldob);

        JLabel add = new JLabel("Address:");
        add.setBounds(130,250,160,20);
        add.setFont(new Font("serif",Font.BOLD,15));
        add(add);

        address =new JTextField();
        address.setBounds(235,250,100,20);
        add(address);

        JLabel phone = new JLabel("Phone No.:");
        phone.setBounds(450,250,220,20);
        phone.setFont(new Font("serif",Font.BOLD,15));
        add(phone);

        phonef =new JTextField();
        phonef.setBounds(570,250,100,20);
        add(phonef);

        JLabel Email = new JLabel("Email:");
        Email.setBounds(130,310,160,20);
        Email.setFont(new Font("serif",Font.BOLD,15));
        add(Email);

        Emailf =new JTextField();
        Emailf.setBounds(235,310,100,20);
        add(Emailf);

        JLabel classx = new JLabel("Class X %:");
        classx.setBounds(450,310,220,20);
        classx.setFont(new Font("serif",Font.BOLD,15));
        add(classx);

        JLabel classxf =new JLabel();
        classxf.setBounds(570,310,100,20);
        add(classxf);

        JLabel Classxii = new JLabel("Class XII %:");
        Classxii.setBounds(130,370,160,20);
        Classxii.setFont(new Font("serif",Font.BOLD,15));
        add(Classxii);

        JLabel classxiif =new JLabel();
        classxiif.setBounds(235,370,100,20);
        add(classxiif);

        JLabel Ad = new JLabel("Aadhar Number:");
        Ad.setBounds(450,370,220,20);
        Ad.setFont(new Font("serif",Font.BOLD,15));
        add(Ad);

        JLabel adf =new JLabel();
        adf.setBounds(570,370,100,20);
        add(adf);

        JLabel qui =new JLabel("Qualification:");
        qui.setBounds(130,430,160,20);
        qui.setFont(new Font("serif",Font.BOLD,15));
        add(qui);

        String crse[]={"","BTech","MTech","BBA","Bsc","Msc","Bca","Mca","Bcom","Mcom","BA","MA"};
        quili =new JComboBox(crse);
        quili.setBackground(Color.white);
        quili.setBounds(235,430,100,20);
        add(quili);

        JLabel dep =new JLabel("Department:");
        dep.setBounds(450,430,160,20);
        dep.setFont(new Font("serif",Font.BOLD,15));
        add(dep);

        dept = new JTextField();
        dept.setBackground(Color.white);
        dept.setBounds(570, 430, 100, 20);
        add(dept);

        Update = new JButton("Update");
        Update.setBounds(260,530,100,25);
        Update.setBackground(new Color(0x0E90BA));   // Using color helper
        Update.setForeground(Color.white);
        Update.addActionListener(this);
        add(Update);

        Back = new JButton("Back");
        Back.setBounds(460,530,100,25);
        Back.setBackground(new Color(0x0E90BA));   // Using color helper
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        try{
            Connectionmysql obj = new Connectionmysql();
            String query="select * from teacher where name ='"+name.getSelectedItem()+"'";
            ResultSet rs = obj.statement.executeQuery(query);
            while (rs.next()){
                slname.setText(rs.getString("Name"));
                flname.setText(rs.getString("Fathers_name"));
                id.setText(rs.getString("ID"));
                dob.setText(rs.getString("DOB"));
                address.setText(rs.getString("Address"));
                phonef.setText(rs.getString("Phone"));
                Emailf.setText(rs.getString("Email"));
                classxf.setText(rs.getString("Class_X"));
                classxiif.setText(rs.getString("Class_XII"));
                adf.setText(rs.getString("Aadhar_Number"));
                quili.setSelectedItem(rs.getString("Qualification"));
                dept.setText(rs.getString("Department"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Connectionmysql obj = new Connectionmysql();
                    String query="select * from teacher where name ='"+name.getSelectedItem()+"'";
                    ResultSet rs = obj.statement.executeQuery(query);
                    while (rs.next()){
                        slname.setText(rs.getString("Name"));
                        flname.setText(rs.getString("Fathers_name"));
                        id.setText(rs.getString("ID"));
                        dob.setText(rs.getString("DOB"));
                        address.setText(rs.getString("Address"));
                        phonef.setText(rs.getString("Phone"));
                        Emailf.setText(rs.getString("Email"));
                        classxf.setText(rs.getString("Class_X"));
                        classxiif.setText(rs.getString("Class_XII"));
                        adf.setText(rs.getString("Aadhar_Number"));
                        quili.setSelectedItem(rs.getString("Qualification"));
                        dept.setText(rs.getString("Department"));
                    }
                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(Update);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TeacherUpdate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Update){
            String name=slname.getText();
            String addrss=address.getText();
            String phone=phonef.getText();
            String email=Emailf.getText();
            String qualification=(String) quili.getSelectedItem();
            String department=dept.getText();

            if (phone.isEmpty() || !phone.matches("\\d+") ||
                    qualification.isEmpty() || department.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter All Details.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (email.isEmpty() || !email.contains("@")) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Email.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                String query ="update teacher set Address ='"+addrss+"',Phone='"+phone+"',Email='"+email+"',Qualification='"+qualification+"',Department='"+department+"' where name='"+name+"'";

                Connectionmysql obj = new Connectionmysql();
                obj.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Updated Successfully!");
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
