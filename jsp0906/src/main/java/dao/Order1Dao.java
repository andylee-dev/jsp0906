package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Item;
import dto.Order1;

public class Order1Dao {
	private static Order1Dao instance;

	public static Order1Dao getInstance() {
		if (instance == null) {
			instance = new Order1Dao();
		}
		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public int getTotalCnt() throws SQLException {
		int result = 0;
		Connection conn = null;
		String sql = "SELECT count(*) FROM order1";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				throw new Exception("Unknown");
			}

		} catch (Exception e) {
			System.out.println("getTotalCnt-err:" + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}

	public List<Order1> list(int startRow, int endRow) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM " + "(SELECT rownum rn, a.* FROM "
				+ "(SELECT o.*, s.name, c.cust_name "
				+ " FROM order1 o, sawon s, custom c "
				+ " WHERE s.sabun=o.sabun AND c.cust_code=o.cust_code "
				+ " ORDER BY o.order_date desc, o.cust_code) a)WHERE rn BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order1> orderList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				orderList = new ArrayList<Order1>();
				do {
					Order1 order = new Order1();
					order.setOrder_date(rs.getString("order_date"));
					order.setCust_code(rs.getInt("cust_code"));
					order.setOrder_desc(rs.getString("order_desc"));
					order.setSabun(rs.getInt("sabun"));
					order.setOrder_status("order_status");
					order.setCust_name("cust_name");
					order.setSawon_name("sawon_name");
					orderList.add(order);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return orderList;
	}

	public int insert(Order1 order) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO order1 VALUES (?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrder_date());
			pstmt.setInt(2, order.getCust_code());
			pstmt.setString(3, order.getOrder_desc());
			pstmt.setInt(4, order.getSabun());
			pstmt.setString(5, order.getOrder_status());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return result;
	}

	public Order1 select(String order_date, int cust_code) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM order1 WHERE order_date=?, cust_code=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order1 order = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_date);
			pstmt.setInt(2, cust_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				order = new Order1();
				order.setOrder_date(order_date);
				order.setCust_code(cust_code);
				order.setOrder_desc(rs.getString("order_desc"));
				order.setOrder_status(rs.getString("order_status"));
				order.setSabun(rs.getInt("sabun"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return order;
	}

	public int update(Order1 order) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE order1 SET order_desc=?, sabun=?, order_status=?  WHERE order_date=?, cust_code=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getOrder_desc());
			pstmt.setInt(2, order.getSabun());
			pstmt.setString(3, order.getOrder_status());
			pstmt.setString(4, order.getOrder_date());
			pstmt.setInt(5, order.getCust_code());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}

	public int delete(String order_date, int cust_code) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0xff;
		try {
			String sql = "DELETE item WHERE order_date=?, cust_code=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_date);
			pstmt.setInt(2, cust_code);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}


}
