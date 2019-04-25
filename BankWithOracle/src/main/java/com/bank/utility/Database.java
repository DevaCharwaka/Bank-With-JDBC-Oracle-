package com.bank.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DEVA","root");
		return con;
	}
}
