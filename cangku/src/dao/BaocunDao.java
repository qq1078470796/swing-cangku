package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbUtil;
import entity.Baocun;
import entity.Baoguanyuan;
import entity.Lingjian;

public class BaocunDao {
	/**
	 * 由仓库所属的保管员执行入库操作
	 * 向某个仓库新增一种零件
	 * @param bgy
	 */
	public int add(Baoguanyuan bgy,Lingjian lj,int number){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		int temp=0;
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="insert into baocun values(?,@ck,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			pstmt.setInt(2, number);
			temp=pstmt.executeUpdate();
			conn.commit(); 
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
		return temp;
	}
	/**
	 * 由仓库保管员执行入库操作
	 * 增加,减少仓库内某个零件的数量
	 * @param bgy
	 * @param lj
	 * @param number
	 */
	public int update(Baoguanyuan bgy,Lingjian lj,int number){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		int temp=0;
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="update baocun set ljsl=ljsl+? where ljnum=? and cknum=@ck";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, lj.getLjnum());
			temp=pstmt.executeUpdate();
			conn.commit(); 
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
		return temp;
	}
	
	/**
	 * 无条件查询所有仓库内的所有零件
	 * @return
	 */
	public ArrayList<Baocun> findAll(){
		String sql="select * from baocun";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		ArrayList<Baocun> list=new ArrayList<Baocun>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baocun temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
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
	 * 查询某个保管员管理的仓库内所有零件
	 * @return
	 */
	public ArrayList<Baocun> findAllByBGY(Baoguanyuan bgy){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ArrayList<Baocun> list=new ArrayList<Baocun>();
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="select * from baocun where cknum=@ck";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baocun temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
				list.add(temp);
			}
			conn.commit(); 
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
	 * 通过零件查询该零在各个仓库中的数量
	 * @param lj
	 * @return
	 */
	public ArrayList<Baocun> findAllByLJ(Lingjian lj){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ArrayList<Baocun> list=new ArrayList<Baocun>();
		try {
			conn.setAutoCommit(false);
			String sql="select * from baocun where ljnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baocun temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
				list.add(temp);
			}
			conn.commit(); 
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
	 * 查询某个某个仓库内特定零件的信息
	 * @return
	 */
	public Baocun findI(Baoguanyuan bgy,Lingjian lj){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		Baocun temp=null;
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="select * from baocun where cknum=@ck and ljnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			rs=pstmt.executeQuery();
			if(rs.next()){
				temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
				
			}
			conn.commit(); 
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
	
		return temp;
	}
	
}
