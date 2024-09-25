package com.example.data.database.favoriteVacancies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
internal interface FavoriteVacanciesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteVacancy(favoriteVacanciesDbModel: FavoriteVacanciesDbModel)

    @Query("SELECT COUNT(*) FROM FavoriteVacanciesDbModel WHERE vacancyId = :vacancyId")
    suspend fun isVacancyFavorite(vacancyId: String): Int

    @Query("SELECT * FROM FavoriteVacanciesDbModel")
    suspend fun getFavoriteVacanciesList(): List<FavoriteVacanciesDbModel>?

    @Query("DELETE FROM FavoriteVacanciesDbModel WHERE vacancyId=:vacancyId")
    suspend fun deleteFromFavorites(vacancyId: String)
}