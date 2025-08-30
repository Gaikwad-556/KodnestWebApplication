package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DatabaseUtils {
	private static Connection con;
	private static final String dburl = System.getenv("URL_DB");
	private static final String dbpassword = System.getenv("PASSWORD_DB");
	private static final String dbuser= System.getenv("USER_DB");
	
	private static List<Map<String,String>> testData(String query, Object...parms ) throws SQLException {
		List<Map<String,String>> rows = new LinkedList<>();
		 try {
			con = DriverManager.getConnection(dburl, dbuser ,dbpassword);
			PreparedStatement ps = con.prepareStatement(query);
		
			for(int i=0; i<parms.length; i++) {
				ps.setObject(i+1, parms[i]);
			}
		
			ResultSet rs = ps.executeQuery() ;
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			
			while(rs.next()) {
				Map<String, String> row = new LinkedHashMap<>();
				
				for(int i=1; i<=colCount; i++) {
					String colName = metaData.getColumnLabel(i);
					String value = rs.getString(i);
					row.put(colName, value);
				}
				rows.add(row);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		 return rows;
	}
	
	public static List<Map<String, String>> getTestData(String prams1, String prams2, String queryOf) throws FileNotFoundException, IOException, SQLException {
		Properties props = new Properties();
		props.load(new FileInputStream("C:\\Users\\hp\\git\\repository2\\KodnestApp\\src\\queries.properties"));
		String query = props.getProperty(queryOf);
		
		return testData(query, prams1, prams2);
	}
	
	public static void close() throws SQLException {
		con.close();
	}
}
