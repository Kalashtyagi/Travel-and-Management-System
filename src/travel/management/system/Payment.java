
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Payment extends JFrame implements ActionListener{
    JButton pay,back;
    
    Payment(){
        setBounds(350,50,800,650);
        setLayout(null);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT );
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,800,600);
        add(image);
        
           
            pay = new JButton("Pay");
           pay.setBounds(420,0,100,30);
           //pay.setBackground(Color.BLACK);
           //pay.setForeground(Color.white);
           pay.addActionListener(this);
           image.add(pay);
           
            back = new JButton("Back");
           back.setBounds(520,0,100,30);
//           back.setBackground(Color.BLACK);
//           back.setForeground(Color.white);
           back.addActionListener(this);
           image.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){
            setVisible(false);
            new Paytm();
            
        }else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Payment();
    }
    
}
