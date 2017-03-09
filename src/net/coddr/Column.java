package net.coddr;

public class Column {
	
	private String sql = "";
	
	private String fieldName;
	private CType fieldType;
	
	
	public Column(String field, CType type) {
		this.fieldName = field;
		this.fieldType = type;
		this.sql += "`"+field+"` ";
		this.sql += fieldType.name().toUpperCase();
	}
	
	/** TODO **/
	public Column setPrimaryKey() {
		if(!sql.contains("PRIMARY KEY")) {
			
		}
		return this;
	}
	
	/***
	 * setAutoincrement
	 * 
	 * @return
	 */
	public Column setAutoincrement() {
		if(fieldType == CType.INTEGER) {
			if(!sql.contains("PRIMARY KEY AUTOINCREMENT")) {
				sql += " PRIMARY KEY AUTOINCREMENT ";
			}
			return this;
		}
		return this;
	}
	
	/***
	 * setUnique
	 * 
	 * @return
	 */
	public Column setUnique() {
		if(!sql.contains("UNIQUE")) {
			this.sql += " UNIQUE";
		}
		return this;
	}
	/***
	 * setDefault
	 * 
	 * @return
	 */
	public Column setDefault(String string) {
		if(!sql.contains("DEFAULT")) {
			this.sql += " DEFAULT '"+string+"'";
		}
		return this;
	}
	
	public String getSQL() {
		return this.sql + ", ";
	}
}
