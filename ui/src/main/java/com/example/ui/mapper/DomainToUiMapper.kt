package com.example.ui.mapper

import com.example.domain.models.Offer
import com.example.domain.models.Vacancy
import com.example.ui.R
import com.example.ui.models.OfferUI
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
}