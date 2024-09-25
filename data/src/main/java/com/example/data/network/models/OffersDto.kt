package com.example.data.network.models

internal data class OffersDto(
    val offers: List<OfferDto>
)

internal data class OfferDto(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonDto? = null
)

internal data class ButtonDto(
    val text: String
)