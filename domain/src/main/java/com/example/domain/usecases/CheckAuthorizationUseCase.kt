package com.example.domain.usecases

import com.example.domain.repository.AuthorizationRepository
import kotlinx.coroutines.flow.Flow

class CheckAuthorizationUseCase(
    private val repository: AuthorizationRepository
) {
    fun invoke(): Flow<Boolean> {
        return repository.checkAuthorization()
    }
}