package bms;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignUpTwo extends JFrame implements ActionListener {


    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, occupation, category, education, income;//JCombox is used to get a drop down box
    String formno;

    SignUpTwo(String formno) {
        this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additonalDetails = new JLabel("Page 2: Additional Details");
        additonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additonalDetails.setBounds(290, 80, 400, 30);
        add(additonalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String[] valReligion = { "Hindu", "Muslim", "Christian", "Ohters" };
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valCategory[] = { "General", "OBC", "SC", "ST", "Others" };
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String valIncome[] = { "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel emailAdd = new JLabel("Qualification:");
        emailAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        emailAdd.setBounds(100, 315, 200, 30);
        add(emailAdd);

        String educationValue[] = { "Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Ohters" };
        education = new JComboBox(educationValue);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marr = new JLabel("Occupation:");
        marr.setFont(new Font("Raleway", Font.BOLD, 20));
        marr.setBounds(100, 390, 200, 30);
        add(marr);

        String occupationValue[] = { "Private Sector", "Government Sector", "Self-Employed", "Student", "Buisness",
                "Retired", "Ohters" };
        occupation = new JComboBox(occupationValue);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(syes);
        martialGroup.add(sno);

        JLabel pincode = new JLabel("Exisiting Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emartialGroup = new ButtonGroup();
        emartialGroup.add(eyes);
        emartialGroup.add(eno);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String) religion.getSelectedItem();// getSelectedItem is used to get the va.ue from thedrop
                                                               // down box and we are typecasting in string coz this
                                                               // function returns the value as an object
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected())// isSelected to used if the button is used or not
        {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
       
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        } 
        String span = pan.getText();
        String saadhar = aadhar.getText();
        

        try {
           
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "' , '" + sreligion + "' , '" + scategory + "' , '" + sincome
                        + "' , '" + seducation + "' , '" + soccupation + "' , '" + span + "' , '" + saadhar + "' , '" + seniorcitizen
                        + "' , '" + existingaccount + "')";
                c.s.executeUpdate(query);

                //signupThree object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
