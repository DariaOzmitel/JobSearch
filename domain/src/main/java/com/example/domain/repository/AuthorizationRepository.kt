package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {
    suspend fun addUser(mail: String)
    fun checkAuthorization(): Flow<Boolean>
}