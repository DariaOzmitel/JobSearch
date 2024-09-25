package com.example.ui.mapper

import com.example.domain.models.Offer
import com.example.domain.models.Vacancy
import com.example.ui.R
import com.example.ui.models.OfferUI
import com.example.ui.models.VacancyCardUI
import com.example.ui.models.VacancyForScreenUi
import java.text.SimpleDateFormat
import java.util.Locale

class DomainToUiMapper {

    fun formatDate(inputDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ru"))
        val outputFormat = SimpleDateFormat("d MMMM", Locale("ru"))

        val date = inputFormat.parse(inputDate)
        return outputFormat.format(date!!)
    }

    fun vacancyToVacancyCardUi(vacancy: Vacancy) = vacancy.run {
        VacancyCardUI(
            id = id,
            lookingNumber = lookingNumber,
            title = title,
            town = address.town,
            company = company,
            experienceText = experiencePreviewText,
            publishedDate = formatDate(publishedDate),
            isFavorite = isFavorite
        )
    }

    fun vacancyToVacancyCardUiList(
        vacancyList: List<Vacancy>,
    ) =
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

    fun vacancyToVacancyScreenUi(vacancy: Vacancy) = vacancy.run {
        VacancyForScreenUi(
            id = id,
            isFavorite = isFavorite,
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