package UniMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Results extends JFrame implements ActionListener {
    JTextField search;
    JButton Result,Back;
    JTable table;

    public Results(){
        setBounds(250,70,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Results");
        heading.setBounds(350,20,300,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel prn = new JLabel("PRN:");
        prn.setBounds(50,85,100,20);
        prn.setFont(new Font("serif",Font.BOLD,15));
        add(prn);

        search = new JTextField();
        search.setBounds(100,87,110,20);
        add(search);

        Result = new JButton("Check Result");
        Result.setBounds(250,87,120,20);
        Result.setBackground(new Color(0x0E90BA));   // Using color helper
        Result.setForeground(Color.white);
        Result.addActionListener(this);
        add(Result);

        Back = new JButton("Back");
        Back.setBounds(390,87,100,20);
        Back.setBackground(new Color(0x0E90BA));   // Using color helper
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10,130,770,420);
        add(sp);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(Result);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Result){
            String Search = search.getText();
            if (Search.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please select your name!","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            setVisible(false);
            new ShowResults(search.getText());
        }else {
            setVisible(false);
            new MainPage();
        }
    }

    public static void main(String[] args) {
        new Results();
    }


}
