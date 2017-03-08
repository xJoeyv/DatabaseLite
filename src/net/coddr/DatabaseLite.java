package net.coddr;

import java.sql.*;

public class DatabaseLite {
	
	private Connection connection;
	private Statement statement;
	
	private String database;

	public DatabaseLite(String dbName) {
		this.database = dbName;
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection("jdbc:sqlite:"+this.database+".db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	public void createTable(DatabaseLiteTable table) {
		String sql = this.endSQL(table.getSQL());
		System.out.println("DatabaseLiteTable  >> " + sql);
		/*
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		*/
	}
	
	public void deleteTable(String tableName) {
		
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String endSQL(String SQL) {
		if(SQL.endsWith(", ")) {
			String sql = SQL.trim();
			sql = sql.substring(0, sql.length() - 1);
			sql += " );";
			return sql;	
		}
		return SQL + " );";
	}
}
