package UniMS;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;
    public Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/college.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,570,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        t= new Thread(this);
        t.start();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        int x=1;
        for (int i=2;i<=400;i+=4,x+=1){
            setLocation(550-((i+x)/2),250-(i/2));
            setSize(i+3*x,i+4*x/2);

            try{
                Thread.sleep(10);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    @Override
    public void run() {
        try{
            Thread.sleep(6000);
            setVisible(false);
            new Login();
        }catch (Exception e){}
    }
    public static void main(String[] args) {
        new Splash();
    }


}
