import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class login {

    JButton b1, b2;
    JFrame f1;
    JPanel p1;
    JTextField t1;
    JPasswordField pf1;
    JLabel l1, l2, l3;
    JLabel message;

    login() {
        f1 = new JFrame("Login Demo");
        f1.setBounds(400, 100, 500, 500);
        f1.setBackground(Color.darkGray);
        p1 = (JPanel) f1.getContentPane();

        p1.setLayout(null);
        t1 = new JTextField(30);
        t1.setBounds(200, 100, 150, 40);
        pf1 = new JPasswordField(30);
        pf1.setBounds(200, 200, 150, 40);
        l1 = new JLabel(" ADMIN LOGIN  ");
        l1.setBounds(200, 5, 200, 100);
        l1.setFont(new Font("Serif", Font.BOLD, 14));
        l1.setForeground(Color.blue);
        l2 = new JLabel("Enter Username");
        l2.setBounds(50, 100, 200, 40);
        l2.setFont(new Font("Serif", Font.BOLD, 12));
        l2.setForeground(Color.red);
        l3 = new JLabel("Enter Password");
        l3.setBounds(50, 200, 200, 40);
        l3.setFont(new Font("Serif", Font.BOLD, 12));
        l3.setForeground(Color.red);
        b1 = new JButton("LOGIN");
        b1.setBounds(50, 350, 150, 40);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial", Font.BOLD, 12));

        //message = new JLabel("Logged in successfully");
        //message.setBounds(300,400,200,40);
        b2 = new JButton("Sign Up");
        b2.setBounds(250, 350, 150, 40);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Arial", Font.BOLD, 12));

        p1.add(t1);
        p1.add(pf1);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(b1);
        p1.add(b2);
        //p1.add(message);
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f1.setVisible(true);

        theHandler handler = new theHandler();
        b1.addActionListener(handler);
        b2.addActionListener(handler);


    }


    class theHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                String s1, s2;
                String str1, str2;
                s1 = t1.getText();
                s2 = pf1.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver"); //Availiblity of Drivers
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "admin@123");
                    //Establish connection specifying database name
                    Statement st = con.createStatement();

                    ResultSet rs;
                    String str;

                    str = "select *from login";
                    rs = st.executeQuery(str);

                    while (rs.next()) {
                        str1 = rs.getString(2);
                        str2 = rs.getString(3);
                        if (s1.equals(str1)) {
                            if (s2.equals(str2)) {
                                JOptionPane.showMessageDialog(f1, "Logged in Successfully");
                                f1.dispose();
                                new Menuclass();
                            }
                        }
                    }

                    rs.close();
                    con.close();
                } catch (Exception e1) {
                    System.out.println("" + e);
                }


            }

            if(e.getSource() == b2)
            {
                new signupmenu();
            }

        }
    }

    public static void main(String args[])
    {
        new login();
    }
}









