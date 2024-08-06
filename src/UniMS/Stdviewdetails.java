package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Stdviewdetails extends JFrame implements ActionListener {
    JTable table;
    Choice prn,name;
    JButton searchP,searchN,add,update,print,Exit;
    public Stdviewdetails(){
        getContentPane().setBackground(Color.white);
        setBounds(40,10,1200,700);
        setLayout(null);

        JLabel heading = new JLabel("Student Details");
        heading.setBounds(530,25,140,20);
        heading.setFont(new Font("Serif",Font.BOLD,20));
        add(heading);

        JLabel head = new JLabel("Search By PRN:");
        head.setBounds(20,60,140,20);
        head.setFont(new Font("Serif",Font.BOLD,15));
        add(head);

        JLabel head1 = new JLabel("Search By Name:");
        head1.setBounds(400,60,140,20);
        head1.setFont(new Font("Serif",Font.BOLD,15));
        add(head1);

        searchP = new JButton("Search By PRN");
        searchP.setBounds(20,100,130,25);
        searchP.setForeground(Color.WHITE);
        searchP.setBackground(Color.gray);
        searchP.addActionListener(this);
        add(searchP);

        searchN = new JButton("Search By Name");
        searchN.setBounds(160,100,140,25);
        searchN.setForeground(Color.WHITE);
        searchN.setBackground(Color.gray);
        searchN.addActionListener(this);
        add(searchN);

        print = new JButton("Print");
        print.setBounds(560,100,100,25);
        print.setForeground(Color.WHITE);
        print.setBackground(Color.gray);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add Student");
        add.setBounds(310,100,110,25);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.gray);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update Details");
        update.setBounds(430,100,120,25);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.gray);
        update.addActionListener(this);
        add(update);

        Exit = new JButton("Exit");
        Exit.setBounds(670,100,100,25);
        Exit.setForeground(Color.WHITE);
        Exit.setBackground(Color.gray);
        Exit.addActionListener(this);
        add(Exit);

        prn =new Choice();
        prn.setBounds(165,60,105,20);
        prn.add("");
        add(prn);

        name =new Choice();
        name.setBounds(550,60,105,20);
        name.add("");
        add(name);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from student");
            while (rs.next()){
                prn.add(rs.getString("Roll_No"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from student");
            while (rs.next()){
                name.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20,150,1150,500);
        add(pane);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(searchN);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchP) {
            String roll = prn.getSelectedItem();
            if (roll.isEmpty()){
                JOptionPane.showMessageDialog(null,"Select Student's PRN!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String query = "select *from student where Roll_No = '" + roll + "'";
            try {
                Connectionmysql obj = new Connectionmysql();
                ResultSet rs = obj.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == searchN) {
            String nam=name.getSelectedItem();
            if (nam.isEmpty()){
                JOptionPane.showMessageDialog(null,"Select Student's Name!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String query = "select *from student where Name = '" + nam + "'";
            try {
                Connectionmysql obj = new Connectionmysql();
                ResultSet rs = obj.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception er) {
                er.printStackTrace();
            }
        } else if (e.getSource() == add) {
            new AddStudent();
            setVisible(false);
        } else if (e.getSource() == update){
            new StdUpdate();
            setVisible(false);
        } else if (e.getSource() == Exit) {
            setVisible(false);
            new MainPage();
        }
    }
    public static void main(String [] args){
        new Stdviewdetails();
    }
}
