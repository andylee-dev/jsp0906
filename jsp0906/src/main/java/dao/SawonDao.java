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

import dto.Sawon;

public class SawonDao {
	private static SawonDao instance;
	public static SawonDao getInstance() {
		if(instance == null) {
			instance = new SawonDao();
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
	
		String sql = "SELECT count(*) FROM sawon";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				result = rs.getInt(1);
			}else {
				throw new Exception("Unknown");
			}

		}catch (Exception e) {
			System.out.println("getTotalCnt-err:"+e.getMessage());
		}finally {
			if(rs != null) rs.close();			
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		return result;		
	}

	public List<Sawon> list(int startRow, int endRow) throws SQLException{
		Connection conn = null;
		String sql = "SELECT * FROM "
				+ "(SELECT rownum rn, a.* FROM "
					+ "(SELECT sawon.* FROM sawon ORDER BY sabun) "
				+ "a)WHERE rn BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Sawon> sawonList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sawonList = new ArrayList<Sawon>();
				do {
					Sawon sawon = new Sawon();
					sawon.setName(rs.getString("name"));
					sawon.setSabun(rs.getInt("sabun"));
					sawon.setSal(rs.getInt("sal"));
					sawon.setHandphone(rs.getString("handphone"));
					sawonList.add(sawon);
				}while(rs.next());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(rs != null) rs.close();			
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return sawonList;
	}
	public int insert(Sawon sawon) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "SELECT NVL(max(sabun),0) FROM sawon";
		String sql = "INSERT INTO sawon VALUES (?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			int sabun = rs.getInt(1) + 1;
			rs.close();
			pstmt.close();

			sawon.setSabun(sabun);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, sawon.getName());
			pstmt.setInt(3, sawon.getSal());
			pstmt.setString(4, sawon.getHandphone());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
		return result;
	}
	
	public Sawon select(int sabun) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM sawon WHERE sabun=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Sawon sawon = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,sabun);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				sawon = new Sawon();
				sawon.setSabun(rs.getInt("sabun"));
				sawon.setName(rs.getString("name"));
				sawon.setSal(rs.getInt("sal"));
				sawon.setHandphone(rs.getString("handphone"));
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(rs != null) rs.close();			
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
		return sawon;
	}
	public int update(Sawon sawon) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("update"+sawon.getSabun());
		String sql = "UPDATE sawon SET name=?, sal=?, handphone=? WHERE sabun=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sawon.getName());
			pstmt.setInt(2, sawon.getSal());
			pstmt.setString(3, sawon.getHandphone());
			pstmt.setInt(4, sawon.getSabun());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return result;
	}
	
	public int delete(int sabun) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0xff;
		try {
			String sql = "DELETE sawon WHERE sabun=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return result;
	}
}
