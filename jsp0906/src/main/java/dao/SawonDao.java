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
	public List<Sawon> list() throws SQLException{
		Connection conn = null;
		String sql = "SELECT * FROM sawon";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Sawon> sawonList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
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
	public Sawon select(int sabun) throws SQLException {
		Connection conn = null;
		String sql = "SELECT * FROM sawon WHERE id=?";
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
				sawon.setName(rs.getString("name"));
				sawon.setSabun(rs.getInt("sabun"));
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
}
