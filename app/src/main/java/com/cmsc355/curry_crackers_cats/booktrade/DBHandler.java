package com.cmsc355.curry_crackers_cats.booktrade;
/**
 *
 * @author Vishakha
 * Purpose: creates database with 3 tables: userInfo, textbookInfo, and messageHistory
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;


import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

	private static DBHandler _instance = null;

	//Logcat tag
	private static final String LOG = DBHandler.class.getName();

	// database version
	private static final int databaseVersion = 1;

	// database name
	private static final String databaseName = "bookTrade";

	// table name
	private static final String table_userInfo = "userInfo";
	private static final String table_txtbkInfo = "textbookInfo";
	private static final String table_messages = "messageHistory";
	// name of columns of userInfo table
	private static final String KEY_userID = "userId";
	private static final String KEY_userName = "userName";
	private static final String KEY_password = "password";
	private static final String KEY_email = "email";

	// name of columns of textbookInfo table
	private static final String KEY_textbookID = "textbookId";
	private static final String KEY_title = "title";
	private static final String KEY_condition = "condition";
	private static final String KEY_price = "price";
	private static final String KEY_description = "description";
	private static final String KEY_favorite = "favorite";
	private static final String KEY_sold = "sold";
	private static final String KEY_image = "image";
	//private static final String KEY_userName = "userName"; ----already declared under the userInfo table section

	// name of columns of the messageHistory table
	private static final String KEY_messageID = "messageId";
	private static final String KEY_content = "content";
	private static final String KEY_userONE = "userOne";
	private static final String KEY_userTWO = "userTwo";
	private static final String KEY_timestamp = "timeStamp";
	// ?? why am I doing this
	public DBHandler(Context context) {
		super(context, databaseName, null, databaseVersion);
	}

	public static DBHandler getInstanceWithContext( Context appContext ) {
		if (_instance == null) {
			_instance = new DBHandler(appContext);
		}

		return _instance;
	}

	// creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_USER_INFO_TABLE = "CREATE TABLE " + table_userInfo + "(" + KEY_userID + " INTEGER PRIMARY KEY, "
				+ KEY_userName + " TEXT UNIQUE NOT NULL, " + KEY_password + " TEXT NOT NULL, " + KEY_email + " TEXT UNIQUE NOT NULL " + ")";

		String CREATE_TEXTBOOK_INFO_TABLE = "CREATE TABLE " + table_txtbkInfo + "(" + KEY_textbookID + " INTEGER PRIMARY KEY, "
				+ KEY_title + " TEXT NOT NULL, " + KEY_condition + " TEXT NOT NULL, " + KEY_price + " REAL NOT NULL" +KEY_description + " TEXT NOT NULL " + KEY_favorite + " INTEGER NOT NULL " + KEY_sold + " INTEGER NOT NULL" + KEY_userName + " TEXT NOT NULL " + KEY_image + " BLOB NOT NULL " + ")";

		String CREATE_MESSAGE_HISTORY_TABLE = "CREATE TABLE " + table_messages + "(" + KEY_messageID + " INTEGER PRIMARY KEY, "
				+ KEY_content + " BLOB NOT NULL, " + KEY_userONE + " TEXT NOT NULL, " + KEY_userTWO + " TEXT NOT NULL " + KEY_timestamp+ " TEXT NOT NULL" + ")";

		db.execSQL(CREATE_USER_INFO_TABLE);
		db.execSQL(CREATE_TEXTBOOK_INFO_TABLE);
		db.execSQL(CREATE_MESSAGE_HISTORY_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion) {
		//drop older table if exists
		db.execSQL("DROP TABLE IF EXISTS " + table_userInfo);
		db.execSQL("DROP TABLE IF EXISTS " + table_txtbkInfo);
		db.execSQL("DROP TABLE IF EXISTS " + table_messages);
		//create tables again
		onCreate(db);
	}

	//adding new user
	public long addUser(User user) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_userName, user.getUserName()); // User Name
		values.put(KEY_password, user.getPassword()); // password
		values.put(KEY_email, user.getEmail()); //email

		//inserting rows
		long uID = db.insert(table_userInfo, null, values); //adds user to database and return id

		return uID; //returns userID of user added to database
	}

	//getting a user

	public User getUser(long userID) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM " + table_userInfo + " WHERE " + KEY_userID + " = " + userID;

		Log.e(LOG, selectQuery);

		Cursor c = db.rawQuery(selectQuery, null);

		if (c != null) {
			c.moveToFirst();
		}

		User one = new User(); //new user created to transfer over information from requested user
		one.setUserId((c.getInt(c.getColumnIndex(KEY_userID)))); // copying id over to the new user object
		one.setUserName(c.getString(c.getColumnIndex(KEY_userName))); // copying userName over to the new user object
		one.setPassword(c.getString(c.getColumnIndex(KEY_password))); // copying password over to the new user object
		one.setEmail(c.getString(c.getColumnIndex(KEY_email))); // copying email over to the new user object
		c.close();
		return one; // returns the user that matches the given userID
	}

	// updating a user

	public int updateUser (User user) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_userName, user.getUserName()); // User Name
		values.put(KEY_password, user.getPassword()); // password
		values.put(KEY_email, user.getEmail());

		//updating a record, return the userID of user entered
		return db.update(table_userInfo, values, KEY_userID + " = ?", new String[] { String.valueOf(user.getUserId())});
	}

	//deleting a user
	public void deleteUser (long userID) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(table_userInfo, KEY_userID + " = ?", new String[] {String.valueOf(userID)});
	}

	//getting all the users
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		String selectQuery = "SELECT * FROM " + table_userInfo;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		//adding each record to the list
		if (c.moveToFirst()) {
			do {
				User one = new User();
				one.setUserId(c.getInt(c.getColumnIndex(KEY_userID))); // copying id over to the new user object
				one.setUserName(c.getString(c.getColumnIndex(KEY_userName))); // copying userName over to the new user object
				one.setPassword(c.getString(c.getColumnIndex(KEY_password))); // copying password over to the new user object
				one.setEmail(c.getString(c.getColumnIndex(KEY_email))); // copying email over to the new user object

				// adding user to list
				users.add(one);
			} while (c.moveToNext());
		}
		c.close();
		return users;
	}

	//adding new textbook
	public long addTextbook(Textbook textbook) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_title, textbook.getTitle()); // title
		values.put(KEY_condition, textbook.getCondition()); // condition
		values.put(KEY_price, textbook.getPrice()); //price
		values.put(KEY_description, textbook.getDescription());
		values.put(KEY_favorite, textbook.getFavorite());
		values.put(KEY_sold, textbook.getSold());
		values.put(KEY_userID, textbook.getUserID());
		//values.put(KEY_image, textbook.get());

		//inserting rows
		long tbID = db.insert(table_txtbkInfo, null, values);

		return tbID;
	}

	//geting a textbook

	public Textbook getTextbook(long textbookID) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM " + table_txtbkInfo + " WHERE " + KEY_textbookID + " = " + textbookID;

		Log.e(LOG, selectQuery);

		Cursor c = db.rawQuery(selectQuery, null);

		if (c != null) {
			c.moveToFirst();
		}

		Textbook one = new Textbook();
		c.close();
		return one;
	}

	// updating a textbook

	public int updateTextbook (Textbook textbook) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_title, textbook.getTitle()); // title
		values.put(KEY_condition, textbook.getCondition()); // condition
		values.put(KEY_price, textbook.getPrice()); //price
		values.put(KEY_description, textbook.getDescription());
		values.put(KEY_favorite, textbook.getFavorite());
		values.put(KEY_sold, textbook.getSold());
		values.put(KEY_userID, textbook.getUserID());
		//values.put(KEY_image, textbook.get());

		//updating a record, return the userID of user entered
		return db.update(table_txtbkInfo, values, KEY_textbookID + " = ?", new String[] { String.valueOf(textbook.getTextbookId())});
	}

	public void deleteTextbook (long textbookID) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(table_txtbkInfo, KEY_textbookID + " = ?", new String[] {String.valueOf(textbookID)});

	}

	//adding new message
	public long addMessage(Messages message) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_content, message.getContent()); // content
		values.put(KEY_userONE, message.getUserOne()); // userOne
		values.put(KEY_userTWO, message.getUserTwo()); // userTwo
		values.put(KEY_timestamp, message.getTimeStamp()); // timeStamp
		//inserting rows
		long messageID = db.insert(table_messages, null, values);

		return messageID;
	}

	//getting a message

	public Messages getMessage(long messageID) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM " + table_messages + " WHERE " + KEY_messageID + " = " + messageID;

		Log.e(LOG, selectQuery);

		Cursor c = db.rawQuery(selectQuery, null);

		if (c != null) {
			c.moveToFirst();
		}

		Messages one = new Messages();
		one.setMessageId(c.getInt(c.getColumnIndex(KEY_messageID))); // copying id over to the new user object
		one.setUserOne(c.getInt(c.getColumnIndex(KEY_userONE))); // copying userName over to the new user object
		one.setUserTwo(c.getInt(c.getColumnIndex(KEY_userTWO))); // copying password over to the new user object
		one.setContent(c.getString(c.getColumnIndex(KEY_content))); // copying email over to the new user object
		c.close();
		return one;
	}

	//getting all messages between two users

	public List<Messages> getAllMessages(int userID, int userID2) {
		List<Messages> messages = new ArrayList<Messages>();
		String selectQuery = "SELECT * FROM " + table_messages + " WHERE (" + KEY_userONE + " = " + userID + " OR " + KEY_userONE + " = " + userID2 + ") AND (" + KEY_userTWO + " = " + userID + " OR " + KEY_userTWO + " = " + userID2 + ");";

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		//adding each record to the list
		if (c.moveToFirst()) {
			do {
				Messages message = new Messages();
				message.setMessageId(c.getInt(c.getColumnIndex(KEY_messageID))); // copying id over to the new user object
				message.setUserOne(c.getInt(c.getColumnIndex(KEY_userONE))); // copying userName over to the new user object
				message.setUserTwo(c.getInt(c.getColumnIndex(KEY_userTWO))); // copying password over to the new user object
				message.setContent(c.getString(c.getColumnIndex(KEY_content))); // copying email over to the new user object

				// adding user to list
				messages.add(message);
			} while (c.moveToNext());
		}
		c.close();
		return messages;
	}

	// closing database connection
	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen()) {
			db.close();
		}
	}
}