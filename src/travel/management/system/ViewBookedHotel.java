
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JButton back;
    ViewBookedHotel(String username){
        
           
        
           setBounds(350, 200, 1000, 600);
           getContentPane().setBackground(Color.white);
           setLayout(null);
           
           JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
           text.setFont(new Font("Tahoma",Font.BOLD,20));
           text.setBounds(60,0,400,60);
           add(text);
           
           
           JLabel lblusername = new JLabel("Username");
           lblusername.setBounds(30,50,150,25);
           add(lblusername);
           
           JLabel labelusername = new JLabel();
            labelusername.setBounds(220,50,150,25);
           add(labelusername);
           
           JLabel lblname = new JLabel("Hotel Name");
           lblname.setBounds(30,90,150,25);
           add(lblname);
           
           JLabel labelname= new JLabel();
            labelname.setBounds(220,90,150,25);
           add(labelname);
           
           JLabel lblpersons = new JLabel("Total Persons");
           lblpersons.setBounds(30,130,150,25);
           add(lblpersons);
           
           JLabel labelpersons= new JLabel();
            labelpersons.setBounds(220,130,150,25);
           add(labelpersons);
           
           JLabel lbldays = new JLabel("Total Days");
           lbldays.setBounds(30,170,150,25);
           add(lbldays);
           
           JLabel labeldays= new JLabel();
            labeldays.setBounds(220,170,150,25);
           add(labeldays);
           
           JLabel lblac= new JLabel("AC/Non-AC");
           lblac.setBounds(30,210,150,25);
           add(lblac);
           
           JLabel labelac= new JLabel();
            labelac.setBounds(220,210,150,25);
           add(labelac);
           
           JLabel lblfood= new JLabel("Included-Food");
           lblfood.setBounds(30,250,150,25);
           add(lblfood);
           
           JLabel labelfood= new JLabel();
            labelfood.setBounds(220,250,150,25);
           add(labelfood);
           
          
           
           JLabel lblphone= new JLabel("Phone");
           lblphone.setBounds(30,290,150,25);
           add(lblphone);
           
           JLabel labelphone= new JLabel();
            labelphone.setBounds(220,290,150,25);
           add(labelphone);
           
           JLabel lblprice = new JLabel(" Total-Price");
           lblprice.setBounds(30,330,150,25);
           add(lblprice);
           
           JLabel labelprice = new JLabel();
            labelprice.setBounds(220,330,150,25);
           add(labelprice);
           
           
           back = new JButton("Back");
           back.setBounds(130,360,100,25);
           back.setBackground(Color.BLACK);
           back.setForeground(Color.white);
           back.addActionListener(this);
           add(back);
           
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
           Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(450,20,500,400);
           add(image);
           
           try{
               //make connection with database
               Conn conn = new Conn();
               String query = "select* from bookhotel where username = '"+username+"'";
               //execute this query
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    labelusername.setText(rs.getString("Username"));
                    labelname.setText(rs.getString("Hotel_Name"));
                    labelpersons.setText(rs.getString("Total_persons"));
                    labeldays.setText(rs.getString("Days"));
                    labelphone.setText(rs.getString("Phone"));
                    labelprice.setText(rs.getString("Price"));
                    labelac.setText(rs.getString("AC"));
                    labelfood.setText(rs.getString("Food"));
                    
                }
               
               
           }catch(Exception e){
               e.printStackTrace();
           }
           
           
           
           
           
           
           
           setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new ViewBookedHotel("kanika Tyagi");
    }
    
}
