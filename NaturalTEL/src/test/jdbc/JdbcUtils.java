package test.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * v1.0
 * 
 */
public class JdbcUtils {
	private static Properties props = null;
	static {
		// 給 props 進行初始化，及加載dbconfig.properties文件到props對象中
		try {
			InputStream in = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");		
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		// 加載驅動類
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		/*
		 * 	調用 DriverManager.getConnection
		 */
		Connection con =  DriverManager.getConnection(props.getProperty("url"), 
							props.getProperty("username"), 
							props.getProperty("password"));		
		return con;
		
	}
	
	public static void close() {
		
	}

}
