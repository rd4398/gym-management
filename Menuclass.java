import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.sql.*;


public class Menuclass {
    JFrame menuframe;
    JPanel menupanel;
    JComboBox jcbm;
    JLabel mem, tra;
    String mmenu[] = {"Select an Option", "Add", "Display", "Update", "Delete", "Trainer Menu"};

    JButton add, del, update, disp;
    JTextField name, id, age, mob, addr, ht, wt, jd, per;
    JLabel nm, mid, ag, mo, ad, h, w, jdate, period;


    Choice loadmid;

    Menuclass() {
        menuframe = new JFrame("Menu");
        menuframe.setBounds(250, 100, 900, 900);
        menuframe.setBackground(Color.darkGray);

        menupanel = (JPanel) menuframe.getContentPane();
        menupanel.setLayout(null);
        mem = new JLabel("Members");
        mem.setBounds(150, 5, 200, 100);
        mem.setFont(new Font("Comic Sans", Font.BOLD, 16));
        mem.setForeground(Color.blue);

        jcbm = new JComboBox<String>(mmenu);

        jcbm.setBounds(100, 75, 200, 30);
        loadmid = new Choice();
        loadmid.add("Select ID");
        loadmid.setBounds(600, 5, 150, 30);


        add = new JButton("Insert");
        add.setBounds(400, 625, 100, 30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setFont(new Font("Arial", Font.BOLD, 12));


        del = new JButton("Delete");
        del.setBounds(400, 625, 100, 30);
        del.setBackground(Color.black);
        del.setForeground(Color.white);
        del.setFont(new Font("Arial", Font.BOLD, 12));

        update = new JButton("Update");
        update.setBounds(400, 625, 100, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setFont(new Font("Arial", Font.BOLD, 12));


        disp = new JButton("Display");
        disp.setBounds(400, 625, 100, 30);
        disp.setBackground(Color.black);
        disp.setForeground(Color.white);
        disp.setFont(new Font("Arial", Font.BOLD, 12));

        nm = new JLabel("Name");
        nm.setBounds(250, 150, 100, 50);
        nm.setFont(new Font("Serif", Font.BOLD, 14));
        nm.setForeground(Color.red);

        mid = new JLabel("Member ID");
        mid.setBounds(250, 225, 100, 50);
        mid.setFont(new Font("Serif", Font.BOLD, 14));
        mid.setForeground(Color.red);


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

        h = new JLabel("Height");
        h.setBounds(250, 450, 100, 50);
        h.setFont(new Font("Serif", Font.BOLD, 14));
        h.setForeground(Color.red);

        w = new JLabel("Weight");
        w.setBounds(550, 450, 100, 50);
        w.setFont(new Font("Serif", Font.BOLD, 14));
        w.setForeground(Color.red);


        jdate = new JLabel("Joining Date");
        jdate.setBounds(250, 525, 100, 50);
        jdate.setFont(new Font("Serif", Font.BOLD, 14));
        jdate.setForeground(Color.red);

        period = new JLabel("Duration");
        period.setBounds(550, 525, 100, 50);
        period.setFont(new Font("Serif", Font.BOLD, 14));
        period.setForeground(Color.red);

        name = new JTextField(50);
        name.setBounds(450, 150, 150, 40);

        id = new JTextField(20);
        id.setBounds(450, 225, 150, 40);


        addr = new JTextField(100);
        addr.setBounds(450, 300, 150, 40);

        age = new JTextField(5);
        age.setBounds(450, 375, 50, 40);

        mob = new JTextField(10);
        mob.setBounds(700, 375, 100, 40);

        ht = new JTextField(5);
        ht.setBounds(450, 450, 50, 40);

        wt = new JTextField(5);
        wt.setBounds(700, 450, 50, 40);

        jd = new JTextField(20);
        jd.setBounds(450, 525, 50, 40);

        per = new JTextField(10);
        per.setBounds(700, 525, 50, 40);


        menupanel.add(jcbm);
        menupanel.add(mem);

        //menupanel.add(update);
        //menupanel.add(del);

        menuframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuframe.setVisible(true);

        MemberHandler Mhandler = new MemberHandler();
        jcbm.addActionListener(Mhandler);
        loadmid.addItemListener(Mhandler);
        add.addActionListener(Mhandler);
        disp.addActionListener(Mhandler);
        del.addActionListener(Mhandler);
        update.addActionListener(Mhandler);
        load();


    }

    public void load()
    {
        loadmid.removeAll();
        loadmid.add("Select ID");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");

            Statement st=con.createStatement();
            ResultSet rs;
            String str;
            str = "select *from Member";
            rs = st.executeQuery(str);
            while(rs.next())
            {
                loadmid.add(rs.getInt(1)+"");

            }
            rs.close();
            con.close();
        }

        catch (Exception e)
        {
            System.out.println(""+e);
        }
    }

    class MemberHandler implements ActionListener, ItemListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String str;
            str = (String) jcbm.getSelectedItem();
            int flag = 0;

            if (str.equals("Add")) {
                flag = 1;
                menupanel.add(name);
                menupanel.add(nm);
                menupanel.add(id);
                menupanel.add(mid);
                menupanel.add(ad);
                menupanel.add(addr);
                menupanel.add(ag);
                menupanel.add(age);
                menupanel.add(mo);
                menupanel.add(mob);
                menupanel.add(h);
                menupanel.add(ht);
                menupanel.add(w);
                menupanel.add(wt);
                menupanel.add(jd);
                menupanel.add(jdate);
                menupanel.add(per);
                menupanel.add(period);
                menupanel.add(add);
                menupanel.remove(del);
                menupanel.remove(update);
                menupanel.remove(disp);

                flag = 100;
                menupanel.revalidate();
                menupanel.repaint();
            }

          /*  while(flag == 1)
            {

            }*/

            else if (str.equals("Display")) {
                flag = 2;
                menupanel.add(name);
                menupanel.add(nm);
                menupanel.add(ad);
                menupanel.add(addr);
                menupanel.add(ag);
                menupanel.add(age);
                menupanel.add(mo);
                menupanel.add(mob);
                menupanel.add(h);
                menupanel.add(ht);
                menupanel.add(w);
                menupanel.add(wt);
                menupanel.add(jd);
                menupanel.add(jdate);
                menupanel.add(per);
                menupanel.add(period);
                menupanel.add(loadmid);
                //menupanel.add(disp);
                menupanel.remove(add);
                menupanel.remove(update);
                menupanel.remove(del);

                flag = 100;
                menupanel.revalidate();
                menupanel.repaint();
            }

           /* while(flag == 2)
            {


            }*/

            else if (str.equals("Update")) {
                flag = 3;
                menupanel.add(name);
                menupanel.add(nm);
                menupanel.add(ad);
                menupanel.add(addr);
                menupanel.add(ag);
                menupanel.add(age);
                menupanel.add(mo);
                menupanel.add(mob);
                menupanel.add(h);
                menupanel.add(ht);
                menupanel.add(w);
                menupanel.add(wt);
                menupanel.add(jd);
                menupanel.add(jdate);
                menupanel.add(per);
                menupanel.add(period);
                menupanel.add(loadmid);
                menupanel.add(update);
                menupanel.remove(del);
                menupanel.remove(add);
                menupanel.remove(disp);
                flag = 100;

                menupanel.revalidate();
                menupanel.repaint();
            }

           /* while(flag == 3)
            {

            }*/

            else if (str.equals("Delete")) {
                flag = 4;
                menupanel.add(name);
                menupanel.add(nm);
                menupanel.add(ad);
                menupanel.add(addr);
                menupanel.add(ag);
                menupanel.add(age);
                menupanel.add(mo);
                menupanel.add(mob);
                menupanel.add(h);
                menupanel.add(ht);
                menupanel.add(w);
                menupanel.add(wt);
                menupanel.add(jd);
                menupanel.add(jdate);
                menupanel.add(per);
                menupanel.add(period);
                menupanel.add(loadmid);
                menupanel.add(del);
                menupanel.remove(disp);
                menupanel.remove(add);
                menupanel.remove(update);

                flag = 100;
                menupanel.revalidate();
                menupanel.repaint();
            }

           /* while(flag == 4)
            {

            }*/

            else if (str.equals("Trainer Menu")) {
                menuframe.dispose();
                new Trainermenu();
            }

            if(e.getSource() == add)
            {
                String n,ad,m,j,p;
                int h,w,a,i;
                n = name.getText();
                i = Integer.parseInt(id.getText());
                ad = addr.getText();
                m = mob.getText();
                j = jd.getText();
                p = per.getText();
                h = Integer.parseInt(ht.getText());
                w = Integer.parseInt(wt.getText());
                a = Integer.parseInt(age.getText());
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");

                    Statement st=con.createStatement();
                    ResultSet rs;
                    String query;
                    query = "insert into Member values('"+i+"','"+n+"','"+ad+"','"+a+"','"+m+"','"+h+"','"+w+"','"+j+"','"+p+"')";
                    st.executeUpdate(query);

                    query = "select *from Member";
                    rs = st.executeQuery(query);
                    load();
                    name.setText("");
                    id.setText("");
                    addr.setText("");
                    age.setText("");
                    mob.setText("");
                    ht.setText("");
                    wt.setText("");
                    jd.setText("");
                    per.setText("");
                    rs.close();
                    con.close();
                }
                catch(Exception ex)
                {
                    System.out.println(""+ex);
                }
            }

            if(e.getSource() == del)
            {
                int no1;
                no1 = Integer.parseInt(loadmid.getSelectedItem());
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");
                    Statement st=con.createStatement();

                    ResultSet rs;
                    String query;
                    query = "delete from Member where id="+no1;
                    st.executeUpdate(query);
                    query = "select *from Member";
                    rs = st.executeQuery(query);
                    load();
                    name.setText("");
                    id.setText("");
                    addr.setText("");
                    age.setText("");
                    mob.setText("");
                    ht.setText("");
                    wt.setText("");
                    jd.setText("");
                    per.setText("");
                    loadmid.select(0);
                    rs.close();
                    con.close();
                }
                catch (Exception ex)
                {
                    System.out.println(""+ex);
                }
            }

            if (e.getSource() == update)
            {
                int no1 = Integer.parseInt(loadmid.getSelectedItem());
                String n,ad,m,j,p;
                int h,w,a,i;
                n = name.getText();
                i = Integer.parseInt(id.getText());
                ad = addr.getText();
                m = mob.getText();
                j = jd.getText();
                p = per.getText();
                h = Integer.parseInt(ht.getText());
                w = Integer.parseInt(wt.getText());
                a = Integer.parseInt(age.getText());
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");

                    Statement st=con.createStatement();

                    ResultSet rs;
                    String query;
                    query = "update Member set id='"+i+"',name='"+n+"',address='"+ad+"',age='"+a+"',mob='"+m+"',ht='"+h+"',wt='"+w+"',jd='"+j+"',per='"+p+"' where id="+no1;
                    st.executeUpdate(query);

                    query = "select *from Member";
                    rs = st.executeQuery(query);
                    load();
                    name.setText("");
                    id.setText("");
                    addr.setText("");
                    mob.setText("");
                    age.setText("");
                    ht.setText("");
                    wt.setText("");
                    jd.setText("");
                    per.setText("");
                    loadmid.select(0);
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
        public void itemStateChanged(ItemEvent e) {
            int no1;
            no1 = Integer.parseInt(loadmid.getSelectedItem());
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","admin@123");
                Statement st=con.createStatement();
                ResultSet rs;
                String query;
                query = "select *from Member where id="+no1;
                rs = st.executeQuery(query);
                rs.next();
                name.setText(rs.getString(2)+"");
                id.setText(rs.getInt(1)+"");
                addr.setText(rs.getString(3)+"");
                age.setText(rs.getInt(4)+"");
                mob.setText(rs.getString(5)+"");
                ht.setText(rs.getInt(6)+"");
                wt.setText(rs.getInt(7)+"");
                jd.setText(rs.getString(8)+"");
                per.setText(rs.getString(9)+"");
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



