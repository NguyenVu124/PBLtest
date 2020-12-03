package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.MySQLConnUtils;

public class DeleteAccountDAO {
	public void deleteAccount(int _ID) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM ACCOUNT WHERE ID = ?";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		pre.executeUpdate();
	}
}
