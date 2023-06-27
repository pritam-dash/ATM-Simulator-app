package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton onehun, fivehun, onethou, twothou, fivethou, tenthou, back;
    String pinnumber;
    
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        onehun =new JButton("Rs 100");
        onehun.setBounds(170, 415, 150, 30);
        onehun.addActionListener(this);
        image.add(onehun);
        
        fivehun =new JButton("Rs 500");
        fivehun.setBounds(355, 415, 150, 30);
        fivehun.addActionListener(this);
        image.add(fivehun);
        
        onethou = new JButton("Rs 1000");
        onethou.setBounds(170, 450, 150, 30);
        onethou.addActionListener(this);
        image.add(onethou);
        
        twothou = new JButton("Rs 2000");
        twothou.setBounds(355, 450, 150, 30);
        twothou.addActionListener(this);
        image.add(twothou);
        
        fivethou =new JButton("Rs 5000");
        fivethou.setBounds(170, 485, 150, 30);
        fivethou.addActionListener(this);
        image.add(fivethou);
        
        tenthou =new JButton("Rs 10000");
        tenthou.setBounds(355, 485, 150, 30);
        tenthou.addActionListener(this);
        image.add(tenthou);
        
        back =new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(true);
            new Transactions(pinnumber).setVisible(true);
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                        balance += Integer.parseInt(rs.getString("amount"));
                    else
                        balance -= Integer.parseInt(rs.getString("amount"));       
                }
                
                if (ae.getSource() != back && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[])
    {
        new FastCash("");
    }
}
