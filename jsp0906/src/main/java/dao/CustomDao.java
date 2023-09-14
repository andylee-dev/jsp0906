package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Custom;

public class CustomDao {
	private static CustomDao instance;
	public static CustomDao getInstance() {
		if(instance == null) {
			instance = new CustomDao();
		}
		return instance;	
	}
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public int getTotalCnt() throws SQLException {
		int result = 0;
		Connection conn = null;
		String sql = "SELECT count(*) FROM custom";
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

	public List<Custom> list(int startRow, int endRow) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM " + "(SELECT rownum rn, a.* FROM " + "(SELECT custom.* FROM custom ORDER BY cust_code) "
				+ "a)WHERE rn BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Custom> customList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				customList = new ArrayList<Custom>();
				do {
					Custom custom = new Custom();
					custom.setCust_code(rs.getInt("cust_code"));
					custom.setCust_name(rs.getString("cust_name"));
					custom.setCust_tel(rs.getString("cust_tel"));
					custom.setCust_gubun(rs.getString("cust_gubun"));
					custom.setCust_ceo(rs.getString("cust_ceo"));
					customList.add(custom);
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
		return customList;
	}

	public int insert(Custom custom) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "SELECT SEQ_CUSTOM.nextval FROM dual";
		String sql = "INSERT INTO custom VALUES (?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			int cust_code = rs.getInt(1) + 1;
			rs.close();
			pstmt.close();

			custom.setCust_code(cust_code);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cust_code);
			pstmt.setString(2, custom.getCust_name());
			pstmt.setString(3, custom.getCust_tel());
			pstmt.setString(4, custom.getCust_gubun());
			pstmt.setString(5, custom.getCust_ceo());
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

	public Custom select(int cust_code) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM custom WHERE cust_code=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Custom custom = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cust_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				custom = new Custom();
				custom.setCust_code(rs.getInt("cust_code"));
				custom.setCust_name(rs.getString("cust_name"));
				custom.setCust_tel(rs.getString("cust_tel"));
				custom.setCust_gubun(rs.getString("cust_gubun"));
				custom.setCust_ceo(rs.getString("cust_ceo"));
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

		return custom;
	}

	public int update(Custom custom) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("update" + custom.getCust_code());
		String sql = "UPDATE custom SET cust_name=?, cust_tel=?, cust_gubun=?, cust_ceo=?  WHERE cust_code=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custom.getCust_name());
			pstmt.setString(2, custom.getCust_tel());
			pstmt.setString(3, custom.getCust_gubun());
			pstmt.setString(4, custom.getCust_ceo());
			pstmt.setInt(5, custom.getCust_code());
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

	public int delete(int cust_code) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0xff;
		try {
			String sql = "DELETE custom WHERE cust_code=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cust_code);
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
