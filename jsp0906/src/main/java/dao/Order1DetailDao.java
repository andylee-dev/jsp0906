package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Order1;
import dto.Order1Detail;

public class Order1DetailDao {
	private static Order1DetailDao instance;

	public static Order1DetailDao getInstance() {
		if (instance == null) {
			instance = new Order1DetailDao();
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
	public int insert(Order1Detail order_detail) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		String sql = "INSERT INTO order1_detail VALUES(?,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_detail.getOrder_date());
			pstmt.setInt(2, order_detail.getCust_code());
			pstmt.setInt(3, order_detail.getItem_code());
			pstmt.setString(4, order_detail.getItem_order_desc());
			pstmt.setString(5, order_detail.getCancel());
			pstmt.setInt(6, order_detail.getItem_count());
			result = pstmt.executeUpdate(); 
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
		return result;
	}
	
	public List<Order1Detail> list(String order_date, int cust_code) throws SQLException {
		List<Order1Detail> list = new ArrayList<Order1Detail>();
		Connection conn = null;	
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = " SELECT  o.order_date , o.cust_code , o.item_order_desc , o.item_code ,o.item_count "
				+    "        ,c.cust_name   , i.item_name          "
				+    " FROM   order1_detail o, custom c, item i    "
				+    " WHERE  o.order_date  = ?                    "
				+    " AND    o.cust_code  = ?                      "
				+    " AND    o.cust_code  = c.cust_code             "
				+    " AND    o.item_code = i.item_code(+)         ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_date);
			pstmt.setInt(2, cust_code);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order1Detail order1_detail = new Order1Detail();
				order1_detail.setOrder_date(rs.getString("order_date"));
				order1_detail.setCust_code(rs.getInt("cust_code"));
				order1_detail.setCust_name(rs.getString("cust_name"));
				order1_detail.setItem_order_desc(rs.getString("item_order_desc"));
				order1_detail.setItem_code(rs.getInt("item_code"));
				order1_detail.setItem_name(rs.getString("item_name"));
				order1_detail.setItem_count(rs.getInt("item_count"));
				list.add(order1_detail);
			}
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return list;
	}
}
