
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice, back, bookpackage;
    BookHotel(String username){
        this.username = username;
        
        setBounds(250,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(110,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
           lblusername.setBounds(40,70,200,20);
           lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lblusername);
           
           labelusername = new JLabel();
            labelusername.setBounds(250,70,100,20);
            lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(labelusername);
           
           JLabel lblpackage = new JLabel("Select Hotel");
           lblpackage.setBounds(40,110,150,20);
           lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lblpackage);
           
           chotel = new Choice();
           chotel.setBounds(250,110,200,20);
           add(chotel);
           
           try{
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery("select* from hotel");
               while(rs.next()){
                   chotel.add(rs.getString("name"));
               }
               
           }catch (Exception e){
               e.printStackTrace();
           }
           
           JLabel lblpersons = new JLabel("Total Persons");
           lblpersons.setBounds(40,150,150,25);
           lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lblpersons);
           
           tfpersons = new JTextField("1");
           tfpersons.setBounds(250,150,200,25);
           add(tfpersons);
           
           JLabel lbldays = new JLabel("No. of Days");
           lbldays.setBounds(40,190,150,20);
           lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lbldays);
           
           tfdays= new JTextField("1");
            tfdays.setBounds(250,190,200,25);
           add(tfdays);
           
           JLabel lblac = new JLabel("AC/Non-AC");
           lblac.setBounds(40,230,150,25);
           lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lblac);
           
           cac = new Choice();
           cac.add("AC");
           cac.add("Non-AC");
           cac.setBounds(250,230,200,20);
           add(cac);
           
           
           JLabel lblfood = new JLabel("Food Included");
           lblfood.setBounds(40,270,150,25);
           lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lblfood);
           
           cfood = new Choice();
           cfood.add("Yes");
           cfood.add("No");
           cfood.setBounds(250,270,200,20);
           add(cfood);
           
           JLabel lblphone = new JLabel("Phone");
           lblphone.setBounds(40,310,150,25);
           lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
           
           add(lblphone);
           
           labelphone= new JLabel();
            labelphone.setBounds(250,310,150,25);
           add(labelphone);
           
           JLabel lbltotal = new JLabel("Total Price");
           lbltotal.setBounds(40,350,150,25);
           lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
           
           add(lbltotal);
           
            labelprice = new JLabel();
            labelprice.setBounds(250,350,150,25);
           add(labelprice);
           
           try{
               //make connection with database
               Conn conn = new Conn();
               String query = "select* from customer where username = '"+username+"'";
               //execute this query
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    labelusername.setText(rs.getString("username"));
                    labelphone.setText(rs.getString("phone"));
                    
                }
               
               
           }catch(Exception e){
               e.printStackTrace();
           }
           
            checkprice = new JButton("Check Price");
           checkprice.setBounds(50,390,200,25);
           checkprice.setBackground(Color.BLACK);
           checkprice.setForeground(Color.white);
           checkprice.addActionListener(this);
           add(checkprice);
           
            back = new JButton("Back");
           back.setBounds(270,390,100,25);
           back.setBackground(Color.BLACK);
           back.setForeground(Color.white);
           back.addActionListener(this);
           add(back);
           
            bookpackage = new JButton("Book Hotel");
           bookpackage.setBounds(390,390,200,25);
           bookpackage.setBackground(Color.BLACK);
           bookpackage.setForeground(Color.white);
           bookpackage.addActionListener(this);
           add(bookpackage);
           
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i12 = new JLabel(i3);
        i12.setBounds(500,20,500,300);
        add(i12);
           
           
           
           
           
           
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice)
        {
             try{
               
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from hotel where name = '"+chotel.getSelectedItem()+"'");
            while(rs.next()) {
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acrrom"));
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(persons * days > 0) {
                    int total = 0;
                    total +=  acselected.equals("AC") ? ac : 0; 
                    total += foodselected.equals("Yes")? food : 0;
                    total += cost;
                    total = total * persons * days;
                    labelprice.setText("Rs " + total);
                
                }else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
             }catch(Exception e){
                 e.printStackTrace();
             }
        }else if(ae.getSource() == back){
            setVisible(false);
        
    }else{
        try{
            Conn c = new Conn();
            c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+cac.getSelectedItem()+"','"+tfdays.getText()+"','"+cfood.getSelectedItem()+"','"+labelprice.getText()+"','"+labelphone.getText()+"'");
            
            
            
            JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
            
        }
            
        }
    }
    public static void main(String[] args){
        new BookHotel("kanika Tyagi");
    }
    
}
