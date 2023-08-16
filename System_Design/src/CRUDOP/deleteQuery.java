package CRUDOP;

import inJDBCutil.JDBCutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteQuery {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;


        try{
            conn = JDBCutil.getJDBcConnection();

            if(conn != null){
                Scanner sc = new Scanner(System.in);
                String mySQLquery = "delete from student where id = ?";

                pst = conn.prepareStatement(mySQLquery);

                if(pst != null){
                    System.out.println("Enter the id ");
                    int id = sc.nextInt();
                    pst.setInt(1,id);

                    int roweffected = pst.executeUpdate();

                    if(roweffected > 0) System.out.println("Row deleted");
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
