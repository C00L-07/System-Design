package CRUDOP;

import inJDBCutil.JDBCutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SelectmySQLquesry {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        Scanner sc = new Scanner(System.in);

        try{
            conn = JDBCutil.getJDBcConnection();

            if(conn != null){
                String mySQLquery = "select * from student where id = ?";

                pst = conn.prepareStatement(mySQLquery);

                if(pst != null){
                    System.out.println("Enter the id: ");
                    int id = sc.nextInt();
                    pst.setInt(1,id);

                    rst = pst.executeQuery();

                    if(rst != null){
                        if(rst.next()){
                            System.out.println("ID\tName\tRollNo\tResult");
                            System.out.println(rst.getInt(1)+"\t"+rst.getString(2)+"\t\t"+rst.getInt(3)+"\t\t"+rst.getString(4));
                        }
                    }
                }



            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                JDBCutil.closeResource(conn,pst,rst);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
