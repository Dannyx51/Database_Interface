package Checkpoint4.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Checkpoint4.GRS;

/**
 * 
 * All database connectivity should be handled from within here.
 *
 */
public class SQL {
	
	private static PreparedStatement ps;
	
    /**
     * Queries the database and prints the results.
     * 
     * @param conn a connection object
     * @param sql a SQL statement that returns rows:
     * 		this query is written with the Statement class, typically 
     * 		used for static SQL SELECT statements.
     */
    public static void sqlQuery(Connection conn, String sql){
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int columnCount = rsmd.getColumnCount();
        	for (int i = 1; i <= columnCount; i++) {
        		String value = rsmd.getColumnName(i);
        		System.out.print(value);
        		if (i < columnCount) System.out.print(",  ");
        	}
			System.out.print("\n");
        	while (rs.next()) {
        		for (int i = 1; i <= columnCount; i++) {
        			String columnValue = rs.getString(i);
            		System.out.print(columnValue);
            		if (i < columnCount) System.out.print(",  ");
        		}
    			System.out.print("\n");
        	}
        	rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Queries the database and prints the results.
     * 
     * @param conn a connection object
     * @param sql a SQL statement that returns rows:
     * 		this query is written with the PrepareStatement class, typically 
     * 		used for dynamic SQL SELECT statements.
     */
    public static void sqlQuery(Connection conn, PreparedStatement sql){
        try {
        	ResultSet rs = sql.executeQuery();
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int columnCount = rsmd.getColumnCount();
        	for (int i = 1; i <= columnCount; i++) {
        		String value = rsmd.getColumnName(i);
        		System.out.print(value);
        		if (i < columnCount) System.out.print(",  ");
        	}
			System.out.print("\n");
        	while (rs.next()) {
        		for (int i = 1; i <= columnCount; i++) {
        			String columnValue = rs.getString(i);
            		System.out.print(columnValue);
            		if (i < columnCount) System.out.print(",  ");
        		}
    			System.out.print("\n");
        	}
        	rs.close();
        	ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Create PreparedStatement to search a table by [coach/player/team] name.
     * 
     * @param sql query for prepared statement
     * 
     * @param name name to search by 
     */
    public static void ps_SearchName(String sql, String name){
    	try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, name);
    		
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	sqlQuery(GRS.conn, ps);
    }
    
    /**
     * Create PreparedStatement to add an entry to a table.
     * 
     * @param sql query for prepared statement
     * 
     * @param name name to add
     */
    public static void ps_Add_Delete_Entry(String sql, String name){
    	try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, name);
    		
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	sqlQuery(GRS.conn, ps);
    }
    
    public static void ps_UpdateEntry(String sql, String old_name, String new_name) {
    	try {
    		ps = GRS.conn.prepareStatement(sql);
    		ps.setString(1, old_name);
    		ps.setString(2, new_name);
    		
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	sqlQuery(GRS.conn, ps);
    }
}
