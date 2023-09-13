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

import dto.Item;

public class ItemDao {
	private static ItemDao instance;

	public static ItemDao getInstance() {
		if (instance == null) {
			instance = new ItemDao();
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
		String sql = "SELECT count(*) FROM item";
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

	public List<Item> list(int startRow, int endRow) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM " + "(SELECT rownum rn, a.* FROM " + "(SELECT item.* FROM item ORDER BY item_code) "
				+ "a)WHERE rn BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Item> itemList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				itemList = new ArrayList<Item>();
				do {
					Item item = new Item();
					item.setItem_name(rs.getString("item_name"));
					item.setItem_code(rs.getInt("item_code"));
					item.setItem_price(rs.getInt("item_price"));
					item.setItem_kind(rs.getString("item_kind"));
					item.setItem_desc(rs.getString("item_desc"));
					item.setItem_birth(rs.getDate("item_birth"));
					itemList.add(item);
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
		return itemList;
	}

	public int insert(Item item) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "SELECT NVL(max(item_code),0) FROM item";
		String sql = "INSERT INTO item VALUES (?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			int item_code = rs.getInt(1) + 1;
			rs.close();
			pstmt.close();

			item.setItem_code(item_code);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_code);
			pstmt.setString(2, item.getItem_name());
			pstmt.setInt(3, item.getItem_price());
			pstmt.setString(4, item.getItem_kind());
			pstmt.setString(5, item.getItem_desc());
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

	public Item select(int item_code) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM item WHERE item_code=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Item item = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				item = new Item();
				item.setItem_code(rs.getInt("item_code"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_price(rs.getInt("item_price"));
				item.setItem_kind(rs.getString("item_kind"));
				item.setItem_desc(rs.getString("item_desc"));
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

		return item;
	}

	public int update(Item item) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("update" + item.getItem_code());
		String sql = "UPDATE item SET item_name=?, item_price=?, item_kind=?, item_desc=?  WHERE item_code=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getItem_name());
			pstmt.setInt(2, item.getItem_price());
			pstmt.setString(3, item.getItem_kind());
			pstmt.setString(4, item.getItem_desc());
			pstmt.setInt(5, item.getItem_code());
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

	public int delete(int item_code) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0xff;
		try {
			String sql = "DELETE item WHERE item_code=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_code);
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
