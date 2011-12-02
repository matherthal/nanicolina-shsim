/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim.base;

import java.sql.*;
import nanicolinashsim.ResourceAgent;

public class DB {
    private static DB obj = null;

    private DB() {
        
    }

    public static DB getInstance() {

        if (obj == null) {
            obj = new DB();
        }

        return obj;
    }

    public static void persistRA(ResourceAgent ra, int type) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:nshsim.db");
        //Statement stat = conn.createStatement();

        //Dropping table
        //stat.executeUpdate("drop table if exists people;");

        //Create table command
        //stat.executeUpdate("create table people (NAME, TYPE);");

        //Insert data
        String tableName = "registered_ra";
        //Passing NULL as the parameter for ID in SQLITE is the same as send "(SELECT MAX(ID) FROM registered_ra)+1"
        //It makes the autoincrement works
        PreparedStatement prep = conn.prepareStatement("INSERT INTO " + tableName + " VALUES (NULL, ?, ?);");        

        prep.setString(1, ra.getURN());
        prep.setString(2, String.valueOf(type));
        prep.addBatch();

        //These options to disable and enable setAutoCommit are used to make transactions faster
        conn.setAutoCommit(false);
        prep.executeBatch();
        //conn.setAutoCommit(true);
        //conn.commit();

        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM " + tableName + ";");
        System.out.println("DEBUG: SELECT * FROM " + tableName);
        while (rs.next()) {
            System.out.println("  Agente de Recurso\n  URN: " + rs.getString("URN"));
            System.out.println("  Type: " + rs.getString("TYPE"));
        }
        conn.commit();
        rs.close();
        conn.close();
        System.out.println("END");
    }
}
