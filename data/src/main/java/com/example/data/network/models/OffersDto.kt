package com.example.data.network.models

data class OffersDto(
    val offers: List<OfferDto>
)

data class OfferDto(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonDto? = null
)

data class ButtonDto(
    val text: String
)