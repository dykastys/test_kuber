package com.example.test_kuber.dto

class CasDto(
    val name: String,
    val address: AddressDto,
)

class AddressDto(
    val city: String,
    val street: String,
    val houseNumber: String
)