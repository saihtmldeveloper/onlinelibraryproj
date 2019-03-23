package com.dkr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dkr.db.ConnectionFactiory;

public class BookDaoImpl implements BookDao {

	@Override
	public String addBook(String bid, String bname, String author, double cost) {
		String status = "";
		
		try{
			Connection con = ConnectionFactiory.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from books where bid=? and bname = ?");
			pst.setString(1, bid);
			pst.setString(2, bname);
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if (b) {
				status = "existed";
			} else {
				PreparedStatement pst1 = con.prepareStatement("insert into books values(?,?,?,?)");
				pst1.setString(1, bid);
				pst1.setString(2, bname);
				pst1.setString(3, author);
				pst1.setDouble(4, cost);
				int count = pst1.executeUpdate();
				status = count>=1 ?"success":"failure";
			}
			
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		}
		
		return status;
	}

}
