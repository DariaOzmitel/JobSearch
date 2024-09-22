package com.example.ui.mapper

import com.example.domain.models.Vacancy
import com.example.ui.models.VacancyCardUI

class DomainToUiMapper {
    fun vacancyToVacancyCardUi(vacancy: Vacancy) = vacancy.run {
        VacancyCardUI(
            lookingNumber = lookingNumber,
            title = title,
            town = address.town,
            company = company,
            experienceText = experienceText,
            publishedDate = publishedDate
        )
    }

    fun vacancyToVacancyCardUiList(vacancyList: List<Vacancy>) =
        vacancyList.map { vacancyToVacancyCardUi(it) }
}