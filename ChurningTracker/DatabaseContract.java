package ut.hacktx.churningtracker;

public final class DatabaseContract {
	//prevent someone from accidentally instantiating the class
	public DatabaseContract() {}
	
	public static abstract class DatabaseEntry implements BaseColumns {
		public static final String KEY_ROWID = "_id";
		
		public static final String KEY_CARD_NAME = "_id";
		public static final String KEY_MONTH_SIGNED = "_id";
		public static final String KEY_MONEY_SPENT = "_id";
		public static final String KEY_LIMIT = "_id";
		public static final String KEY_BONUS = "_id";
		public static final String KEY_TIME_FRAME = "_id";
		public static final String KEY_FEE = "_id";

		private static final String DATABASE_CARD_NAME = "Churningdb";
		private static final String DATABASE_TABLE = "churningTable";
	}
}