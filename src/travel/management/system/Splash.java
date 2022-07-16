
package travel.management.system; 

import javax.swing.*; //swing package contains inside java extended(javax) package
import java.awt.*; //abstract window toolkit

public class Splash extends JFrame implements Runnable{ //JFrame class of swings
    //multithreading is allowed in java with the use of interface not with the use of class thats why we used implements
    //when we implements Runnable interface we use thread object.
    Thread thread; //used to do multitasking
    
    Splash() { //constructor name has same name as its class name
//        setSize(1200,600); //length and breadth of the frame (setsize function defines the size of the frame
        
        //change location of frame as it's by default or origin at top left corner
//        setLocation(100,100); //100 from left(x-axis) and 100 from top(y-axis)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg")); //create object of ImageIcon class to add image 
        //getSystemResource is the ClassLoader class function to pick the resource from the system
        
        
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT); //scaled image
        ImageIcon i3 = new ImageIcon(i2); //can't directly place i2 inside frame thats why we used it.
        JLabel image = new JLabel(i3); 
        add(image); //place splash image using JLabel class inside frame
        thread = new Thread(this);
        thread.start(); //call run method
        // can't call directly as run() coz it doesn't behave as multithreading function
        setVisible(true); //set frame visible as it by default false
        
    }
    public void run(){ //implement runnable method
        try{
            Thread.sleep(7000); // 1 s = 1000 ms //splash screen close after 7 sec
            setVisible(false);
            new Login();
        }catch(Exception e){
            
        }
        
    }
    
    public static void main(String[] args){
       Splash frame = new Splash(); //constructor call when we create object of our class
       int x =1;
       for( int i =1; i<=500; x +=7,i+=6 ){
           frame.setLocation(650-i,350-(i/2)); //dynamically location
           frame.setSize(x + i, x);
           try{
               Thread.sleep(10);
           }catch(Exception e) {}
       }
        
        
    }
    
}
