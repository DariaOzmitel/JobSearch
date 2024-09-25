package com.example.ui.mapper

import com.example.domain.models.Offer
import com.example.domain.models.Vacancy
import com.example.ui.R
import com.example.ui.models.OfferUI
import com.example.ui.models.VacancyCardUI
import com.example.ui.models.VacancyForScreenUi
import java.util.Locale

class DomainToUiMapper {
    fun vacancyToVacancyCardUi(vacancy: Vacancy, favoriteVacanciesId: List<String>?) = vacancy.run {
        VacancyCardUI(
            id = id,
            lookingNumber = lookingNumber,
            title = title,
            town = address.town,
            company = company,
            experienceText = experiencePreviewText,
            publishedDate = publishedDate,
            isFavorite = favoriteVacanciesId?.contains(id) ?: false
        )
    }

    fun vacancyToVacancyCardUiList(
        vacancyList: List<Vacancy>,
        favoriteVacanciesId: List<String>? = emptyList()
    ) =
        vacancyList.map { vacancyToVacancyCardUi(it, favoriteVacanciesId) }

    fun offerToOfferUi(offer: Offer) = offer.run {
        OfferUI(
            iconResId = when (id) {
                "near_vacancies" -> R.drawable.offer_blue
                "level_up_resume" -> R.drawable.offer_star
                "temporary_job" -> R.drawable.offer_document
                else -> null
            },
            title = title.trim(),
            buttonText = buttonText
        )
    }

    fun offerToOfferCardUiList(offerList: List<Offer>) =
        offerList.map { offerToOfferUi(it) }

    fun vacancyToVacancyScreenUi(vacancy: Vacancy) = vacancy.run {
        VacancyForScreenUi(
            lookingNumber = lookingNumber,
            title = title,
            address = "${address.town}, ${address.street}, ${address.house}",
            company = company,
            experience = experienceText,
            salary = salary,
            schedules = schedules.replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale = Locale.getDefault()) else it.toString() },
            appliedNumber = appliedNumber,
            description = description,
            responsibilities = responsibilities,
            questions = questions,
        )
    }
}