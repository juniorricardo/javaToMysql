package primerSQL.Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorDB {

	private static String login = "root";
	private static String password = "1234";
	private static String url = "jdbc:mysql://localhost:3306/employees";
	private static Connection connection_;
	private static Statement st_ = null;

	public ConectorDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection_ = DriverManager.getConnection(url, login, password);
			if (connection_ != null) {
				st_ = connection_.createStatement();
				System.out.println("Conexion ok");
			} else
				System.out.println("fail");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
