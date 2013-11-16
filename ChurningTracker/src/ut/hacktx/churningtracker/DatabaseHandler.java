package ut.hacktx.churningtracker;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "infoManager";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "info";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MONEY_SPENT = "moneySpent";
    private static final String KEY_NEED_TO_SPEND = "needToSpend";
    private static final String KEY_BONUS = "bonus";
    private static final String KEY_FEE = "fee";
    private static final String KEY_TIME_FRAME = "timeFrame";
    private static final String KEY_MONTH = "month";
    
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_MONEY_SPENT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_MONEY_SPENT, contact.getMoneySpent()); // Contact Phone
        values.put(KEY_NEED_TO_SPEND, contact.getNeedToSpend()); // Contact Phone
        values.put(KEY_BONUS, contact.getBonus()); // Contact Phone
        values.put(KEY_FEE, contact.getFee()); // Contact Phone
        values.put(KEY_TIME_FRAME, contact.getTimeFrame()); // Contact Phone
        values.put(KEY_MONTH, contact.getMonth()); // Contact Phone
        
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single card
    Contact getCard(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                KEY_NAME, KEY_MONEY_SPENT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Contact card = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), cursor.getString(7));
        // return contact
        return card;
    }
     
    // Getting All Cards
    public List<Contact> getAllCards() {
        List<Contact> cardList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact card = new Contact();
                card.setID(Integer.parseInt(cursor.getString(0)));
                card.setName(cursor.getString(1));
                card.setMoneySpent(cursor.getString(2));
                card.setNeedToSpend(cursor.getString(3));
                card.setBonus(cursor.getString(4));
                card.setFee(cursor.getString(5));
                card.setTimeFrame(cursor.getString(6));
                card.setMonth(cursor.getString(7));
                // Adding contact to list
                cardList.add(card);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return cardList;
    }
 
    // Updating single contact
    public int updateContact(Contact card) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, card.getName());
        values.put(KEY_MONEY_SPENT, card.getMoneySpent());
        values.put(KEY_NEED_TO_SPEND, card.getNeedToSpend());
        values.put(KEY_BONUS, card.getBonus());
        values.put(KEY_FEE, card.getFee());
        values.put(KEY_TIME_FRAME, card.getTimeFrame());
        values.put(KEY_MONTH, card.getMonth());
        
 
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(card.getID()) });
    }
 
    // Deleting single card
    public void deleteCard(Contact card) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(card.getID()) });
        db.close();
    }
 
 
    // Getting contacts Count
    public int getCardCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
 
}