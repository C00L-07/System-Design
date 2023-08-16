package inJDBCutil;

import java.sql.*;
import java.util.*;
import java.io.*;

public class JDBCutil {
    public static Connection getJDBcConnection() throws IOException, SQLException {
        FileInputStream fis = new FileInputStream("Application.properties");
        Properties p = new Properties();
        p.load(fis);

        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");

        System.out.println(url);
        System.out.println(user);
        System.out.println(password);

        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void closeResource(Connection conn , PreparedStatement pst) throws SQLException {
        if(conn != null){
            conn.close();
        }
        if(pst != null){
            pst.close();
        }

    }
}
