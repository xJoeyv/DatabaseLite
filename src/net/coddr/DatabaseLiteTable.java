package net.coddr;

public class DatabaseLiteTable {
	
	private String sql = "";
	
	public DatabaseLiteTable(String tableName) {
		this.sql += "CREATE TABLE `"+tableName+"` ( ";
	}

	public DatabaseLiteTable column(Column column) {
		this.sql += column.getSQL();
		return this;
	}
	
	public String getSQL() {
		this.sql += "";
		return this.sql;
	}
}
