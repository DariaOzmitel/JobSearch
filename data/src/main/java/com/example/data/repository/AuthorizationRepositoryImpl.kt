package com.example.data.repository

import com.example.data.database.user.UserDao
import com.example.data.database.user.UserDbModel
import com.example.domain.repository.AuthorizationRepository
import kotlinx.coroutines.flow.Flow

internal class AuthorizationRepositoryImpl(
    private val userDao: UserDao,
) : AuthorizationRepository {
    override suspend fun addUser(mail: String) {
        userDao.addUser(UserDbModel(mail))
    }

    override fun checkAuthorization(): Flow<Boolean> = userDao.checkAuthorization()
}