package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Teacherleavedetails extends JFrame implements ActionListener {
    JTable table;
    Choice name;
    JButton searchN,print,Exit;
    public Teacherleavedetails(){
        getContentPane().setBackground(Color.white);
        setBounds(250,160,800,500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Faculty Leave Details");
        heading.setBounds(310,20,200,20);
        heading.setFont(new Font("Serif",Font.BOLD,20));
        add(heading);

        JLabel head1 = new JLabel("Search By Name:");
        head1.setBounds(40,60,140,20);
        head1.setFont(new Font("Serif",Font.BOLD,15));
        add(head1);

        searchN = new JButton("Search By Name");
        searchN.setBounds(20,100,140,25);
        searchN.setForeground(Color.WHITE);
        searchN.setBackground(Color.gray);
        searchN.addActionListener(this);
        add(searchN);

        print = new JButton("Print");
        print.setBounds(180,100,100,25);
        print.setForeground(Color.WHITE);
        print.setBackground(Color.gray);
        print.addActionListener(this);
        add(print);


        Exit = new JButton("Exit");
        Exit.setBounds(300,100,100,25);
        Exit.setForeground(Color.WHITE);
        Exit.setBackground(Color.gray);
        Exit.addActionListener(this);
        add(Exit);

        name =new Choice();
        name.setBounds(180,60,105,20);
        name.add("");
        add(name);

        try{
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
            ResultSet rs = obj.statement.executeQuery("Select*from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(45,150,700,300);
        add(pane);

        getRootPane().setDefaultButton(searchN);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchN) {
            String nam= name.getSelectedItem();
            if (nam.isEmpty()){
                JOptionPane.showMessageDialog(null,"Select Teacher's Name!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String query = "select *from teacherleave where Name = '" + nam + "'";
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
        } else if (e.getSource() == Exit) {
            setVisible(false);
            new MainPage();
        }
    }
    public static void main(String [] args){
        new Teacherleavedetails();
    }
}
