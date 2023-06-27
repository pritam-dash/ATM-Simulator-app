package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener
{
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;
    
    SignupTwo(String formno)     
    {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 140, 200, 30);
        add(rel);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);
        
        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);
        
        JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);
        
        String educationValues[] = {"Non Graduation", "Graduation", "Post-Graduation", "Doctorate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway", Font.BOLD, 20));
        occu.setBounds(100, 390, 200, 30);
        add(occu);
        
        String occupationValues[] = {"Salaried", "Self-employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panNo = new JLabel("PAN Number:");
        panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        panNo.setBounds(100, 440, 200, 30);
        add(panNo);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel aadharNo = new JLabel("Aadhar Number:");
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNo.setBounds(100, 490, 200, 30);
        add(aadharNo);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected())
            seniorCitizen = "Yes";
        else if(sno.isSelected())
            seniorCitizen = "No";
        
        String existingAccount = null;
        if(eyes.isSelected())
            existingAccount = "Yes";
        else if(eno.isSelected())
            existingAccount = "No";
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try
        {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
}
