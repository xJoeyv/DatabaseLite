import net.coddr.CType;
import net.coddr.Column;
import net.coddr.DatabaseLite;
import net.coddr.DatabaseLiteTable;

public class Case1 {
	
	public static void main(String[] args) {
		//
		DatabaseLite db = new DatabaseLite("test");
		
		db.createTable(
				new DatabaseLiteTable("testOne")
				.column(
					new Column("id", CType.INTEGER).setAutoincrement().setPrimaryKey()
				)
				.column(
					new Column("name", CType.TEXT).setUnique().setDefault("test")
				)
				.column(
					new Column("last_name", CType.TEXT)
				)
			);
	}
	
}