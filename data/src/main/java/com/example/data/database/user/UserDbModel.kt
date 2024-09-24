package com.example.data.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDbModel(
    @PrimaryKey(autoGenerate = false)
    val mail: String,
)