
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DashBoard extends JFrame implements ActionListener{
    String username;
    JButton DeletePersonalDetails,notepad,about,calculator,payments,viewBookedHotel,bookhotel,addPersonalDetails,viewPersonalDetails,updatePersonalDetails,checkpackage,viewhotels,bookpackage,viewpackage;
    DashBoard(String username){
//setBounds(0,0,1600,1000); //full screen size
 // if don't know the size of your screen
 this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); //full lappy screen
        setLayout(null); //if want ur own layout
        
        JPanel p1 = new JPanel(); //Header Panel
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2 = new JPanel(); //Header Panel
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60)); //top left bottom rigth
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30)); //top left bottom rigth
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130)); //top left bottom rigth
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        DeletePersonalDetails = new JButton("Delete Personal Details");
        DeletePersonalDetails.setBounds(0,150,300,50);
        DeletePersonalDetails.setBackground(new Color(0,0,102));
        DeletePersonalDetails.setForeground(Color.white);
        DeletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        DeletePersonalDetails.setMargin(new Insets(0,0,0,40)); //top left bottom rigth
        DeletePersonalDetails.addActionListener(this);
        p2.add(DeletePersonalDetails);
        
        checkpackage = new JButton("Check Package");
        checkpackage.setBounds(0,200,300,50);
        checkpackage.setBackground(new Color(0,0,102));
        checkpackage.setForeground(Color.white);
        checkpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackage.setMargin(new Insets(0,0,0,110)); //top left bottom rigth
        checkpackage.addActionListener(this);
        p2.add(checkpackage);
        
        bookpackage = new JButton("Book Package");
        bookpackage .setBounds(0,250,300,50);
        bookpackage .setBackground(new Color(0,0,102));
        bookpackage .setForeground(Color.white);
        bookpackage .setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackage .setMargin(new Insets(0,0,0,120)); //top left bottom rigth
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        
        viewpackage = new JButton("View Package");
        viewpackage .setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setForeground(Color.white);
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage.setMargin(new Insets(0,0,0,120)); //top left bottom rigth
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        viewhotels = new JButton("View Hotels");
        viewhotels .setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,130)); //top left bottom rigth
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
         bookhotel = new JButton("Book Hotel");
        bookhotel .setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,140)); //top left bottom rigth
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel .setBounds(0,450,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,75)); //top left bottom rigth
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        payments = new JButton("Payments");
        payments .setBounds(0,500,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155)); //top left bottom rigth
        payments.addActionListener(this);
        p2.add(payments);
        
        calculator = new JButton("Calculator");
        calculator .setBounds(0,550,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,145)); //top left bottom rigth
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0,600,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,155)); //top left bottom rigth
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about .setBounds(0,650,300,30);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,175)); //top left bottom rigth
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT );
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(350,70,1400,70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        image.add(text); //add on image
        
        
   
        
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }else if(ae.getSource() == viewPersonalDetails){
            new  ViewCustomer(username);
        }else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == checkpackage){
            new CheckPackage();
            
        }else if(ae.getSource() == bookpackage){
            new BookPackage(username);
        }else if(ae.getSource() == viewpackage){
            new ViewPackage(username);
        }else if(ae.getSource() == viewhotels){
            new CheckHotels();
        }else if(ae.getSource() == bookhotel){
            new BookHotel(username);
        }else if(ae.getSource() == viewBookedHotel){
            new ViewBookedHotel(username);
        }else if(ae.getSource() == payments){
            new Payment();
    }else if(ae.getSource() == notepad){
        try{ 
            Runtime.getRuntime().exec("notepad.exe");
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource() == about){
            new About();
    }else if(ae.getSource() == calculator){
            try{
                  Runtime.getRuntime().exec("calc.exe");
                  //can run desktop application with the help of desktop application
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }else if(ae.getSource() == DeletePersonalDetails){
            new DeleteDetails(username);
    }}
    public static void main(String[] args){
        new DashBoard("");
        
    }
    
}
