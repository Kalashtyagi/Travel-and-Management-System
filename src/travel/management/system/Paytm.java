
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class Paytm extends JFrame implements ActionListener{
    JButton back;
    
    Paytm(){
        setBounds(500,200,800,600);
        
        //jeditorpane class work as jtextarea but can easily add scroller
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

      try{
          pane.setPage("https://paytm.com/rent-payment");
          
      }catch(Exception e){
          pane.setContentType("text/html");
          pane.setText("<html> Could not load, Error 405 </html>");
      }    
      
      JScrollPane sp = new JScrollPane(pane); //create it  before embedded scrollbar with argument pane 
      getContentPane().add(sp); //get all frame by getContentPane class and then add scroolpane there
      
       back = new JButton("Back");
           back.setBounds(610,20,80,40);
//           back.setBackground(Color.BLACK);
//           back.setForeground(Color.white);
           back.addActionListener(this);
           pane.add(back); 
           
      setVisible(true);
      
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == back){
            setVisible(false);
            new Payment();
        }
    }
    public static void main(String[] args){
        new Paytm();
    }
    
}
