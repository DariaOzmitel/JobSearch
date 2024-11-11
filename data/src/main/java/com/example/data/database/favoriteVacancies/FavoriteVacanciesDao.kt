package com.example.data.database.favoriteVacancies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface FavoriteVacanciesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavoriteVacancy(favoriteVacanciesDbModel: FavoriteVacanciesDbModel)

    @Query("SELECT COUNT(*) > 0 FROM FavoriteVacanciesDbModel WHERE vacancyId = :vacancyId")
    fun isVacancyFavorite(vacancyId: String): Flow<Boolean>

    @Query("SELECT * FROM FavoriteVacanciesDbModel")
    fun getFavoriteVacanciesList(): Flow<List<FavoriteVacanciesDbModel>>

    @Query("DELETE FROM FavoriteVacanciesDbModel WHERE vacancyId=:vacancyId")
    suspend fun deleteFromFavorites(vacancyId: String)
}