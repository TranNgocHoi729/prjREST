package com.xtel.connnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xtel.logging.LoggingClass;
import com.xtel.model.User;
import com.xtel.services.Services;

public class InsertServices extends Thread{
	User user;
	
	public InsertServices(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		insert(user);
		try {
			sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insert(User user) {
		int result = 0;
		String sql = "insert into vietlot (identify, vietlot_number,price) values(?,?,?)";
		try {
			Connection conn = HikariCPDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getIdentify());
			ps.setString(2, user.getVietlot_number());
			ps.setInt(3, user.getCost());
			result = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			LoggingClass.getLogger().error(e);
		}
	//	 Services.getListOfUser().add(user);
		return result ;
	}



}
