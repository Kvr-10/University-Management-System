package UniMS;

import com.mysql.cj.xdevapi.Table;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Teacherleave extends JFrame implements ActionListener {
    Choice name,duration;
    JDateChooser date;
    JCheckBox check;
    JTable table;
    JButton submit,back;
    public Teacherleave(){
        setBounds(400,40,500,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel head=new JLabel("Faculty Leave");
        head.setBounds(180,40,160,20);
        head.setFont(new Font("serif",Font.BOLD,20));
        add(head);

        JLabel search =new JLabel("Select Teacher Name:");
        search.setBounds(20,85,160,20);
        search.setFont(new Font("serif",Font.BOLD,15));
        add(search);

        name = new Choice();
        name.setBounds(190,87,100,40);
        name.add("");
        add(name);
        name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updatetable();
            }
        });

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("Select*from teacher");
            while(rs.next()) {
                name.add(rs.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select Name,Id from teacher where Name='"+name.getSelectedItem()+"'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(140,120,200,39);
        add(pane);

        JLabel dd =new JLabel("Date:");
        dd.setBounds(20,175,100,20);
        dd.setFont(new Font("serif",Font.BOLD,15));
        add(dd);

        date =new JDateChooser();
        date.setBounds(80,177,100,20);
        add(date);

        JLabel durat =new JLabel("Duration:");
        durat.setBounds(20,225,80,20);
        durat.setFont(new Font("serif",Font.BOLD,15));
        add(durat);

        duration = new Choice();
        duration.setBounds(110,227,100,20);
        duration.add("");
        duration.add("Half Day");
        duration.add("Full Day");
        add(duration);

        check = new JCheckBox("I hereby acknowledge to complete all my work within a week.");
        check.setBackground(Color.white);
        check.setBounds(50,315,400,20);
        add(check);

        submit = new JButton("Submit");
        submit.setBounds(120,440,100,25);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.gray);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(250,440,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.gray);
        back.addActionListener(this);
        add(back);

        getRootPane().setDefaultButton(submit);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Teacherleave();
    }

    private void updatetable(){
        try{
        Connectionmysql obj = new Connectionmysql();
        ResultSet rs = obj.statement.executeQuery("select Name,ID from teacher where Name='"+name.getSelectedItem()+"'");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
        e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String Name = name.getSelectedItem();
            String Date = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            String Duration = duration.getSelectedItem();

            if(Name.isEmpty() || Date.isEmpty() || Duration.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Select All Details.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(!check.isSelected()){
                JOptionPane.showMessageDialog(null, "You must agree to complete all work within a week.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }

            try{
                String query = "insert into teacherleave values('"+Name+"','"+Date+"','"+Duration+"')";
                Connectionmysql obj = new Connectionmysql();
                obj.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Applied!");
                setVisible(false);
                new MainPage();
            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,"Error. try Again!","Warning",JOptionPane.WARNING_MESSAGE);
                ae.printStackTrace();
            }
        }else {
            setVisible(false);
            new MainPage();
        }
    }
}
