package na.severinchik.data.lesson5

import android.content.Context
import android.os.Build
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val VERSION = 1
private const val DB_NAME = "db_example"

@Database(entities = [UserDTO::class], version = VERSION)
abstract class RmDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {
        @Volatile private var INSTANCE: RmDatabase? = null

        fun getInstance(context: Context): RmDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                RmDatabase::class.java, DB_NAME)
                .build()


    }
}