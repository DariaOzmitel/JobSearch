package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.database.favoriteVacancies.FavoriteVacanciesDao
import com.example.data.database.favoriteVacancies.FavoriteVacanciesDbModel
import com.example.data.database.user.UserDao
import com.example.data.database.user.UserDbModel

@Database(
    entities = [UserDbModel::class, FavoriteVacanciesDbModel::class],
    version = 12,
    exportSchema = false
)
internal abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun userDao(): UserDao
    abstract fun favoriteVacanciesDao(): FavoriteVacanciesDao
}