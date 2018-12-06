package edu.fullerton.cpsc411.assignment_2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class MovieDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
        Log.d("table","created");

    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }




    fun insertUser(): Boolean {

        val db = writableDatabase
        Log.d("Insert Working","testing");

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(UserTable.UserEntry.COLUMN_USERNAME,"ssssssssssss")
            put(UserTable.UserEntry.COLUMN_PASSWORD, "sssssssssss")

        }



        // Insert the new row, returning the primary key value of the new row


        val newRowId = db?.insert(UserTable.UserEntry.TABLE_NAME, null, values);


        return true
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "MoiveRating.db"


        private const val SQL_CREATE_ENTRIES =
                "CREATE TABLE ${UserTable.UserEntry.TABLE_NAME} (" +
                        "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                        "${UserTable.UserEntry.COLUMN_USERNAME} TEXT," +
                        "${UserTable.UserEntry.COLUMN_PASSWORD} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserTable.UserEntry.TABLE_NAME}"
    }
}