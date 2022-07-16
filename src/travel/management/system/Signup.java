
package travel.management.system;

import java.awt.*; //abstract window toolkit
import java.awt.event.*;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
    //define button and textfield globally to use it outside 
    JButton create,back;
    JTextField tfname, tfusername, tfpassword, tfans;
    Choice sec;
    
    
    Signup(){
        getContentPane().setBackground(Color.white);
        setBounds(300,200,900,360); //frame ( x y l b) ,setbound is combination of setsize and setlocation
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,450,460); //worlk when layout will be null
        p1.setLayout(null);
        add(p1);
        
        //add label with the use of Jlabel class
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Tohoma",Font.BOLD,14));
        username.setBounds(50,20,125,25);
        p1.add(username);
        
        //add textfilled in front of username label using JTextField class
         tfusername = new JTextField();
        tfusername.setBounds(180,20,180,25); // x y l b according to username label
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        setVisible(true);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tohoma",Font.BOLD,14));
        name.setBounds(50,60,125,25);
        p1.add(name);
        
        //add textfilled in front of username label using JField class
        tfname = new JTextField();
        tfname.setBounds(180,60,180,25); // x y l b according to username label
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Tohoma",Font.BOLD,14));
        password.setBounds(50,100,125,25);
        p1.add(password);
        
        //add textfilled in front of username label using JField class
        tfpassword = new JTextField();
        tfpassword.setBounds(180,100,180,25); // x y l b according to username label
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel security = new JLabel("Security Question");
        security.setFont(new Font("Tohoma",Font.BOLD,14));
        security.setBounds(50,140,125,25);
        p1.add(security);
       
        // to create a dropdown using Choice
        sec = new Choice();
        sec.add("Your Favourite Subject");
        sec.add("Your favourite fruit");
        sec.add("Favourite color");
        sec.add("Favourite cartoon");
        sec.setBounds(180,140,180,25);
        p1.add(sec);
        
        JLabel ans = new JLabel("Answer");
        ans.setFont(new Font("Tohoma",Font.BOLD,14));
        ans.setBounds(50,180,125,25);
        p1.add(ans);
        
        //add textfilled in front of username label using JField class
        tfans = new JTextField();
        tfans.setBounds(180,180,180,25); // x y l b according to username label
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
        
        create = new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.white);
        create.setForeground(new Color(131,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.white);
        back.setForeground(new Color(131,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this); //call actionperformed method internally
        p1.add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT); //set size of image
        ImageIcon i3 = new ImageIcon(i2); //can't set Image on JLabel first convert it into Imageicon coz Jlabel constructor accept only imagelabel object
        JLabel image = new JLabel(i3);
        image.setBounds(600,50,250,250);
        add(image);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae )  {  //override actionperformed methods
        
      //what all perfomed when we click on button
      if (ae.getSource() == create){
          //get values from user
          String username = tfusername.getText();
          String tname = tfname.getText();
          String password = tfpassword.getText();
          String question = sec.getSelectedItem();
          String answer = tfans.getText();
          
          //insert data into database table
          String query = "insert into account values('"+username+"', '"+tname+"','"+password+"','"+question+"','"+answer+"')";
          try{
              //connecton establish
              Conn c = new Conn();
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Account created Successfully"); //show pop up if account datasave succ.
              setVisible(false);
              new Login();
              
          }catch(Exception e){
              e.printStackTrace();
              
          }
      }else if (ae.getSource() == back){
          setVisible(false);
          new Login();
          
      }
    }
    public static void main(String[] args){
        new Signup();
    }
    
}
