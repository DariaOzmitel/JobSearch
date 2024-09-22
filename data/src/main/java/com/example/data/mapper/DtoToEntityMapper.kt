package com.example.data.mapper

import com.example.data.network.models.VacancyDto
import com.example.domain.models.Address
import com.example.domain.models.Vacancy

class DtoToEntityMapper {
    fun mapDtoToEntity(dto: VacancyDto) =
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

    fun mapDtoListToEntityList(dtoList: List<VacancyDto>?) = dtoList?.map {
        mapDtoToEntity(it)
    }
}