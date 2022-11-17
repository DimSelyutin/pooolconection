package by.test.jd2.conectionpool.src;

import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class Logger {
    public void log(Level lvl, String str, SQLException e){
        System.out.println(lvl +", "+str+", "+e);
    }

    public void log(Level lvl, String str){
        System.out.println(lvl +", "+str);
    }
}
