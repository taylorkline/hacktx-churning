package ut.hacktx.churningtracker;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class anotherDataBase extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IS NOT EXISTS myInfo(Email VARCHAR, firstName VARCHAR, lastName VARCHAR);");
		db.execSQL("INSERT INTO myInfo VALUES('hey', 'hey', 'hey);");
		db.close();
	}
}