package UniMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FeeS extends JFrame implements ActionListener {
    JTable table;
    JButton Home,Pay;
    public FeeS(){
        setBounds(250,30,800,620);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/wave.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,260,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(-5,300,800,260);
        add(image);

        JLabel heading = new JLabel("<html><u>Kaiju's University</html>");
        heading.setBounds(310,20,300,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel sheading = new JLabel("Fee-Structure");
        sheading.setBounds(330,70,300,50);
        sheading.setFont(new Font("serif",Font.BOLD,25));
        add(sheading);

        table= new JTable();

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10,130,770,151);
        add(sp);

        try{
            Connectionmysql obj = new Connectionmysql();
            ResultSet rs = obj.statement.executeQuery("select*from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error.Try Again","Warning",JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }

        Home = new JButton("Home");
        Home.setBounds(695,100,80,25);
        Home.setForeground(Color.WHITE);
        Home.setBackground(Color.gray);   // Using color helper
        Home.setForeground(Color.white);
        Home.addActionListener(this);
        add(Home);

        Pay = new JButton("Pay Fee");
        Pay.setBounds(580,100,100,25);
        Pay.setForeground(Color.WHITE);
        Pay.setBackground(Color.gray);   // Using color helper
        Pay.setForeground(Color.white);
        Pay.addActionListener(this);
        add(Pay);

        getRootPane().setDefaultButton(Home);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==Home){
            setVisible(false);
            new MainPage();
        }else {
            setVisible(false);
            new FeeForm();
        }
    }
    public static void main(String[] args) {
        new FeeS();
    }
}
