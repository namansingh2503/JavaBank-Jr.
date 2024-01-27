package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,singup;//globaly declaring buttons coz we are using them outside the login contructor as well
    JTextField cardTextField;
    JPasswordField pinTextField;//To hide the password a specific password class
    
    Login()
    {
        setTitle("Automated Teller Machine"); //javax.swing

        setLayout(null);//changing default border layout to custom layout

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//awt
        Image i2=i1.getImage().getScaledInstance(100,100 , Image.SCALE_DEFAULT);//rescaling the size of image
        ImageIcon i3=new ImageIcon(i2);//craeating a new object of Imageicon coz we cant pass an object of image class i2 here directly to Jlabel
        
        JLabel label =new JLabel(i3);//Jlabel(class) is used to insert the image in the frame
        label.setBounds(70,10,100,100);//inside the frame
        add(label);//Adding to the frame(image)    

        JLabel text= new JLabel("     JavaBank Jr.");//Jlabel class used to insert the text
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);//Adding to the frame(text)

        JLabel cardno= new JLabel("Card No. :");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,400,30);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin= new JLabel("Pin No. :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login=new JButton("SIGN IN");//Jbutton is a class to add buttons in frame
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);//baground color of button
        login.setForeground(Color.white);//font color function
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        
        singup=new JButton("SIGN UP");
        singup.setBounds(300,350,230,30);
        singup.setBackground(Color.black);
        singup.setForeground(Color.white);
        singup.addActionListener(this);
        add(singup);


        getContentPane().setBackground(Color.white);//function to change the baground colour of the frame(getContentPane is used to access the frame)

        setSize(750,500);//size of frame
        setVisible(true);//Visibilty
        setLocation(300,200);//alignment of frame
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
                cardTextField.setText("");//if we leave seText("") empty then it will show nothing
                pinTextField.setText("");
        }
        else if(ae.getSource() == login)
        {
            Conn conn = new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
               ResultSet rs= conn.s.executeQuery(query);//.executeQuery used for ddl commands //result set used to store the data that is returned 
               if(rs.next())
               {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
               }
               else 
               {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
               }
            }catch(Exception e)
            {
                System.out.println(e);
            }

        }
        else if(ae.getSource() == singup)
        {
            setVisible(false);//to close the login panel
            new SignUpOne().setVisible(true);// to openn the login panel
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}

