package Connect;
import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connect {
	private Connection connection = getConnect();
	public Connection getConnect() {
		Connection conn = null;
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/java";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	public User getUserByEmail(String email) {
		User user = new User();
		try {
			String sql = "SELECT * FROM user WHERE email = ?";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
				user.setRole(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setCmnd(rs.getString(8));
				user.setDate(rs.getString(9));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
		
	}
}
