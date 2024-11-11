package com.example.domain.repository

interface AuthorizationRepository {
    suspend fun addUser(mail: String)
    suspend fun checkAuthorization(): Boolean
}