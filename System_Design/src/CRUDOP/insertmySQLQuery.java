package CRUDOP;

import inJDBCutil.JDBCutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertmySQLQuery {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;


        try{
            conn = JDBCutil.getJDBcConnection();

            if(conn != null){
               String mySQLquery = "insert into student(name,rollno,result) values (?,?,?)";

               pst = conn.prepareStatement(mySQLquery);

               if(pst != null){
                   pst.setString(1,"AVI");
                   pst.setInt(2,124);
                   pst.setString(3,"Pass");

                   int roweffected = pst.executeUpdate();
                   if(roweffected > 0) System.out.println("Row inserted");
                   else System.out.println("Not inserted");
               }



            }
        } catch (SQLException  | IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                JDBCutil.closeResource(conn,pst);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
