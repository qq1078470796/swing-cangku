package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbUtil;
import entity.Lingjian;

public class LingjianDao {
	/**
	 * 添加一个新的零件
	 * @param bgy
	 */
	public void add(Lingjian lj){
		Connection conn=DbUtil.getDbutil().getConnection();
		String sql = "insert into lingjian values(?,?)";
		PreparedStatement pstmt =null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			pstmt.setString(2, lj.getLjname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 通过id删除
	 * @param bgy
	 */
	public void deleteById(Lingjian lj){
		String sql="delete from lingjian where ljnum=?";
		PreparedStatement pstmt=null;
		Connection conn=null;
		conn=DbUtil.getDbutil().getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 通过名字删除
	 * @param bgy
	 */
	public void deleteByName(Lingjian lj){
		String sql="delete from lingjian where ljname=?";
		PreparedStatement pstmt=null;
		Connection conn=null;
		conn=DbUtil.getDbutil().getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjname());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 无条件查询所有零件
	 * @return
	 */
	public ArrayList<Lingjian> findAll(){
		String sql="select * from lingjian";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		ArrayList<Lingjian> list=new ArrayList<Lingjian>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Lingjian temp=new Lingjian();
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjname(rs.getString("ljname"));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/**
	 * 通过id找零件
	 * @param bgy
	 * @return
	 */
	public Lingjian findById(Lingjian lj){
		String sql="select * from lingjian where ljnum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		Lingjian t = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,lj.getLjnum());
			rs=pstmt.executeQuery();
			t=new Lingjian();
			if(rs.next()){
				t.setLjnum(rs.getString("ljnum"));
				t.setLjname(rs.getString("ljname"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}
	/**
	 * 通过名字找零件
	 * @param bgy
	 * @return
	 */
	public Lingjian findByName(Lingjian lj){
		String sql="select * from lingjian where ljname=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		Lingjian t = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,lj.getLjname());
			rs=pstmt.executeQuery();
			t=new Lingjian();
			if(rs.next()){
				t.setLjnum(rs.getString("ljnum"));
				t.setLjname(rs.getString("ljname"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}
	
}
