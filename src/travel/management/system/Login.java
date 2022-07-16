
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*; //we have to import subpackage of java swing separetly
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,password; //declare globally
    JTextField tfusername,tfpassword;
    Login(){
        setSize(900,400); //size of frame (length and breadth)
        setLocation(200,200); //location from x and y axis
        setLayout(null); //don't want to use swing layout i.e null //use own layout
         getContentPane().setBackground(Color.white); //get access to entire panel and change color of panel 
        //divide frame into 2 parts using panel class
        JPanel p1 = new JPanel();
        p1.setBackground(Color.gray); //add color using JPanel obj (Foreground- text color) //RGB 
        p1.setBounds(0,0,400,400); //divide 900/2 = 450
        p1.setLayout(null);
        add(p1);
        //layout:- way to frame components in your panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); //scaled image
        ImageIcon i3 = new ImageIcon(i2); //convert it into imageicon
        JLabel image = new JLabel(i3); //can't place image directly
        image.setBounds(90,60,200,200); //work when setlayout function will be run
        p1.add(image); //add image on panel
        
        
        JPanel p2 = new JPanel(); //panel for login details
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        //main work of JLabel to write text on the frame, imageicon is not main work
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("sANS_SERIF",Font.PLAIN,20));
        p2.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder()); //remove border from textfield
        p2.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("sANS_SERIF",Font.PLAIN,20));
        p2.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder()); //remove border from textfield
        p2.add(tfpassword);
        
        //add login button with the help of JButton class
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password?");
        password.setBounds(150,250,130,30);
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in Login...?");
        text.setBounds(20,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        
        
        
        
        
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
                //extract login details to match from databae i.e authentication
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                //match credentials from database to apply query
                String query = "select* from account where username = '"+username+"' AND password = '"+pass+"'";
                //create connection with mysql
                Conn c = new Conn();
                //if query match it will store inside resultset
                ResultSet rs = c.s.executeQuery(query); //import sql package to use it.
                //check if this value contain inside resultset
                //if single value then use if otherwise while(if have only one row i.e password and username
                if(rs.next()){ //next func. return true or false to check in rs(value matches or not)
                    setVisible(false);
                    new Loading(username);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
           
            
            
            
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
            
        }else{
            setVisible(false);
            new ForgetPassword();
            
            
        }
    }
    public static void main(String[] args){
        new Login(); //anonymous object(when we don't want to use our object name further)
        
    }
}

   
