package com.example.data.database.favoriteVacancies

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.data.database.user.UserDbModel

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = UserDbModel::class,
            parentColumns = ["mail"],
            childColumns = ["userMail"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FavoriteVacanciesDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userMail: String,
    val vacancyId: String
)
