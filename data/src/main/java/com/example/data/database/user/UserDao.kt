package com.example.data.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(userDbModel: UserDbModel)

    @Query("SELECT COUNT(*) > 0 FROM UserDbModel")
    fun checkAuthorization(): Flow<Boolean>
}