package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Teacherviewdetails extends JFrame implements ActionListener {
    JTable table;
    Choice id,name;
    JButton searchP,searchN,add,update,print,Exit;
    public Teacherviewdetails(){
        getContentPane().setBackground(Color.white);
        setBounds(40,10,1200,700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Faculty Details");
        heading.setBounds(530,25,140,20);
        heading.setFont(new Font("Serif",Font.BOLD,20));
        add(heading);

        JLabel head = new JLabel("Search By ID:");
        head.setBounds(20,60,100,20);
        head.setFont(new Font("Serif",Font.BOLD,15));
        add(head);

        JLabel head1 = new JLabel("Search By Name:");
        head1.setBounds(400,60,140,20);
        head1.setFont(new Font("Serif",Font.BOLD,15));
        add(head1);

        searchP = new JButton("Search By ID");
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

        add = new JButton("Add Faculty");
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

        id =new Choice();
        id.setBounds(145,60,105,20);
        id.add("");
        add(id);

        name =new Choice();
        name.setBounds(550,60,105,20);
        name.add("");
        add(name);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from teacher");
            while (rs.next()){
                id.add(rs.getString("ID"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from teacher");
            while (rs.next()){
                name.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20,150,1150,500);
        add(pane);

        getRootPane().setDefaultButton(searchN);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchP) {
            String ID = id.getSelectedItem();
            if (ID.isEmpty()){
                JOptionPane.showMessageDialog(null,"Select Teacher's ID!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String query = "select *from teacher where ID = '" +ID + "'";
            try {
                Connectionmysql obj = new Connectionmysql();
                ResultSet rs = obj.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else if (e.getSource() == searchN) {
            String nam = name.getSelectedItem();
            if (nam.isEmpty()){
                JOptionPane.showMessageDialog(null,"Select Teacher's Name!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String query = "select *from teacher where Name = '" + nam + "'";
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
            new AddTeacher();
            setVisible(false);
        } else if (e.getSource() == update){
            new TeacherUpdate();
            setVisible(false);
        } else if (e.getSource() == Exit) {
            setVisible(false);
            new MainPage();
        }
    }
    public static void main(String [] args){
        new Teacherviewdetails();
    }
}
