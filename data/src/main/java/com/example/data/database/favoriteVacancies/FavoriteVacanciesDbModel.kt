package com.example.data.database.favoriteVacancies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class FavoriteVacanciesDbModel(
    @PrimaryKey
    val vacancyId: String
)
