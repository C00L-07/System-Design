package CRUDOP;

import com.mysql.cj.util.StringUtils;
import inJDBCutil.JDBCutil;

import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQuery {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;


        try{
            conn = JDBCutil.getJDBcConnection();

            if(conn != null){
                Scanner sc = new Scanner(System.in);
                String mySQLquery = "update student set result = ? where id = ?";

                pst = conn.prepareStatement(mySQLquery);

                if(pst != null){
                    System.out.println("Enter the id ");
                    int id = sc.nextInt();

                    System.out.println("Enter the updated result ");
                    String result = sc.next();

                    pst.setString(1,result);
                    pst.setInt(2,id);

                    int roweffected = pst.executeUpdate();

                    if(roweffected > 0) System.out.println("Row inserted");
                    else System.out.println("Not inserted");
                }



            }
        } catch (SQLException | IOException e) {
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
