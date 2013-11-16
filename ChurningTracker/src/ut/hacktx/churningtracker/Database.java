package ut.hacktx.churningtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
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
	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	public static class DbHelper extends SQLiteOpenHelper {
		public DbHelper(Context context) {
			super(context, DATABASE_CARD_NAME, null, DATABASE_VERSION);
			
		}
	
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + 
			KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
			KEY_CARD_NAME + " TEXT NOT NULL " + 
			KEY_MONEY_SPENT + " TEXT NOT NULL" + 
			KEY_LIMIT + " TEXT NOT NULL" + 
			KEY_BONUS + " TEXT NOT NULL" + 
			KEY_TIME_FRAME + " TEXT NOT NULL" + 
			KEY_FEE + " TEXT NOT NULL");
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}
	
	public Database (Context c) {
		ourContext = c;
	}
	//
	public Database open() {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close() {
		ourHelper.close();
	}
	
	public long createEntry(String nameOfCard, String monthSignedUp, String moneySpent, String needToSpend, String bonus, String timeFrame, String fee) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_CARD_NAME, nameOfCard);
		cv.put(KEY_MONTH_SIGNED, monthSignedUp);
		cv.put(KEY_MONEY_SPENT, moneySpent);
		cv.put(KEY_LIMIT, needToSpend);
		cv.put(KEY_BONUS, bonus);
		cv.put(KEY_TIME_FRAME, timeFrame);
		cv.put(KEY_FEE, fee);
		
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	
}