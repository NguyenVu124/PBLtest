package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Balance;
import model.bean.Monitoring;
import util.DataSource;
//import util.MySQLConnUtils;

public class WithdrawBalanceDAO {
	public void withdrawBalance(int _ID, float _input) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE BALANCE SET balance = ? WHERE ID = ?";
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(2, _ID);
		pre.setFloat(1, _input);
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}
	
	public Balance getBalance(int _ID) throws SQLException, ClassNotFoundException {
		Balance balance = new Balance();
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		String sql = "SELECT * from BALANCE WHERE ID = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _ID);
		ResultSet rs = pre.executeQuery();
		if (rs.next()) {
			balance.setID(rs.getInt(1));
			balance.setBalance(rs.getFloat(2));
			DataSource.releaseConnection(conn);
			return balance;
		}
		DataSource.releaseConnection(conn);
		return null;
	}
	
	public void insertMonitoring(Monitoring _monitoring) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO MONITORING (ID, time, description,type) VALUES (?, ?, ?, ?)";
		//Connection conn = MySQLConnUtils.getMySQLConnection();
		Connection conn = DataSource.getConnection();
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, _monitoring.getID());
		pre.setString(2, _monitoring.getTime());
		pre.setString(3, _monitoring.getDescription());
		pre.setString(4, _monitoring.getType());
		pre.executeUpdate();
		DataSource.releaseConnection(conn);
	}
}
