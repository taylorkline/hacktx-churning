package ut.hacktx.churningtracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

	private static final String TAG = DbHelper.class.getSimpleName();
	public static final String DB_NAME = "info.db";
	public static final int DB_VERSION = 1;
	public static final String TABLE = "myInfo";
	public static final String C_ID = BaseColumns._ID;  //special for id
	public static final String C_CARD_NAME = "_id";
	public static final String C_MONTH_SIGNED = "_id";
	public static final String C_MONEY_SPENT = "_id";
	public static final String C_LIMIT = "_id";
	public static final String C_BONUS = "_id";
	public static final String C_TIME_FRAME = "_id";
	public static final String C_FEE = "_id";
	
	Context context;
	
	public DbHelper (Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.context = context;
	}
	
	//Do I delete this?
	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = String.format("create table %s (%s, %s, %s, %s, %s, %s, %s)", TABLE, C_ID, C_CARD_NAME, C_MONTH_SIGNED, C_MONEY_SPENT,
				C_LIMIT, C_BONUS, C_TIME_FRAME, C_FEE); 
		
//		sql = context.getString(R.string.sql);
// 37:07???
		
		Log.d(TAG, "OnCreate sql: " + sql);
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists " + TABLE);
		Log.d(TAG, "onUpdate dropped table " + TABLE);
		this.onCreate(db);
	}
	
}