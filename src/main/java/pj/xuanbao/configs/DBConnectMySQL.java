package pj.xuanbao.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {

	private static String USERNAME = "root";
	   private static String PASSWORD = "xuanbao";
	   private static String DRIVER = "com.mysql.jdbc.Driver";
	   private static String URL = "jdbc:mysql://localhost:3306/webprchieu5";

	   public static Connection getDatabaseConnection() throws SQLException, Exception{
	       
	       try 
	       {
	    	   Class.forName(DRIVER);
	    	   return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	       }catch(SQLException e) {
	    	   e.printStackTrace();
	       }
	       return null;
	   }
	   
	   public static void main(String[] args) {
		   try {
			   new DBConnectMySQL();
			   System.out.println(DBConnectMySQL.getDatabaseConnection());
		   } catch (Exception e){
			   e.printStackTrace();
		   }
	   }
}
