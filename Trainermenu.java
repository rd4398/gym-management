import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.sql.*;


public class Trainermenu {
    String tmenu[] = {"Select an Option", "Add", "Display", "Update", "Delete", "Member Menu"};
    JFrame Trainerframe;
    JPanel trainerpanel;
    JComboBox jcbt;
    JLabel tra;
    JButton tadd, tdel, tupdate, tdisp;
    JTextField tid, email, post, cg;
    JLabel trid, em, po, crgr;

    JTextField name, age, mob, addr;
    JLabel nm, ag, mo, ad;
    Choice loadtid;

    Trainermenu() {
        Trainerframe = new JFrame("Menu");
        Trainerframe.setBounds(250, 100, 900, 900);
        Trainerframe.setBackground(Color.darkGray);
        trainerpanel = (JPanel) Trainerframe.getContentPane();
        trainerpanel.setLayout(null);

        tra = new JLabel("Trainers");
        tra.setBounds(150, 5, 200, 100);
        tra.setFont(new Font("Comic Sans", Font.BOLD, 16));
        tra.setForeground(Color.blue);

        loadtid = new Choice();
        loadtid.add("Select ID");
        loadtid.setBounds(600, 5, 150, 30);

        jcbt = new JComboBox<String>(tmenu);
        jcbt.setBounds(100, 75, 200, 30);

        tadd = new JButton("Insert");
        tadd.setBounds(400, 625, 100, 30);
        tadd.setBackground(Color.black);
        tadd.setForeground(Color.white);
        tadd.setFont(new Font("Arial", Font.BOLD, 12));

        tdel = new JButton("Delete");
        tdel.setBounds(400, 625, 100, 30);
        tdel.setBackground(Color.black);
        tdel.setForeground(Color.white);
        tdel.setFont(new Font("Arial", Font.BOLD, 12));

        tupdate = new JButton("Update");
        tupdate.setBounds(400, 625, 100, 30);
        tupdate.setBackground(Color.black);
        tupdate.setForeground(Color.white);
        tupdate.setFont(new Font("Arial", Font.BOLD, 12));

        tdisp = new JButton("Display");
        tdisp.setBounds(400, 625, 100, 30);
        tdisp.setBackground(Color.black);
        tdisp.setForeground(Color.white);
        tdisp.setFont(new Font("Arial", Font.BOLD, 12));

        nm = new JLabel("Name");
        nm.setBounds(250, 150, 100, 50);
        nm.setFont(new Font("Serif", Font.BOLD, 14));
        nm.setForeground(Color.red);

        trid = new JLabel("Trainer ID");
        trid.setBounds(250, 225, 100, 50);
        trid.setFont(new Font("Serif", Font.BOLD, 14));
        trid.setForeground(Color.red);

        ad = new JLabel("Address");
        ad.setBounds(250, 300, 100, 50);
        ad.setFont(new Font("Serif", Font.BOLD, 14));
        ad.setForeground(Color.red);

        ag = new JLabel("Age");
        ag.setBounds(250, 375, 100, 50);
        ag.setFont(new Font("Serif", Font.BOLD, 14));
        ag.setForeground(Color.red);

        mo = new JLabel("Mobile Number");
        mo.setBounds(550, 375, 200, 50);
        mo.setFont(new Font("Serif", Font.BOLD, 14));
        mo.setForeground(Color.red);

        em = new JLabel("Email");
        em.setBounds(250, 450, 100, 50);
        em.setFont(new Font("Serif", Font.BOLD, 14));
        em.setForeground(Color.red);

        po = new JLabel("Post");
        po.setBounds(250, 525, 100, 50);
        po.setFont(new Font("Serif", Font.BOLD, 14));
        po.setForeground(Color.red);

        crgr = new JLabel("Grade");
        crgr.setBounds(550, 525, 100, 50);
        crgr.setFont(new Font("Serif", Font.BOLD, 14));
        crgr.setForeground(Color.red);

        name = new JTextField(50);
        name.setBounds(450, 150, 150, 40);

        tid = new JTextField(20);
        tid.setBounds(450, 225, 150, 40);

        addr = new JTextField(100);
        addr.setBounds(450, 300, 150, 40);

        age = new JTextField(5);
        age.setBounds(450, 375, 50, 40);

        mob = new JTextField(10);
        mob.setBounds(700, 375, 100, 40);

        email = new JTextField(50);
        email.setBounds(450, 450, 150, 40);

        post = new JTextField(50);
        post.setBounds(450, 525, 50, 40);

        cg = new JTextField(10);
        cg.setBounds(700, 525, 50, 40);

        trainerpanel.add(jcbt);
        trainerpanel.add(tra);
        Trainerframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Trainerframe.setVisible(true);

        TrainerHandler Thandler = new TrainerHandler();
        jcbt.addActionListener(Thandler);
        loadtid.addItemListener(Thandler);
        tadd.addActionListener(Thandler);
        tdisp.addActionListener(Thandler);
        tdel.addActionListener(Thandler);
        tupdate.addActionListener(Thandler);
        loader();

    }

    public void loader()
    {
        loadtid.removeAll();
        loadtid.add("Select ID");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");

            Statement st=con.createStatement();
            ResultSet rs;
            String str;
            str = "select *from Trainer";
            rs = st.executeQuery(str);
            while(rs.next())
            {
                loadtid.add(rs.getInt(1)+"");

            }
            rs.close();
            con.close();
        }

        catch (Exception e)
        {
            System.out.println(""+e);
        }
    }


    class TrainerHandler implements ActionListener, ItemListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String str1;
            str1 = (String) jcbt.getSelectedItem();
            int flag = 0;

            if (str1.equals("Add")) {
                flag = 5;
                trainerpanel.add(name);
                trainerpanel.add(nm);
                trainerpanel.add(tid);
                trainerpanel.add(trid);
                trainerpanel.add(ad);
                trainerpanel.add(addr);
                trainerpanel.add(ag);
                trainerpanel.add(age);
                trainerpanel.add(mo);
                trainerpanel.add(mob);
                trainerpanel.add(email);
                trainerpanel.add(em);
                trainerpanel.add(po);
                trainerpanel.add(post);
                trainerpanel.add(cg);
                trainerpanel.add(crgr);
                trainerpanel.add(tadd);
                trainerpanel.remove(tdel);
                trainerpanel.remove(tupdate);
                trainerpanel.remove(tdisp);

                flag = 100;
                trainerpanel.revalidate();
                trainerpanel.repaint();
            } else if (str1.equals("Display")) {
                flag = 6;
                trainerpanel.add(name);
                trainerpanel.add(nm);
                trainerpanel.add(tid);
                trainerpanel.add(trid);
                trainerpanel.add(ad);
                trainerpanel.add(addr);
                trainerpanel.add(ag);
                trainerpanel.add(age);
                trainerpanel.add(mo);
                trainerpanel.add(mob);
                trainerpanel.add(email);
                trainerpanel.add(em);
                trainerpanel.add(po);
                trainerpanel.add(post);
                trainerpanel.add(cg);
                trainerpanel.add(crgr);
                trainerpanel.add(loadtid);
                //trainerpanel.add(tdisp);
                trainerpanel.remove(tadd);
                trainerpanel.remove(tupdate);
                trainerpanel.remove(tdel);

                flag = 100;
                trainerpanel.revalidate();
                trainerpanel.repaint();
            } else if (str1.equals("Update")) {
                flag = 7;
                trainerpanel.add(name);
                trainerpanel.add(nm);
                trainerpanel.add(tid);
                trainerpanel.add(trid);
                trainerpanel.add(ad);
                trainerpanel.add(addr);
                trainerpanel.add(ag);
                trainerpanel.add(age);
                trainerpanel.add(mo);
                trainerpanel.add(mob);
                trainerpanel.add(email);
                trainerpanel.add(em);
                trainerpanel.add(po);
                trainerpanel.add(post);
                trainerpanel.add(cg);
                trainerpanel.add(crgr);
                trainerpanel.add(tupdate);
                trainerpanel.remove(tdel);
                trainerpanel.remove(tdisp);
                trainerpanel.remove(tadd);
                trainerpanel.add(loadtid);

                flag = 100;
                trainerpanel.revalidate();
                trainerpanel.repaint();
            } else if (str1.equals("Delete")) {
                flag = 8;
                trainerpanel.add(name);
                trainerpanel.add(nm);
                trainerpanel.add(tid);
                trainerpanel.add(trid);
                trainerpanel.add(ad);
                trainerpanel.add(addr);
                trainerpanel.add(ag);
                trainerpanel.add(age);
                trainerpanel.add(mo);
                trainerpanel.add(mob);
                trainerpanel.add(email);
                trainerpanel.add(em);
                trainerpanel.add(po);
                trainerpanel.add(post);
                trainerpanel.add(cg);
                trainerpanel.add(crgr);
                trainerpanel.add(tdel);
                trainerpanel.remove(tdisp);
                trainerpanel.remove(tupdate);
                trainerpanel.remove(tadd);
                trainerpanel.add(loadtid);

                flag = 100;
                trainerpanel.revalidate();
                trainerpanel.repaint();
            } else if (str1.equals("Member Menu")) {
                Trainerframe.dispose();
                new Menuclass();

            }

            if (e.getSource() == tadd)
            {
                String n,ad,m,g,p,em;
                int a,i;
                n = name.getText();
                i = Integer.parseInt(tid.getText());
                ad = addr.getText();
                m = mob.getText();
                g = cg.getText();
                p = post.getText();
                em = email.getText();
                a = Integer.parseInt(age.getText());
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");

                    Statement st=con.createStatement();
                    ResultSet rs;
                    String query;
                    query = "insert into Trainer values('"+i+"','"+n+"','"+ad+"','"+a+"','"+m+"','"+em+"','"+p+"','"+g+"')";
                    st.executeUpdate(query);

                    query = "select *from Trainer";
                    rs = st.executeQuery(query);
                    loader();
                    name.setText("");
                    tid.setText("");
                    addr.setText("");
                    age.setText("");
                    mob.setText("");
                    email.setText("");
                    cg.setText("");
                    post.setText("");
                    rs.close();
                    con.close();
                }
                catch(Exception ex)
                {
                    System.out.println(""+ex);
                }
            }

            if(e.getSource() == tdel)
            {
                int no1;
                no1 = Integer.parseInt(loadtid.getSelectedItem());
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");
                    Statement st=con.createStatement();

                    ResultSet rs;
                    String query;
                    query = "delete from Trainer where id="+no1;
                    st.executeUpdate(query);
                    query = "select *from Trainer";
                    rs = st.executeQuery(query);
                    loader();
                    name.setText("");
                    tid.setText("");
                    addr.setText("");
                    age.setText("");
                    mob.setText("");
                    email.setText("");
                    cg.setText("");
                    post.setText("");
                    loadtid.select(0);
                    rs.close();
                    con.close();
                }
                catch (Exception ex)
                {
                    System.out.println(""+ex);
                }
            }

            if(e.getSource() == tupdate)
            {
                String no1 = loadtid.getSelectedItem();
                String n,ad,m,em,p,g;
                int a,i;
                n = name.getText();
                i = Integer.parseInt(tid.getText());
                ad = addr.getText();
                m = mob.getText();
                em = email.getText();
                p = post.getText();
                g = cg.getText();
                a = Integer.parseInt(age.getText());
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");

                    Statement st=con.createStatement();

                    ResultSet rs;
                    String query;
                    query = "update Trainer set id='"+i+"',name='"+n+"',address='"+ad+"',age='"+a+"',mob='"+m+"',email='"+em+"',post='"+p+"',grade='"+g+"'where id="+no1;
                    st.executeUpdate(query);

                    query = "select *from Trainer";
                    rs = st.executeQuery(query);
                    loader();
                    name.setText("");
                    tid.setText("");
                    addr.setText("");
                    mob.setText("");
                    email.setText("");
                    age.setText("");
                    cg.setText("");
                    post.setText("");

                    loadtid.select(0);
                    rs.close();
                    con.close();
                }

                catch (Exception ex)
                {
                    System.out.println(""+ex);
                }
            }

        }

            @Override
            public void itemStateChanged (ItemEvent e){

                int no1;
                no1 = Integer.parseInt(loadtid.getSelectedItem());
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");
                    Statement st=con.createStatement();
                    ResultSet rs;
                    String query;
                    query = "select *from Trainer where id="+no1;
                    rs = st.executeQuery(query);
                    rs.next();
                    name.setText(rs.getString(2)+"");
                    tid.setText(rs.getInt(1)+"");
                    addr.setText(rs.getString(3)+"");
                    age.setText(rs.getInt(4)+"");
                    mob.setText(rs.getString(5)+"");
                    email.setText(rs.getString(6)+"");
                    post.setText(rs.getString(7)+"");
                    cg.setText(rs.getString(8)+"");
                    rs.close();
                    con.close();
                }

                catch (Exception ex)
                {
                    System.out.println(""+ex);
                }

            }


    }
}
