package com.xtel.connnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.xtel.logging.LoggingClass;
import com.xtel.model.User;

public class ExportResult {
	
	public ArrayList<User> getListOfUser(){
		String sql = "select * from vietlot";
		ArrayList<User> list = new ArrayList<User>();
		try {
			Connection conn = HikariCPDataSource.getConnection();
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while(rs.next()){
				String identify = rs.getString(1);
				String number = rs.getString(2);
				int cost = rs.getInt(3);
				list.add(new User(identify, number, cost));
			}
			conn.close();
		} catch (Exception e) {
			LoggingClass.getLogger().error(e);
		}
		
		return list;
		
	}
}
