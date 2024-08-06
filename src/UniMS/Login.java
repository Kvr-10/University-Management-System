package UniMS;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

public class Login extends JFrame implements ActionListener {
    JButton Login,Cancel;
    JTextField usernamefield,passwordfield;
    public Login(){

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel L1= new JLabel(i3);
        L1.setBounds(300,10,200,200);
        add(L1);

        JLabel username = new JLabel("Username");
        username.setBounds(40,40,100,30);
        username.setFont(new Font("Serif",Font.BOLD,15));
        add(username);

        usernamefield= new JTextField();
        usernamefield.setBounds(150,45,100,20);
        add(usernamefield);

        JLabel Password = new JLabel("Password");
        Password.setBounds(40,90,100,30);
        Password.setFont(new Font("Serif",Font.BOLD,15));
        add(Password);

        passwordfield= new JPasswordField(); //Object of JpasswordFiedl,Reference of Jtextfield
        passwordfield.setBounds(150,95,100,20);
        add(passwordfield);

        Login = new JButton("Login");
        Login.setBounds(50,175,100,25);
        Login.setForeground(Color.WHITE);
        Login.setBackground(Color.BLACK);
        Login.addActionListener(this);
        add(Login);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(170,175,100,25);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBackground(Color.BLACK);
        Cancel.addActionListener(this);
        add(Cancel);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(370,200,550,300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(Login);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==Login){
            String username = usernamefield.getText();
            String password = passwordfield.getText();

            String query = "select * from login where username = '"+username+"' and password ='"+password+"'";


            try{
                //Connecting Sql and Executing Queries
                Connectionmysql obj = new Connectionmysql();
                ResultSet queryresult = obj.statement.executeQuery(query);

                if(queryresult.next()){
                    setVisible(false);
                    new MainPage();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password!","Warning",JOptionPane.WARNING_MESSAGE);
                    usernamefield.setText("");
                    passwordfield.setText("");
                    //setVisible(false);
                }
                //Closing connection
                obj.statement.close();
            }catch (Exception ex){
                ex.printStackTrace();;
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
