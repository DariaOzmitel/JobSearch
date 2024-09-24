package com.example.data.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(userDbModel: UserDbModel)

    @Query("SELECT * FROM UserDbModel LIMIT 1")
    suspend fun checkAuthorization(): UserDbModel?
}