package jdbcjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Purpose: This class is used for establish connection between java progaram and Database
 * @author SURJYAMANI DUAN
 */

public class EmployeeConfig {

	private static Connection connection = null;
	/**
	 * Using static block creating the connection
	 */
	static {
		String URL_JD = "jdbc:mysql://localhost:3306/payroll_service";
		String USER_NAME = "root";
		String PASSWORD = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL_JD, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new EmployeeException("invalid driver");
		} catch (SQLException throwable) {
			throw new EmployeeException("Invalid get connection parameters");
		}
	}
	public static Connection getConfig(){
		return connection;
	}

}