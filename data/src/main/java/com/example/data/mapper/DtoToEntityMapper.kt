package com.example.data.mapper

import com.example.data.network.models.OfferDto
import com.example.data.network.models.VacancyDto
import com.example.domain.models.Address
import com.example.domain.models.Offer
import com.example.domain.models.Vacancy

class DtoToEntityMapper {
    fun mapVacancyDtoToEntity(dto: VacancyDto) =
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
                experienceText = experience.previewText,
                publishedDate = publishedDate
            )
        }

    fun mapVacancyDtoListToEntityList(dtoList: List<VacancyDto>?) = dtoList?.map {
        mapVacancyDtoToEntity(it)
    }

    fun mapOfferDtoToEntity(dto: OfferDto) =
        dto.run {
            Offer(
                id = id,
                title = title,
                link = link,
                buttonText = button?.text
            )
        }

    fun mapOfferDtoListToEntityList(dtoList: List<OfferDto>?) = dtoList?.map {
        mapOfferDtoToEntity(it)
    }
}