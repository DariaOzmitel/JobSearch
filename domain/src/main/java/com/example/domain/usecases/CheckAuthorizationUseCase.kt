package com.example.domain.usecases

import com.example.domain.repository.JobSearchRepository

class CheckAuthorizationUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(): Boolean {
        return repository.checkAuthorization()
    }
}