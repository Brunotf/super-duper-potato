package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBUtil {
	// private final static String USERNAME = "crudcon";
	// private final static String PASSWORD = "abc123";
	// private final static String URLDB = "jdbc:sqlserver://localhost:20000";
//	private static DBUtil instancia;
	private Connection con;

	// private DBUtil() {
	// try {
	// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	//// con = DriverManager.getConnection(URLDB, USERNAME, PASSWORD);
	// con =
	// DriverManager.getConnection("jdbc:sqlserver://localhost;database=ControleEstoque;user=LeonardoMoura;password=leonardomoura");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public static DBUtil getInstance() {
	//
	// if (instancia == null)
	// instancia = new DBUtil();
	// return instancia;
	// }

	public Connection getConnection() {

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost/ControleEstoque;instance=ASGARD;",
					"crudcon", "abc123");
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
}
