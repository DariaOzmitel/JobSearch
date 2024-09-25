package com.example.data.database.favoriteVacancies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteVacanciesDbModel(
    @PrimaryKey
    val vacancyId: String
)
