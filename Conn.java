package bms;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn()
    {
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);//in the newer versions we dont need to registor the driver explicitly.
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "v!k9839K");
            s=c.createStatement();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
