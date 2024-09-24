package com.example.domain.usecases

import com.example.domain.repository.JobSearchRepository

class AddUserUseCase(
    private val repository: JobSearchRepository
) {
    suspend fun invoke(mail: String) {
        return repository.addUser(mail)
    }
}