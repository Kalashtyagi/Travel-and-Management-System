
package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    //use multithreading to make progress 0 to 100
    Thread t; //c object name of thread class
    JProgressBar bar; //declare globally
    String username;
    
    //overide run method
    public void run(){
        try{
            for(int i=1; i<=101; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue(); //current value
                if(value< max){
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false); //when more than 100
                    new DashBoard(username);
                }
                Thread.sleep(50); //speed of loader
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    Loading(String username){
        this.username = username;
        //thread class call run method
        t = new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
        //add progress bar using JProgrss class
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true); //progress show 0 percent
        add(bar);
        
        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(230,130,180,40);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);
        
        
       JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20,310,600,40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblusername);
       
        
        
        t.start(); //call start method
        setVisible(true);
        
        
    }
    public static void main(String[] args){
        new Loading("");
    }
    
}
