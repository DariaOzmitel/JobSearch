package com.example.data.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun addUser(userDbModel: UserDbModel)

    @Query("SELECT * FROM UserDbModel WHERE mail=:mail")
    suspend fun getUser(mail: String): UserDbModel?
}