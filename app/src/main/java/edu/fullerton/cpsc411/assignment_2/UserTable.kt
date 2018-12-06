package edu.fullerton.cpsc411.assignment_2

import android.provider.BaseColumns

object UserTable {

    /* Inner class that defines the table contents */
    class UserEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "users"
            const val COLUMN_USERNAME = "username"
           const val COLUMN_PASSWORD = "password"
        }
    }


}

