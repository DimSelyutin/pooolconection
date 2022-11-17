package by.test.jd2.conectionpool.src;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import by.test.jd2.conectionpool.src.ConnectionPool;



public class Main {
    public static void main(String[] args) throws ConnectionPoolException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, ClassNotFoundException {
        

        
        Constructor<ConnectionPool> constructor = ConnectionPool.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ConnectionPool conPool = constructor.newInstance();
        
        
        Connection con = null;
        Statement st = null;

        conPool.initPoolData();
        
        con = conPool.takeConnection();
        st = con.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM users");
        while(rs.next()){
            System.out.println(rs.getString(1)+" - "+rs.getString(2));
        }
        
        System.out.println(con.isClosed());
        
        conPool.dispose();
        
        System.out.println(con.isClosed());
        
       
        
        

       
    }
}