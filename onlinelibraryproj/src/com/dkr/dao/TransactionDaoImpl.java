package com.dkr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.dkr.db.ConnectionFactiory;

public class TransactionDaoImpl implements TransactionDao {
	static Connection con = ConnectionFactiory.getConnection();
	
	@Override
	public String issueBook(String[] bid, String cid) {
		String status = "";
		try {
			PreparedStatement p = con.prepareStatement("select noofbooks from custaudit where cid = ?");
			
			p.setString(1, cid);
			ResultSet rs = p.executeQuery();
			int count = 0;
			if(rs.next()) {
				
				count = rs.getInt(1);
			}
			java.util.Date udate = new java.util.Date();
			long time = udate.getTime();
			java.sql.Date currentDate = new java.sql.Date(time);
			int rounds = 0;
			if(count<2 && count >= 0) {
				PreparedStatement pst = con.prepareStatement("insert into Transaction values(?,?,?,?,Transaction_id.nextval)");
				if(count == 0 ) {
					
					for(String b:bid) {
						if(b == null || b.equals("") ) {
							break;
						}
						pst.setString(1, "issue");
						pst.setString(2, b);
						pst.setString(3, cid);
						pst.setDate(4, currentDate);
						
						pst.executeUpdate();
						rounds++;
					}
					PreparedStatement pst1 = con.prepareStatement(" update custaudit set noofbooks = noofbooks+"+rounds+" where cid= ?");
					pst1.setString(1, cid);
					pst1.executeUpdate();
				}else {
					pst.setString(1, "issue");
					pst.setString(2, bid[0]);
					pst.setString(3, cid);
					pst.setDate(4, currentDate);
					
	
					pst.executeUpdate();
					
					PreparedStatement pst2 = con.prepareStatement(" update custaudit set noofbooks = noofbooks+1 where cid = ?");
					pst2.setString(1, cid);
					pst2.executeUpdate();
				}
				status = "success";
				
			}
			else {
				status = "max";
			}
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public String getBook(String[] bid, String cid) {
		String status = "";
		try {
			PreparedStatement p = con.prepareStatement("select noofbooks from custaudit where cid = ?");
			
			p.setString(1, cid);
			ResultSet rs = p.executeQuery();
			int count = 0;
			if(rs.next()) {
				
				count = rs.getInt(1);
			}
			int rounds = 0;
			for(String b: bid){ 
				if(b == null || b.equals("")) {
					break;
				}
				rounds++;
				
			}
			
			
			java.util.Date udate = new java.util.Date();
			long time = udate.getTime();
			java.sql.Date currentDate = new java.sql.Date(time);
			
			if(count<2 && count >= 0) {
				PreparedStatement pst = con.prepareStatement("insert into Transaction values(?,?,?,?,Transaction_id.nextval)");
				if(count == 0 ) {
					
					for(String b:bid) {
						if(b == null || b.equals("") ) {
							break;
						}
						pst.setString(1, "get");
						pst.setString(2, b);
						pst.setString(3, cid);
						pst.setDate(4, currentDate);
						
						pst.executeUpdate();
						rounds++;
					}
					
				}else {
					pst.setString(1, "get");
					pst.setString(2, bid[0]);
					pst.setString(3, cid);
					pst.setDate(4, currentDate);
					
	
					pst.executeUpdate();
					
				}
				
				
			}
			
			
			PreparedStatement pst = con.prepareStatement("update custaudit set noofbooks = ? where cid=?");
			pst.setString(1, ""+(count-rounds));
			pst.setString(2, cid);
			pst.executeUpdate();
			status = "updated";
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		}
		
		
		return status;
	}

}
