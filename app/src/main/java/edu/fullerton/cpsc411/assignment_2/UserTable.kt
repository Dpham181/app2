package edu.fullerton.cpsc411.assignment_2

import android.provider.BaseColumns

object Tables {

    /* Inner class that defines the table contents */
    class User : BaseColumns {
        companion object {
            const val TABLE_USER = "users"
            const val COLUMN_1 = "username"
            const val COLUMN_2 = "password"
        }
    }
    class Moive : BaseColumns {
        companion object {
            const val TABLE_MOIVE = "Moive"
            const val COLUMN_1 = "Title"
            const val COLUMN_2 = "Description"
            const val COLUMN_3 = "IMG"
            const val COLUMN_4 = "Stars"

        }
    }
//    class UserLikes : BaseColumns {
//        companion object{
//            const val TABLE_USERLIKES = "UserLikes"
//            const val COLUMN_1 = "username"
//            const
//        }
//    }

}

