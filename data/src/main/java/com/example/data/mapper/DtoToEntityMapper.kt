package com.example.data.mapper

import com.example.data.network.models.OfferDto
import com.example.data.network.models.VacancyDto
import com.example.domain.models.Address
import com.example.domain.models.Offer
import com.example.domain.models.Vacancy

internal class DtoToEntityMapper {
    fun mapOfferDtoListToEntityList(dtoList: List<OfferDto>?) = dtoList?.map {
        mapOfferDtoToEntity(it)
    }

    fun mapVacancyDtoListToEntityList(
        dtoList: List<VacancyDto>?,
        favoriteVacanciesId: List<String>? = emptyList()
    ) = dtoList?.map {
        mapVacancyDtoToEntity(it, favoriteVacanciesId)
    }

    private fun mapVacancyDtoToEntity(dto: VacancyDto, favoriteVacanciesId: List<String>? = null) =
        dto.run {
            Vacancy(
                id = id,
                lookingNumber = lookingNumber,
                title = title,
                address = Address(
                    town = address.town,
                    street = address.street,
                    house = address.house
                ),
                company = company,
                experiencePreviewText = experience.previewText,
                publishedDate = publishedDate,
                salary = salary.full,
                schedules = schedules.joinToString { it },
                appliedNumber = appliedNumber,
                description = description,
                responsibilities = responsibilities,
                questions = questions,
                experienceText = experience.text,
                isFavorite = favoriteVacanciesId?.contains(id) ?: false
            )
        }

    private fun mapOfferDtoToEntity(dto: OfferDto) =
        dto.run {
            Offer(
                id = id,
                title = title,
                link = link,
                buttonText = button?.text
            )
        }
}