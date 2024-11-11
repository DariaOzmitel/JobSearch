package com.example.domain.usecases

import com.example.domain.repository.AuthorizationRepository

class AddUserUseCase(
    private val repository: AuthorizationRepository
) {
    suspend fun invoke(mail: String) {
        return repository.addUser(mail)
    }
}