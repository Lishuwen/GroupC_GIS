package com.cyt.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyt.dao.JDBCConnect;


public class Sdata extends JDBCConnect{

	public List deng() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		JDBCConnect j = new Sdata();
		String sql = "Select * from car";
		List l = new ArrayList();
		l = j.get(sql);
		return l;
	}
}
