/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim.base;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import nanicolinashsim.ResourceAgent;
import nanicolinashsim.Widget;
import nanicolinashsim.utils.ResourceTypes;
import nanicolinashsim.widgets.Bed;
import nanicolinashsim.widgets.Cooker;
import nanicolinashsim.widgets.Refrigerator;
import nanicolinashsim.widgets.TV;
import nanicolinashsim.Position;

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

        /*Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM " + tableName + ";");
        System.out.println("DEBUG: SELECT * FROM " + tableName);
        while (rs.next()) {
            System.out.println("  Agente de Recurso\n  URN: " + rs.getString("URN"));
            System.out.println("  Type: " + rs.getString("TYPE"));
        }
        System.out.println("END");
        rs.close();
        */
        conn.commit();
        conn.close();        
    }

    public static List<Widget> getAllRA() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:nshsim.db");
               
        String tableName = "registered_ra";
        
        //These options to disable and enable setAutoCommit are used to make transactions faster
        conn.setAutoCommit(false);

        List<Widget> list = new ArrayList<Widget>(); //Widgets to be returned by this method
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM " + tableName + ";");
        System.out.println("DEBUG: SELECT * FROM " + tableName);
        //Iterating over the query result to get the RA (Widgets)
        while (rs.next()) {
            System.out.println("  Agente de Recurso\n  URN: " + rs.getString("URN"));
            System.out.println("  Type: " + rs.getString("TYPE"));            

            //Auxiliary vars
            String urn = rs.getString("URN");
            String url = "localhost"; //TODO: chose what to do concerning the URL
            Position pos = null;
            Widget w;
            //Specialize the Widget if the database contains the type associated
            switch (rs.getInt("TYPE")) {
                case ResourceTypes.COOKER:
                    w = new Cooker(urn, url, pos);
                    break;
                case ResourceTypes.REFRIGERATOR:
                    w = new Refrigerator(urn, url, pos);
                    break;
                case ResourceTypes.TV:
                    w = new TV(urn, url, pos);
                    break;
                case ResourceTypes.BED:
                    w = new Bed(urn, url, pos);
                    break;
                default:
                    w = new Widget(rs.getString("URN"), url, pos);
                    break;
            }
            list.add(w);
        }
        System.out.println("END");
        conn.commit();
        rs.close();
        conn.close();

        return list;
    }
}
