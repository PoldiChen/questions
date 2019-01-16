package question022;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlTest {
	
	public static void main(String[] args) throws SQLException {
		test();
	}
	
	public static void test() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.DriverManager");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/performance",
					"root", "123456");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from season");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("year"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

}
