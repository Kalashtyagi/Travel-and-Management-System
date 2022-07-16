
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(500,100,600,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("ABOUT");
           l1.setBounds(150,10,100,40);
           l1.setBackground(Color.WHITE);
           l1.setForeground(Color.RED);
           l1.setFont(new Font("Tahoma",Font.BOLD,20));
           add(l1);
           
           String n = "About projects                     \n"  +
                   " \n " +
                   "The Objective of The Travel and Tourism Management system project is to develop a system that automates the processing and activities of a travel and the purpose is to design the system using which can perform all operations related to travelling.\n This Application will help in accesing the information relating to the travel to the particular destination with great ease. The user can track the information related to their tools with great ease through this application. The Travel agency information can also be obtained through the application.   \n" +
                   " \n " +
                   "Advantage of this Project: \n" +
                   "Gives accurate information: \n" +
                   "Simplifies the manual work: \n" +
                   "It minimize the documnetation related work: \n" +
                   "Provides up to date information: \n" +
                   "Travelers details can be provided: \n" +
                   "Booking confirmation notifications";
                   
           
           TextArea area = new TextArea(n, 10, 40, Scrollbar.VERTICAL);
           area.setEditable(false);
           area.setBounds(20,100,450,300);
           add(area);
           
           back = new JButton("Back");
           back.setBounds(200,420,100,30);
          back.setBackground(Color.BLACK);
          back.setForeground(Color.white);
           back.addActionListener(this);
           add(back);
           
           setVisible(true);
           
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new About();
    }
    
}
