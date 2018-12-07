package edu.fullerton.cpsc411.assignment_2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log
import androidx.lifecycle.ViewModel

class MovieDbHelper(context: Context) :  SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
        db.execSQL(SQL_CREATE_ENTRIES2)

        Log.d("table","created");

    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL(SQL_DELETE_ENTRIES)
        db.execSQL(SQL_CREATE_ENTRIES2)

        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    /*
    private var sInstance: MovieDbHelper? = null

    @Synchronized
    fun getInstance(context: Context): MovieDbHelper {


        if (sInstance == null) {
            sInstance = MovieDbHelper(context.applicationContext)
        }
        return sInstance as MovieDbHelper
    }

    */
    fun insertNewUser(username:String, password:String): Boolean {

        val db = writableDatabase
        Log.d("Insert Working","testing");

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(UserTable.UserEntry.COLUMN_USERNAME,username)
            put(UserTable.UserEntry.COLUMN_PASSWORD, password)

        }

        db?.insert(UserTable.UserEntry.TABLE_NAME, null, values);

        db.close()

        return true
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "MoiveRs.db"


        private const val SQL_CREATE_ENTRIES =
                "CREATE TABLE ${UserTable.UserEntry.TABLE_NAME} (" +
                        "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                        "${UserTable.UserEntry.COLUMN_USERNAME} TEXT," +
                        "${UserTable.UserEntry.COLUMN_PASSWORD} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserTable.UserEntry.TABLE_NAME}"

        private const val SQL_CREATE_ENTRIES2 =
                "CREATE TABLE ${UserTable.MoiveEntry.TABLE_Moive} (" +
                        "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                        "${UserTable.MoiveEntry.COLUMN_1} TEXT," +
                        "${UserTable.MoiveEntry.COLUMN_2} TEXT)"

        private const val SQL_DELETE_ENTRIES2 = "DROP TABLE IF EXISTS ${UserTable.MoiveEntry.TABLE_Moive}"





    }
}