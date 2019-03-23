package com.dkr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dkr.db.ConnectionFactiory;

public class CustDaoImpl implements CustDao {

	@Override
	public String add(String cid, String cname, long mobno) {
		String status = "";

		try {
			Connection con = ConnectionFactiory.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into customer values(?, ?, ? )");
			pst.setString(1, cid);
			pst.setString(2, cname);
			pst.setLong(3, mobno);
			int count = pst.executeUpdate();
			status = (count >= 1 ? "success" : "failure");

		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}

		return status;
	}

}
