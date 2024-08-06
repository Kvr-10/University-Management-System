package UniMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;

public class MainPage extends JFrame implements ActionListener {
    public MainPage(){
        setSize(1285,722);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/mainpage.jpg"));
        Image i2= i1.getImage().getScaledInstance(1285,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);

        JMenuBar menuBar = new JMenuBar();

        JMenu View = new JMenu("New Information");
        menuBar.add(View);

        JMenuItem Teacher = new JMenuItem("New Faculty Information");
        Teacher.setBackground(Color.WHITE);
        Teacher.addActionListener(this);
        View.add(Teacher);

        JMenuItem Student = new JMenuItem("New Student Information");
        Student.setBackground(Color.WHITE);
        Student.addActionListener(this);
        View.add(Student);


        JMenu details = new JMenu("View Details");
        menuBar.add(details);

        JMenuItem Teacherdetails = new JMenuItem("View Faculty Details");
        Teacherdetails.setBackground(Color.WHITE);
        Teacherdetails.addActionListener(this);
        details.add(Teacherdetails);

        JMenuItem Studentdetails = new JMenuItem("View Student Details");
        Studentdetails.setBackground(Color.WHITE);
        Studentdetails.addActionListener(this);
        details.add(Studentdetails);

        JMenu leave = new JMenu("Apply Leave");
        menuBar.add(leave);

        JMenuItem Teacherleave = new JMenuItem("Faculty Leave");
        Teacherleave.setBackground(Color.WHITE);
        Teacherleave.addActionListener(this);
        leave.add(Teacherleave);

        JMenuItem Stdleave = new JMenuItem("Student Leave");
        Stdleave.setBackground(Color.WHITE);
        Stdleave.addActionListener(this);
        leave.add(Stdleave);

        JMenu leavedetails = new JMenu("Leave Details");
        menuBar.add(leavedetails);

        JMenuItem Teacherleavedetails = new JMenuItem("Faculty Leave Details");
        Teacherleavedetails.setBackground(Color.WHITE);
        Teacherleavedetails.addActionListener(this);
        leavedetails.add(Teacherleavedetails);

        JMenuItem Stdleavedetails = new JMenuItem("Student Leave Details");
        Stdleavedetails.setBackground(Color.WHITE);
        Stdleavedetails.addActionListener(this);
        leavedetails.add(Stdleavedetails);

        JMenu Updateinfo = new JMenu("Update Details");
        menuBar.add(Updateinfo);

        JMenuItem UpTeacher = new JMenuItem("Update Faculty Details");
        UpTeacher.setBackground(Color.WHITE);
        UpTeacher.addActionListener(this);
        Updateinfo.add(UpTeacher);

        JMenuItem Upstd = new JMenuItem("Update Student Details");
        Upstd.setBackground(Color.WHITE);
        Upstd.addActionListener(this);
        Updateinfo.add(Upstd);

        JMenu Exam = new JMenu("Examination");
        menuBar.add(Exam);

        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.addActionListener(this);
        Exam.add(EnterMarks);

        JMenuItem Examdetails = new JMenuItem("Examination Results");
        Examdetails.setBackground(Color.WHITE);
        Examdetails.addActionListener(this);
        Exam.add(Examdetails);

        JMenu fee = new JMenu("Fee Details");
        menuBar.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee-Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee-Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);

        JMenuItem feedisplay = new JMenuItem("Paid Fees List");
        feedisplay.setBackground(Color.WHITE);
        feedisplay.addActionListener(this);
        fee.add(feedisplay);


        JMenu Extras = new JMenu("Extras");
        menuBar.add(Extras);

        JMenuItem Calc = new JMenuItem("Calculator");
        Calc.addActionListener(this);
        Calc.setBackground(Color.WHITE);
        Extras.add(Calc);

        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.addActionListener(this);
        Notepad.setBackground(Color.WHITE);
        Extras.add(Notepad);

        JMenu About = new JMenu("About Creator");
        About.addActionListener(this);
        About.setBackground(Color.WHITE);
        menuBar.add(About);

        JMenuItem Insta = new JMenuItem("Instagram");
        Insta.addActionListener(this);
        Insta.setBackground(Color.white);
        About.add(Insta);

        JMenuItem Github = new JMenuItem("Github");
        Github.addActionListener(this);
        Github.setBackground(Color.white);
        About.add(Github);

        JMenuItem pdf = new JMenuItem("2nd Year Result");
        pdf.addActionListener(this);
        pdf.setBackground(Color.white);
        About.add(pdf);

        JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.red);
        menuBar.add(Exit);

        JMenuItem Ex = new JMenuItem("Exit");
        Ex.addActionListener(this);
        Ex.setBackground(Color.WHITE);
        Ex.setForeground(Color.red);
        Exit.add(Ex);

        setJMenuBar(menuBar);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String msg= e.getActionCommand();
        if(msg.equals("Exit")){
            System.exit(0);
        } else if (msg.equalsIgnoreCase("Calculator")) {

//            try {
//                Runtime.getRuntime().exec("calc.exe");      // This is Deprecated Now
//            }catch (Exception ae){}

            try {
                ProcessBuilder pb1 = new ProcessBuilder("calc.exe");
                pb1.start();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if (msg.equalsIgnoreCase("Notepad")) {
            try {
                ProcessBuilder pb2 = new ProcessBuilder("notepad.exe");
                pb2.start();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(msg.equalsIgnoreCase("instagram")){
            try {
                Desktop.getDesktop().browse(new URI("https://www.instagram.com/kvr10_/"));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(msg.equalsIgnoreCase("Github")){
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Kvr-10"));
            }
            catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if(msg.equalsIgnoreCase("2nd Year Result")){
            try {
                Desktop.getDesktop().open(new File("C:/Users/chama/OneDrive/Desktop/Docs/Second Year result.pdf"));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else if (msg.equalsIgnoreCase("New Student Information")) {
            System.out.println("Opening Add Std");
            new AddStudent();
            setVisible(false);
        }
        else if (msg.equalsIgnoreCase("New Faculty Information")) {
            System.out.println("Opening Add Teacher");
            new AddTeacher();
            setVisible(false);
        }
        else if (msg.equalsIgnoreCase("View Student Details")) {
            System.out.println("Viewing Stds");
            new Stdviewdetails();
            setVisible(false);
        }
        else if (msg.equalsIgnoreCase("View Faculty Details")) {
            System.out.println("Viewing Faculty");
            new Teacherviewdetails();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Student Leave")) {
            System.out.println("Opening Student Leave");
            new Stdleave();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Faculty Leave")) {
            System.out.println("Opening Faculty Leave");
            new Teacherleave();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Faculty Leave Details")) {
            System.out.println("Viewing Faculty Leave");
            new Teacherleavedetails();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Student Leave Details")) {
            System.out.println("Viewing Student Leave");
            new Stdleavedetails();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Update Faculty Details")) {
            System.out.println("Opening Update Faculty Info");
            new TeacherUpdate();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Update Student Details")) {
            System.out.println("Opening Update Student Info");
            new StdUpdate();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Enter Marks")) {
            System.out.println("Opening Enter marks");
            new EnterMarks();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Examination Results")) {
            System.out.println("Opening Examination Results");
            new Results();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Fee-Structure")) {
            System.out.println("Opening Fee-Structure");
            //new FeeS();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Student Fee-Form")) {
            System.out.println("Opening Student Fee-Form");
            //new FeeForm();
            setVisible(false);
        }else if (msg.equalsIgnoreCase("Paid Fees List")) {
            System.out.println("Opening Paid Fees List");
            //new FeesDisplay();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new MainPage();
    }
}
