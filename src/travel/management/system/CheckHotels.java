
package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable{
    Thread t1;
    
    //create array for 10 labels for 10 image 
    JLabel l1, l2, l3, l4, l5 ,l6, l7, l8, l9, l10;
    JLabel[] label = new JLabel[]{l1, l2, l3, l4, l5 ,l6, l7, l8, l9, l10};
    JLabel caption;
    
    public void run(){
        String[] text = new String[]{"JW Marriot Hotel", "Madrin Oriental Hotel","Four Season Hotels", "Radiasson blue Hotel", "Classio Hotel", "The Day Club Hotel", "The Raisen Arise Hotel", "The Taj Hotel", "Breeze Blow Hotel","Happy Morning Hotel"};
        
        try{
            //slideshow functionality
            for(int i = 0; i<=9; i++){
                label[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(2500); //hold pic for 2.5 sec
                label[i].setVisible(false); //close 1 screen after 2.5 sec
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
}
    CheckHotels(){
        setBounds(300, 100, 800, 600);
        caption = new JLabel();
        caption.setBounds(50,500,1000,70);
        caption.setFont(new Font("Tahoma", Font.PLAIN,40));
        caption.setForeground(Color.WHITE);
        add(caption);
        
        ImageIcon i1 = null, i2 = null, i3 = null, i4 = null, i5 = null ,i6 = null, i7 = null, i8 = null, i9 = null, i10 = null;
        ImageIcon[] image = new ImageIcon[]{i1, i2, i3, i4, i5 ,i6, i7, i8, i9, i10};
        
        Image J1 = null, J2 = null, J3 = null, J4 = null, J5 = null ,J6 = null, J7 = null, J8 = null, J9 = null, J10 = null;
        Image[] Jimage = new Image[]{J1, J2, J3, J4, J5 ,J6, J7, J8, J9, J10};
        
        ImageIcon k1 = null, k2 = null, k3 = null, k4 = null, k5 = null ,k6 = null, k7 = null, k8 = null, k9 = null, k10 = null;
        ImageIcon[] kimage = new ImageIcon[]{k1, k2, k3, k4, k5 ,k6, k7, k8, k9, k10};
        
    
        for(int i=0 ; i<=9; i++){
        image[i]= new ImageIcon(ClassLoader.getSystemResource("icons/hotel"+(i+1)+".jpg"));
        Jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        kimage[i]  = new ImageIcon(Jimage[i]);
        label[i] = new JLabel(kimage[i]);
        label[i].setBounds(0,0,800,600);
        add(label[i]);
        }
        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }
    public static void main(String[] args){
        new CheckHotels();
    }
    
}
