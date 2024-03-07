import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class signupmenu {

    JFrame f2;
    JPanel p2;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    JPasswordField pf;
    JButton signup,loginback;

    signupmenu() {

        f2 = new JFrame("Login Demo");
        f2.setBounds(400, 100, 500, 500);
        p2 = (JPanel) f2.getContentPane();
        p2.setLayout(null);
        l1 = new JLabel("SignUp");
        l1.setBounds(225, 5, 200, 100);
        l1.setFont(new Font("Serif", Font.BOLD, 14));
        l1.setForeground(Color.blue);
        l2 = new JLabel("Enter Name");
        l2.setBounds(50, 100, 200, 40);
        l2.setFont(new Font("Serif", Font.BOLD, 14));
        l2.setForeground(Color.red);
        l3 = new JLabel("Enter Username");
        l3.setBounds(50, 200, 200, 40);
        l3.setFont(new Font("Serif", Font.BOLD, 14));
        l3.setForeground(Color.red);
        l4 = new JLabel("Enter Password");
        l4.setBounds(50, 300, 200, 40);
        l4.setFont(new Font("Serif", Font.BOLD, 14));
        l4.setForeground(Color.red);
        t1 = new JTextField(30);
        t1.setBounds(200, 100, 150, 40);
        t2 = new JTextField(30);
        t2.setBounds(200, 200, 150, 40);
        pf = new JPasswordField(30);
        pf.setBounds(200, 300, 150, 40);
        signup = new JButton("Done");
        signup.setBounds(50, 400, 150, 40);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setFont(new Font("Arial", Font.BOLD, 12));
        loginback = new JButton("Back to Login");
        loginback.setBounds(250,400,150,40);
        loginback.setBackground(Color.black);
        loginback.setForeground(Color.white);
        loginback.setFont(new Font("Arial", Font.BOLD, 12));

        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(t1);
        p2.add(t2);
        p2.add(pf);
        p2.add(signup);
        p2.add(loginback);
        f2.setVisible(true);
        theHandler handler = new theHandler();
        signup.addActionListener(handler);
        loginback.addActionListener(handler);


    }

    private class theHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == signup) {
                String user, pass;
                String name;
                user = t2.getText();
                name = t1.getText();
                pass = pf.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver"); //Availiblity of Drivers
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "admin@123");
                    //Establish connection specifying database name
                    Statement st = con.createStatement();

                    ResultSet rs;
                    String str;
                    str = "insert into login values('" + name + "','" + user + "','" + pass + "')";
                    st.executeUpdate(str);

                    //str = "select *from emp";
                    rs = st.executeQuery(str);

                    rs.close();
                    con.close();
                } catch (Exception e1) {
                    System.out.println("" + e);
                }

            }

            if(e.getSource() == loginback)
            {
                new login();
            }
        }
    }
}




