package com.example.test_kuber.persistence.entity

import com.example.test_kuber.dto.AddressDto
import com.example.test_kuber.dto.CasDto
import com.example.test_kuber.persistence.entity.base.BaseAuditEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
class Cas(

    @Column(unique = true, nullable = false)
    var name: String,

    @OneToOne(cascade = [(CascadeType.ALL)], orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    var address: Address
): BaseAuditEntity() {

    fun toCasDto(): CasDto {
        val address = AddressDto(
            city = address.city,
            street = address.street,
            houseNumber = address.house
        )
        return CasDto(name = name, address = address)
    }

    fun updateByCasDto(casDto: CasDto): Cas {
        this.name = casDto.name
        this.address.city = casDto.address.city
        this.address.street = casDto.address.street
        this.address.house = casDto.address.houseNumber
        return this
    }
}