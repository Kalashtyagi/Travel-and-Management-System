//we  use Java database connnectivity (JDBC) for database connectivity
//5 steps of JDBC 1. Register the driver Class (Mysql driver) 2. Creating connection String
//3. creating the statement 4. Executing mysql queries(with the help of java) basically jdbc help mysql queries executew with the help of execute
//4. closing the connecton(it is opitional)
package travel.management.system;

import java.sql.*; //contain connection class


public class Conn {
    
    Connection c;
    Statement s;
    Conn(){ //no main method coz just use object only of this class does't run it.
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //initialise driver using forname with argument(address pass of driver
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","sbjilu11"); //establish connection
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
